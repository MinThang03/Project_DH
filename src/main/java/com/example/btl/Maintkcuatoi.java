package com.example.btl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Maintkcuatoi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tkcuatoi); // Thiết lập layout tkcuatoi

        // Tìm button btthoat
        ImageButton btthoat = findViewById(R.id.btthoat);

        // Thiết lập sự kiện khi nhấn button thoát
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Maindoimk và quay về Activity trước đó
            }
        });

        // Tìm button btnCapNhat
        Button btcapnhat = findViewById(R.id.btcapnhat);

        // Thiết lập sự kiện khi nhấn button cập nhật
        btcapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Maintkcuatoi.this, "Bạn đã cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}