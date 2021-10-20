package android.example.autodata;

import android.provider.BaseColumns;

import java.util.stream.BaseStream;


//consists of names of columns, names of tables...
public class UserContract {
    public static class UserData implements BaseColumns {
        public static String TABLE_NAME = "user_data";
        public static String COLUMN_LOGIN = "login";
        public static String COLUMN_PASSWORD = "password";


        public static String TYPE_TEXT = "TEXT";
        public static String TYPE_INTEGER = "INTEGER";

        public static String CREATE_COMMAND = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + _ID + " " +
                TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " + COLUMN_LOGIN + " " +
                TYPE_TEXT + ", " + COLUMN_PASSWORD + " " + TYPE_TEXT + ", "  + TYPE_INTEGER + ")";

        public static String DROP_COMMAND = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }
}
