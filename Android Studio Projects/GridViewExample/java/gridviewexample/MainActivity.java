package example.com.vn.gridviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import example.com.vn.adapter.ImgAdapter;

public class MainActivity extends AppCompatActivity {

    GridView gvImg;
    ArrayList<Integer> lstImg;
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
        lstImg.add(R.drawable.img_1);
        lstImg.add(R.drawable.img_2);
        lstImg.add(R.drawable.img_3);
        lstImg.add(R.drawable.img_4);
        lstImg.add(R.drawable.img_5);

        imgAdapter = new ImgAdapter(
                MainActivity.this,
                R.layout.item,
                lstImg
        );

        gvImg.setAdapter(imgAdapter);

    }
}