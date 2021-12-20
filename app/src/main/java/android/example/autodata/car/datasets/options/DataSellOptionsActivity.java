package android.example.autodata.car.datasets.options;

import androidx.appcompat.app.AppCompatActivity;

import android.example.autodata.R;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class DataSellOptionsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private RadioButton radioButtonOperator;
    private RadioButton radioButtonMarketplace;
    private CheckBox checkBoxPersonalized;
    private TextView price;
    private TextView marketPrice;
    private TextView personPrice;
    private DataSellOptionsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_sell_options);

        checkBoxPersonalized = findViewById(R.id.checkBoxPersonalized);
        radioButtonOperator = findViewById(R.id.radioButtonOperator);
        radioButtonMarketplace = findViewById(R.id.radioButtonMarketplace);
        radioButtonOperator.setOnCheckedChangeListener(this);
        radioButtonMarketplace.setOnCheckedChangeListener(this);

        price = findViewById(R.id.textViewPrice);
        marketPrice = findViewById(R.id.tvMarketplacePrice);
        personPrice = findViewById(R.id.tvPersonalizedDataPrice);
        presenter = new DataSellOptionsPresenter(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            if (buttonView.getId() == R.id.radioButtonOperator) {
                radioButtonMarketplace.setChecked(false);
            }

        }
        if (isChecked) {
            if (buttonView.getId() == R.id.radioButtonMarketplace) {
                radioButtonOperator.setChecked(false);
            }

        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onOptionsStart();
    }

    public void setPrices(String a, String b, String c) {
        price.setText(a);
        marketPrice.setText(b);
        personPrice.setText(c);
    }
}