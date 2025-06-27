package com.example.btl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Maindoimk extends AppCompatActivity {

    private EditText mkcu, mkmoi, mkmoi2;
    private Button capnhat;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doimk);

        mkcu = findViewById(R.id.mk);
        mkmoi = findViewById(R.id.mkmoi);
        mkmoi2 = findViewById(R.id.xacnhanmk);
        capnhat = findViewById(R.id.btcapnhat);
        ImageButton btthoat = findViewById(R.id.btthoat);

        dbHelper = new DatabaseHelper(this); // Initialize DatabaseHelper

        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String makh = getIntent().getStringExtra("khach");

        capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPassword = mkcu.getText().toString();
                String newPassword = mkmoi.getText().toString();
                String confirmPassword = mkmoi2.getText().toString();

                // Check if new password and confirmation match
                if (!newPassword.equals(confirmPassword)) {
                    Toast.makeText(Maindoimk.this, "Mật khẩu mới không khớp", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Call updatePassword in DatabaseHelper
                boolean updated = dbHelper.updatePassword(makh, oldPassword, newPassword);
                if (updated) {
                    Toast.makeText(Maindoimk.this, "Bạn đã thay đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                    mkcu.setText("");
                    mkmoi.setText("");
                    mkmoi2.setText("");
                } else {
                    Toast.makeText(Maindoimk.this, "Mật khẩu cũ không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
