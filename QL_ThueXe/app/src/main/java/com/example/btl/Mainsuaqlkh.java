package com.example.btl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Mainsuaqlkh extends AppCompatActivity {

    private Button btsua;
    private EditText tenkh, tentk, sdt, mk, ngaysinh, email, diachi;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suaqlkh);

        // Khởi tạo các EditText
        tenkh = findViewById(R.id.editTextTenkh);
        tentk = findViewById(R.id.editTextTentk);
        sdt = findViewById(R.id.editTextdsdt);
        mk = findViewById(R.id.editTextmk);
        ngaysinh = findViewById(R.id.editTextns);
        email = findViewById(R.id.editTextemail);
        diachi = findViewById(R.id.editTextdc);
        btsua = findViewById(R.id.btsua);

        // Khởi tạo DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Lấy dữ liệu từ Intent
        String makh = getIntent().getStringExtra("Makh");
        String ten = getIntent().getStringExtra("Tentk");
        String ht = getIntent().getStringExtra("ht");
        String sdt2 = getIntent().getStringExtra("sdt");
        String mk2 = getIntent().getStringExtra("mk");
        String ns = getIntent().getStringExtra("ns");
        String email1 = getIntent().getStringExtra("email");
        String dc = getIntent().getStringExtra("dc");

        // Đặt giá trị cho các EditText
        if (ht != null) tenkh.setText(ht);
        if (ten != null) tentk.setText(ten);
        if (sdt2 != null) sdt.setText(sdt2);
        if (mk2 != null) mk.setText(mk2);
        if (ns != null) ngaysinh.setText(ns);
        if (email1 != null) email.setText(email1);
        if (dc != null) diachi.setText(dc);

        // Sự kiện click để sửa khách hàng
        btsua.setOnClickListener(v -> {
            // Lấy dữ liệu từ các EditText
            String tenkhachHang = tenkh.getText().toString();
            String tenTaiKhoan = tentk.getText().toString();
            String soDienThoai = sdt.getText().toString();
            String matKhau = mk.getText().toString();
            String ngaySinh = ngaysinh.getText().toString();
            String emailKhachHang = email.getText().toString();
            String diaChi = diachi.getText().toString();

            // Gọi hàm sửa khách hàng
            boolean isUpdated = databaseHelper.suaKhachHang(makh, tenkhachHang, tenTaiKhoan, soDienThoai, matKhau, ngaySinh, emailKhachHang, diaChi);

            if (isUpdated) {
                // Thông báo sửa thành công
                Toast.makeText(this, "Sửa khách hàng thành công", Toast.LENGTH_SHORT).show();
                finish();  // Đóng Activity sau khi sửa thành công
            } else {
                // Thông báo lỗi
                Toast.makeText(this, "Sửa khách hàng thất bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
