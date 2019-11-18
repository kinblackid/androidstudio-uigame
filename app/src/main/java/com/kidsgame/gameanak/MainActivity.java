package com.kidsgame.gameanak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgview, imganimals;
    ViewPager viewPager;
    ImageButton btnplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //viewPager = (ViewPager) findViewById(R.id.view_pager);
        // membuat transparan notifikasi
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        // membuat transparan notifikasi
        changeStatusBarColor();


        imgview = findViewById(R.id.logo);
        imganimals = findViewById(R.id.animals);
        btnplay = findViewById(R.id.buttonplay);

        Animation animation01 = AnimationUtils.loadAnimation(this, R.anim.top);
        animation01.reset();
        imgview.clearAnimation();
        imgview.startAnimation(animation01);


        Animation animation03 = AnimationUtils.loadAnimation(this, R.anim.scale);
        animation03.reset();
        imganimals.clearAnimation();
        imganimals.startAnimation(animation03);

        Animation animation02 = AnimationUtils.loadAnimation(this, R.anim.bottom);
        animation02.reset();
        btnplay.clearAnimation();
        btnplay.startAnimation(animation02);



        //anim click
        final Animation myAnim1 = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim1.setInterpolator(interpolator);
        myAnim1.setDuration(500);
        myAnim1.setFillAfter(true);
        //imganimals.startAnimation(myAnim1);

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnplay.startAnimation(myAnim1);
                Intent i = new Intent(MainActivity.this, GamePlayActivity.class);
                startActivity(i);

            }
        });
    }

    /* Making notification bar transparent*/
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
