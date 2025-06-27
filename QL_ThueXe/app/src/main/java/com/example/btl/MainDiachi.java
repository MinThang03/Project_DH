package com.example.btl;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainDiachi extends AppCompatActivity {
    // Khai báo các EditText
    private EditText tinhEditText, quanEditText, phuongEditText, diachiEditText;
    private ImageButton btThoat; // Khai báo nút thoát
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diachi);  // Đảm bảo layout là "themdiachi.xml"

        // Tìm các EditText trong layout
        tinhEditText = findViewById(R.id.tinh);
        quanEditText = findViewById(R.id.quan);
        phuongEditText = findViewById(R.id.phuong);
        diachiEditText = findViewById(R.id.diachi);

        // Tìm nút "Lưu" và "Thoát" trong layout
        Button btnLuu = findViewById(R.id.btluu);
        btThoat = findViewById(R.id.btthoat); // Nút thoát

        databaseHelper = new DatabaseHelper(this);

        loaddiachi();

        // Xử lý sự kiện click cho nút "Lưu"
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tinh = tinhEditText.getText().toString().trim();
                String quan = quanEditText.getText().toString().trim();
                String phuong = phuongEditText.getText().toString().trim();
                String sonha = diachiEditText.getText().toString().trim();

                String makh = getIntent().getStringExtra("khach");
                String diachi = sonha.trim() + "," + phuong.trim() + "," + quan.trim() + "," + tinh.trim();

                // Validate inputs
                if (tinh.isEmpty() || quan.isEmpty() || phuong.isEmpty() || sonha.isEmpty()) {
                    Toast.makeText(MainDiachi.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    // Call the updateUserInfo method to update the user information
                    boolean isUpdated = databaseHelper.updatediachi(makh, diachi);

                    if (isUpdated) {
                        // Inform the user that the update was successful
                        Toast.makeText(MainDiachi.this, "Bạn đã cập nhật địa chỉ thành công", Toast.LENGTH_SHORT).show();
                        // Reload user info after update
                        loaddiachi();
                    } else {
                        // Inform the user that the update failed
                        Toast.makeText(MainDiachi.this, "Cập nhật địa chỉ thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Xử lý sự kiện click cho nút "Thoát"
        btThoat.setOnClickListener(v -> {
            // Đóng activity hiện tại
            finish();  // Kết thúc Activity và quay lại màn hình trước đó
        });
    }

    // Hàm kiểm tra xem tất cả các EditText có được điền đầy đủ hay không
    private boolean isAllFieldsFilled() {
        return  !tinhEditText.getText().toString().isEmpty() &&
                !quanEditText.getText().toString().isEmpty() &&
                !phuongEditText.getText().toString().isEmpty() &&
                !diachiEditText.getText().toString().isEmpty();
    }

    private void loaddiachi() {
        String makh = getIntent().getStringExtra("khach");

        // Lấy thông tin người dùng từ CSDL
        Cursor cursor = databaseHelper.getdiachi(makh);

        if (cursor != null && cursor.moveToFirst()) {
            // Lấy tên cột bằng getColumnIndex
            int indexdc = cursor.getColumnIndex("Diachi");

            // Kiểm tra xem cột có tồn tại hay không
            if (indexdc != -1) {
                String diachi = cursor.getString(indexdc);
                // Tách chuỗi dựa trên dấu ","
                String[] addressParts = diachi.split(",");
                if (addressParts.length >= 4) {
                    diachiEditText.setText(addressParts[0].trim());       // Phần địa chỉ
                    phuongEditText.setText(addressParts[1].trim());     // Phần xã/phường
                    quanEditText.setText(addressParts[2].trim());        // Phần quận/huyện
                    tinhEditText.setText(addressParts[3].trim());     // Phần thành phố
                } else {
                    // Xử lý trường hợp không đủ thông tin
                    Toast.makeText(MainDiachi.this, "Địa chỉ không đầy đủ", Toast.LENGTH_SHORT).show();
                }
            } else {
                // Nếu cột không tồn tại, thông báo lỗi
                Toast.makeText(MainDiachi.this, "Thông tin địa chỉ không hợp lệ", Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        } else {
            // Nếu không có dữ liệu người dùng
            Toast.makeText(MainDiachi.this, "Không tìm thấy địa chỉ người dùng", Toast.LENGTH_SHORT).show();
        }
    }
}
