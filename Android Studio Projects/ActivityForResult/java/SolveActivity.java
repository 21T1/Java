package example.com.vn.activityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SolveActivity extends AppCompatActivity {

    TextView txtReceive;
    Button btnSolve;
    Intent intent;
    int a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleFindGCD();
            }
        });
    }

    private void handleFindGCD() {
        int min = Math.min(a, b);
        int gcd = 1;
        for (int i = min; i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }

        intent.putExtra("GCD", gcd);
        setResult(404, intent);
        finish();
    }

    private void addControls() {
        txtReceive = findViewById(R.id.txtReceive);
        btnSolve = findViewById(R.id.btnSolve);

        intent = getIntent();
        a = intent.getIntExtra("a", -1);
        b = intent.getIntExtra("b", -1);

        txtReceive.setText("a = " + a + "\nb = " + b);
    }
}