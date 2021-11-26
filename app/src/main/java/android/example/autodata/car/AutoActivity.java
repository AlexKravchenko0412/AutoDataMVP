package android.example.autodata.car;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.example.autodata.OfferActivity;
import android.example.autodata.R;
import android.example.autodata.stock.StockActivity;
import android.example.autodata.settings.SettingsActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class AutoActivity extends AppCompatActivity {


    // ArrayList<CarDataPackage> dataPackage = new ArrayList<>();
    private ImageView auto;
    private ImageView stock;
    private ImageView offer;
    private ImageView settings;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);
        RecyclerView recyclerView = findViewById(R.id.recViewCar);
        CarAdapter.OnCarDataClickListener carDataClickListener = new CarAdapter.OnCarDataClickListener() {
            @Override
            public void OnCarDataClick(CarDataPackage carDataModel, int position) {
                Intent intent = new Intent(getApplicationContext(), CarDataPackage.class);
                // put dataset name in intent
                startActivity(intent);
            }
        };
        CarAdapter carAdapter = new CarAdapter(this, carDataClickListener);
        recyclerView.setAdapter(carAdapter);

        auto = findViewById(R.drawable.auto_img);
        stock = findViewById(R.drawable.stock_img);
        offer = findViewById(R.drawable.offers_img);
        settings = findViewById(R.drawable.settings_img);


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
                        Intent offerIntent = new Intent(getApplicationContext(), OfferActivity.class);
                        startActivity(offerIntent);
                }
                return false;
            }
        });

    }


}