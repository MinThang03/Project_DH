package com.example.btl;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Thongke extends Fragment {

    private Spinner tgian;
    private BarChart barChart;
    private Button btdoanhthu, btsoluongdatxe, btsoluongxetrongkho;

    public Thongke() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.thongke, container, false);

        // Khởi tạo BarChart
        barChart = view.findViewById(R.id.barChart);
        setupBarChart();

        // Initialize UI components
        tgian = view.findViewById(R.id.tgian);
        btdoanhthu = view.findViewById(R.id.btdt);
        btsoluongdatxe = view.findViewById(R.id.btslxedat);
        btsoluongxetrongkho = view.findViewById(R.id.btxetrongkho);

        // Set up button listeners
        btdoanhthu.setOnClickListener(v -> getStatistics("doanhthu"));
        btsoluongdatxe.setOnClickListener(v -> getStatistics("soluongdatxe"));
        btsoluongxetrongkho.setOnClickListener(v -> getStockStatistics());

        return view;
    }

    // Thiết lập BarChart
    private void setupBarChart() {
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        try {
            dbHelper.openDatabase(); // Mở cơ sở dữ liệu trước khi sử dụng
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Thongke", "Error opening database", e);
            return; // Dừng nếu không mở được
        }

        Cursor cursor = dbHelper.getVehicleCountByType();
        if (cursor != null && cursor.getCount() > 0) {
            ArrayList<BarEntry> barEntries = new ArrayList<>();

            // Lấy chỉ số cột cho Maloaixe và SoLuong
            int maloaixeIndex = cursor.getColumnIndex("Maloaixe");
            int soluongIndex = cursor.getColumnIndex("SoLuong");

            // Kiểm tra xem các chỉ số cột có hợp lệ không
            if (maloaixeIndex == -1 || soluongIndex == -1) {
                Log.e("Thongke", "Column indices are invalid");
                cursor.close(); // Đảm bảo đóng cursor nếu gặp lỗi
                return;
            }

            while (cursor.moveToNext()) {
                int maloaixe = cursor.getInt(maloaixeIndex);
                int count = cursor.getInt(soluongIndex);
                barEntries.add(new BarEntry(maloaixe, count));
            }

            cursor.close(); // Đảm bảo đóng cursor sau khi sử dụng

            // Thiết lập dữ liệu cho BarChart
            BarDataSet barDataSet = new BarDataSet(barEntries, "Số lượng xe theo loại");
            barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
            BarData barData = new BarData(barDataSet);
            barChart.setData(barData);

            // Thiết lập trục X và Y như trước
            XAxis xAxis = barChart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setGranularity(1f);
            xAxis.setLabelCount(barEntries.size());
            xAxis.setValueFormatter(new ValueFormatter() {
                @Override
                public String getFormattedValue(float value) {
                    if(value == 1){
                        return "Sedan";
                    }else if ( value == 2 ){
                        return "CUV";
                    }else if ( value == 3 ){
                        return "SUV";
                    }else if ( value == 4 ){
                        return "Coupe";
                    }else{
                        return "Bán Tải";
                    }

                }
            });

            YAxis leftAxis = barChart.getAxisLeft();
            YAxis rightAxis = barChart.getAxisRight();
            rightAxis.setEnabled(false);
            leftAxis.setAxisMinimum(0);

            barChart.getDescription().setEnabled(false);
            barChart.setDrawGridBackground(false);
            barChart.animateY(1000);

            barChart.invalidate(); // Cập nhật biểu đồ
        } else {
            Log.e("Thongke", "Cursor is null or empty.");
        }
    }

    // Phương thức thống kê theo lựa chọn
    private void getStatistics(String type) {
        String selectedTime = tgian.getSelectedItem().toString();
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());

        Cursor cursor = null;

        switch (selectedTime) {
            case "Hôm nay":
                String today = getCurrentDate(); // Lấy ngày hôm nay
                cursor = (type.equals("doanhthu")) ? dbHelper.getRevenueByDate(today) : dbHelper.getVehicleCountByDate(today);
                break;
            case "Tuần":
                String[] weekDates = getWeekStartEndDates(); // Lấy ngày bắt đầu và kết thúc tuần
                cursor = (type.equals("doanhthu")) ? dbHelper.getRevenueByWeek(weekDates[0], weekDates[1]) : dbHelper.getVehicleCountByWeek(weekDates[0], weekDates[1]);
                break;
            case "Tháng":
                String[] monthDates = getMonthStartEndDates(); // Lấy ngày bắt đầu và kết thúc tháng
                cursor = (type.equals("doanhthu")) ? dbHelper.getRevenueByMonth(monthDates[0], monthDates[1]) : dbHelper.getVehicleCountByMonth(monthDates[0], monthDates[1]);
                break;
            case "Năm":
                String year = getCurrentYear(); // Lấy năm hiện tại
                cursor = (type.equals("doanhthu")) ? dbHelper.getRevenueByYear(year) : dbHelper.getVehicleCountByYear(year);
                break;
            default:
                Log.e("Thongke", "Invalid time selection");
                return;
        }

        // Xử lý cursor và hiển thị kết quả lên biểu đồ hoặc UI
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            int result = cursor.getInt(0); // Doanh thu hoặc số lượng xe

            if (type.equals("doanhthu")) {
                // Hiển thị doanh thu
                Toast.makeText(getContext(), "Doanh thu: " + NumberFormat.getNumberInstance(Locale.GERMANY).format(result) + " VNĐ", Toast.LENGTH_SHORT).show();
            } else {
                // Hiển thị số lượng xe
                Toast.makeText(getContext(), "Số lượng xe: " + (int) result, Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        } else {
            Toast.makeText(getContext(), "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        }
    }

    // Phương thức lấy số lượng xe trong kho
    private void getStockStatistics() {
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        Cursor cursor = dbHelper.getVehicleCountInStock();

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            int count = cursor.getInt(0);
            // Hiển thị số lượng xe trong kho
            Toast.makeText(getContext(), "Số lượng xe trong kho: " + count, Toast.LENGTH_SHORT).show();
            cursor.close();
        } else {
            Toast.makeText(getContext(), "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        }
    }

    // Các phương thức lấy ngày hôm nay, tuần, tháng, năm
    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(new Date());
    }

    private String[] getWeekStartEndDates() {
        // Tính toán ngày bắt đầu và kết thúc của tuần hiện tại
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date currentDate = new Date();
        // Ví dụ: sử dụng các thư viện hoặc logic tính toán ngày bắt đầu và kết thúc tuần
        return new String[]{sdf.format(currentDate), sdf.format(currentDate)}; // Thay bằng logic tính tuần
    }

    private String[] getMonthStartEndDates() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date currentDate = new Date();
        // Ví dụ: sử dụng các thư viện hoặc logic tính toán ngày bắt đầu và kết thúc tháng
        return new String[]{sdf.format(currentDate), sdf.format(currentDate)}; // Thay bằng logic tính tháng
    }

    private String getCurrentYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy", Locale.getDefault());
        return sdf.format(new Date());
    }
}
