package example.com.vn.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import example.com.vn.adapter.MyAdapter;

public class ListViewActivity extends AppCompatActivity {

    ListView lvName;
    ArrayList<String> lstName;
    MyAdapter adapterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        lvName = findViewById(R.id.lvData);
        lstName = new ArrayList<>();
        adapterName = new MyAdapter(
                ListViewActivity.this,
                R.layout.item,
                lstName
        );
        lvName.setAdapter(adapterName);
        for (int i = 0; i < 5000; i++) {
            lstName.add("Tên thứ " + (i + 1));
        }
        adapterName.notifyDataSetChanged();
    }
}