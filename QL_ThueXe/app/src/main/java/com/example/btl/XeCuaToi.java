package com.example.btl;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class XeCuaToi extends Fragment {

    private RecyclerView recyclerView;
    private myCarAdapter myCarAdapter;
    private List<myCar> myCarList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate layout cho fragment
        View view = inflater.inflate(R.layout.listxecuatoi, container, false);

        recyclerView = view.findViewById(R.id.listxe);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        String makh = "";
        Bundle bundle = getArguments();
        if (bundle != null) {
            makh = bundle.getString("makh"); // Lấy mã khách hàng
        }

        // Tạo đối tượng DatabaseHelper và gọi getMyCars để lấy danh sách xe
        DatabaseHelper dbHelper = new DatabaseHelper(getActivity());
        myCarList = dbHelper.getMyCars(makh);

        // Kiểm tra nếu danh sách xe không rỗng
        if (myCarList.isEmpty()) {
            Toast.makeText(getActivity(), "Không có xe nào để hiển thị", Toast.LENGTH_SHORT).show();
        }

        // Khởi tạo adapter với sự kiện click
        myCarAdapter = new myCarAdapter(getActivity(), myCarList, new myCarAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(myCar car) {
                // Khi click vào item, chuyển sang Mainthongtinxe
                Intent intent = new Intent(getActivity(), Maincthd.class);
                intent.putExtra("madon", car.getMadon());  // Gửi tên xe (hoặc bất kỳ thông tin nào bạn muốn)
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(myCarAdapter);
        return view;
    }
}
