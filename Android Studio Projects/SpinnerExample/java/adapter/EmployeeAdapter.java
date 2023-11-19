package example.com.vn.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import example.com.vn.model.Employee;
import example.com.vn.spinnerexample.R;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    Activity context;
    int resource;
    List<Employee> objects;

    public EmployeeAdapter(@NonNull Activity context, int resource, @NonNull List<Employee> objects) {
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

        TextView txtEmpName = row.findViewById(R.id.txtEmpName);
        TextView txtEmpYear = row.findViewById(R.id.txtEmpYear);
        TextView txtEmpDay = row.findViewById(R.id.txtEmpDay);

        Employee emp = this.objects.get(position);
        txtEmpName.setText(emp.getName());
        txtEmpYear.setText(String.valueOf(emp.getYear()));
        txtEmpDay.setText(emp.getDay());

        return row;
    }
}
