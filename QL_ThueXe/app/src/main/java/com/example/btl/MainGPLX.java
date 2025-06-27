package com.example.btl;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

    public class MainGPLX extends AppCompatActivity {

    private EditText edtSoGPLX, edtNoiDK, edtNgayHetHan;
    private Spinner hang;
    private DatabaseHelper dbHelper;  // Đảm bảo rằng bạn đã tạo đối tượng này đúng cách

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gplaixe);

        // Initialize Spinner and set adapter
        hang = findViewById(R.id.hang);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hang_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hang.setAdapter(adapter);

        // Initialize EditTexts
        edtSoGPLX = findViewById(R.id.sogplx);
        edtNoiDK = findViewById(R.id.noidk);
        edtNgayHetHan = findViewById(R.id.ngayhethan);

        // Initialize Database Helper
        dbHelper = new DatabaseHelper(this); // Thay "MyDatabaseHelper" bằng lớp của bạn

        // Set up "Thoát" button
        ImageButton btthoat = findViewById(R.id.btthoat);
        btthoat.setOnClickListener(v -> finish());

        // Set up "Cập nhật" button
        Button btcapnhat = findViewById(R.id.btcapnhat);
        btcapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAllFieldsFilled()) {
                    String makh = getIntent().getStringExtra("khach");
                    String sogp = edtSoGPLX.getText().toString();
                    String hangbang = hang.getSelectedItem().toString();
                    String noidk = edtNoiDK.getText().toString();
                    String ngayhh = edtNgayHetHan.getText().toString();

                    // Cập nhật thông tin vào cơ sở dữ liệu
                    boolean isUpdated = dbHelper.updatebang(makh, sogp, hangbang, noidk, ngayhh);
                    if (isUpdated) {
                        Toast.makeText(MainGPLX.this, "Bạn đã cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainGPLX.this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainGPLX.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Tải thông tin khi Activity được mở
        loadgplx();
    }

    // Check if all fields are filled
    private boolean isAllFieldsFilled() {
        return !edtSoGPLX.getText().toString().isEmpty() &&
                !edtNoiDK.getText().toString().isEmpty() &&
                !edtNgayHetHan.getText().toString().isEmpty();
    }

    // Hàm tải thông tin từ cơ sở dữ liệu và hiển thị lên màn hình
    private void loadgplx() {
        String makh = getIntent().getStringExtra("khach");

        Cursor cursor = dbHelper.getbang(makh);
        if (cursor != null && cursor.moveToFirst()) {
            // Kiểm tra các chỉ số cột trước khi sử dụng
            int sogpIndex = cursor.getColumnIndex("Sogp");
            int hangbangIndex = cursor.getColumnIndex("Hangbang");
            int noidkIndex = cursor.getColumnIndex("Noidk");
            int ngayhhIndex = cursor.getColumnIndex("Ngayhh");

            // Kiểm tra nếu các chỉ số cột hợp lệ
            if (sogpIndex >= 0 && hangbangIndex >= 0 && noidkIndex >= 0 && ngayhhIndex >= 0) {
                String sogp = cursor.getString(sogpIndex);
                String hangbang = cursor.getString(hangbangIndex);
                String noidk = cursor.getString(noidkIndex);
                String ngayhh = cursor.getString(ngayhhIndex);

                edtSoGPLX.setText(sogp);
                edtNoiDK.setText(noidk);
                edtNgayHetHan.setText(ngayhh);

                // Chọn item tương ứng trong Spinner
                ArrayAdapter<CharSequence> adapter = (ArrayAdapter<CharSequence>) hang.getAdapter();
                int spinnerPosition = adapter.getPosition(hangbang);
                hang.setSelection(spinnerPosition);
            } else {
                // Nếu không tìm thấy cột, thông báo lỗi
                Toast.makeText(this, "Dữ liệu không hợp lệ", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Nếu không có dữ liệu
            Toast.makeText(this, "Không tìm thấy dữ liệu cho Makh: " + makh, Toast.LENGTH_SHORT).show();
        }

        if (cursor != null) {
            cursor.close();
        }
    }

}
