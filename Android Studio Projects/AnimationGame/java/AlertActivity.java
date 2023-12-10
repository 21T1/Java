package example.com.vn.animationgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
    }

    public void backToMain(View view) {
        Intent intent = new Intent(AlertActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}