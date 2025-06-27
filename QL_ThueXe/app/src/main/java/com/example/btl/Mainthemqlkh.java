package com.example.btl;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Mainthemqlkh extends AppCompatActivity {

    private static final int REQUEST_CODE_PICK_IMAGE = 100;  // Mã yêu cầu cho việc chọn ảnh từ thư viện

    private ImageView imageViewAnh1, imageViewAnh2, imageViewAnh3;
    private Button btthem;
    private EditText tenkh, tentk, sdt, mk, ngaysinh,email,diachi;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themqkh);

        // Khởi tạo các EditText và Spinner
        tenkh = findViewById(R.id.editTextTenkh);
        tentk = findViewById(R.id.editTextTentk);
        sdt = findViewById(R.id.editTextdsdt);
        mk = findViewById(R.id.editTextmk);
        ngaysinh = findViewById(R.id.editTextns);
        email = findViewById(R.id.editTextemail);
        diachi = findViewById(R.id.editTextdc);
        btthem = findViewById(R.id.btthem);

        // Lấy dữ liệu từ Intent
        databaseHelper = new DatabaseHelper(this);

        btthem.setOnClickListener(v -> {
            // Lấy dữ liệu từ các EditText và Spinner được khởi tạo
            String tenkhachHang = tenkh.getText().toString();
            String tenTaiKhoan = tentk.getText().toString();
            String soDienThoai = sdt.getText().toString();
            String matKhau = mk.getText().toString();
            String ngaySinh = ngaysinh.getText().toString();
            String emailKhachHang = email.getText().toString();
            String diaChi = diachi.getText().toString();

            // Gọi hàm thêm hoặc cập nhật khách hàng (tùy thuộc vào logic bạn cần)
            boolean isInserted = databaseHelper.themKhachHang(tenkhachHang, tenTaiKhoan, soDienThoai, matKhau, ngaySinh, emailKhachHang, diaChi);

            if (isInserted) {
                // Thông báo thêm thành công
                Toast.makeText(this, "Thêm khách hàng thành công", Toast.LENGTH_SHORT).show();
                finish();  // Đóng Activity sau khi thêm thành công
            } else {
                // Thông báo lỗi
                Toast.makeText(this, "Thêm khách hàng thất bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
