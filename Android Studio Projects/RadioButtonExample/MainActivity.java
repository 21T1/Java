package example.com.vn.radiobuttonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton radVery, radGood, radNormal, radBad;
    Button btnRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRate();
            }
        });
    }

    private void handleRate() {
        String s = "";
        if (radVery.isChecked()) {
            s = radVery.getText().toString();
        } else if (radGood.isChecked()) {
            s = radGood.getText().toString();
        } else if (radNormal.isChecked()) {
            s = radNormal.getText().toString();
        } else if (radBad.isChecked()){
            s = radBad.getText().toString();
        }

        Toast.makeText(MainActivity.this, "Đánh giá: " + s, Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        radVery = findViewById(R.id.radVery);
        radGood = findViewById(R.id.radGood);
        radNormal = findViewById(R.id.radNormal);
        radBad = findViewById(R.id.radBad);
        btnRate = findViewById(R.id.btnRate);
    }
}