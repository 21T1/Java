package com.example.json_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.model.Post;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    ListView lvPost;
    ArrayList<Post> listPost;
    ArrayAdapter<Post> adapterPost;

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
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Thông báo");

        lvPost = findViewById(R.id.lvPost);
        listPost = new ArrayList<>();
        adapterPost = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listPost);
        lvPost.setAdapter(adapterPost);

        PostTask task = new PostTask();
        task.execute();
    }

    class PostTask extends AsyncTask<Void, Void, ArrayList<Post>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            adapterPost.clear();
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(ArrayList<Post> posts) {
            super.onPostExecute(posts);
            adapterPost.clear();
            adapterPost.addAll(posts);
            adapterPost.notifyDataSetChanged();
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<Post> doInBackground(Void... voids) {
            ArrayList<Post> lst = new ArrayList<>();
            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/posts");
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder builder = new StringBuilder();
                String line;
                do {
                    line = bufferedReader.readLine();
                    builder.append(line);
                } while (line != null);

                JSONArray jsonArray = new JSONArray(builder.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Post post = new Post();
                    if (jsonObject.has("userId")) {
                        post.setUserId(jsonObject.getString("userId"));
                    }
                    if (jsonObject.has("id")) {
                        post.setId(Integer.parseInt(jsonObject.getString("id")));
                    }
                    if (jsonObject.has("title")) {
                        post.setTitle(jsonObject.getString("title"));
                    }
                    if (jsonObject.has("body")) {
                        post.setBody(jsonObject.getString("body"));
                    }
                    lst.add(post);
                }
            } catch (Exception e) {
                Log.e("JSON_ERROR", e.toString());
            }
            return lst;
        }
    }
}