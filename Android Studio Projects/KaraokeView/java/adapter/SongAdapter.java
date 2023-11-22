package example.com.vn.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import example.com.vn.karaokeview.R;
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
        if (song.isLike()) {
            btnLike.setVisibility(View.INVISIBLE);
            btnDislike.setVisibility(View.VISIBLE);
        } else {
            btnDislike.setVisibility(View.INVISIBLE);
            btnLike.setVisibility(View.VISIBLE);
        }

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.setLike(true);
                btnLike.setVisibility(View.INVISIBLE);
                btnDislike.setVisibility(View.VISIBLE);
            }
        });
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.setLike(false);
                btnLike.setVisibility(View.VISIBLE);
                btnDislike.setVisibility(View.INVISIBLE);
            }
        });

        notifyDataSetChanged();
        return row;
    }
}
