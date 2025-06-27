package com.example.btl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Mainkhoxe extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CarAdapter carAdapter;
    private List<Car> carList;
    private DatabaseHelper databaseHelper;
    private String date1, date2, time1, time2, location, rentalType, makh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.khoxe);// Đặt layout `khoxe.xml`

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        date1 = intent.getStringExtra("date1");
        date2 = intent.getStringExtra("date2");
        time1 = intent.getStringExtra("time1");
        time2 = intent.getStringExtra("time2");
        location = intent.getStringExtra("location");
        rentalType = intent.getStringExtra("rentalType");
        makh = intent.getStringExtra("makh");

        ImageView btthoat = findViewById(R.id.btthoat);

        // Thiết lập sự kiện khi nhấn button thoát
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Maindoimk và quay về Activity trước đó
            }
        });

        // Khởi tạo RecyclerView và thiết lập adapter
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        carList = new ArrayList<>();

        // Khởi tạo DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Lấy dữ liệu xe từ cơ sở dữ liệu
        carList = databaseHelper.getCarList();

        // Thiết lập adapter cho RecyclerView
        carAdapter = new CarAdapter(this, carList);
        recyclerView.setAdapter(carAdapter);

        // Thiết lập sự kiện click cho CarAdapter
        carAdapter.setOnItemClickListener(car -> {
            // Khi click vào item, chuyển sang CarDetailActivity
            Intent intent2 = new Intent(Mainkhoxe.this,Mainthongtinxe.class);
            intent2.putExtra("car_name", car.getModel());
            intent2.putExtra("date1", date1);
            intent2.putExtra("date2", date2);
            intent2.putExtra("time1", time1);
            intent2.putExtra("time2", time2);
            intent2.putExtra("location", location);
            intent2.putExtra("rentalType", rentalType);
            intent2.putExtra("makh", makh);
            intent2.putExtra("car_name", car.getModel());
            startActivity(intent2);
        });
    }
}
