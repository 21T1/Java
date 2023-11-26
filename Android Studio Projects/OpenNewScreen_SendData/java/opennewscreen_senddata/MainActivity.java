package example.com.vn.opennewscreen_senddata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import example.com.vn.model.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleOpenAndSend(View view) {
        Intent intent = new Intent(MainActivity.this, Screen2Activity.class);

        intent.putExtra("KIEU_BOOLEAN", true);
        intent.putExtra("KIEU_CHAR", 'x');
        intent.putExtra("KIEU_INT", 100);
        intent.putExtra("KIEU_DOUBLE", 15.99);
        intent.putExtra("KIEU_STRING", "Example");
        Student student = new Student(1, "Example");
        intent.putExtra("STUDENT", student);

        startActivity(intent);
    }
}