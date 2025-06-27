package com.example.btl;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class QlCarAdapter extends RecyclerView.Adapter<QlCarAdapter.QlCarViewHolder> {

    private Context context;
    private List<QLcar> qlcarList;
    private ImageSelectionListener imageSelectionListener;
    private DatabaseHelper dbHelper;
    public static final int REQUEST_CODE_PICK_IMAGE = 100;
    private ImageView currentImageView;

    public void setImageUri(Uri imageUri) {
        if (currentImageView != null) {
            currentImageView.setImageURI(imageUri);
        }
    }

    @Override
    public int getItemCount() {
        return qlcarList.size();
    }

    public interface ImageSelectionListener {
        void onImageSelectionRequested();
    }

    public QlCarAdapter(Context context, List<QLcar> qlcarList, ImageSelectionListener imageSelectionListener) {
        this.context = context;
        this.qlcarList = qlcarList;
        this.imageSelectionListener = imageSelectionListener;
    }

    @NonNull
    @Override
    public QlCarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.qlcar, parent, false);
        return new QlCarViewHolder(view);
    }
    // Callback để thông báo về việc xóa item
    public interface OnItemDeletedListener {
        void onItemDeleted();
    }

    private OnItemDeletedListener onItemDeletedListener;
    public void setOnItemDeletedListener(OnItemDeletedListener listener) {
        this.onItemDeletedListener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull QlCarViewHolder holder, int position) {
        QLcar qlcar = qlcarList.get(position);
        holder.modelTextView.setText(qlcar.getTenxe());
        holder.priceTextView.setText("Giá "+qlcar.getGia() + " VND/Ngày");
        holder.typeTextView.setText(qlcar.getHangxe());
        holder.rangeTextView.setText(qlcar.getTuikhi() + " Túi khí");
        holder.seatsTextView.setText(qlcar.getSoghe() + " chỗ");
        holder.capacityTextView.setText(qlcar.getCopxe());

        dbHelper = new DatabaseHelper(context);

        String imageNameOrPath = qlcar.getHinhanh(); // Lấy đường dẫn ảnh từ cơ sở dữ liệu

        if (imageNameOrPath != null && !imageNameOrPath.isEmpty()) {
            int imageResId = context.getResources().getIdentifier(imageNameOrPath, "drawable", context.getPackageName());

            if (imageResId != 0) {
                // Nếu tên ảnh có trong drawable, lấy ảnh từ drawable
                holder.carImageView.setImageResource(imageResId);
            } else {
                // Nếu không, thử lấy ảnh từ bộ nhớ trong
                File imgFile = new File(imageNameOrPath);

                if (imgFile.exists()) {
                    Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                    holder.carImageView.setImageBitmap(bitmap); // Set ảnh từ bộ nhớ trong
                } else {
                    // Nếu không tìm thấy ảnh, đặt ảnh mặc định
                    holder.carImageView.setImageResource(R.drawable.vvf3);
                }
            }
        } else {
            holder.carImageView.setImageResource(R.drawable.vvf6); // Ảnh mặc định nếu không có tên ảnh
        }


        holder.deleteButton.setOnClickListener(v -> {
            qlcarList.remove(position);
            notifyItemRemoved(position);
        });

        holder.editButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, Mainsuatt.class);
            intent.putExtra("maxe", qlcar.getMaxe());
            intent.putExtra("tenxe", qlcar.getTenxe());
            intent.putExtra("maloaixe", qlcar.getMaloaixe());
            intent.putExtra("hangxe", qlcar.getHangxe());
            intent.putExtra("bienso", qlcar.getBienso());
            intent.putExtra("hinhanh", qlcar.getHinhanh());
            intent.putExtra("gia", qlcar.getGia());
            intent.putExtra("trangthai", qlcar.getTrangthai());
            intent.putExtra("soghe", qlcar.getSoghe());
            intent.putExtra("kieuso", qlcar.getKieuso());
            intent.putExtra("dongco", qlcar.getDongco());
            intent.putExtra("copxe", qlcar.getCopxe());
            intent.putExtra("tocdo", qlcar.getTocdo());
            intent.putExtra("tuikhi", qlcar.getTuikhi());
            intent.putExtra("mota", qlcar.getMota());
            intent.putExtra("anh1", qlcar.getAnh1());
            intent.putExtra("anh2", qlcar.getAnh2());
            intent.putExtra("anh3", qlcar.getAnh3());
            context.startActivity(intent);
        });
        holder.deleteButton.setOnClickListener(v -> {
            // Lấy mã xe (maxe) mà bạn muốn xóa, có thể từ một item trong danh sách
            String maxe = qlcar.getMaxe(); // Lấy mã xe từ đối tượng xe tương ứng

            // Tạo AlertDialog để xác nhận hành động xóa
            new AlertDialog.Builder(v.getContext())
                    .setTitle("Xác nhận xóa")
                    .setMessage("Bạn có chắc chắn muốn xóa xe này không?")
                    .setPositiveButton("Có", (dialog, which) -> {
                        // Nếu chọn "Có", gọi hàm deleteXe để xóa xe
                        boolean isDeleted = dbHelper.deleteXe(maxe);

                        if (isDeleted) {
                            // Hiển thị thông báo thành công
                            Toast.makeText(v.getContext(), "Xe đã được xóa thành công!", Toast.LENGTH_SHORT).show();
                        } else {
                            // Hiển thị thông báo nếu xóa thất bại
                            Toast.makeText(v.getContext(), "Xóa xe thất bại!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Không", (dialog, which) -> {
                        // Nếu chọn "Không", chỉ cần đóng dialog mà không làm gì thêm
                        dialog.dismiss();
                    })
                    .show();
        });

    }

    public static class QlCarViewHolder extends RecyclerView.ViewHolder {
        TextView modelTextView, priceTextView, typeTextView, rangeTextView, seatsTextView, capacityTextView;
        ImageView carImageView;
        ImageButton deleteButton, editButton;

        public QlCarViewHolder(View itemView) {
            super(itemView);
            modelTextView = itemView.findViewById(R.id.modelTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            typeTextView = itemView.findViewById(R.id.typeTextView);
            rangeTextView = itemView.findViewById(R.id.rangeTextView);
            seatsTextView = itemView.findViewById(R.id.seatsTextView);
            capacityTextView = itemView.findViewById(R.id.capacityTextView);
            carImageView = itemView.findViewById(R.id.carImageView);
            deleteButton = itemView.findViewById(R.id.btxoa);
            editButton = itemView.findViewById(R.id.btsua);
        }
    }

    public void updateXe(QLcar qlcar, String tenxe, String maloai, String hangxe, String bienso, String hinhanh, String gia, String trangthai, String soghe, String kieuso, String dongco, String copxe, String tocdo, String tuikhi, String mota, String anh1, String anh2, String anh3) {
        dbHelper.updateXe(qlcar.getMaxe(), tenxe, maloai, hangxe, bienso, hinhanh, gia, trangthai, soghe, kieuso, dongco, copxe, tocdo, tuikhi, mota, anh1, anh2, anh3);
    }
}