package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.model.Rate;
import com.example.project_json.R;

import java.util.List;

public class RateAdapter extends ArrayAdapter<Rate> {

    Activity context;
    int resource;
    List<Rate> objects;

    public RateAdapter(@NonNull Activity context, int resource, @NonNull List<Rate> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        ImageView imgImg = row.findViewById(R.id.imgImg);
        TextView txtType = row.findViewById(R.id.txtType);
        TextView txtBuyCash = row.findViewById(R.id.buyCash);
        TextView txtBuyTransfer = row.findViewById(R.id.buyTransfer);
        TextView txtSellCash = row.findViewById(R.id.sellCash);
        TextView txtSellTransfer = row.findViewById(R.id.sellTransfer);

        Rate rate = this.objects.get(position);

        imgImg.setImageBitmap(rate.getBitmap());
        txtType.setText(rate.getType());
        txtBuyCash.setText(rate.getBuyCash());
        txtBuyTransfer.setText(rate.getBuyTransfer());
        txtSellCash.setText(rate.getSellCash());
        txtSellTransfer.setText(rate.getSellTransfer());

        return row;
    }
}
