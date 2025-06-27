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

public class myCarAdapter extends RecyclerView.Adapter<myCarAdapter.MyCarViewHolder> {

    private Context context;
    private List<myCar> myCarList;
    private OnItemClickListener listener;

    // Interface để xử lý sự kiện click
    public interface OnItemClickListener {
        void onItemClick(myCar car);
    }

    // Constructor có thêm tham số listener
    public myCarAdapter(Context context, List<myCar> myCarList, OnItemClickListener listener) {
        this.context = context;
        this.myCarList = myCarList;
        this.listener = listener;
    }

    @Override
    public MyCarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.xecuatoi, parent, false);
        return new MyCarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyCarViewHolder holder, int position) {
        myCar car = myCarList.get(position);

        // Set data for car details
        holder.tenxe.setText(car.getTenxe());
        holder.madon.setText(car.getMadon());
        holder.tinhtrang.setText(car.getTinhtrang());

        String imageName = car.getAnhxe();
        if (imageName != null && !imageName.isEmpty()) {
            int imageResId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
            holder.anhxe.setImageResource(imageResId != 0 ? imageResId : R.drawable.vvf3);
        } else {
            holder.anhxe.setImageResource(R.drawable.vvf6);
        }

        // Xử lý sự kiện click
        holder.itemView.setOnClickListener(v -> listener.onItemClick(car));
    }

    @Override
    public int getItemCount() {
        return myCarList.size();
    }

    public static class MyCarViewHolder extends RecyclerView.ViewHolder {
        TextView tenxe, madon, tinhtrang;
        ImageView anhxe;

        public MyCarViewHolder(View itemView) {
            super(itemView);
            // Link the views
            tenxe = itemView.findViewById(R.id.tenxe);
            madon = itemView.findViewById(R.id.madon);
            tinhtrang = itemView.findViewById(R.id.tinhtrang);
            anhxe = itemView.findViewById(R.id.anhxe);
        }
    }
}
