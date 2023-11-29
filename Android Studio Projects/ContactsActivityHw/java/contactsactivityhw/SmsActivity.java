package example.com.vn.contactsactivityhw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SmsActivity extends AppCompatActivity {

    private final int SMS_PERMISSION_CODE = 1;
    EditText txtPhoneNum, txtMsg;
    Button btnSend;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSend();
            }
        });
    }

    private void handleSend() {
        if (ActivityCompat.checkSelfPermission(SmsActivity.this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    SmsActivity.this,
                    new String[]{Manifest.permission.SEND_SMS},
                    SMS_PERMISSION_CODE
            );
            Toast.makeText(SmsActivity.this, "Không thể thực hiện gửi tin nhắn", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] lstPhone = txtPhoneNum.getText().toString().split("; ");
        String msg = txtMsg.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        for (String phone : lstPhone) {
            smsManager.sendTextMessage(
                    phone,
                    null,
                    msg,
                    null,
                    null
            );
        }
        Toast.makeText(SmsActivity.this, "Gửi tin nhắn thành công", Toast.LENGTH_SHORT).show();
    }

    private void addControls() {
        txtPhoneNum = findViewById(R.id.txtPhoneNum);
        txtMsg = findViewById(R.id.txtMsg);
        btnSend = findViewById(R.id.btnSend);

        intent = getIntent();
        ArrayList<String> listSelect = intent.getStringArrayListExtra("LIST_SELECT");

        String to = "";
        for (String s : listSelect) {
            to += s + "; ";
        }
        to = to.substring(0, to.length() - 2);
        txtPhoneNum.setText(to);
    }
}