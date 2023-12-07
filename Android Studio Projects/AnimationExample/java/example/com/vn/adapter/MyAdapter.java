package example.com.vn.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import example.com.vn.animationexample.R;

public class MyAdapter extends ArrayAdapter<String> {

    Activity context;
    int resource;
    List<String> objects;

    public MyAdapter(@NonNull Activity context, int resource, @NonNull List<String> objects) {
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

        TextView txtName = row.findViewById(R.id.txtName);
        txtName.setText(this.objects.get(position));

        Animation animation = AnimationUtils.loadAnimation(this.context, R.anim.listview_animation);
        row.startAnimation(animation);

        return row;
    }
}
