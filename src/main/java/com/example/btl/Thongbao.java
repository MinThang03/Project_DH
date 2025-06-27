package com.example.btl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class Thongbao extends Fragment {

    private ArrayList<String> notifications;
    private ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thongbao, container, false);

        // Initialize the notifications list
        notifications = new ArrayList<>();
        notifications.add("Thông báo quan trọng\nNgày: 10/11/2024\nNội dung: Cập nhật hệ thống.");
        notifications.add("LẦN ĐẦU ĐI TQ - ƯU ĐÃI SIÊU HỜI\nNgày: 09/11/2024\nBạn QT ơi,\nBiết bạn còn ngần ngại, TQ tặng bộ ưu đãi để...");
        notifications.add("Welcome to TQ\nNgày: 08/11/2024\nChào mừng bạn tham gia cộng đồng TQ,...");

        // Set up the ListView and adapter
        ListView listThongBao = view.findViewById(R.id.listthongbao);
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, notifications);
        listThongBao.setAdapter(adapter);

        // Set up the delete button and listener
        ImageButton btnXoa = view.findViewById(R.id.btxoa);
        btnXoa.setOnClickListener(v -> showConfirmationDialog());

        return view;
    }

    private void showConfirmationDialog() {
        new AlertDialog.Builder(requireContext())
                .setMessage("Bạn có muốn xóa hay không?")
                .setPositiveButton("Có", (dialog, which) -> {
                    // Clear the list and notify the adapter
                    notifications.clear();
                    adapter.notifyDataSetChanged();
                })
                .setNegativeButton("Không", null)
                .show();
    }
}
