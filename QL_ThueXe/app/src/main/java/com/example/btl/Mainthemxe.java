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

public class Mainthemxe extends AppCompatActivity {

    private static final int REQUEST_CODE_PICK_IMAGE = 100;  // Mã yêu cầu cho việc chọn ảnh từ thư viện

    private ImageView imageViewAnh1, imageViewAnh2, imageViewAnh3;
    private Button btnAnh1, btnAnh2, btnAnh3, btnThem;
    private String imagePath1, imagePath2, imagePath3;  // Để lưu trữ đường dẫn ảnh
    private EditText editTextTenxe, editTextHangxe, editTextBienso, editTextGia, editTextTrangthai;
    private EditText editTextSoghe, editTextKieuso, editTextDongco, editTextCopxe, editTextTocdo;
    private EditText editTextTuikhi, editTextMota;
    private Spinner spinnerMaloai;
    private String anh1,anh2,anh3;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themxe2);

        // Khởi tạo các EditText và Spinner
        btnThem = findViewById(R.id.btthem);
        editTextTenxe = findViewById(R.id.editTextTenxe);
        spinnerMaloai = findViewById(R.id.spinnerMaloai);
        editTextHangxe = findViewById(R.id.editTextHangxe);
        editTextBienso = findViewById(R.id.editTextBienso);
        editTextGia = findViewById(R.id.editTextGia);
        editTextTrangthai = findViewById(R.id.editTextTrangthai);
        editTextSoghe = findViewById(R.id.editTextSoghe);
        editTextKieuso = findViewById(R.id.editTextKieuso);
        editTextDongco = findViewById(R.id.editTextDongco);
        editTextCopxe = findViewById(R.id.editTextCopxe);
        editTextTocdo = findViewById(R.id.editTextTocdo);
        editTextTuikhi = findViewById(R.id.editTextTuikhi);
        editTextMota = findViewById(R.id.editTextMota);

        // Khởi tạo Spinner
        List<String> carTypes = getCarTypes();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Mainthemxe.this, android.R.layout.simple_spinner_item, carTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaloai.setAdapter(adapter);

        // Ánh xạ các ImageView và Button cho ảnh
        imageViewAnh1 = findViewById(R.id.imageViewanh1);
        imageViewAnh2 = findViewById(R.id.imageViewanh2);
        imageViewAnh3 = findViewById(R.id.imageViewanh3);
        btnAnh1 = findViewById(R.id.btanh1);
        btnAnh2 = findViewById(R.id.btanh2);
        btnAnh3 = findViewById(R.id.btanh3);

        // Lấy dữ liệu từ Intent
        databaseHelper = new DatabaseHelper(this);

        // Bắt sự kiện khi người dùng nhấn vào nút chọn ảnh
        btnAnh1.setOnClickListener(v -> openImagePicker(1));
        btnAnh2.setOnClickListener(v -> openImagePicker(2));
        btnAnh3.setOnClickListener(v -> openImagePicker(3));

        btnThem.setOnClickListener(v -> {
            String tenXex = editTextTenxe.getText().toString();
            String loaiXex = spinnerMaloai.getSelectedItem().toString().split(" - ")[0];  // Chỉ lấy mã loại xe từ Spinner
            String hangXex = editTextHangxe.getText().toString();
            String bienSox = editTextBienso.getText().toString();
            String giax = editTextGia.getText().toString();
            String trangThaix = editTextTrangthai.getText().toString();
            String soGhex = editTextSoghe.getText().toString();
            String kieusox = editTextKieuso.getText().toString();
            String dongCox = editTextDongco.getText().toString();
            String copXex = editTextCopxe.getText().toString();
            String tocDox = editTextTocdo.getText().toString();
            String tuiKhix = editTextTuikhi.getText().toString();
            String moTax = editTextMota.getText().toString();

            // Sử dụng các đường dẫn ảnh mới hoặc ảnh mặc định nếu không chọn ảnh mới
            String anh1Update = (imagePath1 != null) ? imagePath1 : anh1;
            String anh2Update = (imagePath2 != null) ? imagePath2 : anh2;
            String anh3Update = (imagePath3 != null) ? imagePath3 : anh3;


            // Gọi hàm updateXe để cập nhật thông tin xe
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            boolean isUpdated = dbHelper.themxe(tenXex, loaiXex, hangXex, bienSox, anh1Update, giax, trangThaix, soGhex, kieusox, dongCox, copXex, tocDox, tuiKhix, moTax, anh1Update, anh2Update, anh3Update);

            if (isUpdated) {
                // Thông báo cập nhật thành công
                Toast.makeText(this, "Thêm xe mới thành công", Toast.LENGTH_SHORT).show();
                finish();  // Đóng Activity sau khi cập nhật thành công
            } else {
                // Thông báo lỗi
                Toast.makeText(this, "Cập nhật thông tin thất bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Mở thư viện ảnh và yêu cầu người dùng chọn ảnh
    private void openImagePicker(int imageNumber) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, imageNumber);
    }

    // Xử lý kết quả khi người dùng chọn ảnh từ thư viện
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();

            switch (requestCode) {
                case 1:
                    imagePath1 = getRealPathFromURI(imageUri);
                    imageViewAnh1.setImageURI(imageUri);
                    anh1 = imagePath1;  // Cập nhật tên ảnh
                    break;
                case 2:
                    imagePath2 = getRealPathFromURI(imageUri);
                    imageViewAnh2.setImageURI(imageUri);
                    anh2 = imagePath2;  // Cập nhật tên ảnh
                    break;
                case 3:
                    imagePath3 = getRealPathFromURI(imageUri);
                    imageViewAnh3.setImageURI(imageUri);
                    anh3 = imagePath3;  // Cập nhật tên ảnh
                    break;
            }
        }
    }

    // Chuyển đổi URI thành đường dẫn thực tế
    private String getRealPathFromURI(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            String filePath = cursor.getString(columnIndex);
            cursor.close();
            return filePath;
        }
        return null;
    }

    // Lấy danh sách loại xe
    private List<String> getCarTypes() {
        List<String> types = new ArrayList<>();
        types.add("1 - Sedan");
        types.add("2 - CUV");
        types.add("3 - SUV");
        types.add("4 - Coupe");
        types.add("5 - Bán tải");
        return types;
    }
    private String getCarTypeName(String maloai) {
        switch (maloai) {
            case "1":
                return "Sedan";
            case "2":
                return "CUV";
            case "3":
                return "SUV";
            case "4":
                return "Coupe";
            case "5":
                return "Bán tải";
            default:
                return "Unknown";
        }
    }
    // Hàm hỗ trợ để lấy dữ liệu từ Cursor
    private String getStringColumn(Cursor cursor, String columnName) {
        int index = cursor.getColumnIndex(columnName);
        if (index >= 0) {
            return cursor.getString(index);
        } else {
            return null; // Nếu không tìm thấy cột, trả về null
        }
    }
}
