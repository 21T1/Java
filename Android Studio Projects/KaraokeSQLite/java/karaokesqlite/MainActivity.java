package example.com.vn.karaokesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import example.com.vn.adapter.SongAdapter;
import example.com.vn.model.Song;

public class MainActivity extends AppCompatActivity {

    public static String DATABASE_NAME = "Arirang.sqlite";
    String DB_PATH_SUFFIX = "/databases/";
    public static SQLiteDatabase database;

    TabHost tabHost;

    ListView lvSongs;
    ArrayList<Song> lstSong;
    SongAdapter songAdapter;

    ListView lvFavour;
    ArrayList<Song> lstFavour;
    SongAdapter favourAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processCopy();

        addControls();
        addEvents();

        handleShowSong();
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

    private void addEvents() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equalsIgnoreCase("t1")) {
                    handleShowSong();
                } else if (tabId.equalsIgnoreCase("t2")) {
                    handleShowFavour();
                }
            }
        });
    }

    private void handleShowFavour() {
        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        Cursor cursor = database.rawQuery("SELECT * FROM ArirangSongList WHERE YEUTHICH = ?", new String[]{"1"});

        lstFavour.clear();
        while (cursor.moveToNext()) {
            lstFavour.add(new Song(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(3),
                    cursor.getInt(5)
            ));
        }
        cursor.close();

        favourAdapter.notifyDataSetChanged();
    }

    private void handleShowSong() {
        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        Cursor cursor = database.rawQuery("SELECT * FROM ArirangSongList", null);

        lstSong.clear();
        while (cursor.moveToNext()) {
            lstSong.add(new Song(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(3),
                    cursor.getInt(5)
            ));
        }
        cursor.close();

        songAdapter.notifyDataSetChanged();
    }

    private void addControls() {
        tabHost = findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
        tab1.setIndicator("", getResources().getDrawable(R.drawable.song));
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab2.setIndicator("", getResources().getDrawable(R.drawable.favour));
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        lvSongs = findViewById(R.id.lvSongs);
        lstSong = new ArrayList<>();
        songAdapter = new SongAdapter(
                MainActivity.this,
                R.layout.item,
                lstSong
        );
        lvSongs.setAdapter(songAdapter);

        lvFavour = findViewById(R.id.lvFavour);
        lstFavour = new ArrayList<>();
        favourAdapter = new SongAdapter(
                MainActivity.this,
                R.layout.item,
                lstFavour
        );
        lvFavour.setAdapter(favourAdapter);
    }

}