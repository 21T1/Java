package example.com.vn.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import example.com.vn.listviewenhance.MainActivity;
import example.com.vn.listviewenhance.R;
import example.com.vn.model.Contacts;

public class ContactsAdapter extends ArrayAdapter<Contacts> {

    Activity context;       // màn hình sử dụng layout
    int resource;           // layout item
    List<Contacts> objects; // danh sách nguồn dữ liệu
    public ContactsAdapter(@NonNull Activity context, int resource, @NonNull List<Contacts> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater(); // build layout -> java
        View row = inflater.inflate(this.resource, null);

        TextView txtName = row.findViewById(R.id.txtName);
        TextView txtPhone = row.findViewById(R.id.txtPhone);
        ImageButton btnCall = row.findViewById(R.id.btnCall);
        ImageButton btnSms = row.findViewById(R.id.btnSms);
        ImageButton btnDetail = row.findViewById(R.id.btnDetail);

        Contacts contacts = this.objects.get(position);
        txtName.setText(contacts.getName());
        txtPhone.setText(contacts.getPhone());

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDetail(contacts);
            }
        });
        return row;
    }

    private void handleDetail(Contacts contacts) {
        Toast.makeText(this.context, "Thông tin của " + contacts.getName(), Toast.LENGTH_SHORT).show();
    }
}
