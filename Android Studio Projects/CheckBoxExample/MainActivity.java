package example.com.vn.checkboxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chkMath, chkPhys, chkChem;
    Button btnSelect;
    TextView txtSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSelectSubject();
            }
        });

    }

    private void handleSelectSubject() {
        String s = "";
        if (chkMath.isChecked()) {
            s += chkMath.getText().toString() + "\n";
        }
        if (chkPhys.isChecked()) {
            s += chkPhys.getText().toString() + "\n";
        }
        if (chkChem.isChecked()) {
            s += chkChem.getText().toString() + "\n";
        }
        txtSubject.setText(s);
    }

    private void addControls() {
        chkMath = findViewById(R.id.chkMath);
        chkPhys = findViewById(R.id.chkPhys);
        chkChem = findViewById(R.id.chkChem);
        btnSelect = findViewById(R.id.btnSelect);
        txtSubject = findViewById(R.id.txtSubject);
    }
}