package android.example.autodata.car;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.example.autodata.R;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

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