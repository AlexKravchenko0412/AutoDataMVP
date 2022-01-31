package android.example.autodata.settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.autodata.R;
import android.example.autodata.car.AutoActivity;
import android.example.autodata.offers.OffersActivity;
import android.example.autodata.settings.bluetooth.BtConnectionActivity;
import android.example.autodata.stock.StockActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsActivity extends AppCompatActivity {

    private Button btnChooseDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavViewMenu);
        btnChooseDevice = findViewById(R.id.btnChooseDevice);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_auto:
                        //auto.setVisibility(View.VISIBLE);
                        //stock.setVisibility(View.GONE);
                        //offer.setVisibility(View.GONE);
                        //settings.setVisibility(View.GONE);
                        Intent intent = new Intent(getApplicationContext(), AutoActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.settings:
                        //auto.setVisibility(View.GONE);
                        //stock.setVisibility(View.GONE);
                        //offer.setVisibility(View.GONE);
                        //settings.setVisibility(View.VISIBLE);
                        break;
                    case R.id.action_stock:
                        Intent stockIntent = new Intent(getApplicationContext(), StockActivity.class);
                        startActivity(stockIntent);
                        break;
                    case R.id.action_offers:
                        Intent offerIntent = new Intent(getApplicationContext(), OffersActivity.class);
                        startActivity(offerIntent);
                }
                return false;
            }
        });

        btnChooseDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(SettingsActivity.this, DeviceSearchActivity.class);
                //Intent intent = new Intent(SettingsActivity.this, DeviceSearchActivity.class);
                Intent intent = new Intent(SettingsActivity.this, BtConnectionActivity.class);
                startActivity(intent);
            }
        });
    }
}