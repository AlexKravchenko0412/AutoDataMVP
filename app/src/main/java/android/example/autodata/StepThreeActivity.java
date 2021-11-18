package android.example.autodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.autodata.car.AutoActivity;
import android.os.Bundle;
import android.view.View;

public class StepThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_three);
    }

    public void onClickStart(View view) {
        Intent intent = new Intent(this, AutoActivity.class);
        startActivity(intent);
    }
}