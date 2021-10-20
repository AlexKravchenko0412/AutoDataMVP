package android.example.autodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.example.autodata.R;
import android.example.autodata.StepOneActivity;
import android.example.autodata.UserContract;
//import android.example.autodata.UserDataDBHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {

    private EditText editTextLogin;
    private EditText editTextPassword;
    private Button btnEnter;
    //private UserDataDBHelper dbHelper;

    private LoginContract.LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //editTextLogin = findViewById(R.id.editTextLogin);
        //editTextPassword = findViewById(R.id.editTextPassword);
        //dbHelper = new UserDataDBHelper(this);
        mPresenter = new LoginPresenter(this);
        btnEnter = findViewById(R.id.buttonEnter);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onButtonWasClicked();
                mPresenter.showDbLog();
            }
        });
    }
}