package com.example.btl;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Home extends Fragment {
    private TabLayout tabLayout;
    private FrameLayout container;
    private Spinner locationSpinner;
    private EditText pickupDateTextView1;
    private EditText pickupTimeTextView1;
    private EditText pickupDateTextView2;
    private EditText pickupTimeTextView2;
    private EditText thueT;
    private Calendar calendar;
    private Button btsearch;
    private TextView tenkhach;
    private String makh;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btsearch = view.findViewById(R.id.button_search);
        pickupDateTextView1 = view.findViewById(R.id.edittext_pickup_date1);
        pickupTimeTextView1 = view.findViewById(R.id.edittext_pickup_time1);
        pickupDateTextView2 = view.findViewById(R.id.edittext_return_date2);
        pickupTimeTextView2 = view.findViewById(R.id.edittext_return_time2);
        calendar = Calendar.getInstance();
        tabLayout = view.findViewById(R.id.TabLayout);
        locationSpinner = view.findViewById(R.id.spinner_location);
        this.container = view.findViewById(R.id.container);

        // Lấy TextView trong layout
        tenkhach = view.findViewById(R.id.Tenkhach);
        // Lấy tên khách hàng từ Bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            String username = bundle.getString("tenkh");
            makh = bundle.getString("makh");
            tenkhach.setText("Xin chào, " + username);  // Hiển thị tên khách hàng
        }

        // Sample data for location spinner
        String[] locations = {"Hà Nội", "Đà Nẵng", "TP Hồ Chí Minh"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, locations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(adapter);

        // Add tabs and set listener
        tabLayout.addTab(tabLayout.newTab().setText("Thuê ngày"));
        tabLayout.addTab(tabLayout.newTab().setText("Thuê tháng"));

        // Set tab selection listener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                loadTabContent(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        // Set onClickListener for date fields for "Thuê ngày"
        pickupDateTextView1.setOnClickListener(v -> showDatePicker(pickupDateTextView1));
        pickupDateTextView2.setOnClickListener(v -> {
            if (tabLayout.getSelectedTabPosition() == 0) {
                showDatePicker(pickupDateTextView2);
            }
        });

        // Set onClickListener for time fields
        pickupTimeTextView1.setOnClickListener(v -> showTimePicker(pickupTimeTextView1));
        pickupTimeTextView2.setOnClickListener(v -> {
            if (tabLayout.getSelectedTabPosition() == 0) {
                showTimePicker(pickupTimeTextView2);
            }
        });

        // Xử lý sự kiện khi bấm vào nút Tìm kiếm
        btsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pickupDateTextView1.getText().toString().isEmpty() ||
                        pickupDateTextView2.getText().toString().isEmpty() ||
                        pickupTimeTextView1.getText().toString().isEmpty() ||
                        pickupTimeTextView2.getText().toString().isEmpty()) {

                    Toast.makeText(requireContext(), "Bạn chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    String date1 = pickupDateTextView1.getText().toString();
                    String date2 = pickupDateTextView2.getText().toString();
                    String time1 = pickupTimeTextView1.getText().toString();
                    String time2 = pickupTimeTextView2.getText().toString();
                    String location = locationSpinner.getSelectedItem().toString();
                    String rentalType = tabLayout.getSelectedTabPosition() == 0 ? "Thuê ngày" : "Thuê tháng";

                    String ten = tenkhach.getText().toString().trim();
                    Intent intent = new Intent(requireContext(), Mainkhoxe.class);
                    intent.putExtra("date1", date1);
                    intent.putExtra("date2", date2);
                    intent.putExtra("time1", time1);
                    intent.putExtra("time2", time2);
                    intent.putExtra("location", location);
                    intent.putExtra("rentalType", rentalType);
                    intent.putExtra("rentalType", rentalType);
                    intent.putExtra("makh", makh);
                    startActivity(intent);
                }
            }
        });

        return view;  // Return the inflated view
    }

    private void loadTabContent(int position) {
        container.removeAllViews(); // Clear previous content

        LayoutInflater inflater = LayoutInflater.from(getContext());
        if (position == 0) {
            // "Thuê ngày" - enable both date and time fields for the second entry
            pickupDateTextView2.setEnabled(true);
            pickupTimeTextView2.setEnabled(true);
        } else {
            // "Thuê tháng" - show `thueT` field and disable date and time for the second entry
            View layout1 = inflater.inflate(R.layout.thuethang, container, false);
            thueT = layout1.findViewById(R.id.thangthue);
            thueT.setText("1");  // Default value for "Thuê tháng"
            container.addView(layout1);
            pickupDateTextView2.setEnabled(false);
            pickupTimeTextView2.setEnabled(false);
            pickupTimeTextView2.setText("17:30"); // Default time for "Thuê tháng"
            setDate2BasedOnMonths();

            // Set listener for thueT to auto-update date 2 when changed
            thueT.setOnFocusChangeListener((v, hasFocus) -> {
                if (!hasFocus) {
                    setDate2BasedOnMonths();
                }
            });
        }
    }

    private void setDate2BasedOnMonths() {
        try {
            int monthsToAdd = Integer.parseInt(thueT.getText().toString());
            Calendar calendar2 = (Calendar) calendar.clone();
            calendar2.add(Calendar.MONTH, monthsToAdd);
            String formattedDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(calendar2.getTime());
            pickupDateTextView2.setText(formattedDate);
        } catch (NumberFormatException e) {
            Toast.makeText(requireContext(), "Vui lòng nhập số tháng hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }

    private void showDatePicker(EditText editText) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(),
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    calendar.set(Calendar.YEAR, selectedYear);
                    calendar.set(Calendar.MONTH, selectedMonth);
                    calendar.set(Calendar.DAY_OF_MONTH, selectedDay);
                    updateDateInView(editText);

                    // If "Thuê tháng" tab is selected, auto-update date 2
                    if (tabLayout.getSelectedTabPosition() == 1) {
                        setDate2BasedOnMonths();
                    }
                }, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }

    private void showTimePicker(EditText editText) {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(requireContext(),
                (view, selectedHour, selectedMinute) -> {
                    calendar.set(Calendar.HOUR_OF_DAY, selectedHour);
                    calendar.set(Calendar.MINUTE, selectedMinute);
                    updateTimeInView(editText);
                }, hour, minute, true);
        timePickerDialog.show();
    }

    private void updateDateInView(EditText editText) {
        String myFormat = "dd/MM/yyyy";  // Define the date format
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        editText.setText(sdf.format(calendar.getTime()));  // Set formatted date to the EditText
    }

    private void updateTimeInView(EditText editText) {
        String myFormat = "HH:mm";  // Define the time format
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        editText.setText(sdf.format(calendar.getTime()));  // Set formatted time to the EditText
    }
}
