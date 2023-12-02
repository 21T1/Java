package example.com.vn.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
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

import example.com.vn.model.Contact;
import example.com.vn.sqlite_contactmanager.R;

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

        TextView txtContactName = row.findViewById(R.id.txtContactName);
        TextView txtContactPhone = row.findViewById(R.id.txtContactPhone);
        ImageButton btnCall = row.findViewById(R.id.btnCall);
        ImageButton btnSms = row.findViewById(R.id.btnSms);

        final Contact contact = this.objects.get(position);
        txtContactName.setText(contact.getName());
        txtContactPhone.setText(contact.getPhone());

        return row;
    }
}
