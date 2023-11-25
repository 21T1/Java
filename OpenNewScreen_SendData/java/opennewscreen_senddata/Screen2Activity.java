package example.com.vn.opennewscreen_senddata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import example.com.vn.model.Student;

public class Screen2Activity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        addControls();
    }

    private void addControls() {
        txtResult = findViewById(R.id.txtResult);

        Intent intent = getIntent();
        boolean varBoolean = intent.getBooleanExtra("KIEU_BOOLEAN", false);
        char varChar = intent.getCharExtra("KIEU_CHAR", ' ');
        int varInt = intent.getIntExtra("KIEU_INT", -1);
        double varDouble = intent.getDoubleExtra("KIEU_DOUBLE", 0.0);
        String varString = intent.getStringExtra("KIEU_STRING");
        Student student = (Student) intent.getSerializableExtra("STUDENT");

        txtResult.setText("Kiểu boolean: " + varBoolean
                + "\nKiểu char: " + varChar
                + "\nKiểu int: " + varInt
                + "\nKiểu double: " + varDouble
                + "\nKiểu chuỗi: " + varString
                + "\nKiểu đối tượng: " + student);
    }
}