package com.example.btl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QLcarr extends Fragment {

    private RecyclerView recyclerView;
    private QlCarAdapter adapter;
    private List<QLcar> qlcarList;
    private DatabaseHelper databaseHelper;
    private ImageView thoat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listqlcar, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        thoat = rootView.findViewById(R.id.btthoat);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // Khởi tạo DatabaseHelper
        databaseHelper = new DatabaseHelper(getActivity());
        qlcarList = new ArrayList<>();

        qlcarList = databaseHelper.getQLCarList();

        adapter = new QlCarAdapter(getContext(), qlcarList, new QlCarAdapter.ImageSelectionListener() {
            @Override
            public void onImageSelectionRequested() {
                pickImage();
            }
        });
        thoat.setOnClickListener(v -> {
            // Quay về màn hình đăng nhập (Maindangnhap.class)
            Intent intent = new Intent(getActivity(), Maindangnhap.class);
            // Chạy intent và đóng màn hình hiện tại
            startActivity(intent);
            getActivity().finish();  // Đóng activity hiện tại (listqlcar)
        });
        // Set listener khi item bị xóa
        adapter.setOnItemDeletedListener(new QlCarAdapter.OnItemDeletedListener() {
            @Override
            public void onItemDeleted() {
                // Cập nhật lại danh sách xe khi một item bị xóa
                qlcarList.clear();
                qlcarList.addAll(databaseHelper.getQLCarList());
                adapter.notifyDataSetChanged();  // Cập nhật RecyclerView
            }
        });
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Xóa danh sách cũ và thêm lại từ cơ sở dữ liệu
        qlcarList.clear();
        qlcarList.addAll(databaseHelper.getQLCarList());
        adapter.notifyDataSetChanged();  // Thông báo adapter cập nhật
    }

    public void pickImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, QlCarAdapter.REQUEST_CODE_PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == QlCarAdapter.REQUEST_CODE_PICK_IMAGE && resultCode == getActivity().RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            adapter.setImageUri(selectedImage);
        }
    }
}
