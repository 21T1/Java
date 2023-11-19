package example.com.vn.spinnerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import example.com.vn.adapter.EmployeeAdapter;
import example.com.vn.model.Employee;

public class MainActivity extends AppCompatActivity {

    EditText txtName, txtYear;

    Spinner spDay;
    String[] arrDay;
    ArrayAdapter<String> adapterDay;

    Button btnSubmit;

    ListView lvEmp;
    ArrayList<Employee> lstEmp;
    EmployeeAdapter employeeAdapter;
    int lastedSelected = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubmit();
            }
        });

        spDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lastedSelected = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void handleSubmit() {
        if (lastedSelected == -1 || txtName.getText().toString().trim().matches("") || txtYear.getText().toString().trim().matches("")) {
            Toast.makeText(MainActivity.this, "Không thể xác nhận", Toast.LENGTH_SHORT).show();
        } else {
            Employee emp = new Employee();
            emp.setName(txtName.getText().toString());
            emp.setYear(Integer.parseInt(txtYear.getText().toString()));
            emp.setDay(arrDay[lastedSelected]);

            lstEmp.add(emp);
            employeeAdapter.notifyDataSetChanged();
            txtName.setText("");
            txtName.requestFocus();
            txtYear.setText("");
            Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
        }
    }

    private void addControls() {
        txtName = findViewById(R.id.txtName);
        txtYear = findViewById(R.id.txtYear);

        spDay = findViewById(R.id.spDay);

        arrDay = getResources().getStringArray(R.array.arrDay);

        adapterDay = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_spinner_item,
                arrDay
        );
        adapterDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spDay.setAdapter(adapterDay);

        btnSubmit = findViewById(R.id.btnSubmit);

        lvEmp = findViewById(R.id.lvEmp);
        lstEmp = new ArrayList<Employee>();
        lstEmp.add(new Employee("Hoàng A", 2000, "Thứ 2"));
        employeeAdapter = new EmployeeAdapter(
                MainActivity.this,
                R.layout.item,
                lstEmp
        );
        lvEmp.setAdapter(employeeAdapter);
    }
}