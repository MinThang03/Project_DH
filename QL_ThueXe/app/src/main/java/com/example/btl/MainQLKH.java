package com.example.btl;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainQLKH extends Fragment {

    private RecyclerView recyclerView;
    private QLkhachhangAdapter adapter;
    private List<QLkhachhang> qlkhList;
    private ImageButton btadd;
    private DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listqlkhachhang, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        btadd = rootView.findViewById(R.id.addkh);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Khởi tạo DatabaseHelper
        databaseHelper = new DatabaseHelper(getActivity());

        // Lấy dữ liệu từ database
        qlkhList = databaseHelper.getqlkh();

        // Kiểm tra nếu qlkhList rỗng hoặc null
        if (qlkhList == null || qlkhList.isEmpty()) {
            qlkhList = new ArrayList<>(); // Tránh lỗi null pointer
        }

        // Khởi tạo adapter với danh sách dữ liệu

        // Xử lý sự kiện click cho ImageButton để chuyển màn hình
        btadd.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Mainthemqlkh.class);
            startActivity(intent);
        });
        adapter = new QLkhachhangAdapter(qlkhList,getContext());
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
