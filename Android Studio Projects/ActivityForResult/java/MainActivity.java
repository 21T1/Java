package example.com.vn.activityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtA, txtB;
    Button btnSubmit;
    TextView txtResult;

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
                handleFindGCD();
            }
        });
    }

    private void handleFindGCD() {
        Intent intent = new Intent(MainActivity.this, SolveActivity.class);
        intent.putExtra("a", Integer.parseInt(txtA.getText().toString()));
        intent.putExtra("b", Integer.parseInt(txtB.getText().toString()));
        startActivityForResult(intent, 111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 111 && resultCode == 404) {
            txtResult.setText("UCLN = " + data.getIntExtra("GCD", 1));
        }
    }

    private void addControls() {
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtResult = findViewById(R.id.txtResult);
    }
}