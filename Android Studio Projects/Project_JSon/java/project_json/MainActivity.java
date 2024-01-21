package com.example.project_json;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.adapter.RateAdapter;
import com.example.model.Rate;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    ListView lvRate;
    ArrayList<Rate> listRate;
    RateAdapter rateAdapter;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        lvRate = findViewById(R.id.lvRate);
        listRate = new ArrayList<>();
        rateAdapter = new RateAdapter(this, R.layout.item, listRate);
        lvRate.setAdapter(rateAdapter);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Thông báo");
        progressDialog.setMessage("Đang tải...");

        RateTask task = new RateTask();
        task.execute();
    }

    class RateTask extends AsyncTask<Void, Void, ArrayList<Rate>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            listRate.clear();
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(ArrayList<Rate> rates) {
            super.onPostExecute(rates);
            listRate.clear();
            listRate.addAll(rates);
            rateAdapter.notifyDataSetChanged();
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<Rate> doInBackground(Void... voids) {
            ArrayList<Rate> lst = new ArrayList<>();
            try {
                URL url = new URL("https://dongabank.com.vn/exchange/export");
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                connection.setRequestProperty("User-Agent", "PostmanRuntime/7.36.1");   // "Mozilla/5.0 ( compatible ) "
                connection.setRequestProperty("Accept", "*/*");

                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder builder = new StringBuilder();
                String line;
                do {
                    line = bufferedReader.readLine();
                    builder.append(line);
                } while (line != null);
                String json = builder.toString();
                json = json.replace("(", "");
                json = json.replace(")", "");

                JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = jsonObject.getJSONArray("items");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject item = jsonArray.getJSONObject(i);
                    Rate rate = new Rate();
                    if (item.has("type")) {
                        rate.setType(item.getString("type"));
                    }
                    if (item.has("imageurl")) {
                        rate.setImageurl(item.getString("imageurl"));

                        url = new URL(rate.getImageurl());
                        connection = (HttpsURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                        connection.setRequestProperty("User-Agent", "PostmanRuntime/7.36.1");
                        connection.setRequestProperty("Accept", "*/*");
                        Bitmap bitmap = BitmapFactory.decodeStream(connection.getInputStream());

                        rate.setBitmap(bitmap);
                    }
                    if (item.has("muatienmat")) {
                        rate.setBuyCash(item.getString("muatienmat"));
                    }
                    if (item.has("muack")) {
                        rate.setBuyTransfer(item.getString("muack"));
                    }
                    if (item.has("bantienmat")) {
                        rate.setSellCash(item.getString("bantienmat"));
                    }
                    if (item.has("banck")) {
                        rate.setSellTransfer(item.getString("banck"));
                    }
                    lst.add(rate);
                }
            } catch (Exception e) {
                Log.e("JSON_ERROR", e.toString());
                progressDialog.setMessage(e.toString());
            }
            return lst;
        }
    }
}