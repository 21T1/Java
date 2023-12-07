package example.com.vn.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btnRotateControl, btnRotateScreen, btnRotate3s, btnListViewAnimation;

    Animation animation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnRotateControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate_control);
                btnRotateControl.startAnimation(animation);
            }
        });
        btnRotateScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layoutScreen = findViewById(R.id.layoutScreen);
                animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate_screen);
                layoutScreen.startAnimation(animation);
            }
        });
        btnRotate3s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate_left_3s);
                btnRotate3s.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        btnListViewAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        btnRotateControl = findViewById(R.id.btnRotateControl);
        btnRotateScreen = findViewById(R.id.btnRotateScreen);
        btnRotate3s = findViewById(R.id.btnRotate3s);
        btnListViewAnimation = findViewById(R.id.btnListViewAnimation);
    }
}