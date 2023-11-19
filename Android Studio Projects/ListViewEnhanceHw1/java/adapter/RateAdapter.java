package example.com.vn.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import example.com.vn.listviewenhancehw1.R;
import example.com.vn.model.Rate;

public class RateAdapter extends ArrayAdapter<Rate> {

    Activity context;
    int resource;
    List<Rate> objects;

    public RateAdapter(@NonNull Activity context, int resource, @NonNull List<Rate> objects) {
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

        ImageView imgCountry = row.findViewById(R.id.imgCountry);
        TextView txtCountry = row.findViewById(R.id.txtCountry);
        TextView txtBuyCash = row.findViewById(R.id.txtBuyCash);
        TextView txtSaleCash = row.findViewById(R.id.txtSaleCash);
        TextView txtBuyTrans = row.findViewById(R.id.txtBuyTrans);
        TextView txtSaleTrans = row.findViewById(R.id.txtSaleTrans);

        // item[i]
        Rate rate = this.objects.get(position);

        String name = rate.getName();
        if (name == "AUD") {
            imgCountry.setImageResource(R.drawable.aud);
        } else if (name == "CAD") {
            imgCountry.setImageResource(R.drawable.cad);
        } else if (name == "CHF") {
            imgCountry.setImageResource(R.drawable.chf);
        } else if (name == "CNY") {
            imgCountry.setImageResource(R.drawable.cny);
        } else if (name == "EUR") {
            imgCountry.setImageResource(R.drawable.eur);
        }

        txtCountry.setText(rate.getName());
        txtBuyCash.setText(rate.getBuyCash());
        txtSaleCash.setText(rate.getSaleCash());
        txtBuyTrans.setText(rate.getBuyTrans());
        txtSaleTrans.setText(rate.getSaleTrans());

        return row;
    }
}
