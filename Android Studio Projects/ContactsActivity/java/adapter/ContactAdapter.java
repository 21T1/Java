package example.com.vn.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import java.util.List;

import example.com.vn.contactsactivity.MainActivity;
import example.com.vn.contactsactivity.R;
import example.com.vn.contactsactivity.SmsActivity;
import example.com.vn.model.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private final int PHONE_PERMISSION_CODE = 1;

    Activity context;
    int resource;
    List<Contact> object;
    public ContactAdapter(@NonNull Activity context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.object = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View view = inflater.inflate(this.resource, null);

        TextView txtContactName = view.findViewById(R.id.txtContactName);
        TextView txtContactPhone = view.findViewById(R.id.txtContactPhone);
        ImageButton btnCall = view.findViewById(R.id.btnCall);
        ImageButton btnSms = view.findViewById(R.id.btnSms);
        ImageButton btnDel = view.findViewById(R.id.btnDel);

        final Contact contact = this.object.get(position);
        txtContactName.setText(contact.getName());
        txtContactPhone.setText(contact.getPhone());

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCall(contact);
            }
        });
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSms(contact);
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDel(contact);
            }
        });

        return view;
    }

    private void handleDel(Contact contact) {
        this.remove(contact);
    }

    private void handleSms(Contact contact) {
        Intent intentSms = new Intent(this.context, SmsActivity.class);
        intentSms.putExtra("CONTACT", contact);
        this.context.startActivity(intentSms);
    }

    private void handleCall(Contact contact) {
        Intent intentCall = new Intent(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:" + contact.getPhone());
        intentCall.setData(uri);
        if (ActivityCompat.checkSelfPermission(this.context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this.context,
                    new String[]{Manifest.permission.CALL_PHONE},
                    PHONE_PERMISSION_CODE
            );
            Toast.makeText(this.context, "Không thể thực hiện cuộc gọi", Toast.LENGTH_SHORT).show();
            return;
        }
        this.context.startActivity(intentCall);
    }
}
