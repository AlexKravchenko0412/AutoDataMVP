package android.example.autodata.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.autodata.R;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PairedDevicesActivityTest extends AppCompatActivity {

    private ListView lvPairedDevices;
    private ArrayList pairs;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paired_devices_test);

       /* lvPairedDevices = findViewById(R.id.lvPairedDevices);
        Bundle bundle = getIntent().getExtras();
        pairs = bundle.getStringArrayList("pairs");
        Intent intent = new Intent();
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,pairs);
        lvPairedDevices.setAdapter(adapter);
        */
    }
}