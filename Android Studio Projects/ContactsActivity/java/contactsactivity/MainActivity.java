package example.com.vn.contactsactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import example.com.vn.adapter.ContactAdapter;
import example.com.vn.model.Contact;

public class MainActivity extends AppCompatActivity {

    EditText txtName, txtPhone;
    Button btnSave;

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
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSave();
            }
        });
    }

    private void handleSave() {
        String name = txtName.getText().toString();
        String phone = txtPhone.getText().toString();
        if (name.trim().equals("") || phone.trim().equals("")) {
            Toast.makeText(MainActivity.this, "Không thể lưu", Toast.LENGTH_SHORT).show();
        } else {
            lstContact.add(new Contact(name, phone));
        }
        contactAdapter.notifyDataSetChanged();
    }

    private void addControls() {
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        btnSave = findViewById(R.id.btnSave);

        lvContact = findViewById(R.id.lvContact);
        lstContact = new ArrayList<>();
        lstContact.add(new Contact("Nguyễn Văn A", "*101#"));
        contactAdapter = new ContactAdapter(
                MainActivity.this,
                R.layout.item,
                lstContact
        );
        lvContact.setAdapter(contactAdapter);
    }
}