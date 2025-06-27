package com.example.btl;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class QLhoadonAdapter extends RecyclerView.Adapter<QLhoadonAdapter.HoadonViewHolder> {
    private List<QLhoadon> hoadonList;
    private DatabaseHelper databaseHelper;
    private OnItemClickListener onItemClickListener; // Thêm biến listener

    // Cập nhật constructor để nhận OnItemClickListener
    public QLhoadonAdapter(Context context, List<QLhoadon> hoadonList, OnItemClickListener onItemClickListener) {
        this.hoadonList = hoadonList;
        this.databaseHelper = new DatabaseHelper(context); // Khởi tạo databaseHelper với context
        this.onItemClickListener = onItemClickListener; // Gán listener
    }

    @NonNull
    @Override
    public HoadonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.qlhoadon, parent, false);
        return new HoadonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoadonViewHolder holder, int position) {
        QLhoadon hoadon = hoadonList.get(position);
        holder.madon.setText(hoadon.getMadon());
        holder.name.setText(hoadon.getName());
        holder.trangthai.setText(hoadon.getTrangthai());
        int tongValue = Integer.parseInt(hoadon.getTong());
        holder.tong.setText(NumberFormat.getNumberInstance(Locale.GERMANY).format(tongValue) + " VNĐ");

        // Xử lý sự kiện khi nhấn vào btxacnhan
        holder.btxacnhan.setOnClickListener(v -> {
            // Hiển thị thông báo xác nhận
            showConfirmDialog(holder.btxacnhan.getContext(), position);
        });

        // Sự kiện click cho mỗi item, sẽ gọi onItemClick nếu có
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(hoadon); // Gọi callback khi item được click
            }
        });
    }

    @Override
    public int getItemCount() {
        return hoadonList.size();
    }

    // Hiển thị thông báo xác nhận và cập nhật trạng thái đơn hàng nếu đồng ý
    private void showConfirmDialog(Context context, int position) {
        new AlertDialog.Builder(context)
                .setTitle("Xác nhận")
                .setMessage("Bạn có muốn xác nhận đơn này không")
                .setPositiveButton("Có", (dialog, which) -> {
                    // Kiểm tra trạng thái hiện tại của hóa đơn
                    String currentStatus = hoadonList.get(position).getTrangthai();
                    if ("Chưa xử lý".equals(currentStatus)) {
                        // Cập nhật trạng thái đơn hàng trong cơ sở dữ liệu
                        boolean isUpdated = databaseHelper.updateTinhTrangHoaDon(
                                hoadonList.get(position).getMadon()
                        );

                        if (isUpdated) {
                            // Cập nhật thành công, thay đổi trạng thái trong danh sách và làm mới RecyclerView
                            hoadonList.get(position).setTrangthai("Đã xử lý");
                            notifyItemChanged(position);
                            Toast.makeText(context, "Đơn đã được xử lý", Toast.LENGTH_SHORT).show();
                        } else {
                            // Xử lý trường hợp cập nhật thất bại
                            Toast.makeText(context, "Có lỗi xảy ra khi cập nhật hóa đơn", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Nếu đơn hàng đã xử lý, hiển thị thông báo
                        Toast.makeText(context, "Hóa đơn này đã được xử lý từ trước", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Không", (dialog, which) -> dialog.dismiss())
                .show();
    }

    // Định nghĩa giao diện cho sự kiện click
    public interface OnItemClickListener {
        void onItemClick(QLhoadon hoadon);
    }

    public static class HoadonViewHolder extends RecyclerView.ViewHolder {
        TextView madon, name, trangthai, tong;
        ImageView carImageView;
        ImageButton btxacnhan;

        public HoadonViewHolder(@NonNull View itemView) {
            super(itemView);
            madon = itemView.findViewById(R.id.madon);
            name = itemView.findViewById(R.id.name);
            trangthai = itemView.findViewById(R.id.trangthai);
            tong = itemView.findViewById(R.id.tong);
            carImageView = itemView.findViewById(R.id.carImageView);
            btxacnhan = itemView.findViewById(R.id.btxacnhan);
        }
    }
}

