package example.com.vn.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lvDay;
    String[] arrDay;
    ArrayAdapter<String> adapterDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        lvDay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrDay[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addControls() {
        arrDay = getResources().getStringArray(R.array.arrDay);
        adapterDay = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrDay
        );
        lvDay = findViewById(R.id.lvDay);
        lvDay.setAdapter(adapterDay);
    }
}