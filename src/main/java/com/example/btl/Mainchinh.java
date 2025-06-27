package com.example.btl;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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

public class Mainchinh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutchinh);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
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
                makePhoneCall("0702180982"); // Thay "123456789" bằng số điện thoại bạn muốn gọi
            }
        });

        String usernameFromIntent = getIntent().getStringExtra("tenkh");
        String makh = getIntent().getStringExtra("makh");
        if (usernameFromIntent != null) {
            saveUsernameToPreferences(usernameFromIntent);
        }
        loadFragmentWithUsername( new Home());


        // Thiết lập sự kiện cho BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            if (item.getItemId() == R.id.bthome) {
                selectedFragment = new Home();
            } else if (item.getItemId() == R.id.btxecuatoi) {
                selectedFragment = new XeCuaToi();
            } else if (item.getItemId() == R.id.btthongbao) {
                selectedFragment = new Thongbao();
            } else if (item.getItemId() == R.id.bthotro) {
                selectedFragment = new Hotro();
            }else if (item.getItemId() == R.id.btcanhan) {
                selectedFragment = new Canhan();
            }

            // Tải Fragment được chọn với `username`
            return loadFragmentWithUsername(selectedFragment);
        });
    }
    private void saveUsernameToPreferences(String username) {
        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("tenkh", username);
        editor.apply();
    }

    private String getUsernameFromPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        return sharedPreferences.getString("tenkh", null);
    }
    private String getmakh() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        return sharedPreferences.getString("makh", null);
    }
    private boolean loadFragmentWithUsername(Fragment fragment) {
        if (fragment != null) {
            String username = getUsernameFromPreferences();
            String makh = getmakh();
            if (username != null) {
                Bundle bundle = new Bundle();
                bundle.putString("tenkh", username);
                bundle.putString("makh", makh);
                fragment.setArguments(bundle);
            }

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

    private void makePhoneCall(String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));

        // Kiểm tra quyền CALL_PHONE trước khi thực hiện cuộc gọi
        if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(callIntent);
        } else {
            requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE}, 1);
        }
    }
}
