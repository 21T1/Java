package example.com.vn.contactsactivityhw;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import example.com.vn.adapter.ContactAdapter;
import example.com.vn.model.Contact;

public class MainActivity extends AppCompatActivity {

    ImageButton btnExit, btnAdd;

    ListView lvContact;
    ArrayList<Contact> lstContact;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleExit();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddScreen();
            }
        });
    }

    private void handleExit() {
        Toast.makeText(MainActivity.this, "Thoát chương trình", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void showAddScreen() {
        Intent intentAddScreen = new Intent(MainActivity.this, AddActivity.class);
        startActivityForResult(intentAddScreen, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == 11) {
            Contact contact = (Contact) data.getSerializableExtra("CONTACT");
            if (contact != null) {
                lstContact.add(contact);
                Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Lỗi!", Toast.LENGTH_SHORT).show();
            }
            contactAdapter.notifyDataSetChanged();
        }
    }

    private void addControls() {
        btnExit = findViewById(R.id.btnExit);
        btnAdd = findViewById(R.id.btnAdd);
        lvContact = findViewById(R.id.lvContact);

        lstContact = new ArrayList<>();
        lstContact.add(new Contact("Nguyễn Văn A", "0981234567"));

        contactAdapter = new ContactAdapter(
                MainActivity.this,
                R.layout.item,
                lstContact
        );
        lvContact.setAdapter(contactAdapter);
    }
}