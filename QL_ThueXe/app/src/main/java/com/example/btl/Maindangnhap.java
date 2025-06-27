package com.example.btl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Maindangnhap extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private DatabaseHelper databaseTX;
    private TextView registerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutdangnhap);

        // Khởi tạo các trường nhập liệu và nút đăng nhập
        usernameEditText = findViewById(R.id.etdangnhap);
        passwordEditText = findViewById(R.id.etmatkhau);
        loginButton = findViewById(R.id.btlogin);
        registerTextView = findViewById(R.id.tvdk);

        // Khởi tạo DatabaseTX
        databaseTX = new DatabaseHelper(this);

        // Xử lý sự kiện khi nhấn vào nút "Đăng nhập"
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Maindangnhap.this, "Vui lòng nhập tên đăng nhập và mật khẩu", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase db = null;
                    Cursor cursor = null;
                    try {
                        db = databaseTX.openDatabase();

                        cursor = db.rawQuery("SELECT * FROM khachhang WHERE Tentk = ? AND Mk = ?", new String[]{username, password});

                        if (cursor != null && cursor.moveToFirst()) {
                            String tenkh = cursor.getString(1);
                            String makh = cursor.getString(0);

                            Toast.makeText(Maindangnhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Maindangnhap.this, Mainchinh.class);
                            SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("tenkh", tenkh);
                            editor.putString("makh", makh);
                            editor.apply();
                            startActivity(intent);
                        } else if (username.equals("ad") && password.equals("ad")) {
                            Intent intent = new Intent(Maindangnhap.this, Mainadmin.class);
                            Toast.makeText(Maindangnhap.this, "Đăng nhập admin thành công", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        } else {
                            Toast.makeText(Maindangnhap.this, "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException e) {
                        Log.e("Maindangnhap", "Lỗi khi kết nối cơ sở dữ liệu", e);
                        Toast.makeText(Maindangnhap.this, "Lỗi khi kết nối cơ sở dữ liệu", Toast.LENGTH_SHORT).show();
                    } finally {
                        if (cursor != null) cursor.close();
                        if (db != null && db.isOpen()) db.close();
                    }
                }
            }
        });

        // Xử lý sự kiện khi nhấn vào "Đăng ký tài khoản"
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang màn hình đăng ký
                Intent intent = new Intent(Maindangnhap.this, MainDangKy.class);
                startActivity(intent);
            }
        });
    }
}
