package com.example.btl;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QLkhachhangAdapter extends RecyclerView.Adapter<QLkhachhangAdapter.KhachHangViewHolder> {
    private List<QLkhachhang> khachHangList;
    private DatabaseHelper dbHelper;
    private Context context; // Khai báo Context

    // Constructor mới chấp nhận List<QLkhachhang> và Context
    public QLkhachhangAdapter(List<QLkhachhang> khachHangList, Context context) {
        this.khachHangList = khachHangList;
        this.context = context;
        this.dbHelper = new DatabaseHelper(context); // Khởi tạo DatabaseHelper với Context
    }

    @NonNull
    @Override
    public KhachHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.qlkhachhang, parent, false);
        return new KhachHangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KhachHangViewHolder holder, int position) {
        QLkhachhang khachHang = khachHangList.get(position);
        holder.makh.setText("Mã KH: " + khachHang.getMakh());
        holder.hoten.setText("Họ tên: " + khachHang.getHoten());
        holder.sdt.setText("SĐT: " + khachHang.getSdt());
        holder.email.setText("Email: " + khachHang.getEmail());

        // Xử lý khi nhấn nút chỉnh sửa
        holder.btchinhsua.setOnClickListener(v -> {
            // Lấy Makh của khách hàng được chọn
            String makh = khachHang.getMakh();
            String tentk = khachHang.getTentk();
            String ht = khachHang.getHoten();
            String sdt = khachHang.getSdt();
            String mk = khachHang.getMk();
            String ns = khachHang.getNgaysinh();
            String email = khachHang.getEmail();
            String dc = khachHang.getDiachi();

            // Tạo Intent để chuyển sang MainQLKH
            Intent intent = new Intent(v.getContext(), Mainsuaqlkh.class);
            intent.putExtra("Makh", makh);
            intent.putExtra("Tentk", tentk);
            intent.putExtra("ht", ht);
            intent.putExtra("sdt", sdt);
            intent.putExtra("mk", mk);
            intent.putExtra("ns", ns);
            intent.putExtra("email", email);
            intent.putExtra("dc", dc);// Gửi Makh sang Activity/Fragment khác

            // Bắt đầu Activity mới
            v.getContext().startActivity(intent);
        });


        // Xử lý khi nhấn nút xóa
        holder.btxoa.setOnClickListener(v -> {
            new AlertDialog.Builder(v.getContext())
                    .setMessage("Bạn có chắc chắn muốn xóa khách hàng này?")
                    .setCancelable(false)
                    .setPositiveButton("Đồng ý", (dialog, id) -> {
                        // Lấy Makh từ danh sách hiện tại
                        String makh = khachHang.getMakh();

                        // Gọi phương thức xóa khách hàng từ DatabaseHelper
                        boolean isDeleted = dbHelper.xoaKhachHang(makh);

                        if (isDeleted) {
                            // Xóa mục khỏi danh sách và cập nhật RecyclerView
                            khachHangList.remove(position);
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position, khachHangList.size());
                            Toast.makeText(v.getContext(), "Xóa khách hàng thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(v.getContext(), "Xóa khách hàng thất bại", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Hủy", null)
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return khachHangList.size();
    }

    // Phương thức xóa item khỏi danh sách
    public void removeItem(int position) {
        khachHangList.remove(position);
        notifyItemRemoved(position); // Cập nhật RecyclerView
    }

    public static class KhachHangViewHolder extends RecyclerView.ViewHolder {
        TextView makh, hoten, sdt, email;
        ImageButton btchinhsua, btxoa;

        public KhachHangViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ các TextView từ layout
            makh = itemView.findViewById(R.id.makh);
            hoten = itemView.findViewById(R.id.hoten);
            sdt = itemView.findViewById(R.id.sdt);
            email = itemView.findViewById(R.id.email);
            btchinhsua = itemView.findViewById(R.id.btchinhsua);
            btxoa = itemView.findViewById(R.id.btxoa);
        }
    }
}
