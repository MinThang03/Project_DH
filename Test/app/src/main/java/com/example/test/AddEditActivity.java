package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddEditActivity extends AppCompatActivity {

    private EditText etName, etQuantity, etPrice, etUnit;
    private MyDbAdapter dbAdapter;
    private int productId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        etName = findViewById(R.id.etName);
        etQuantity = findViewById(R.id.etQuantity);
        etPrice = findViewById(R.id.etPrice);
        etUnit = findViewById(R.id.etUnit);
        dbAdapter = new MyDbAdapter(this);

        productId = getIntent().getIntExtra("id", -1);
        if (productId != -1) {
            loadProduct();
        }
    }

    private void loadProduct() {
        // TODO: Load product details by ID if editing.
    }

    public void onSave(View view) {
        String name = etName.getText().toString();
        int quantity = Integer.parseInt(etQuantity.getText().toString());
        double price = Double.parseDouble(etPrice.getText().toString());
        String unit = etUnit.getText().toString();

        if (productId == -1) {
            dbAdapter.addProduct(name, quantity, price, unit);
            Toast.makeText(this, "Hàng hóa đã được thêm!", Toast.LENGTH_SHORT).show();
        } else {
            dbAdapter.updateProduct(productId, name, quantity, price, unit);
            Toast.makeText(this, "Hàng hóa đã được cập nhật!", Toast.LENGTH_SHORT).show();
        }

        finish();
    }
}
