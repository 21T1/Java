package example.com.vn.listviewenhancehw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import example.com.vn.adapter.RateAdapter;
import example.com.vn.model.Rate;

public class MainActivity extends AppCompatActivity {

    ListView lvRate;
    ArrayList<Rate> lstRate;
    RateAdapter rateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        lvRate = findViewById(R.id.lvRate);

        lstRate = new ArrayList<>();
        lstRate.add(new Rate(1, "AUD", "15770", "15850", "15750", "15830"));
        lstRate.add(new Rate(2, "CAD", "16850", "16930", "16830", "16910"));
        lstRate.add(new Rate(3, "CHF", "22570", "23060", "22920", "23040"));
        lstRate.add(new Rate(4, "CNY", "3000", "3500", "3000", "3500"));
        lstRate.add(new Rate(5, "EUR", "25140", "25240", "25100", "25000"));

        rateAdapter = new RateAdapter(
                MainActivity.this,
                R.layout.item,
                lstRate
        );

        lvRate.setAdapter(rateAdapter);
    }
}