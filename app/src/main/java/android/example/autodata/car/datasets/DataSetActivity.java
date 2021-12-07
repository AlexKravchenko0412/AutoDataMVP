package android.example.autodata.car.datasets;

import android.content.Intent;
import android.example.autodata.R;
import android.example.autodata.car.datasets.composition.DataSetCompositionActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DataSetActivity extends AppCompatActivity {

    private TextView dataSetName;
    private TextView tvDefaultTerm;
    private ImageView imageViewTerm;
    private ImageView ivCompositionDataset;
    private ImageView ivDataSellVariants;
    private FormPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_set);
        dataSetName = findViewById(R.id.textViewDataSetName);

        tvDefaultTerm =findViewById(R.id.textViewDefaultTerm);
        imageViewTerm = findViewById(R.id.imageViewTerm);
        ivCompositionDataset = findViewById(R.id.ivCompositionDataset);
        ivDataSellVariants = findViewById(R.id.ivDataSellVariants);
        presenter = new FormPresenter(this);


       Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String value = extras.getString("paramName");
            dataSetName.setText(value);
        }


        View.OnClickListener btnDatasetClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ivCompositionDataset:
                        Intent intent = new Intent(DataSetActivity.this, DataSetCompositionActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.ivDataSellVariants:
                        ///
                        break;
                    case R.id.imageViewTerm:

                        break;
                }
            }
        };
        imageViewTerm.setOnClickListener(btnDatasetClick);
        ivCompositionDataset.setOnClickListener(btnDatasetClick);
        ivDataSellVariants.setOnClickListener(btnDatasetClick);

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onFormStart();
    }

    public void setTvDefaultTerm(String val)
    {
        tvDefaultTerm.setText(val);
    }
}