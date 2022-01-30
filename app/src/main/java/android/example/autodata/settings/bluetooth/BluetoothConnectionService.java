package android.example.autodata.settings.bluetooth;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.UUID;

public class BluetoothConnectionService
{
    private static final String TAG = "BluetoothConnectionServ";
    private static final String appName = "AutoData";

    private static final UUID UUID_INSECURE = UUID.fromString("680cc08e-21a9-49b1-a7a9-7f3b5f2cc84c");

    private BluetoothAdapter bluetoothAdapter;
    Context context;

    private AcceptThread insecureAcceptThread;
    private ConnectThread connectThread;
    private BluetoothDevice bluetoothDevice;
    private UUID deviceUUID;
    ProgressDialog progressDialog;

    private ConnectedThread connectedThread;

    public BluetoothConnectionService(Context context) {
        this.context = context;
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    //Thread waiting for the connection
    private class AcceptThread extends Thread {
        private final BluetoothServerSocket serverSocket;

        public AcceptThread() {
            BluetoothServerSocket tmp = null; //Creating a new listening server socket
            try {
                tmp = bluetoothAdapter.listenUsingInsecureRfcommWithServiceRecord(appName,UUID_INSECURE);

                Log.d(TAG, "Accept Thread Setting up server using: " + UUID_INSECURE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            serverSocket = tmp;
        }

        public void run() {
            Log.d(TAG, "run: AcceptThread Running");

            BluetoothSocket bluetoothSocket = null;

            try {
                Log.d(TAG, "run: RFCOM server socket start...");
                bluetoothSocket = serverSocket.accept();
                Log.d(TAG, "run: RFCOM server socket accepted connection");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(bluetoothSocket != null) {
                connected(bluetoothSocket, bluetoothDevice); //??bluetoothDevice
            }
            Log.i(TAG,"END AcceptThread");
        }

        public void cancel() {
            Log.d(TAG, "cancel: Canceling AcceptThread");

            try {
                serverSocket.close();
            } catch (IOException e) {

            }
        }
    }

    private class ConnectThread extends Thread {
        private BluetoothSocket bluetoothSocket;

        public ConnectThread(BluetoothDevice device, UUID uuid) {
            Log.d(TAG, "ConnectThread: started");
            bluetoothDevice = device;
            deviceUUID = uuid;
        }

        public void run() {
            BluetoothSocket tmp = null;
            Log.i(TAG, "RUN ConnectThread");
            try {
                tmp = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(deviceUUID);
            } catch (IOException e) {
                e.printStackTrace();
            }
            bluetoothSocket = tmp;

            bluetoothAdapter.cancelDiscovery();

            try {
                bluetoothSocket.connect();
            } catch (IOException e) {
                try {
                    bluetoothSocket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                e.printStackTrace();
            }
            connected(bluetoothSocket,bluetoothDevice);
        }
        public void cancel() {
            try {
                bluetoothSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public synchronized void start() {
        Log.d(TAG, "start");

        if(connectThread != null) {
            connectThread.cancel();
            connectThread = null;
        }
        if(insecureAcceptThread == null) {
            insecureAcceptThread = new AcceptThread();
            insecureAcceptThread.start();
        }
    }

    public void startClient(BluetoothDevice device, UUID uuid) {
        Log.d(TAG, "startClient: Started");

        progressDialog = ProgressDialog.show(context, "Connecting bluetooth",
                "Please wait...", true);

        connectThread = new ConnectThread(device, uuid);
        connectThread.start();
    }


    private class ConnectedThread extends Thread {
        private final BluetoothSocket bluetoothSocket;
        private final InputStream inputStream;
        private final OutputStream outputStream;


        public ConnectedThread(BluetoothSocket socket) {
            Log.d(TAG, "ConnectedThread: Starting");

            bluetoothSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            progressDialog.dismiss();

            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            inputStream = tmpIn;
            outputStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[1024];

            int bytes;

            while (true) {
                try {
                    bytes = inputStream.read(buffer);
                    String incomingMessage = new String(buffer, 0, bytes);
                    Log.d(TAG, "InputStream" + incomingMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }


        public void write(byte[] bytes) {
            String text = new String (bytes, Charset.defaultCharset());
            try {
                outputStream.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public void cancel() {
            try {
                bluetoothSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void connected(BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice) {
        Log.d(TAG, "Connected: Starting");

        connectedThread = new ConnectedThread(bluetoothSocket);
        connectedThread.start();
    }


    public void write(byte[] out) {
        ConnectedThread r;

        Log.d(TAG, "write: write called");
       connectedThread.write(out);

    }

}
