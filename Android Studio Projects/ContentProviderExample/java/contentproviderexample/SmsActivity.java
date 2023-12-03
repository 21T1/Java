package example.com.vn.contentproviderexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import example.com.vn.adapter.SmsAdapter;
import example.com.vn.model.SmsRead;

public class SmsActivity extends AppCompatActivity {

    private final int SMS_PERMISSION_CODE = 2;
    ListView lvSms;
    ArrayList<SmsRead> lstSms;
    SmsAdapter smsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        addControls();
        addEvents();

        if (readSmsPermission()) {
            readAllSms();
            Toast.makeText(this, "Đọc tin nhắn thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Không thể đọc tin nhắn", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean readSmsPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.READ_SMS},
                    SMS_PERMISSION_CODE
            );
            return false;
        }
        return true;
    }

    private void readAllSms() {
        Uri uri = Uri.parse("content://sms/sent");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        lstSms.clear();
        while (cursor.moveToNext()) {
            int indexPhoneNumber = cursor.getColumnIndex("address");
            int indexTimeStamp = cursor.getColumnIndex("date");
            int indexBody = cursor.getColumnIndex("body");

            String phoneNumber = cursor.getString(indexPhoneNumber);
            String timeStamp = cursor.getString(indexTimeStamp);
            String body = cursor.getString(indexBody);
            lstSms.add(new SmsRead(phoneNumber, timeStamp, body));
        }
        cursor.close();
        smsAdapter.notifyDataSetChanged();
    }
    private void addEvents() {

    }

    private void addControls() {
        lvSms = findViewById(R.id.lvSms);
        lstSms = new ArrayList<>();
        smsAdapter = new SmsAdapter(
                SmsActivity.this,
                R.layout.item_sms,
                lstSms
        );
        lvSms.setAdapter(smsAdapter);
    }
}