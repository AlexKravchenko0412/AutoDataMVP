package android.example.autodata.settings;

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

public class DeviceSearchActivityTest extends AppCompatActivity {

    private Button btnDevSearch;
    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;
    BluetoothAdapter adapter;
    private ArrayList<String> pairedList;
    private String dev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_search_test);

        btnDevSearch = findViewById(R.id.btnDeviceSearch);

        adapter = BluetoothAdapter.getDefaultAdapter();

        if (adapter == null) {
            showToast("Bluetooth не доступен");
        } else {
            showToast("Bluetooth доступен");
        }

        if (adapter.isEnabled()) {
            showToast("Bluetooth включен");
        } else {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent,REQUEST_ENABLE_BT);
        }

        btnDevSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adapter.isEnabled()) {
                    String devName = adapter.getName();
                    String devAddress = adapter.getAddress();
                    dev = devName + " : " + devAddress;
                } else
                    {
                        dev = "Bluetooth off";
                    }
                showToast(dev);

                Set<BluetoothDevice> pairedDevices = adapter.getBondedDevices();
                if(pairedDevices.size() > 0) {
                    for(BluetoothDevice device : pairedDevices) {
                        pairedList.add(device.getName() + "\n" + device.getAddress());
                    }
                }

            }
        });

       /* btnDevSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.isEnabled()) {
                    Set<BluetoothDevice> devices = adapter.getBondedDevices();
                    for (BluetoothDevice device : devices) {
                        String devName = device.getName();
                        pairedList.add(devName);
                    }

                } else {
                    showToast("Включите bluetooth");
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("pairs",pairedList);
                Intent intent = new Intent(DeviceSearchActivityTest.this, PairedDevicesActivityTest.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }); */

    }

    private void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}