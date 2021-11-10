package android.example.autodata.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.example.autodata.database.UserContract;
import android.example.autodata.database.UserDataDBHelper;

public class LoginRepository implements LoginContract.LoginRepository {

   // private UserDataDBHelper dbHelper;
    private String login;
    private String password;
    private SQLiteDatabase database;
    private Context mContext;

    public LoginRepository (Context context){
        mContext = context;
        try {
            UserDataDBHelper dbHelper = new UserDataDBHelper(mContext);
            database = dbHelper.getWritableDatabase();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addUser(String login, String password) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.UserData.COLUMN_LOGIN, login);
        contentValues.put(UserContract.UserData.COLUMN_PASSWORD, password);

        try {
            database.insert(UserContract.UserData.TABLE_NAME, null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public SQLiteDatabase getDatabase() {
        return database;
    }
}
