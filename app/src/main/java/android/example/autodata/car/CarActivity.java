package android.example.autodata.car;

import androidx.appcompat.app.AppCompatActivity;

import android.example.autodata.R;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
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

public class CarActivity extends AppCompatActivity {

    private TextView textViewTest;
    private final String DATA_URL = "http://api.openweathermap.org/data/2.5/weather?q=%D0%9C%D0%BE%D1%81%D0%BA%D0%B2%D0%B0&appid=b79154bedd2aaa19f1dc0963dc255087";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        textViewTest = findViewById(R.id.textViewTest);
        DownloadDataTask downloadDataTask = new DownloadDataTask();
        downloadDataTask.execute(DATA_URL);
    }

    private class DownloadDataTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            URL url = null;
            URLConnection urlConnection = null;
            StringBuilder result = new StringBuilder();
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                while (line != null) {
                    result.append(line);
                    line = bufferedReader.readLine();
                }
                return result.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    ((HttpURLConnection) urlConnection).disconnect();
                }

            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                String city = jsonObject.getString("name");
                String temp = jsonObject.getJSONObject("main").getString("temp");
                String description = jsonObject.getJSONArray("weather").getJSONObject(0).
                        getString("description");
                String weather = String.format("%s\nTemp: %s\n%s", city, temp, description);
                textViewTest.setText(weather);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}