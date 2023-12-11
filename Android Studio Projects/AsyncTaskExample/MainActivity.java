package example.com.vn.asynctaskexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText txtNum;
    Button btnDraw;
    ProgressBar progressBarPercent;
    TextView txtPercent;
    LinearLayout layoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDrawButtonInRealTime();
            }
        });
    }

    private void handleDrawButtonInRealTime() {
        int n = Integer.parseInt(txtNum.getText().toString());

        ButtonTask task = new ButtonTask();
        task.execute(n);
    }

    private void addControls() {
        txtNum = findViewById(R.id.txtNum);
        btnDraw = findViewById(R.id.btnDraw);
        progressBarPercent = findViewById(R.id.progressBarPercent);
        txtPercent = findViewById(R.id.txtPercent);
        layoutButton = findViewById(R.id.layoutButton);
    }

    class ButtonTask extends AsyncTask<Integer, Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            layoutButton.removeAllViews();
            progressBarPercent.setProgress(0);
            txtPercent.setText("0%");
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            progressBarPercent.setProgress(100);
            txtPercent.setText("100%");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int value = values[1];
            int percent = values[0];
            progressBarPercent.setProgress(percent);
            txtPercent.setText(percent + "%");

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,    // width
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );

            Button btn = new Button(MainActivity.this);
            btn.setLayoutParams(params);
            btn.setText(value + "");

            layoutButton.addView(btn);
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            int n = integers[0];
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                int percent = i * 100 / n;
                int value = random.nextInt(500);
                publishProgress(percent, value);
                SystemClock.sleep(100);
            }
            return null;
        }
    }
}