package android.example.autodata.car.datasets;

import androidx.appcompat.app.AppCompatActivity;

import android.example.autodata.R;
import android.example.autodata.car.CarAdapter;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DataSetActivity extends AppCompatActivity {

    private TextView dataSetName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_set);
        dataSetName = findViewById(R.id.textViewDataSetName);


    }
}