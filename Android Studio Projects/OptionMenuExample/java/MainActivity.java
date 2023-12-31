package example.com.vn.optionmenuexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
    }

    private void addControls() {
        txtColor = findViewById(R.id.txtColor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnuGreen) {
            txtColor.setBackgroundColor(Color.GREEN);
        } else if (item.getItemId() == R.id.mnuRed) {
            txtColor.setBackgroundColor(Color.RED);
        } else if (item.getItemId() == R.id.mnuYellow) {
            txtColor.setBackgroundColor(Color.YELLOW);
        }

        return super.onOptionsItemSelected(item);
    }
}