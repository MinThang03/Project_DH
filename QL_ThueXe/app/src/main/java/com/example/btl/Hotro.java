package com.example.btl;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Hotro extends Fragment {

    private EditText nhapTen, nhapSdt, nhapEmail, dichVu, moTa;
    private Button btnOpDon;
    private Spinner spinnerLoaiHoTro;

    // Khởi tạo DatabaseHelper
    private DatabaseHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hotro, container, false);

        // Khởi tạo DatabaseHelper
        dbHelper = new DatabaseHelper(getActivity());

        // Khởi tạo các view từ layout
        nhapTen = view.findViewById(R.id.nhapten);
        nhapSdt = view.findViewById(R.id.nhapsdt);
        nhapEmail = view.findViewById(R.id.nhapemail);
        dichVu = view.findViewById(R.id.dichvu);
        moTa = view.findViewById(R.id.mota);
        btnOpDon = view.findViewById(R.id.btnopdon);
        spinnerLoaiHoTro = view.findViewById(R.id.loaihotro);

        // Tạo danh sách các loại hỗ trợ
        String[] loaiHoTroArray = {"Hỗ trợ kỹ thuật", "Hỗ trợ tài khoản", "Hỗ trợ thanh toán", "Hỗ trợ dịch vụ"};

        // Tạo ArrayAdapter và thiết lập cho Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, loaiHoTroArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLoaiHoTro.setAdapter(adapter);


        // Thiết lập sự kiện khi nhấn nút "Nộp đơn"
        btnOpDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ các trường nhập liệu
                String ten = nhapTen.getText().toString().trim();
                String sdt = nhapSdt.getText().toString().trim();
                String email = nhapEmail.getText().toString().trim();
                String chude = spinnerLoaiHoTro.getSelectedItem().toString();
                String dichVuText = dichVu.getText().toString().trim();
                String mota = moTa.getText().toString().trim();
                String makh = null;
                Bundle bundle = getArguments();
                if (bundle != null) {
                    makh = bundle.getString("makh", "");// Hiển thị tên khách hàng
                }

                // Kiểm tra nếu có trường nào còn trống
                if (ten.isEmpty() || sdt.isEmpty() || email.isEmpty() || dichVuText.isEmpty() || mota.isEmpty() ) {
                    Toast.makeText(getActivity(), "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    // Thêm dữ liệu vào cơ sở dữ liệu
                    boolean isInserted = dbHelper.insertHotro(makh, ten, sdt, email, chude, dichVuText, mota);

                    if (isInserted) {
                        Toast.makeText(getActivity(), "Bạn đã nộp đơn hỗ trợ thành công", Toast.LENGTH_SHORT).show();
                        nhapTen.setText("");
                        nhapSdt.setText("");
                        nhapEmail.setText("");
                        dichVu.setText("");
                        moTa.setText("");
                        spinnerLoaiHoTro.setSelection(0);
                    } else {
                        Toast.makeText(getActivity(), "Lỗi khi nộp đơn hỗ trợ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
    }
}
