
package example.com.vn.contentproviderexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import example.com.vn.adapter.ContactAdapter;
import example.com.vn.model.Contact;

public class ContactsActivity extends AppCompatActivity {

    private final int CONTACTS_PERMISSION_CODE = 1;
    ListView lvContacts;
    ArrayList<Contact> lstContact;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        addControls();
        addEvents();

        if (readContactPermission()) {
            showAllContactsFromDevice();
            Toast.makeText(this, "Đọc danh bạ thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Không thể đọc danh bạ", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean readContactPermission() {
        if (ActivityCompat.checkSelfPermission(ContactsActivity.this,
                Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    CONTACTS_PERMISSION_CODE
            );
            return false;
        }
        return true;
    }

    private void showAllContactsFromDevice() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        lstContact.clear();
        while (cursor.moveToNext()) {
            String colNameName = ContactsContract.Contacts.DISPLAY_NAME;
            int colNameIndex = cursor.getColumnIndex(colNameName);
            String name = cursor.getString(colNameIndex);

            String colPhoneName = ContactsContract.CommonDataKinds.Phone.NUMBER;
            int colPhoneIndex = cursor.getColumnIndex(colPhoneName);
            String phone = cursor.getString(colPhoneIndex);

            lstContact.add(new Contact(name, phone));
        }
        contactAdapter.notifyDataSetChanged();
    }

    private void addEvents() {

    }

    private void addControls() {
        lvContacts = findViewById(R.id.lvContacts);
        lstContact = new ArrayList<>();
        contactAdapter = new ContactAdapter(
                ContactsActivity.this,
                R.layout.item_contact,
                lstContact
        );
        lvContacts.setAdapter(contactAdapter);
    }
}