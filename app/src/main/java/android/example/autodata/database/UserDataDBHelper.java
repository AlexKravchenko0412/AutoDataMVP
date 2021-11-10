package android.example.autodata.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.example.autodata.database.UserContract;


public class UserDataDBHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "user_data.db";
    private static int DB_VERSION = 1;


    public UserDataDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserContract.UserData.CREATE_COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserContract.UserData.DROP_COMMAND);
        onCreate(db);
    }
}
