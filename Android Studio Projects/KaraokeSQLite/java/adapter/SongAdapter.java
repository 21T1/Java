package example.com.vn.adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import example.com.vn.karaokesqlite.MainActivity;
import example.com.vn.karaokesqlite.R;
import example.com.vn.model.Song;

public class SongAdapter extends ArrayAdapter<Song> {

    Activity context;
    int resource;
    List<Song> objects;

    public SongAdapter(@NonNull Activity context, int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        TextView txtId = row.findViewById(R.id.txtId);
        TextView txtName = row.findViewById(R.id.txtName);
        TextView txtSinger = row.findViewById(R.id.txtSinger);
        ImageButton btnLike = row.findViewById(R.id.btnLike);
        ImageButton btnDislike = row.findViewById(R.id.btnDislike);

        Song song = this.objects.get(position);
        txtId.setText(song.getId());
        txtName.setText(song.getName());
        txtSinger.setText(song.getSinger());
        if (song.getLike() == 1) {
            btnLike.setVisibility(View.INVISIBLE);
            btnDislike.setVisibility(View.VISIBLE);
        } else {
            btnDislike.setVisibility(View.INVISIBLE);
            btnLike.setVisibility(View.VISIBLE);
        }

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLike(song);
                btnLike.setVisibility(View.INVISIBLE);
                btnDislike.setVisibility(View.VISIBLE);
            }
        });
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDislike(song);
                btnLike.setVisibility(View.VISIBLE);
                btnDislike.setVisibility(View.INVISIBLE);
            }
        });

        notifyDataSetChanged();
        return row;
    }

    private void handleDislike(Song song) {
        ContentValues row = new ContentValues();
        row.put("YEUTHICH", 0);
        MainActivity.database.update(
                "ArirangSongList",
                row,
                "MABH = ?",
                new String[]{song.getId()}
        );
    }

    private void handleLike(Song song) {
        ContentValues row = new ContentValues();
        row.put("YEUTHICH", 1);
        MainActivity.database.update(
                "ArirangSongList",
                row,
                "MABH = ?",
                new String[]{song.getId()}
        );
    }
}
