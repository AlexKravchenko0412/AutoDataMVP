package android.example.autodata.car;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.example.autodata.R;
import android.os.Bundle;



public class AutoActivity extends AppCompatActivity {


    // ArrayList<CarDataPackage> dataPackage = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);
        RecyclerView recyclerView = findViewById(R.id.recViewCar);
        CarAdapter carAdapter = new CarAdapter(this);
        recyclerView.setAdapter(carAdapter);

    }

}