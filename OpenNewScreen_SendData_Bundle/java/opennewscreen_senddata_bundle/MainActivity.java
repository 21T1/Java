package example.com.vn.opennewscreen_senddata_bundle;

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

    public void handleOpenAndSendWithBundle(View view) {
        Intent intent = new Intent(MainActivity.this, Screen2Activity.class);

        Bundle bundle = new Bundle();
        bundle.putInt("X", 1);
        bundle.putDouble("D", 1.1);
        Student student = new Student(1, "ABC");
        bundle.putSerializable("STUDENT", student);

        intent.putExtra("MY_BUNDLE", bundle);
        startActivity(intent);
    }
}