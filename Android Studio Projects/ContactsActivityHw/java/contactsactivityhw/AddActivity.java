package example.com.vn.contactsactivityhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.com.vn.model.Contact;

public class AddActivity extends AppCompatActivity {

    EditText txtName, txtPhone;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAddNew();
            }
        });
    }

    private void handleAddNew() {
        String name = txtName.getText().toString().trim();
        String phone = txtPhone.getText().toString().trim();
        if (name.equals("") || phone.equals("")) {
            Toast.makeText(AddActivity.this, "Thông tin không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = getIntent();
        Contact contact = new Contact(name, phone);
        intent.putExtra("CONTACT", contact);
        setResult(11, intent);
        finish();
    }

    private void addControls() {
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        btnAdd = findViewById(R.id.btnAdd);
    }
}