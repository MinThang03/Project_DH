package com.example.btl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;

public class Maintkcuatoi extends AppCompatActivity {
    private EditText ten, ngaysinh, sdt, email;
    Button btcapnhat;
    DatabaseHelper databaseHelper;  // Declare the DatabaseHelper instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tkcuatoi); // Set the layout for this activity

        // Initialize views
        ImageButton btthoat = findViewById(R.id.btthoat);
        ten = findViewById(R.id.nhapten);
        ngaysinh = findViewById(R.id.nhapngaysinh);
        sdt = findViewById(R.id.nhapsdt);
        email = findViewById(R.id.nhapemail);
        btcapnhat = findViewById(R.id.btcapnhat);

        // Initialize the DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Load user info when the activity is created
        loadUserInfo();

        // Set exit button click listener
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the activity and return to the previous one
            }
        });

        // Set update button click listener
        btcapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newHoten = ten.getText().toString().trim();
                String newNgaysinh = ngaysinh.getText().toString().trim();
                String newSdt = sdt.getText().toString().trim();
                String newEmail = email.getText().toString().trim();

                String makh = getIntent().getStringExtra("khach");

                // Validate inputs
                if (newHoten.isEmpty() || newNgaysinh.isEmpty() || newSdt.isEmpty() || newEmail.isEmpty()) {
                    Toast.makeText(Maintkcuatoi.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    // Call the updateUserInfo method to update the user information
                    boolean isUpdated = databaseHelper.updateUserInfo(makh, newHoten, newNgaysinh, newSdt, newEmail);

                    if (isUpdated) {
                        // Inform the user that the update was successful
                        Toast.makeText(Maintkcuatoi.this, "Bạn đã cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
                        // Reload user info after update
                        loadUserInfo();
                    } else {
                        // Inform the user that the update failed
                        Toast.makeText(Maintkcuatoi.this, "Cập nhật thông tin thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void loadUserInfo() {
        String makh = getIntent().getStringExtra("khach");

        // Lấy thông tin người dùng từ CSDL
        Cursor cursor = databaseHelper.getUserInfo(makh);

        if (cursor != null && cursor.moveToFirst()) {
            // Lấy tên cột bằng getColumnIndex
            int indexHoten = cursor.getColumnIndex("Tenkh");
            int indexNgaysinh = cursor.getColumnIndex("Ngaysinh");
            int indexSdt = cursor.getColumnIndex("Sdt");
            int indexEmail = cursor.getColumnIndex("Email");

            // Kiểm tra xem cột có tồn tại hay không
            if (indexHoten != -1 && indexNgaysinh != -1 && indexSdt != -1 && indexEmail != -1) {
                String hoten = cursor.getString(indexHoten);
                String ngaysinh = cursor.getString(indexNgaysinh);
                String sdt = cursor.getString(indexSdt);
                String email = cursor.getString(indexEmail);

                // Gán giá trị vào các EditText
                this.ten.setText(hoten);
                this.ngaysinh.setText(ngaysinh);
                this.sdt.setText(sdt);
                this.email.setText(email);
            } else {
                // Nếu cột không tồn tại, thông báo lỗi
                Toast.makeText(Maintkcuatoi.this, "Thông tin người dùng không hợp lệ", Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        } else {
            // Nếu không có dữ liệu người dùng
            Toast.makeText(Maintkcuatoi.this, "Không tìm thấy thông tin người dùng", Toast.LENGTH_SHORT).show();
        }
    }

}
