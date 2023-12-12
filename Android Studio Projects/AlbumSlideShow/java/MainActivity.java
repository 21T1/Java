package example.com.vn.albumslideshow;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView imgImg;
    CheckBox chkAuto;
    ImageButton btnPrev, btnNext;
    EditText txtNo;
    TextView txtNum;

    int currentPos = -1;
    ArrayList<String> lstImg;

    Timer timer = null;
    TimerTask timerTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleShowPrevImg();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleShowNextImg();
            }
        });
        chkAuto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Bật tự động", Toast.LENGTH_SHORT).show();

                    btnPrev.setEnabled(false);
                    btnNext.setEnabled(false);

                    handleShowImgAuto();
                } else {
                    Toast.makeText(MainActivity.this, "Tắt tự động", Toast.LENGTH_SHORT).show();

                    btnPrev.setEnabled(true);
                    btnNext.setEnabled(true);

                    if (timer != null) {
                        timer.cancel();
                    }
                }
            }
        });
        txtNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    int pos = Integer.parseInt(txtNo.getText().toString().trim());
                    new ImageTask().execute(lstImg.get(pos - 1));
                    currentPos = pos - 1;
                } catch (Exception ex) {
                    Log.e("POSITION_ERROR", ex.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void handleShowImgAuto() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {  // Update UI
                    @Override
                    public void run() {
                        currentPos++;
                        if (currentPos == lstImg.size()) {
                            currentPos = 0;
                        }
                        new ImageTask().execute(lstImg.get(currentPos));
                        txtNo.setText((currentPos + 1) + "");
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 0, 5000);
    }

    private void handleShowNextImg() {
        currentPos++;
        if (currentPos == lstImg.size()) {
            currentPos = 0;
        }
        new ImageTask().execute(lstImg.get(currentPos));
        txtNo.setText((currentPos + 1) + "");
    }

    private void handleShowPrevImg() {
        currentPos--;
        if (currentPos == -1) {
            currentPos = lstImg.size() - 1;
        }
        new ImageTask().execute(lstImg.get(currentPos));
        txtNo.setText((currentPos + 1) + "");
    }

    private void addControls() {
        imgImg = findViewById(R.id.imgImg);
        chkAuto = findViewById(R.id.chkAuto);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        txtNo = findViewById(R.id.txtNo);
        txtNum = findViewById(R.id.txtNum);

        lstImg = new ArrayList<>();
        insertListData();
        txtNum.setText("/ " + lstImg.size());

        currentPos = 0;
        chkAuto.setChecked(false);
        ImageTask task = new ImageTask();
        task.execute(lstImg.get(currentPos));
    }

    private void insertListData() {
        lstImg.add("https://mir-s3-cdn-cf.behance.net/project_modules/1400/b164aa10953207.560ef1bcba0e7.jpg");
        lstImg.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/adfb0110953207.560fb9139365a.jpg");
        lstImg.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/58bf3f10953207.562551eedc024.jpg");
        lstImg.add("https://sva.design/image/project/uploads/upload-28007-WS_Macbeth.jpg");
        lstImg.add("https://sva.design/image/project/uploads/upload-28008-WS_Romeo_Juliet.jpg");
        lstImg.add("https://sva.design/image/project/uploads/upload-28009-WS_Tempest.jpg");
        lstImg.add("https://sva.design/image/project/uploads/upload-28010-WS_Hamlet.jpg");
        lstImg.add("https://sva.design/image/project/uploads/upload-28011-WS_Midsummer.jpg");
    }

    class ImageTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgImg.setImageBitmap(bitmap);

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                InputStream inputStream = (InputStream) new URL(strings[0]).getContent();
                return BitmapFactory.decodeStream(inputStream);
            } catch (Exception ex) {
                Log.e("BITMAP_ERROR", ex.toString());
            }
            return null;
        }
    }
}