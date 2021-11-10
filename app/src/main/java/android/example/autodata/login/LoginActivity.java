package android.example.autodata.login;

import androidx.appcompat.app.AppCompatActivity;

import android.example.autodata.R;
//import android.example.autodata.database.UserDataDBHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {

    private EditText editTextLogin;
    private EditText editTextPassword;
    private Button btnEnter;


    private LoginContract.LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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