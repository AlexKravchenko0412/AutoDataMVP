package android.example.autodata.settings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.example.autodata.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class DeviceSearchActivity extends AppCompatActivity {

    //private static final int REQUEST_ENABLE_BT = 0;
    //private static final int REQUEST_DISCOVER_BT = 1;
    private int REQUEST_CODE = 1;
    private Set<BluetoothDevice> pairedDevices;
    private ArrayList<String> listPairedDevices;


    private Button btnDeviceSearch;

    BluetoothAdapter mBlueAdapter;
    //private ArrayList<String> pairedDevs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_search);
        btnDeviceSearch = findViewById(R.id.btnDeviceSearch);

        btnDeviceSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBlueAdapter = BluetoothAdapter.getDefaultAdapter();
                if (mBlueAdapter == null) {
                    showToast("Bluetooth недоустпен");
                } else {
                    if (!mBlueAdapter.isEnabled()) {
                        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(intent, REQUEST_CODE);
                    }
                }
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE)
        {
           if(resultCode==RESULT_OK)
           {
               showToast("Bluetooth on");
               pairedDevices = mBlueAdapter.getBondedDevices();
               int count = pairedDevices.size();
               for(BluetoothDevice device : pairedDevices)
               {
                   listPairedDevices.add(device.getName().toString());
                   count++;
               }
           }


        }
    }


    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}