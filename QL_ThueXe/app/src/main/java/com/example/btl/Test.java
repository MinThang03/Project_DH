package com.example.btl;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Test extends AppCompatActivity {

    private static final int REQUEST_CODE_PICK_IMAGE = 100;
    private ImageView imageView;
    private Button btnSelectImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        imageView = findViewById(R.id.imageView);
        btnSelectImage = findViewById(R.id.btnSelectImage);

        // Xử lý sự kiện click chọn ảnh
        btnSelectImage.setOnClickListener(v -> {
            // Mở bộ chọn ảnh
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Kiểm tra xem yêu cầu có phải là yêu cầu chọn ảnh hay không
        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            // Lấy URI của ảnh đã chọn
            Uri imageUri = data.getData();

            // Cập nhật đường dẫn file (nếu cần)
            String filePath = getRealPathFromURI(imageUri);

            // Hiển thị ảnh trong ImageView
            imageView.setImageURI(imageUri);

            // Thông báo đường dẫn file (nếu muốn)
            Toast.makeText(this, "Đường dẫn: " + filePath, Toast.LENGTH_LONG).show();
        }
    }

    // Hàm để lấy đường dẫn thực từ URI
    private String getRealPathFromURI(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            String filePath = cursor.getString(columnIndex);
            cursor.close();
            return filePath;
        } else {
            return null;
        }
    }
}
