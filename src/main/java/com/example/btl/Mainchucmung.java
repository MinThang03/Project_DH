package com.example.btl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Mainchucmung extends AppCompatActivity {
    public static int Splash_Screen = 5000; // Thời gian hiển thị splash screen
    Animation topAnim, bottomAnim;
    ImageView img;
    TextView txt1, txt2;
    Button btxacnhan; // Button xác nhận

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chucmung);

        // Load animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        // Hooks
        img = findViewById(R.id.view); // ImageView với ID 'view'
        txt1 = findViewById(R.id.text1); // TextView với ID 'text1'
        txt2 = findViewById(R.id.text2); // TextView với ID 'text2'
        btxacnhan = findViewById(R.id.btxacnhan); // Button xác nhận

        // Set animations
        img.setAnimation(topAnim);
        txt1.setAnimation(bottomAnim);
        txt2.setAnimation(bottomAnim);

        // Thiết lập sự kiện khi ấn nút xác nhận
        btxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mainchucmung.this, Mainchinh.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
