package com.example.btl;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Khoxe extends Fragment {

    private RecyclerView recyclerView;
    private CarAdapter carAdapter;
    private List<Car> carList;
    private DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.khoxe, container, false);

        // Khởi tạo RecyclerView và thiết lập adapter
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        carList = new ArrayList<>();

        // Khởi tạo DatabaseHelper
        databaseHelper = new DatabaseHelper(getActivity());

        // Lấy dữ liệu xe từ cơ sở dữ liệu
        carList = databaseHelper.getCarList();

        // Thiết lập adapter cho RecyclerView
        carAdapter = new CarAdapter(getActivity(), carList);
        recyclerView.setAdapter(carAdapter);

        // Thiết lập sự kiện click cho CarAdapter
        carAdapter.setOnItemClickListener(car -> {
            // Khi click vào item, chuyển sang CarDetailActivity
            Intent intent = new Intent(getActivity(), Mainthongtinxe.class);
            intent.putExtra("car_name", car.getModel());
            startActivity(intent);
        });

        return view;
    }
}


