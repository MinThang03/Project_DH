package com.example.btl;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;  // Thêm thư viện Log để ghi lại thông tin kiểm tra
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Canhan extends Fragment {
    private TextView tkCuaToi, doiMK, gplx, xoatk, tenkh;
    private Button dx;

    // Khai báo biến cấp lớp cho `makh`
    private String makh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.canhan, container, false);

        // Khởi tạo TextView
        tkCuaToi = view.findViewById(R.id.tkcuatoi);
        gplx = view.findViewById(R.id.gplx);
        doiMK = view.findViewById(R.id.doimk);
        dx = view.findViewById(R.id.dangxuat);
        xoatk = view.findViewById(R.id.xoatk);
        tenkh = view.findViewById(R.id.name);

        // Lấy giá trị từ `Bundle`
        Bundle bundle = getArguments();
        if (bundle != null) {
            String username = bundle.getString("tenkh", "");  // Trả về chuỗi rỗng nếu không có "tenkh"
            makh = bundle.getString("makh", "");              // Trả về chuỗi rỗng nếu không có "makh"
            tenkh.setText("Khách hàng * " + username);        // Hiển thị tên khách hàng
        }

        // Xử lý khi nhấn "Tài khoản của tôi"
        tkCuaToi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Maintkcuatoi.class);
                startActivity(intent);
            }
        });

        // Xử lý khi nhấn "Xóa tài khoản"
        xoatk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Mainxoatk.class);
                intent.putExtra("khach", makh);  // Truyền `makh` qua Intent
                startActivity(intent);
            }
        });

        // Xử lý khi nhấn "Đăng xuất"
        dx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Maindangnhap.class);
                startActivity(intent);
            }
        });

        // Xử lý khi nhấn "Giấy phép lái xe"
        gplx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainGPLX.class);
                intent.putExtra("khach", makh);  // Truyền `makh` qua Intent
                startActivity(intent);
            }
        });

        // Xử lý khi nhấn "Đổi mật khẩu"
        doiMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Maindoimk.class);
                intent.putExtra("khach", makh);  // Truyền `makh` qua Intent
                startActivity(intent);
            }
        });

        return view; // Trả về view đã được inflate
    }
}
