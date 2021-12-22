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

    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;

    private Button btnDeviceSearch;

    BluetoothAdapter mBlueAdapter;
    private ArrayList<String> pairedDevs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_search);
        btnDeviceSearch = findViewById(R.id.btnDeviceSearch);

        mBlueAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBlueAdapter == null) {
            showToast("Bluetooth недоустпен");
        }

        btnDeviceSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  if (!mBlueAdapter.isEnabled()) {
             //       showToast("Bluetooth включается");
              //      Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
              //      startActivityForResult(intent, REQUEST_ENABLE_BT);
              //  } else {
              //      showToast("Bluetooth уже включен");
              //  }

                if(!mBlueAdapter.isDiscovering()) {
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(intent,REQUEST_DISCOVER_BT);
                }

               // if(mBlueAdapter.isEnabled()) {
             //       mBlueAdapter.disable();
               //     showToast("Bluetooth выключается");
              //  }
              //  else {
              //      showToast("Bluetooth уже выключен");
              //  }

                if(mBlueAdapter.isEnabled()) {
                    Set<BluetoothDevice> devices = mBlueAdapter.getBondedDevices();
                    for(BluetoothDevice device : devices) {
                        pairedDevs.add(device.getName());
                    }
                }
                else {
                    showToast("Bluetooth выключен");
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case REQUEST_ENABLE_BT:
                if (resultCode == RESULT_OK) {
                    showToast("Bluetooth включен");
                } else {
                    showToast("Не удалось включить Bluetooth");
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}