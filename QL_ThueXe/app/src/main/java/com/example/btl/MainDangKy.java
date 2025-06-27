package com.example.btl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainDangKy extends AppCompatActivity {
    private EditText usernameEditText, phoneEditText, passwordEditText, confirmPasswordEditText, nameEditText;
    private Button registerButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutdangky);

        // Khởi tạo các trường nhập liệu và nút đăng ký
        nameEditText = findViewById(R.id.namekh);
        usernameEditText = findViewById(R.id.username);
        phoneEditText = findViewById(R.id.sdt);
        passwordEditText = findViewById(R.id.mk1);
        confirmPasswordEditText = findViewById(R.id.mk2);
        registerButton = findViewById(R.id.register_button);

        // Khởi tạo DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Xử lý sự kiện khi nhấn vào nút "Đăng ký"
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ các trường nhập liệu
                String namekh = nameEditText.getText().toString().trim();
                String username = usernameEditText.getText().toString().trim();
                String phone = phoneEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                // Kiểm tra nếu có trường nào bị bỏ trống
                if (username.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(MainDangKy.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                // Kiểm tra mật khẩu có khớp hay không
                else if (!password.equals(confirmPassword)) {
                    Toast.makeText(MainDangKy.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                }
                // Kiểm tra tên tài khoản đã tồn tại chưa
                else if (databaseHelper.checkUsernameExists(username)) {
                    // Nếu tài khoản đã tồn tại, hiển thị thông báo lỗi
                    Toast.makeText(MainDangKy.this, "Tên tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu tài khoản chưa tồn tại, thực hiện thêm người dùng vào cơ sở dữ liệu
                    boolean isInserted = databaseHelper.insertUser(namekh, username, phone, password);
                    if (isInserted) {
                        Toast.makeText(MainDangKy.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        // Xóa dữ liệu trong các trường nhập liệu sau khi đăng ký thành công
                        nameEditText.setText("");
                        usernameEditText.setText("");
                        phoneEditText.setText("");
                        passwordEditText.setText("");
                        confirmPasswordEditText.setText("");
                    } else {
                        Toast.makeText(MainDangKy.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
