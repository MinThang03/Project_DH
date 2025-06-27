package com.example.btl;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Hotro extends Fragment {

    private EditText nhapTen, nhapSdt, nhapEmail, dichVu, moTa;
    private Button btnOpDon;
    private Spinner spinnerLoaiHoTro;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflating the layout for this fragment
        View view = inflater.inflate(R.layout.hotro, container, false);

        // Khởi tạo các view từ layout
        nhapTen = view.findViewById(R.id.nhapten);
        nhapSdt = view.findViewById(R.id.nhapsdt);
        nhapEmail = view.findViewById(R.id.nhapemail);
        dichVu = view.findViewById(R.id.dichvu);
        moTa = view.findViewById(R.id.mota);
        btnOpDon = view.findViewById(R.id.btnopdon);
        spinnerLoaiHoTro = view.findViewById(R.id.loaihotro);

        // Thiết lập sự kiện khi nhấn nút "Nộp đơn"
        btnOpDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra nếu có trường nào còn trống
                if (nhapTen.getText().toString().isEmpty() ||
                        nhapSdt.getText().toString().isEmpty() ||
                        nhapEmail.getText().toString().isEmpty()) {
                    // Hiển thị thông báo nếu có trường trống
                    Toast.makeText(getActivity(), "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    // Thực hiện hành động nộp đơn (Ví dụ: Hiển thị Toast)
                    Toast.makeText(getActivity(), "Bạn đã nộp đơn hỗ trợ thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
