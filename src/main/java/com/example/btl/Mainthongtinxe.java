package com.example.btl;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class Mainthongtinxe extends AppCompatActivity {

    private ImageView carImage;
    private Animation fadeOut;
    private Button btdatxe;
    private String date1, date2, time1, time2, location, rentalType, makh;
    private String image1, image2, image3;
    int priceValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtinxe);
        DatabaseHelper dbHelper = new DatabaseHelper(this);

        // Tìm button btthoat
        ImageView btthoat = findViewById(R.id.btthoat);

        // Thiết lập sự kiện khi nhấn button thoát
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Maindoimk và quay về Activity trước đó
            }
        });

        TextView carName = findViewById(R.id.carName);
        TextView carPrice = findViewById(R.id.carPrice);
        TextView scn = findViewById(R.id.scn);
        TextView std = findViewById(R.id.std);
        TextView hp = findViewById(R.id.hp);
        TextView lit = findViewById(R.id.lit);
        TextView hangxe = findViewById(R.id.asuv);
        TextView tuikhi = findViewById(R.id.tuikhi);
        TextView km = findViewById(R.id.km);
        TextView tiennghi = findViewById(R.id.tiennghi);

        Intent intent = getIntent();
        date1 = intent.getStringExtra("date1");
        date2 = intent.getStringExtra("date2");
        time1 = intent.getStringExtra("time1");
        time2 = intent.getStringExtra("time2");
        location = intent.getStringExtra("location");
        rentalType = intent.getStringExtra("rentalType");
        makh = intent.getStringExtra("makh");

        // Khai báo các ImageView
        btdatxe = findViewById(R.id.bookButton);
        carImage = findViewById(R.id.carImage);
        ImageView thumbnail1 = findViewById(R.id.anh1);
        ImageView thumbnail2 = findViewById(R.id.anh2);
        ImageView thumbnail3 = findViewById(R.id.anh3);

        // tên xe đã được truyền qua Intent
        String tenXe = getIntent().getStringExtra("car_name");

// Lấy dữ liệu từ cơ sở dữ liệu dựa vào tên xe
        Cursor cursor = dbHelper.getThongTinXeByTenXe(tenXe);
        if (cursor != null && cursor.moveToFirst()) {
            carName.setText(cursor.getString(cursor.getColumnIndexOrThrow("Tenxe")));
            priceValue = cursor.getInt(cursor.getColumnIndexOrThrow("Gia"));
            carPrice.setText(NumberFormat.getNumberInstance(Locale.GERMANY).format(priceValue) + " VNĐ/ngày");
            scn.setText("Số chỗ ngồi: "+cursor.getString(cursor.getColumnIndexOrThrow("Soghe")) + " chỗ");
            std.setText("Hộp số: "+cursor.getString(cursor.getColumnIndexOrThrow("Kieuso")));
            hp.setText("Mã lực: "+cursor.getString(cursor.getColumnIndexOrThrow("Dongco")));
            tuikhi.setText("Số túi khí: "+cursor.getString(cursor.getColumnIndexOrThrow("Tuikhi")) + " túi");
            lit.setText("Thể tích cốp : "+cursor.getString(cursor.getColumnIndexOrThrow("Copxe")));
            km.setText("Tốc độ tối đa: "+cursor.getString(cursor.getColumnIndexOrThrow("Tocdo")) + " km/h");
            hangxe.setText("Dòng xe: "+cursor.getString(cursor.getColumnIndexOrThrow("Tenloaixe")));
            tiennghi.setText(cursor.getString(cursor.getColumnIndexOrThrow("Mota")));
            // Lấy tên hình ảnh từ cơ sở dữ liệu
            image1 = cursor.getString(cursor.getColumnIndexOrThrow("Anh1"));
            image2 = cursor.getString(cursor.getColumnIndexOrThrow("Anh2"));
            image3 = cursor.getString(cursor.getColumnIndexOrThrow("Anh3"));

            // Chuyển tên ảnh thành resource ID
            int imageRes1 = getResources().getIdentifier(image1, "drawable", getPackageName());
            int imageRes2 = getResources().getIdentifier(image2, "drawable", getPackageName());
            int imageRes3 = getResources().getIdentifier(image3, "drawable", getPackageName());

            // Cập nhật hình ảnh vào các thumbnail
            thumbnail1.setImageResource(imageRes1);
            thumbnail2.setImageResource(imageRes2);
            thumbnail3.setImageResource(imageRes3);

            // Set default image for carImage
            carImage.setImageResource(imageRes1);
            // Thiết lập OnClickListener cho từng ảnh nhỏ
            thumbnail1.setOnClickListener(v -> changeImage(getResources().getIdentifier(image1, "drawable", getPackageName())));
            thumbnail2.setOnClickListener(v -> changeImage(getResources().getIdentifier(image2, "drawable", getPackageName())));
            thumbnail3.setOnClickListener(v -> changeImage(getResources().getIdentifier(image3, "drawable", getPackageName())));
        }
        cursor.close();


        // Load animations
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        // Set default image for carImage
        //carImage.setImageResource(R.drawable.img_6); // Set the first image by defaul

        btdatxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(Mainthongtinxe.this,Mainxacnhan.class);
                t.putExtra("car_name", carName.getText().toString().trim());
                t.putExtra("date1", date1);
                t.putExtra("date2", date2);
                t.putExtra("time1", time1);
                t.putExtra("time2", time2);
                t.putExtra("location", location);
                t.putExtra("rentalType", rentalType);
                t.putExtra("makh", makh);
                t.putExtra("anh", image1);
                t.putExtra("gia", priceValue);
                startActivity(t);
            }
        });
    }

    private void changeImage(int resId) {
        // Start fade out animation
        carImage.startAnimation(fadeOut);

        // Set a listener on the fade out animation to change the image after it ends
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // No action needed
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Change the image resource
                carImage.setImageResource(resId);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // No action needed
            }
        });

    }

}