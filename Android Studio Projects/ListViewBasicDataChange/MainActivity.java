package example.com.vn.listviewbasicdatachange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrName;
    ArrayAdapter<String> adapterName;
    ListView lvName;

    EditText txtName;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSave();
            }
        });

        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrName.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleSave() {
        String name = txtName.getText().toString();
        arrName.add(name);
        adapterName.notifyDataSetChanged();
        txtName.setText("");
        txtName.requestFocus();
    }

    private void addControls() {
        txtName = findViewById(R.id.txtName);
        btnSave = findViewById(R.id.btnSave);

        arrName = new ArrayList<String>();
        adapterName = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrName
        );
        lvName = findViewById(R.id.lvName);
        lvName.setAdapter(adapterName);
    }

}