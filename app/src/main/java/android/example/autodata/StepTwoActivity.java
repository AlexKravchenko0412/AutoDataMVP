package android.example.autodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StepTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_two);
    }

    public void onClickNext(View view) {
        Intent intent = new Intent(this, StepThreeActivity.class);
        startActivity(intent);
    }
}