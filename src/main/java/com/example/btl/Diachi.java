package com.example.btl;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Diachi extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<classDiachi> diachiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdiachi);

        // Khởi tạo danh sách địa chỉ
        diachiList = new ArrayList<>();
        diachiList.add(new Diachi("Hà Nội", "Phường Hà Nội"));
        diachiList.add(new Diachi("TP Hồ Chí Minh", "Phường 1"));
        diachiList.add(new Diachi("Đà Nẵng", "Phường 2"));

        // Khởi tạo RecyclerView và gán adapter
        recyclerView = findViewById(R.id.listdiachi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Tạo và set adapter
        DiachiAdapter adapter = new DiachiAdapter(diachiList);
        recyclerView.setAdapter(adapter);
    }
}