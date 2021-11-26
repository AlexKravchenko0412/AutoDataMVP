package android.example.autodata.car.datasets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.autodata.R;
import android.example.autodata.car.CarAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DataSetActivity extends AppCompatActivity {

    private TextView dataSetName;
    private ImageView imageViewTerm;
    private ImageView ivCompositionDataset;
    private ImageView ivDataSellVariants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_set);
        dataSetName = findViewById(R.id.textViewDataSetName);

        imageViewTerm = findViewById(R.id.imageViewTerm);
        ivCompositionDataset = findViewById(R.id.ivCompositionDataset);
        ivDataSellVariants = findViewById(R.id.ivDataSellVariants);


        View.OnClickListener btnDatasetClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ivCompositionDataset:
                        Intent intent = new Intent(DataSetActivity.this, DataSetCompositionActivity.class);
                        break;
                    case R.id.ivDataSellVariants:
                        ///
                        break;
                    case R.id.imageViewTerm:
                        ///
                        break;
                }
            }
        };
        imageViewTerm.setOnClickListener(btnDatasetClick);
        ivCompositionDataset.setOnClickListener(btnDatasetClick);
        ivDataSellVariants.setOnClickListener(btnDatasetClick);

    }
}