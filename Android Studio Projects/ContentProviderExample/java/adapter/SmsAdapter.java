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
import example.com.vn.model.SmsRead;

public class SmsAdapter extends ArrayAdapter<SmsRead> {

    Activity context;
    int resource;
    List<SmsRead> objects;

    public SmsAdapter(@NonNull Activity context, int resource, @NonNull List<SmsRead> objects) {
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

        TextView txtSmsPhone = row.findViewById(R.id.txtSmsPhone);
        TextView txtSmsTime = row.findViewById(R.id.txtSmsTime);
        TextView txtSmsBody = row.findViewById(R.id.txtSmsBody);

        SmsRead smsRead = this.objects.get(position);
        txtSmsPhone.setText(smsRead.getPhone());
        txtSmsTime.setText(smsRead.getTime());
        txtSmsBody.setText(smsRead.getBody());

        return row;
    }
}
