package example.com.vn.autocompletetextviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtName;
    AutoCompleteTextView autoProvince;
    String[] arrProvince;
    ArrayAdapter<String> adapterProvince;
    Button btnSubmit;
    TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubmit();
            }
        });
    }

    private void handleSubmit() {
        String s = txtName.getText().toString()
                + " - " + autoProvince.getText().toString() + "\n";
        txtInfo.setText(s);
    }

    private void addControls() {
        txtName = findViewById(R.id.txtName);

        autoProvince = findViewById(R.id.autoProvince);
        arrProvince = getResources().getStringArray(R.array.arrProvince);
        adapterProvince = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrProvince
        );
        autoProvince.setAdapter(adapterProvince);

        btnSubmit = findViewById(R.id.btnSubmit);
        txtInfo = findViewById(R.id.txtInfo);
    }
}