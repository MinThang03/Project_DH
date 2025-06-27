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

import java.util.ArrayList;
import java.util.List;


public class MainQLhoadon extends Fragment {
    private RecyclerView listqlhoadon;
    private QLhoadonAdapter hoadonAdapter;
    private List<QLhoadon> hoadonList;
    private DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Gán layout cho fragment
        View view = inflater.inflate(R.layout.listqlhoadon, container, false);

        // Khởi tạo RecyclerView
        listqlhoadon = view.findViewById(R.id.recyclerView);
        listqlhoadon.setLayoutManager(new LinearLayoutManager(getContext()));

        // Khởi tạo database helper và lấy dữ liệu từ cơ sở dữ liệu
        databaseHelper = new DatabaseHelper(getActivity());
        hoadonList = databaseHelper.getqlhd(); // Lấy dữ liệu từ cơ sở dữ liệu

        // Thiết lập adapter cho RecyclerView
        hoadonAdapter = new QLhoadonAdapter(getContext(), hoadonList, new QLhoadonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(QLhoadon hoadon) {
                // Khi nhấn vào item, chuyển đến MainChinh Activity và gửi Mathuexe
                Intent intent = new Intent(getActivity(), Maincthd.class);
                intent.putExtra("madon", hoadon.getMadon()); // Gửi Mathuexe (Madon) qua Intent
                startActivity(intent); // Chuyển đến Activity
            }
        });
        listqlhoadon.setAdapter(hoadonAdapter);

        return view;
    }
}
