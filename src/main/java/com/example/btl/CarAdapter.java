package com.example.btl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private List<Car> carList;
    private Context context;
    private OnItemClickListener listener;

    public CarAdapter(Context context, List<Car> carList) {
        this.context = context;
        this.carList = carList;
    }

    // Giao diện cho sự kiện click
    public interface OnItemClickListener {
        void onItemClick(Car car);
    }

    // Thiết lập lắng nghe sự kiện click
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.modelTextView.setText(car.getModel());
        holder.priceTextView.setText(car.getPrice());
        holder.typeTextView.setText(car.getType());
        holder.rangeTextView.setText(car.getRange());
        holder.seatsTextView.setText(car.getSeats());
        holder.capacityTextView.setText(car.getCapacity());

        String imageName = car.getImageResId();  // Lấy tên tệp ảnh từ cơ sở dữ liệu
        if (imageName != null && !imageName.isEmpty()) {
            int imageResId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
            if (imageResId != 0) {
                holder.carImageView.setImageResource(imageResId);
            } else {
                // Nếu không tìm thấy, có thể hiển thị ảnh mặc định
                holder.carImageView.setImageResource(R.drawable.vvf3);  // ảnh mặc định
            }
        } else {
            // Nếu imageName không hợp lệ, hiển thị ảnh mặc định
            holder.carImageView.setImageResource(R.drawable.vvf6);  // ảnh mặc định
        }

        // Thiết lập sự kiện click cho item
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(car);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder {

        ImageView carImageView;
        TextView modelTextView, priceTextView, typeTextView, rangeTextView, seatsTextView, capacityTextView;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            carImageView = itemView.findViewById(R.id.carImageView);
            modelTextView = itemView.findViewById(R.id.modelTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            typeTextView = itemView.findViewById(R.id.typeTextView);
            rangeTextView = itemView.findViewById(R.id.rangeTextView);
            seatsTextView = itemView.findViewById(R.id.seatsTextView);
            capacityTextView = itemView.findViewById(R.id.capacityTextView);
        }
    }
}
