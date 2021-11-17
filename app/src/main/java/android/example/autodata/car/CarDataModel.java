package android.example.autodata.car;

import android.example.autodata.R;
import android.os.AsyncTask;

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
import java.util.ArrayList;

public class CarDataModel {
    ArrayList<CarDataPackage> items = new ArrayList<>();
    private final String DATA_URL = "https://api.openweathermap.org/data/2.5/weather?q=Санкт-Петербург&appid=b47d1fe9f6c8abcc2c5ced5c59413e6d";
    private CarAdapter carAdapter;

    public CarDataModel(CarAdapter adapter) {
        carAdapter = adapter;
    }

    public void onLoadCarData() {
        DownloadData downloadData = new DownloadData();
        downloadData.execute(DATA_URL);

    }

    public int getSize() {
        return items.size();
    }

    public CarDataPackage getDataItem(int position) {
        return items.get(position);
    }

    private class DownloadData extends AsyncTask<String, Void, String> {

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
            } catch (Exception ex) {
                ex.printStackTrace();
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

                if (s != null) {
                    JSONObject jsonObject = new JSONObject(s);
                    String city = jsonObject.getString("name");
                    String temp = jsonObject.getJSONObject("main").getString("temp");
                    String description = jsonObject.getJSONArray("weather").getJSONObject(0).
                            getString("description");
                    items.add(new CarDataPackage(city, city, R.drawable.warning_img));
                    items.add(new CarDataPackage(temp, temp, R.drawable.warning_img));
                    items.add(new CarDataPackage(description, description, R.drawable.warning_img));
                    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                    //       android.R.layout.simple_list_item_1, items);
                    //listViewTest.setAdapter(adapter);

                    //String weather = String.format("%s\nTemp: %s\n%s", city, temp, description);
                    //textViewTest.setText(weather);
                }
                carAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

}
