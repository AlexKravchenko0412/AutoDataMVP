package android.example.autodata.car.datasets.options;

import androidx.appcompat.app.AppCompatActivity;

import android.example.autodata.R;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class DataSellOptionsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private RadioButton radioButtonOperator;
    private RadioButton radioButtonMarketplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_sell_options);

        radioButtonOperator = findViewById(R.id.radioButtonOperator);
        radioButtonMarketplace = findViewById(R.id.radioButtonMarketplace);
        radioButtonOperator.setOnCheckedChangeListener(this);
        radioButtonMarketplace.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked) {
            if(buttonView.getId() == R.id.radioButtonOperator){
                radioButtonMarketplace.setChecked(false);
            }

        }
            if(isChecked) {
                if(buttonView.getId() == R.id.radioButtonMarketplace) {
                    radioButtonOperator.setChecked(false);
                }

            }

    }
}