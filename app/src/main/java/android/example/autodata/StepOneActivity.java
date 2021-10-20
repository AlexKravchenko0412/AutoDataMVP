package android.example.autodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StepOneActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one);

    }

    public void onClickNext(View view) {
        Intent intent = new Intent(this, StepTwoActivity.class);
        startActivity(intent);
    }
}