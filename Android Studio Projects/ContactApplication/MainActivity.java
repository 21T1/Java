package example.com.vn.contactapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtPhone, txtMessage;
    Button btnDial, btnCall, btnText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDial();
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCall();
            }
        });
        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleText();
            }
        });
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    private void handleText() {
        final SmsManager sms = SmsManager.getDefault();
        Intent intent = new Intent("ACTION_MSG_SENT");
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            return;
        }

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg = "OK";
                if (result != Activity.RESULT_OK) {
                    msg = "Failed";
                }
                Toast.makeText(MainActivity.this, "msg", Toast.LENGTH_SHORT).show();
            }
        }, new IntentFilter("ACTION_MSG_SENT"));

        sms.sendTextMessage(
                txtPhone.getText().toString(),
                null,
                txtMessage.getText() + "",
                pendingIntent,
                null
        );
    }

    private void handleCall() {
        Uri uri = Uri.parse("tel:" + txtPhone.getText().toString());
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(intent);
    }

    private void handleDial() {
        Uri uri = Uri.parse("tel:" + txtPhone.getText().toString());
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);
    }

    private void addControls() {
        txtPhone = findViewById(R.id.txtPhone);
        txtMessage = findViewById(R.id.txtMessage);
        btnDial = findViewById(R.id.btnDial);
        btnCall = findViewById(R.id.btnCall);
        btnText = findViewById(R.id.btnText);
    }
}