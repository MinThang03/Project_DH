package com.example.btl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Mainxoatk extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private String makh;// Khai báo đối tượng DatabaseHelper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xoatk); // Đảm bảo layout chứa các button đã được thiết kế

        // Khởi tạo DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Tìm button btthoat
        ImageButton btthoat = findViewById(R.id.btthoat);

        // Thiết lập sự kiện khi nhấn button thoát
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Mainxoatk và quay về Activity trước đó
            }
        });
        makh = getIntent().getStringExtra("khach");

        // Tìm nút xác nhận
        Button btnXacNhan = findViewById(R.id.btxacnhan);

        // Thiết lập sự kiện khi nhấn vào nút xác nhận
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy mã khách hàng (makh) từ SharedPreferences hoặc Intent, ví dụ:
                 // Ví dụ mã khách hàng, bạn cần thay đổi cách lấy makh thực tế
                // Gọi phương thức xóa tài khoản
                boolean result = databaseHelper.deleteUserById(makh);

                // Kiểm tra kết quả xóa
                if (result) {
                    // Hiển thị thông báo "Xóa tài khoản thành công"
                    Toast.makeText(Mainxoatk.this, "Xóa tài khoản thành công", Toast.LENGTH_SHORT).show();

                    // Mở màn hình đăng nhập
                    Intent intent = new Intent(Mainxoatk.this, Maindangnhap.class);
                    startActivity(intent); // Mở LoginActivity

                    // Đóng màn hình hiện tại (Mainxoatk)
                    finish();
                } else {
                    // Hiển thị thông báo nếu có lỗi khi xóa
                    Toast.makeText(Mainxoatk.this, "Xóa tài khoản thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}