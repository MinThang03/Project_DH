package com.example.btl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Mainkhoidong extends AppCompatActivity {
    public static int Splash_Screen = 500; // Thời gian hiển thị splash screen
    Animation topAnim, bottomAnim;
    ImageView img;
    TextView txt1, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutkhoidong);

        // Load animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        // Hooks
        img = findViewById(R.id.view); // ImageView với ID 'view'
        txt1 = findViewById(R.id.text1); // TextView với ID 'text1'
        txt2 = findViewById(R.id.text2); // TextView với ID 'text2'

        // Set animations
        img.setAnimation(topAnim);
        txt1.setAnimation(bottomAnim);
        txt2.setAnimation(bottomAnim);

        // Chuyển sang MainActivity sau 5 giây
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Mainkhoidong.this, Maindangnhap.class);
                startActivity(intent);
                finish(); // Đóng IntroActivity
            }
        }, Splash_Screen);
    }
}

