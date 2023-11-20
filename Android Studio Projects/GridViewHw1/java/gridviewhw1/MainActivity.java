package example.com.vn.gridviewhw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

import example.com.vn.adapter.ImgAdapter;
import example.com.vn.model.Img;

public class MainActivity extends AppCompatActivity {

    GridView gvImg;
    ArrayList<Img> lstImg;
    ImgAdapter imgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        gvImg = findViewById(R.id.gvImg);

        lstImg = new ArrayList<>();
        lstImg.add(new Img(R.drawable.img_1, "Heo", 0));
        lstImg.add(new Img(R.drawable.img_2, "Thỏ", 0));
        lstImg.add(new Img(R.drawable.img_3, "Cánh cụt", 0));
        lstImg.add(new Img(R.drawable.img_4, "Gấu trúc", 0));
        lstImg.add(new Img(R.drawable.img_5, "Robot", 0));
        lstImg.add(new Img(R.drawable.img_6, "Ếch", 0));
        lstImg.add(new Img(R.drawable.img_7, "Mèo", 0));

        imgAdapter = new ImgAdapter(
                MainActivity.this,
                R.layout.item,
                lstImg
        );

        gvImg.setAdapter(imgAdapter);
    }
}