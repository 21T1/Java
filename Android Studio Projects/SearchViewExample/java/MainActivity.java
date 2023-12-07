package example.com.vn.searchviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lvProvince;
    ArrayList<String> lstProvince;
    ArrayAdapter<String> adapterProvince;

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
        lvProvince = findViewById(R.id.lvProvince);
        lstProvince = new ArrayList<>();
        lstProvince.addAll(Arrays.asList(getResources().getStringArray(R.array.arrProvince)));
        adapterProvince = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                lstProvince
        );
        lvProvince.setAdapter(adapterProvince);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem mnuSearch = menu.findItem(R.id.mnuSearch);
        SearchView searchView = (SearchView) mnuSearch.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterProvince.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}