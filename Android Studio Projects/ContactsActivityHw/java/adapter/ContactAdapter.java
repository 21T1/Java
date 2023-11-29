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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

import example.com.vn.contactsactivityhw.R;
import example.com.vn.contactsactivityhw.SmsActivity;
import example.com.vn.model.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private final int CALL_PERMISSION_CODE = 1;
    Activity context;
    int resource;
    List<Contact> objects;

    public ContactAdapter(@NonNull Activity context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        TextView txtCtName = row.findViewById(R.id.btnCtName);
        TextView txtCtPhone = row.findViewById(R.id.btnCtPhone);
        CheckBox chkSelect = row.findViewById(R.id.chkSelect);
        ImageButton btnCall = row.findViewById(R.id.btnCall);
        ImageButton btnSms = row.findViewById(R.id.btnSms);
        ImageButton btnDel = row.findViewById(R.id.btnDel);

        final Contact contact = this.objects.get(position);
        txtCtName.setText(contact.getName());
        txtCtPhone.setText(contact.getPhone());

        chkSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    contact.setSelected(true);
                    Toast.makeText(context, "Chọn " + contact.getName(), Toast.LENGTH_SHORT).show();
                } else {
                    contact.setSelected(false);
                    Toast.makeText(context, "Bỏ chọn " + contact.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        notifyDataSetChanged();

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

        notifyDataSetChanged();

        return row;
    }

    private void handleDel(Contact contact) {
        this.remove(contact);
    }

    private void handleSms(Contact contact) {
        Intent intentSms = new Intent(this.context, SmsActivity.class);
        ArrayList<String> lstSelect = new ArrayList<>();
        lstSelect.add(contact.getPhone());
        for (Contact ct : this.objects) {
            if (ct.isSelected() && ct != contact) {
                lstSelect.add(ct.getPhone());
            }
        }
        intentSms.putStringArrayListExtra("LIST_SELECT", lstSelect);
        this.context.startActivity(intentSms);
    }

    private void handleCall(Contact contact) {
        Intent intentCall = new Intent(Intent.ACTION_CALL);
        intentCall.setData(Uri.parse("tel:" + contact.getPhone()));

        if (ActivityCompat.checkSelfPermission(this.context,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this.context,
                    new String[]{Manifest.permission.CALL_PHONE},
                    CALL_PERMISSION_CODE
            );
            Toast.makeText(this.context, "Không thể thực hiện cuộc gọi", Toast.LENGTH_SHORT).show();
            return;
        }
        this.context.startActivity(intentCall);
    }
}
