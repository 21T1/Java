package example.com.vn.contentproviderexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleReadContacts(View view) {
        Intent intentContacts = new Intent(MainActivity.this, ContactsActivity.class);
        startActivity(intentContacts);
    }

    public void handleReadSms(View view) {
        Intent intentSms = new Intent(MainActivity.this, SmsActivity.class);
        startActivity(intentSms);
    }
}