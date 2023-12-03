package example.com.vn.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import example.com.vn.contentproviderexample.R;
import example.com.vn.model.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {

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

        Contact contact = this.objects.get(position);
        txtContactName.setText(contact.getName());
        txtContactPhone.setText(contact.getPhone());

        return row;
    }
}
