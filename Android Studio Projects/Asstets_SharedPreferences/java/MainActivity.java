package example.com.vn.asstets_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView txtFont;

    Button btnPlay, btnStop;
    MediaPlayer player = null;

    ListView lvFont;
    ArrayList<String> lstFont;
    ArrayAdapter<String> fontAdapter;

    String saveFont = "TrangThaiFont";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        lvFont.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                handleChangeFont(position);
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePlayMusic();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleStopMusic();
            }
        });
    }

    private void handleStopMusic() {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
            Toast.makeText(MainActivity.this, "Stoped!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handlePlayMusic() {
        try {
            AssetFileDescriptor afd = getAssets().openFd("music/BabySharkDance.mp3");
            if (player != null && player.isPlaying()) {
                handleStopMusic();
            }
            player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            player.prepare();
            player.start();
            Toast.makeText(MainActivity.this, "Play!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleChangeFont(int position) {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/" + lstFont.get(position));
        txtFont.setTypeface(typeface);

        SharedPreferences preferences = getSharedPreferences(saveFont, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("FONT_CHU", "font/" + lstFont.get(position));
        editor.commit();
    }

    private void addControls() {
        txtFont = findViewById(R.id.txtFont);
        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);
        lvFont = findViewById(R.id.lvFont);
        lstFont = new ArrayList<>();
        fontAdapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                lstFont
        );
        lvFont.setAdapter(fontAdapter);

        try {
            AssetManager assetManager = getAssets();
            String[] arrFontName = assetManager.list("font");
            lstFont.addAll(Arrays.asList(arrFontName));
            fontAdapter.notifyDataSetChanged();

            SharedPreferences preferences = getSharedPreferences(saveFont, MODE_PRIVATE);
            String font = preferences.getString("FONT_CHU", "");
            if (font.length() > 0) {
                txtFont.setTypeface(Typeface.createFromAsset(getAssets(), font));
            }
        } catch (Exception ex) {
            Log.e("LOI_FONT", ex.toString());
        }
    }
}