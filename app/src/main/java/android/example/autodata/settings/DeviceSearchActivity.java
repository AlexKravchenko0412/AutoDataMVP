package android.example.autodata.settings;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.example.autodata.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class DeviceSearchActivity extends AppCompatActivity {

   /// private int REQUEST_CODE = 1;
   /// private Set<BluetoothDevice> pairedDev;
   /// private ArrayList<String> listPairedDevices;
    private Button btnDeviceSearch;

    /*private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String deviceName = device.getName();
                String deviceAddress = device.getAddress();
                listPairedDevices.add(deviceName + " : " + deviceAddress);

            }
        }
    };

    BluetoothAdapter mBlueAdapter; */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_search);
        btnDeviceSearch = findViewById(R.id.btnDeviceSearch);
        //lvPairedDevices = findViewById(R.id.lvPairedDevices);

        /*mBlueAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBlueAdapter == null) {
            showToast("Bluetooth недоустпен");
        } else {
            if (!mBlueAdapter.isEnabled()) {
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent, REQUEST_CODE);
            }
        }*/


        btnDeviceSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeviceSearchActivity.this, DeviceScanActivity.class);
                startActivity(intent);
                /*pairedDev = mBlueAdapter.getBondedDevices();
                listPairedDevices = new ArrayList<>();
                int count = pairedDev.size();
                if (count > 0) {
                    for (BluetoothDevice device : pairedDev) {
                        String devName = device.getName();
                        String devAddress = device.getAddress();
                        //listPairedDevices.add(devName + " : " + devAddress);
                    }
                }*/

                /*if (mBlueAdapter.isDiscovering()) {
                    mBlueAdapter.cancelDiscovery();
                }

                IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
                registerReceiver(receiver, filter);

                mBlueAdapter.startDiscovery();*/

                /*Bundle bundle = new Bundle();
                bundle.putStringArrayList("pairs", listPairedDevices);
                Intent intent = new Intent(DeviceSearchActivity.this, PairedDevicesActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);*/
            }
        });
    }


    /*public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                showToast("Bluetooth on");

                //adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,
                //      (List) lvPairedDevices);
                //lvPairedDevices.setAdapter(adapter);
            } else {
                showToast("Bluetooth off");
            }
        }
    }*/


    /*@Override
    protected void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    2);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    4);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_ADMIN)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BLUETOOTH_ADMIN},
                    3);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }*/

    /*private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }*/
}