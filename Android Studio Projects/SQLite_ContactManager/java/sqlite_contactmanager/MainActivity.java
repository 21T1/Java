package example.com.vn.sqlite_contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import example.com.vn.adapter.ContactAdapter;
import example.com.vn.model.Contact;

public class MainActivity extends AppCompatActivity {

    Button btnAddContact, btnEditContact, btnDeleteContact;
    String DATABASE_NAME = "dbContact";
    String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database = null;

    ListView lvContact;
    ArrayList<Contact> lstContact;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processCopy();

        addControls();
        addEvents();

        showAllContact();
    }

    private void showAllContact() {
        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        // Cursor cursor = database.query("Contact", null, null, null, null, null, null);
        Cursor cursor = database.rawQuery("SELECT * FROM Contact", null);

        lstContact.clear();
        while (cursor.moveToNext()) {
            lstContact.add(new Contact(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
            ));
        }
        cursor.close();
        contactAdapter.notifyDataSetChanged();
    }

    private void addEvents() {
        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAddContact();
            }
        });
        btnEditContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleEditContact();
            }
        });
        btnDeleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDeleteContact();
            }
        });
    }

    private void handleDeleteContact() {
        database.delete("Contact", "ID = ?", new String[]{"2"});
        showAllContact();
    }

    private void handleEditContact() {
        ContentValues row = new ContentValues();
        row.put("Name", "Hoàng H");
        database.update("Contact", row, "ID = ?", new String[]{"3"});
        showAllContact();
    }

    private void handleAddContact() {
        ContentValues row = new ContentValues();
        row.put("ID", 5);
        row.put("Name", "Ngô H");
        row.put("Phone", "0912378456");
        long res = database.insert("Contact", null, row);
        Toast.makeText(this, "Kết quả trạng thái r = " + res, Toast.LENGTH_SHORT).show();
        showAllContact();
    }

    private void addControls() {
        btnAddContact = findViewById(R.id.btnAddContact);
        btnEditContact = findViewById(R.id.btnEditContact);
        btnDeleteContact = findViewById(R.id.btnDeleteContact);

        lvContact = findViewById(R.id.lvContact);
        lstContact = new ArrayList<>();
        contactAdapter = new ContactAdapter(
                MainActivity.this,
                R.layout.item,
                lstContact
        );
        lvContact.setAdapter(contactAdapter);
    }

    private String getDatabasePath() {
        return  getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
    }

    private void copyDatabaseFromAssetsFolder() {
        try {
            InputStream inputStream = getAssets().open(DATABASE_NAME);
            String outFileName = getDatabasePath();

            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists()) {
                f.mkdir();
            }

            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();

        } catch (Exception ex) {
            Log.e("Copy_Error", ex.toString());
        }
    }

    private void processCopy() {
        File dbFile = getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists()) {
            try {
                copyDatabaseFromAssetsFolder();
                Toast.makeText(this, "Sao chép thành công!", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }


}