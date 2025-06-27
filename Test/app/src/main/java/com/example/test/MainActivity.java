package com.example.test;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyDbAdapter dbAdapter;
    private ArrayList<String> productList;
    private ArrayAdapter<String> adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbAdapter = new MyDbAdapter(this);
        listView = findViewById(R.id.listView);
        productList = new ArrayList<>();

        loadProducts();

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Cursor cursor = dbAdapter.getAllProducts();
            if (cursor.moveToPosition(position)) {
                int productId = cursor.getInt(cursor.getColumnIndexOrThrow("id"));

                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_product, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(item -> {
                    if (item.getItemId() == R.id.menu_edit) {
                        Intent intent = new Intent(MainActivity.this, AddEditActivity.class);
                        intent.putExtra("id", productId);
                        startActivity(intent);
                    } else if (item.getItemId() == R.id.menu_delete) {
                        dbAdapter.deleteProduct(productId);
                        Toast.makeText(MainActivity.this, "Đã xóa sản phẩm!", Toast.LENGTH_SHORT).show();
                        loadProducts();
                    }
                    return true;
                });

                popupMenu.show();
            }
        });
    }

    private void loadProducts() {
        productList.clear();
        Cursor cursor = dbAdapter.getAllProducts();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                int quantity = cursor.getInt(cursor.getColumnIndexOrThrow("quantity"));
                double price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
                String unit = cursor.getString(cursor.getColumnIndexOrThrow("unit"));

                productList.add("Mã: " + id + ", Tên: " + name +
                        "\nSố lượng: " + quantity + ", Giá: " + price +
                        ", Đơn vị: " + unit);
            } while (cursor.moveToNext());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productList);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadProducts();
    }

    public void onAddProduct(View view) {
        Intent intent = new Intent(this, AddEditActivity.class);
        startActivity(intent);
    }
}
