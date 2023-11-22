package example.com.vn.karaokeview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

import example.com.vn.adapter.SongAdapter;
import example.com.vn.model.Song;

public class MainActivity extends AppCompatActivity {

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

        addControls();
        addEvents();
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
        lstFavour.clear();
        for (Song song : lstSong) {
            if (song.isLike()) {
                lstFavour.add(song);
            }
        }
        favourAdapter.notifyDataSetChanged();
    }

    private void handleShowSong() {
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

        fakeData();
    }

    private void fakeData() {
        lstSong.add(new Song("000001", "Một Con Vịt", "Xuân Mai", false));
        lstSong.add(new Song("000002", "Con Heo Đất", "Xuân Mai", true));
        lstSong.add(new Song("000003", "Rửa Mặt Như Mèo", "Xuân Mai", true));
        lstSong.add(new Song("000004", "Cháu Lên Ba", "Xuân Mai", false));
        lstSong.add(new Song("000005", "Đi Học Về", "Xuân Mai", true));
        songAdapter.notifyDataSetChanged();
    }
}