package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbAdapter {

    private static final String DATABASE_NAME = "Store.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Products";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_QUANTITY = "quantity";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_UNIT = "unit";

    private SQLiteDatabase db;

    public MyDbAdapter(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    // Add product
    public long addProduct(String name, int quantity, double price, String unit) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_QUANTITY, quantity);
        values.put(COLUMN_PRICE, price);
        values.put(COLUMN_UNIT, unit);
        return db.insert(TABLE_NAME, null, values);
    }

    // Update product
    public int updateProduct(int id, String name, int quantity, double price, String unit) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_QUANTITY, quantity);
        values.put(COLUMN_PRICE, price);
        values.put(COLUMN_UNIT, unit);
        return db.update(TABLE_NAME, values, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
    }

    // Delete product
    public int deleteProduct(int id) {
        return db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
    }

    // Get all products
    public Cursor getAllProducts() {
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }

    // Helper class
    private static class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_QUANTITY + " INTEGER, " +
                    COLUMN_PRICE + " REAL, " +
                    COLUMN_UNIT + " TEXT)");

            // Thêm 3 sản phẩm mẫu
            db.execSQL("INSERT INTO " + TABLE_NAME + " (name, quantity, price, unit) VALUES " +
                    "('Bàn phím', 100, 5000, 'cái'), " +
                    "('Chuột', 50, 15000, 'cái'), " +
                    "('Tai nghe', 200, 2000, 'Cái')");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}
