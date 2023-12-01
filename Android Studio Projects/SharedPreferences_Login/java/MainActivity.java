package example.com.vn.sharedpreferences_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername, txtPassword;
    CheckBox chkSaveInfo;
    Button btnLogin, btnExit;

    String saveLoginInfo = "login";

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
                finish();
            }
        });
    }

    private void addControls() {
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        chkSaveInfo = findViewById(R.id.chkSaveInfo);
        btnLogin = findViewById(R.id.btnLogin);
        btnExit = findViewById(R.id.btnExit);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences preferences = getSharedPreferences(saveLoginInfo, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Username", txtUsername.getText().toString());
        editor.putString("Password", txtPassword.getText().toString());
        editor.putBoolean("SAVE", chkSaveInfo.isChecked());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences(saveLoginInfo, MODE_PRIVATE);
        String username = preferences.getString("Username", "");
        String password = preferences.getString("Password", "");
        boolean save = preferences.getBoolean("SAVE", false);
        if (save) {
            txtUsername.setText(username);
            txtPassword.setText(password);
        }
    }
}