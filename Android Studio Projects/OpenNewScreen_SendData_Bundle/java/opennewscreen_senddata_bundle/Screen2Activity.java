package example.com.vn.opennewscreen_senddata_bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Screen2Activity extends AppCompatActivity {

    TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        addControls();
    }

    private void addControls() {
        txtRes = findViewById(R.id.txRes);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("MY_BUNDLE");

        txtRes.setText("X = " + bundle.getInt("X")
                + "\nD = " + bundle.getDouble("D")
                + "\nSinh viên: " + bundle.getSerializable("STUDENT"));
    }
}