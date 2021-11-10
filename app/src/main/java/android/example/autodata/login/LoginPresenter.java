package android.example.autodata.login;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.example.autodata.R;
import android.example.autodata.StepOneActivity;
import android.example.autodata.database.UserContract;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPresenter implements LoginContract.LoginPresenter {
    private LoginActivity mView;
    private LoginRepository mRepository;
    private String LOG_TAG = "myLogs";

    public LoginPresenter(Activity mView) {
        this.mView = (LoginActivity) mView;
        this.mRepository = new LoginRepository(mView.getApplicationContext());
    }


    @Override
    public void onButtonWasClicked() {
        EditText editTextLogin = mView.findViewById(R.id.editTextLogin);
        String login = editTextLogin.getText().toString().trim();
        EditText editTextPassword = mView.findViewById(R.id.editTextPassword);
        String password = editTextPassword.getText().toString().trim();
        if(!login.isEmpty() && !password.isEmpty()) {
            Intent intent = new Intent(mView, StepOneActivity.class);
            mView.startActivity(intent);
        } else {
            Toast.makeText(mView,
                    R.string.enter_all_fields,
                    Toast.LENGTH_SHORT).show();
        }

        mRepository.addUser(login, password);
    }

    @Override
    public void showDbLog() {
        Cursor cursor = mRepository.getDatabase().query(UserContract.UserData.TABLE_NAME, null, null, null, null,
                null, null);
        if (cursor.moveToFirst()) {
            int idColIndex = cursor.getColumnIndex(UserContract.UserData._ID);
            int idColLogin = cursor.getColumnIndex(UserContract.UserData.COLUMN_LOGIN);
            int idColPassword = cursor.getColumnIndex(UserContract.UserData.COLUMN_PASSWORD);

            do {
                Log.d(LOG_TAG, "ID = " + cursor.getInt(idColIndex) + ", Login = " + cursor.getString(idColLogin) +
                        ", Password = " + cursor.getString(idColPassword));
            } while (cursor.moveToNext());
        } else Log.d(LOG_TAG, "0 rows");
        cursor.close();
    }
}
