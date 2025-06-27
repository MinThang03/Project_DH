package com.example.btl;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class Mainhang extends AppCompatActivity {

    private RecyclerView recyclerView;
    private QLkhachhangAdapter adapter;
    private List<QLkhachhang> qlkhList;
    private ImageButton btadd;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listqlkhachhang);

        // Khởi tạo các view từ layout
        recyclerView = findViewById(R.id.recyclerView);
        btadd = findViewById(R.id.addkh);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Lấy dữ liệu từ database
        qlkhList = databaseHelper.getqlkh();

        // Kiểm tra nếu qlkhList rỗng hoặc null
        if (qlkhList == null || qlkhList.isEmpty()) {
            qlkhList = new ArrayList<>(); // Tránh lỗi null pointer
        }

        // Khởi tạo adapter với danh sách dữ liệu
        adapter = new QLkhachhangAdapter(qlkhList, this);
        recyclerView.setAdapter(adapter);

        // Xử lý sự kiện click cho ImageButton để chuyển màn hình
        btadd.setOnClickListener(v -> {
            Intent intent = new Intent(Mainhang.this, Mainthemqlkh.class);
            startActivity(intent);
        });
    }
}
