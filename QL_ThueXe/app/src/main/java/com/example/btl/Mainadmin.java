package com.example.btl;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.content.pm.PackageManager;

public class Mainadmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutad);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation2);
        ImageButton callButton = findViewById(R.id.call_icon); // Thêm ImageButton cho gọi điện
        ObjectAnimator shakeAnimation = ObjectAnimator.ofPropertyValuesHolder(
                callButton,
                PropertyValuesHolder.ofFloat("translationX", 0f, 8f, -8f, 8f, -8f, 0f)
        );

        shakeAnimation.setDuration(800); // Thời gian của hiệu ứng (500ms)
        shakeAnimation.setRepeatCount(ObjectAnimator.INFINITE); // Lặp lại vô hạn
        shakeAnimation.setRepeatMode(ObjectAnimator.REVERSE); // Đảo ngược chiều của hiệu ứng

        // Kích hoạt hiệu ứng rung
        shakeAnimation.start();

        // Thiết lập sự kiện khi nhấn vào ImageButton để gọi điện
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mainadmin.this, Mainthemxe.class);
                startActivity(intent);
            }
        });

        loadFragmentWithUsername( new QLcarr());


        // Thiết lập sự kiện cho BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            if (item.getItemId() == R.id.qlxe) {
                selectedFragment = new QLcarr();
            } else if (item.getItemId() == R.id.qlkh) {
                selectedFragment = new MainQLKH();
            } else if (item.getItemId() == R.id.qlhd) {
                selectedFragment = new MainQLhoadon();
            }else if (item.getItemId() == R.id.thongke) {
                selectedFragment = new Thongke();
            }

            // Tải Fragment được chọn với `username`
            return loadFragmentWithUsername(selectedFragment);
        });
    }

    private boolean loadFragmentWithUsername(Fragment fragment) {
        if (fragment != null) {
                Bundle bundle = new Bundle();
                fragment.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
