package com.example.btl;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Mainxacnhan extends AppCompatActivity {

    private TextView diachi, tgthue, hinhthuc, namexe, gia, total;
    private Spinner TTSpinner;
    private long diffInDays;
    private EditText Ten, sdt, email, noinhanxe, ghichu;
    private CheckBox cbdk, cbdy;
    private Button btthanhtoan;
    private String makh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xacnhan);

        // Tìm button btthoat
        ImageView btthoat = findViewById(R.id.btthoat);

        // Thiết lập sự kiện khi nhấn button thoát
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Maindoimk và quay về Activity trước đó
            }
        });

        btthanhtoan = findViewById(R.id.btthanhtoan);
        Ten = findViewById(R.id.nhapten);
        sdt = findViewById(R.id.nhapsdt);
        email = findViewById(R.id.nhapemail);
        noinhanxe = findViewById(R.id.nhapnoinhan);
        ghichu = findViewById(R.id.nhapghichu);
        cbdk = findViewById(R.id.cbdieukhoan);
        cbdy = findViewById(R.id.cbdongy);
        gia = findViewById(R.id.tienphithue);
        total = findViewById(R.id.tong);
        diachi = findViewById(R.id.dcxe);
        tgthue = findViewById(R.id.tgthue);
        namexe = findViewById(R.id.carName);
        hinhthuc = findViewById(R.id.hinhthuc);
        TTSpinner = findViewById(R.id.spinner_tt);

        // Nhận dữ liệu từ Intent
        String date1t = getIntent().getStringExtra("date1");
        String date2t = getIntent().getStringExtra("date2");
        String time1t = getIntent().getStringExtra("time1");
        String time2t = getIntent().getStringExtra("time2");
        String location = getIntent().getStringExtra("location");
        String rentalType = getIntent().getStringExtra("rentalType");
        makh = getIntent().getStringExtra("makh");
        String namxe = getIntent().getStringExtra("car_name");
        String anhxe = getIntent().getStringExtra("anh");
        int priceValue = getIntent().getIntExtra("gia", 0);
        Toast.makeText(Mainxacnhan.this, makh, Toast.LENGTH_SHORT).show();

        gia.setText(NumberFormat.getNumberInstance(Locale.GERMANY).format(priceValue) + " VNĐ/ngày");
        diachi.setText(location.trim());
        hinhthuc.setText("Hình thức thuê: " + rentalType.trim());
        namexe.setText(namxe.trim());
        int imageResId = getResources().getIdentifier(anhxe, "drawable", getPackageName());
        ImageView carImage = findViewById(R.id.carImage);
        carImage.setImageResource(imageResId);

        String[] locations = {"Thanh toán khi nhận xe", "Chuyển khoản ngân hàng", "Quét mã QR code"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Mainxacnhan.this, android.R.layout.simple_spinner_item, locations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        TTSpinner.setAdapter(adapter);

        // Tính toán thời gian thuê
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm, dd/MM/yyyy");
        try {
            // Kết hợp thời gian và ngày để tạo thành chuỗi đầy đủ
            Date startDate = dateFormat.parse(time1t + ", " + date1t);
            Date endDate = dateFormat.parse(time2t + ", " + date2t);

            // Tính số ngày giữa startDate và endDate
            long diffInMillis = endDate.getTime() - startDate.getTime();
            diffInDays = TimeUnit.MILLISECONDS.toDays(diffInMillis) + 1; // Cộng 1 để tính cả ngày đầu và cuối

            // Định dạng chuỗi kết quả cho tgthue
            String tgthueText = diffInDays + " ngày\n" + time1t + ", " + date1t + " -> " + time2t + ", " + date2t;
            tgthue.setText(tgthueText);

        } catch (ParseException e) {
            e.printStackTrace();
            tgthue.setText("Lỗi định dạng ngày giờ.");
        }

        int tong = (int) (priceValue * diffInDays)+10050000;
        total.setText(NumberFormat.getNumberInstance(Locale.GERMANY).format(tong) + " VNĐ");

        // Kiểm tra điều kiện
        checkConditions();

        // Thêm sự kiện khi có thay đổi trong các EditText và CheckBox
        Ten.addTextChangedListener(textWatcher);
        sdt.addTextChangedListener(textWatcher);
        email.addTextChangedListener(textWatcher);
        noinhanxe.addTextChangedListener(textWatcher);
        ghichu.addTextChangedListener(textWatcher);
        cbdk.setOnCheckedChangeListener((buttonView, isChecked) -> checkConditions());
        cbdy.setOnCheckedChangeListener((buttonView, isChecked) -> checkConditions());

        btthanhtoan.setOnClickListener(v -> {
            // Lấy các giá trị
            String hotenthue = Ten.getText().toString().trim();
            String sdtthue = sdt.getText().toString().trim();
            String emailthue = email.getText().toString().trim();
            String ghichuText = ghichu.getText().toString().trim();
            String diachiNhan = noinhanxe.getText().toString().trim();
            String ht = rentalType.trim();
            // Kết hợp thời gian và ngày để tạo thành thời gian nhận và trả xe
            String timeNhan = time1t.toString() + ", " + date1t.toString(); // Thời gian nhận xe
            String timeTra = time2t.toString() + ", " + date2t.toString();  // Thời gian trả xe
            String selectedLocation = TTSpinner.getSelectedItem().toString();
            String tenxe = namexe.getText().toString().trim();


            DatabaseHelper dbHelper = new DatabaseHelper(Mainxacnhan.this);
            boolean isSuccess = dbHelper.addThuexe(hotenthue,sdtthue,emailthue,ghichuText,ht,diachiNhan,timeNhan,timeTra,selectedLocation,tong,tenxe,makh);

            if (isSuccess) {
                // Chuyển sang màn hình tiếp theo nếu thêm thành công
                Intent intent = new Intent(Mainxacnhan.this, Mainchucmung.class);
                startActivity(intent);
            } else {
                // Hiển thị thông báo lỗi nếu thêm thất bại
                Toast.makeText(Mainxacnhan.this, "Thêm dữ liệu thất bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Khai báo TextWatcher
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            // Có thể không cần xử lý ở đây
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            // Có thể không cần xử lý ở đây
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // Kiểm tra điều kiện sau khi văn bản thay đổi
            checkConditions();
        }
    };

    private void checkConditions() {
        // Kiểm tra các điều kiện và bật/tắt nút thanh toán
        boolean isFormValid = !Ten.getText().toString().isEmpty() &&
                !sdt.getText().toString().isEmpty() &&
                !email.getText().toString().isEmpty() &&
                !noinhanxe.getText().toString().isEmpty() &&
                !ghichu.getText().toString().isEmpty() &&
                cbdk.isChecked() && cbdy.isChecked();

        btthanhtoan.setEnabled(isFormValid);
    }
}
