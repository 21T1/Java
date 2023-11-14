package example.com.vn.handleevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    EditText txtA, txtB;
    Button btnSub;
    Button btnMulti, btnDiv;
    Button btnHide;
    Button btnExit;

    View.OnClickListener eventShare = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubtraction();
            }
        });

        eventShare = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnMulti) {
                    handleMultiplication();
                } else if (v.getId() == R.id.btnDiv) {
                    handleDivision();
                }
            }
        };

        btnMulti.setOnClickListener(eventShare);
        btnDiv.setOnClickListener(eventShare);

        btnHide.setOnLongClickListener(this);

        btnExit.setOnClickListener(new MyEvent());
    }

    private void handleDivision() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());

        Toast.makeText(MainActivity.this, "Thương: " + (a / b), Toast.LENGTH_SHORT).show();
    }

    private void handleMultiplication() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());

        Toast.makeText(MainActivity.this, "Tích: " + (a * b), Toast.LENGTH_SHORT).show();
    }

    private void handleSubtraction() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());

        Toast.makeText(MainActivity.this, "Hiệu: " + (a - b), Toast.LENGTH_SHORT).show();
    }

    private void addControls() {
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        btnSub = findViewById(R.id.btnSub);
        btnMulti = findViewById(R.id.btnMulti);
        btnDiv = findViewById(R.id.btnDiv);
        btnHide = findViewById(R.id.btnHide);
        btnExit = findViewById(R.id.btnExit);
    }

    public void handleAddition(View v) {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());

        int c = a + b;
        Toast.makeText(MainActivity.this, "Tổng: " + c, Toast.LENGTH_LONG).show();    // LENGTH_LONG: 1.5s - 3.5s
    }


    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.btnHide) {
            btnHide.setVisibility(View.INVISIBLE);
        }
        return false;
    }

    public class MyEvent implements View.OnClickListener, View.OnLongClickListener {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btnExit) {
                finish();
            }
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }

    public void handleChange(View v) {
        Button btnNew = new androidx.appcompat.widget.AppCompatButton(MainActivity.this) {
            @Override
            public boolean performClick() {
                setContentView(R.layout.activity_main);

                addControls();
                addEvents();

                return super.performClick();
            }
        };

        btnNew.setText("Quay về");
        btnNew.setWidth(200);
        btnNew.setHeight(200);

        setContentView(btnNew);
    }
}