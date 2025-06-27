package com.example.btl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Maindoimk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doimk); // Thiết lập layout doimk

        // Tìm button btthoat
        ImageButton btthoat = findViewById(R.id.btthoat);

        // Thiết lập sự kiện khi nhấn button thoát
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Maindoimk và quay về Activity trước đó
            }
        });
        // lấy mã KH nhá =))
        String makh = getIntent().getStringExtra("khach");

        // Tìm button btnCapNhat
        Button btcapnhat = findViewById(R.id.btcapnhat);

        // Thiết lập sự kiện khi nhấn button cập nhật
        btcapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Maindoimk.this, "Bạn đã thay đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}