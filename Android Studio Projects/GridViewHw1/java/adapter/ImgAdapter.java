package example.com.vn.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import example.com.vn.gridviewhw1.R;
import example.com.vn.model.Img;

public class ImgAdapter extends ArrayAdapter<Img> {

    Activity context;
    int resource;
    List<Img> objects;

    public ImgAdapter(@NonNull Activity context, int resource, @NonNull List<Img> objects) {
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

        ImageView imgImg = row.findViewById(R.id.imgImg);
        imgImg.setImageResource(this.objects.get(position).getId());

        TextView txtNum = row.findViewById(R.id.txtNum);
        txtNum.setText(String.valueOf(this.objects.get(position).getNum()));

        Button btnBuy = row.findViewById(R.id.btnCheck);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objects.get(position).setNum(Integer.parseInt(txtNum.getText().toString()));
                Toast.makeText(context, objects.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return row;
    }
}
