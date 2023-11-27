package example.com.vn.contactsactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import example.com.vn.model.Contact;

public class SmsActivity extends AppCompatActivity {

    private final int SMS_PERMISSION_CODE = 1;
    TextView txtContact, txtSms;
    ImageButton btnSend;

    Contact selectedContact = null;

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

        final SmsManager sms = SmsManager.getDefault();
        Intent msgSent = new Intent("ACTION_MSG_SENT");

        if (ActivityCompat.checkSelfPermission(SmsActivity.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    SmsActivity.this,
                    new String[]{Manifest.permission.SEND_SMS},
                    SMS_PERMISSION_CODE
            );
            Toast.makeText(SmsActivity.this, getApplicationContext() + "Không thể gửi tin nhắn", Toast.LENGTH_SHORT).show();
            return;
        }

        final PendingIntent pendingMsgSent = PendingIntent.getBroadcast(this, 0, msgSent, PendingIntent.FLAG_IMMUTABLE);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (getResultCode() != Activity.RESULT_OK) {
                    Toast.makeText(SmsActivity.this, "Gửi tin nhắn thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        }, new IntentFilter("ACTION_MSG_SENT"));

        sms.sendTextMessage(
                selectedContact.getPhone(),
                null,
                txtSms.getText().toString(),
                pendingMsgSent,
                null
                );
    }


    private void addControls() {
        txtContact = findViewById(R.id.txtContact);
        txtSms = findViewById(R.id.txtSms);
        btnSend = findViewById(R.id.btnSend);

        Intent intent = getIntent();
        selectedContact = (Contact) intent.getSerializableExtra("CONTACT");
        txtContact.setText(selectedContact.getName() + " (" + selectedContact.getPhone() + ")");
    }
}