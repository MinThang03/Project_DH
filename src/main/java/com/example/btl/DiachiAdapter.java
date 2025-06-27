package com.example.btl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DiachiAdapter extends RecyclerView.Adapter<DiachiAdapter.DiachiViewHolder> {

    private List<classDiachi> diachiList;

    // Constructor
    public DiachiAdapter(List<classDiachi> diachiList) {
        this.diachiList = diachiList;
    }

    @Override
    public DiachiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate item layout for each item in the list
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diachi, parent, false);
        return new DiachiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DiachiViewHolder holder, int position) {
        // Bind the data to the views
        classDiachi classDiachi = diachiList.get(position);
        holder.tinh.setText(classDiachi.getTinh());
        holder.phuong.setText(classDiachi.getPhuong());
    }

    @Override
    public int getItemCount() {
        return diachiList.size();
    }

    // ViewHolder class
    public static class DiachiViewHolder extends RecyclerView.ViewHolder {
        TextView tinh, phuong;

        public DiachiViewHolder(View itemView) {
            super(itemView);
            tinh = itemView.findViewById(R.id.tinh);
            phuong = itemView.findViewById(R.id.phuong);
        }
    }
}
