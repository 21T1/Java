package example.com.vn.animationgame;

import static android.view.View.TRANSLATION_X;
import static android.view.View.TRANSLATION_Y;

import static java.lang.Math.pow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int score = 0, point = 1, speed = 3000, ballNum = 6, getGameOver = 0;
    boolean removeView = false;
    Random random;
    TextView txtScore;
    ViewGroup.LayoutParams params;
    LinearLayout layoutBall;
    Button btnStart;
    boolean playing = false;
    ObjectAnimator objectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playing) {
                    getGameOver = 0;
                    playing = true;
                    for (int i = 0; i < random.nextInt(ballNum); i++) {
                        processAnim();
                    }
                    playing = false;
                }
            }
        });
    }

    @SuppressLint("ObjectAnimatorBinding")
    private void processAnim() {
        ImageView img = getImageView();
        img.setBackground(getDrawable());
        img.setScaleType(ImageView.ScaleType.FIT_CENTER);
        removeView = false;
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutBall.removeView(v);
                removeView = true;
                txtScore.setText("Score: " + (score += point));
            }
        });

        objectAnimator = (ObjectAnimator)
                AnimatorInflater.loadAnimator(MainActivity.this, R.animator.ball_animation);
        objectAnimator.setDuration(random.nextInt(1000) + speed);
        objectAnimator.setTarget(img);
        layoutBall.addView(img, params);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animation) {

            }

            @Override
            public void onAnimationEnd(@NonNull Animator animation) {
                if (!removeView) {
                    layoutBall.removeView((View) (
                            (ObjectAnimator) animation
                    ).getTarget());
                    getGameOver += 1;
                    gameOver();
//                    finish();
                }
            }

            @Override
            public void onAnimationCancel(@NonNull Animator animation) {

            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animation) {

            }
        });
        objectAnimator.start();
    }

    private void gameOver() {
        if (getGameOver == 1) {
            Intent intent = new Intent(MainActivity.this, AlertActivity.class);
            startActivity(intent);
        } else {
            finish();
        }
    }

    private Drawable getDrawable() {
        Drawable draw;
        switch (random.nextInt(5)) {
            case 1:
                draw = getResources().getDrawable(R.drawable.b1);
                break;
            case 2:
                draw = getResources().getDrawable(R.drawable.b2);
                break;
            case 3:
                draw = getResources().getDrawable(R.drawable.b3);
                break;
            case 4:
                draw = getResources().getDrawable(R.drawable.b4);
                break;
            default:
                draw = getResources().getDrawable(R.drawable.b5);
                break;
        }
        return draw;
    }

    private ImageView getImageView() {
        ImageView img = new ImageView(MainActivity.this);
        img.setX(random.nextInt(500));
        return img;
    }

    private void addControls() {
        txtScore = findViewById(R.id.txtScore);
        random = new Random();
        layoutBall = findViewById(R.id.layoutBall);
        params = new LinearLayout.LayoutParams(400, 400);
        btnStart = findViewById(R.id.btnStart);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnu1) {
            point = 1;
            speed = 3000;
            ballNum = 6;
        } else if (item.getItemId() == R.id.mnu2) {
            point = 2;
            speed = 2000;
            ballNum = 9;
        } else if (item.getItemId() == R.id.mnu3) {
            point = 3;
            speed = 1000;
            ballNum = 12;
        }
        Toast.makeText(MainActivity.this, "Lựa chọn cấp độ thành công", Toast.LENGTH_SHORT).show();
        playing = false;
        score = 0;
        txtScore.setText(String.valueOf(score));

        return super.onOptionsItemSelected(item);
    }
}