package example.com.vn.listviewenhance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import example.com.vn.adapter.ContactsAdapter;
import example.com.vn.model.Contacts;

public class MainActivity extends AppCompatActivity {

    ListView lvContacts;
    ArrayList<Contacts> lstContacts;
    ContactsAdapter contactsAdapter;

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
        lvContacts = findViewById(R.id.lvContacts);
        lstContacts = new ArrayList<>();
        lstContacts.add(new Contacts(1, "Hoàng A", "0912378456"));
        lstContacts.add(new Contacts(2, "Nguyễn B", "0978456123"));
        lstContacts.add(new Contacts(3, "Lê C", "0978123456"));

        contactsAdapter = new ContactsAdapter(
                MainActivity.this,
                R.layout.item,
                lstContacts
        );
        lvContacts.setAdapter(contactsAdapter);
    }
}