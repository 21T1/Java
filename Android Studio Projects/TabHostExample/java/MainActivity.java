package example.com.vn.tabhostexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtA, txtB;
    Button btnAdd;

    ListView lvHistory;
    ArrayList<String> lstAdd;
    ArrayAdapter<String> adapterAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAdd();
            }
        });
    }

    private void handleAdd() {
        if (txtA.getText().toString().trim().matches("") || txtB.getText().toString().matches("")) {
            Toast.makeText(MainActivity.this, "Thiếu dữ liệu", Toast.LENGTH_SHORT).show();
        } else {
            int a = Integer.parseInt(txtA.getText().toString());
            int b = Integer.parseInt(txtB.getText().toString());
            String res = a + " + " + b + " = " + (a + b);
            lstAdd.add(res);
            Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT).show();
            adapterAdd.notifyDataSetChanged();
            txtA.setText("");
            txtB.setText("");
        }
    }

    private void addControls() {
        TabHost tabHost = findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
        tab1.setIndicator("", getResources().getDrawable(R.drawable.add));
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab2.setIndicator("", getResources().getDrawable(R.drawable.history));
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        btnAdd = findViewById(R.id.btnAdd);

        lvHistory = findViewById(R.id.lvHistory);
        lstAdd = new ArrayList<>();
        adapterAdd = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                lstAdd
        );
        lvHistory.setAdapter(adapterAdd);
    }
}