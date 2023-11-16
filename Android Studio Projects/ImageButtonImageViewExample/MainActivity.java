package example.com.vn.imagebuttonimageviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnImgExit;
    RadioButton radImgAnd, radImgIOS;
    ImageView imgImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnImgExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        radImgAnd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    imgImg.setImageResource(R.drawable.android);
                }
            }
        });

        radImgIOS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    imgImg.setImageResource(R.drawable.ios);
                }
            }
        });
    }

    private void addControls() {
        btnImgExit = findViewById(R.id.btnImgExit);
        radImgAnd = findViewById(R.id.radImgAnd);
        radImgIOS = findViewById(R.id.radImgIOS);
        imgImg = findViewById(R.id.imgImg);
    }
}