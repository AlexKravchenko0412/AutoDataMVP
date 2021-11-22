package android.example.autodata.settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.autodata.R;
import android.example.autodata.car.AutoActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavViewMenu);

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
                }
                return false;
            }
        });
    }
}