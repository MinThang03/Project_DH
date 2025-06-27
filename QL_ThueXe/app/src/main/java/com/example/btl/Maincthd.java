package com.example.btl;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class Maincthd extends AppCompatActivity {

    private TextView soluong, tongphi, giaxe, madon, trangthai, name, sdt, email, hinhthuc, dongxe, bienso, diachi, tgnhanxe,tgtraxe,tong;
    private ImageButton btthoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutchitietdon);

        // Ánh xạ các TextView
        madon = findViewById(R.id.madon);
        trangthai = findViewById(R.id.trangthai);
        name = findViewById(R.id.name);
        sdt = findViewById(R.id.sdt);
        email = findViewById(R.id.email);
        hinhthuc = findViewById(R.id.hinhthuc);
        dongxe = findViewById(R.id.dongxe);
        bienso = findViewById(R.id.bienso);
        diachi = findViewById(R.id.diachi);
        tgnhanxe = findViewById(R.id.tgnhanxe);
        tgtraxe = findViewById(R.id.tgtraxe);
        tong = findViewById(R.id.tongtien);
        giaxe = findViewById(R.id.giaxe);
        tongphi = findViewById(R.id.tongphi);
        soluong = findViewById(R.id.soluong);

        // Lấy mã đơn từ Intent
        String mathue = getIntent().getStringExtra("madon");

        if (mathue != null) {
            // Tạo đối tượng DatabaseHelper và truy vấn thông tin từ bảng Thuexe
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            Cursor cursor = dbHelper.getThuexe(mathue);

            if (cursor != null && cursor.moveToFirst()) {
                // Kiểm tra và hiển thị thông tin vào các TextView nếu cột tồn tại
                int madonIndex = cursor.getColumnIndex("Mathuexe");
                if (madonIndex != -1) madon.setText("#" + cursor.getString(madonIndex));

                int trangthaiIndex = cursor.getColumnIndex("Tinhtrang");
                if (trangthaiIndex != -1) trangthai.setText(cursor.getString(trangthaiIndex));

                int nameIndex = cursor.getColumnIndex("Hotenthue");
                if (nameIndex != -1) name.setText(cursor.getString(nameIndex));

                int sdtIndex = cursor.getColumnIndex("Sdtthue");
                if (sdtIndex != -1) sdt.setText(cursor.getString(sdtIndex));

                int emailIndex = cursor.getColumnIndex("Emailthue");
                if (emailIndex != -1) email.setText(cursor.getString(emailIndex));

                int hinhthucIndex = cursor.getColumnIndex("Hinhthucthue");
                if (hinhthucIndex != -1) hinhthuc.setText(cursor.getString(hinhthucIndex));

                int dongxeIndex = cursor.getColumnIndex("Tenxe");
                if (dongxeIndex != -1) dongxe.setText(cursor.getString(dongxeIndex));

                int biensoIndex = cursor.getColumnIndex("Bienso");
                if (biensoIndex != -1) bienso.setText(cursor.getString(biensoIndex));

                int diachiIndex = cursor.getColumnIndex("Diachinhanxe");
                if (diachiIndex != -1) diachi.setText(cursor.getString(diachiIndex));

                int tgnhanxeIndex = cursor.getColumnIndex("Timenhan");
                if (tgnhanxeIndex != -1) tgnhanxe.setText(cursor.getString(tgnhanxeIndex));

                int tgtraxeIndex = cursor.getColumnIndex("Timetra");
                if (tgtraxeIndex != -1) tgtraxe.setText(cursor.getString(tgtraxeIndex));

                // Lấy giá trị của "Tongtien" và "Gia" từ cursor và định dạng
                int tongIndex = cursor.getColumnIndex("Tongtien");
                if (tongIndex != -1) {
                    int tongValue = cursor.getInt(tongIndex);
                    tong.setText(NumberFormat.getNumberInstance(Locale.GERMANY).format(tongValue) + " VNĐ");
                }

                int giaxeIndex = cursor.getColumnIndex("Gia");
                if (giaxeIndex != -1) {
                    int giaxeValue = cursor.getInt(giaxeIndex);
                    giaxe.setText(NumberFormat.getNumberInstance(Locale.GERMANY).format(giaxeValue) + " VNĐ");
                }

                // Chuyển đổi giá trị từ TextView sang kiểu số (int hoặc double)
                int tongValue = cursor.getInt(tongIndex);
                int giaxeValue = cursor.getInt(giaxeIndex);
                int tongphiValue = tongValue - 10050000; // Tính toán giá trị "tongphi"

                // Cập nhật giá trị của "tongphi"
                tongphi.setText(NumberFormat.getNumberInstance(Locale.GERMANY).format(tongphiValue) + " VNĐ");

                // Tính toán và cập nhật giá trị của "soluong"
                if (giaxeValue != 0) {  // Kiểm tra tránh chia cho 0
                    int soluongValue = (int) tongphiValue / giaxeValue;
                    soluong.setText(String.valueOf(soluongValue));
                } else {
                    soluong.setText("0");  // Nếu giaxe = 0, hiển thị 0
                }

                cursor.close();
            }
        }
        // Ánh xạ ImageButton btthoat và thiết lập sự kiện click
        btthoat = findViewById(R.id.btthoat); // Tìm ImageButton btthoat trong layout
        btthoat.setOnClickListener(v -> {
            // Tự động quay lại màn hình trước (Activity trước đó)
            onBackPressed(); // Gọi phương thức onBackPressed() để quay lại Activity trước đó
        });
    }
}
