package android.example.autodata.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.example.autodata.R;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class DeviceSearchActivityTest extends AppCompatActivity {

    private Button btnDevSearch;
    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;
    BluetoothAdapter adapter;

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
                showToast("Bluetooth выключен");
        }

    }

    private void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}