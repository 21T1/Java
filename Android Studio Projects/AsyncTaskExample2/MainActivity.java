package example.com.vn.asynctaskexample2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText txtUrl;
    Button btnDownload;
    ImageView imgImg;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDownload();
            }
        });
    }

    private void handleDownload() {
        String url = txtUrl.getText().toString().trim();
        ImageTask task = new ImageTask();
        if (!url.matches("")) {
            task.execute(url);
        } else {
            task.execute(randomUrl());
        }
    }

    private String randomUrl() {
        String url = "https://memetemplatehouse.com/wp-content/uploads/2020/08/AD782843-1C41-4BAD-AC51-5E4A84A55DBD.jpeg";
        String url2 = "https://imgflip.com/s/meme/Cute-Cat.jpg";
        String url3 = "https://i.pinimg.com/564x/33/07/47/330747ce550405e3a2273043a0503d76.jpg";
        String url4 = "https://i.cbc.ca/1.5359228.1577206958!/fileImage/httpImage/image.jpg_gen/derivatives/16x9_620/smudge-the-viral-cat.jpg";
        String url5 = "https://static.independent.co.uk/2020/09/22/09/Untitled.png";

        ArrayList<String> lstUrl = new ArrayList<String>();
        lstUrl.add(url);
        lstUrl.add(url2);
        lstUrl.add(url3);
        lstUrl.add(url4);
        lstUrl.add(url5);

        Random random = new Random();
        return lstUrl.get(random.nextInt(5));
    }

    private void addControls() {
        txtUrl = findViewById(R.id.txtUrl);
        btnDownload = findViewById(R.id.btnDownload);
        imgImg = findViewById(R.id.imgImg);
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setTitle("Thông báo");
        dialog.setMessage("Đang tải");
        dialog.setCanceledOnTouchOutside(false);    // not turn off when touch out
    }

    class ImageTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgImg.setImageBitmap(bitmap);
            dialog.dismiss();   // reuse <> cancel
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                InputStream inputStream = (InputStream) new URL(strings[0]).getContent();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            } catch (Exception e) {
                Log.e("LOI", e.toString());
            }

            return null;
        }
    }
}