package android.example.autodata.offers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.autodata.R;
import android.example.autodata.car.AutoActivity;
import android.example.autodata.settings.SettingsActivity;
import android.example.autodata.stock.StockActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OffersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavViewMenu);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_auto:
                        Intent intentAuto = new Intent(getApplicationContext(), AutoActivity.class);
                        startActivity(intentAuto);
                        //auto.setVisibility(View.VISIBLE);
                        //stock.setVisibility(View.GONE);
                        //offer.setVisibility(View.GONE);
                        //settings.setVisibility(View.GONE);
                        break;
                    case R.id.settings:
                        //auto.setVisibility(View.GONE);
                        //stock.setVisibility(View.GONE);
                        //offer.setVisibility(View.GONE);
                        //settings.setVisibility(View.VISIBLE);
                        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                        startActivity(intent);
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
    }
}