package com.example.btl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "QLTX.sqlite"; // tên tệp của bạn
    private static final int DATABASE_VERSION = 1;
    private static String DATABASE_PATH = "";
    private final Context context;
    private SQLiteDatabase database;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        DATABASE_PATH = context.getApplicationInfo().dataDir + "/databases/";
    }

    public void createDatabase() {
        try {
            // Kiểm tra xem cơ sở dữ liệu đã tồn tại trên thiết bị chưa
            if (!checkDatabaseExists()) {
                this.getReadableDatabase();
                copyDatabase();
            } else {
                // Nếu cơ sở dữ liệu đã tồn tại, xóa nó đi và sao chép lại
                String path = DATABASE_PATH + DATABASE_NAME;
                File dbFile = new File(path);
                if (dbFile.exists()) {
                    dbFile.delete(); // Xóa cơ sở dữ liệu cũ
                }
                copyDatabase(); // Sao chép cơ sở dữ liệu mới
            }
        } catch (Exception e) {
            Log.e("DatabaseHelper", "Error creating database", e);
        }
    }


    private boolean checkDatabaseExists() {
        SQLiteDatabase checkDB = null;
        try {
            String path = DATABASE_PATH + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (Exception e) {
            Log.e("DatabaseHelper", "Database not found", e);
        } finally {
            if (checkDB != null) {
                checkDB.close();
            }
        }
        return checkDB != null;
    }

    private void copyDatabase() {
        try {
            InputStream input = context.getAssets().open(DATABASE_NAME);
            String outputFileName = DATABASE_PATH + DATABASE_NAME;
            OutputStream output = new FileOutputStream(outputFileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }

            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {
            Log.e("DatabaseHelper", "Error copying database", e);
        }
    }

    public SQLiteDatabase openDatabase() throws IOException {
        String path = DATABASE_PATH + DATABASE_NAME;
        if (database == null || !database.isOpen()) {
            // Sau khi đăng ký thành công, không sao chép mà trực tiếp mở cơ sở dữ liệu
            if (!checkDatabaseExists()) {
                createDatabase(); // Nếu cơ sở dữ liệu chưa tồn tại, sao chép
            }
            database = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        }
        return database;
    }

    @Override
    public synchronized void close() {
        if (database != null) {
            database.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Không cần làm gì nếu cơ sở dữ liệu đã được tạo sẵn.
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Thêm xử lý nâng cấp cơ sở dữ liệu nếu cần.
    }

    public Cursor getData(String query) {
        return database.rawQuery(query, null);
    }

    // Phương thức kiểm tra xem tên tài khoản đã tồn tại hay chưa
    public boolean checkUsernameExists(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM khachhang WHERE Tentk = ?", new String[]{username});

        if (cursor != null && cursor.getCount() > 0) {
            cursor.close();
            return true; // Nếu tìm thấy tên tài khoản, trả về true
        } else {
            cursor.close();
            return false; // Nếu không tìm thấy tên tài khoản, trả về false
        }
    }

    // Phương thức thêm người dùng vào cơ sở dữ liệu
    public boolean insertUser(String namekh, String username, String phone, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Kiểm tra nếu tên tài khoản đã tồn tại
        if (checkUsernameExists(username)) {
            return false; // Nếu tài khoản đã tồn tại, trả về false
        }

        // Nếu tên tài khoản chưa tồn tại, tiếp tục thêm người dùng
        ContentValues contentValues = new ContentValues();
        contentValues.put("Tenkh", namekh);    // Tên khách hàng
        contentValues.put("Tentk", username);  // Tên tài khoản
        contentValues.put("Sdt", phone);       // Số điện thoại
        contentValues.put("Mk", password);     // Mật khẩu

        // Chèn dữ liệu vào bảng khachhang
        long result = db.insert("khachhang", null, contentValues);
        db.close();

        // Đảm bảo cơ sở dữ liệu được cập nhật
        if (result != -1) {
            return true; // Trả về true nếu thêm thành công
        } else {
            return false; // Trả về false nếu có lỗi
        }
    }
    public List<Car> getCarList() {
        List<Car> cars = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Truy vấn bảng "Xe" và lấy dữ liệu
        Cursor cursor = db.rawQuery(
                "SELECT Xe.Tenxe, Thongtinxe.Soghe, Thongtinxe.Copxe, Thongtinxe.Dongco, Xe.Gia, Loaixe.Tenloaixe, Xe.Hinhanh " +
                        "FROM Xe " +
                        "JOIN Thongtinxe ON Xe.Maxe = Thongtinxe.Maxe " +
                        "JOIN Loaixe ON Xe.Maloaixe = Loaixe.Maloaixe " +
                        "WHERE Xe.Trangthai = 0", // Thêm điều kiện Xe.Trangthai = 0
                null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int modelIndex = cursor.getColumnIndex("Tenxe");
                int priceIndex = cursor.getColumnIndex("Gia");
                int typeIndex = cursor.getColumnIndex("Tenloaixe");
                int rangeIndex = cursor.getColumnIndex("Dongco");
                int seatsIndex = cursor.getColumnIndex("Soghe");
                int capacityIndex = cursor.getColumnIndex("Copxe");
                int imageIndex = cursor.getColumnIndex("Hinhanh");

                if (modelIndex != -1 && priceIndex != -1 && typeIndex != -1 && imageIndex != -1) {
                    String model = cursor.getString(modelIndex);
                    int priceValue = cursor.getInt(priceIndex);
                    String price = "Chỉ từ "+NumberFormat.getNumberInstance(Locale.GERMANY).format(priceValue)+" VNĐ/Ngày";
                    String type = cursor.getString(typeIndex);
                    String range = cursor.getString(rangeIndex); // Thêm dữ liệu này nếu cần từ bảng khác hoặc tính toán
                    String seats = cursor.getString(seatsIndex) + " Chỗ"; // Cập nhật tùy thuộc vào thông tin của bạn
                    String capacity = cursor.getString(capacityIndex); // Cập nhật tùy thuộc vào thông tin của bạn
                    String imageResId = cursor.getString(imageIndex); // Lấy tên ảnh từ database (không có đuôi .jpg)

                    // Tạo đối tượng Car và thêm vào danh sách
                    cars.add(new Car(model, price, type, range, seats, capacity, imageResId));
                }
            }
            cursor.close();
        }

        db.close();
        return cars;
    }
    public Cursor getThongTinXeByTenXe(String tenXe) {
        SQLiteDatabase db = this.getReadableDatabase();
        // Truy vấn dữ liệu bao gồm cả Tenloaixe từ bảng Loaixe
        return db.rawQuery(
                "SELECT Thongtinxe.Soghe, Thongtinxe.Kieuso, Thongtinxe.Dongco, Thongtinxe.Copxe, Thongtinxe.Anh1, Thongtinxe.Anh2, Thongtinxe.Anh3, " +
                        "Thongtinxe.Tocdo, Thongtinxe.Tuikhi, Thongtinxe.Mota, Xe.Tenxe, Xe.Gia, Loaixe.Tenloaixe " +
                        "FROM Xe " +
                        "JOIN Thongtinxe ON Xe.Maxe = Thongtinxe.Maxe " +
                        "JOIN Loaixe ON Xe.Maloaixe = Loaixe.Maloaixe " +
                        "WHERE Xe.Tenxe = ?",
                new String[] { tenXe }
        );
    }
    public boolean addThuexe(String hotenthue, String sdtthue, String emailthue, String ghichu, String hinhthuc, String diachinhanxe, String timenhan, String timetra, String phuongthuctt, int tongtien, String carName, String makh) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Tìm ID của xe trong bảng Xe
        Cursor cursor = db.rawQuery("SELECT Maxe FROM Xe WHERE Tenxe = ?", new String[]{carName});

        // Kiểm tra nếu không tìm thấy xe
        if (cursor != null && cursor.moveToFirst()) {
            int maxe = cursor.getInt(cursor.getColumnIndexOrThrow("Maxe"));
            cursor.close();

            // Thực hiện câu lệnh INSERT vào bảng Thuexe
            ContentValues values = new ContentValues();
            values.put("Maxe", maxe);  // ID của xe
            values.put("Makh", makh);
            values.put("Hotenthue", hotenthue);  // Tên người thuê
            values.put("Sdtthue", sdtthue);  // Số điện thoại người thuê
            values.put("Emailthue", emailthue);  // Email người thuê
            values.put("Ghichu", ghichu);  // Ghi chú
            values.put("Hinhthucthue", hinhthuc);  // Hình thức thuê
            values.put("Diachinhanxe", diachinhanxe);  // Địa chỉ nhận xe
            values.put("Timenhan", timenhan);  // Thời gian nhận xe
            values.put("Timetra", timetra);  // Thời gian trả xe
            values.put("PhuongthucTT", phuongthuctt);  // Phương thức thanh toán
            values.put("Tongtien", tongtien);
            values.put("Tinhtrang", "Chưa xử lý");// Tổng tiền

            // Thực thi câu lệnh INSERT và kiểm tra kết quả
            long result = db.insert("Thuexe", null, values);
            // Nếu insert thành công, tiến hành cập nhật trạng thái của xe trong bảng Xe
            if (result != -1) {
                ContentValues updateValues = new ContentValues();
                updateValues.put("Trangthai", 1); // Cập nhật trạng thái thành 1 (xe đã có người thuê)
                db.update("Xe", updateValues, "Maxe = ?", new String[]{String.valueOf(maxe)});
            }
            db.close();  // Đóng kết nối sau khi thực hiện

            // Kiểm tra nếu insert thành công, trả về true, ngược lại trả về false
            return result != -1;
        } else {
            // Nếu không tìm thấy xe, đóng cursor và trả về false
            if (cursor != null) {
                cursor.close();
            }
            return false;
        }
    }
    public List<myCar> getMyCars(String makh) {
        List<myCar> myCarList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query để lấy thông tin từ bảng Thuexe và Xe với điều kiện makh
        String query = "SELECT Thuexe.Maxe, Xe.Tenxe, Thuexe.Tinhtrang, Xe.Hinhanh " +
                "FROM Thuexe " +
                "INNER JOIN Xe ON Thuexe.Maxe = Xe.Maxe " +
                "WHERE Thuexe.Makh = ?";

        // Thực thi truy vấn với makh là tham số
        Cursor cursor = db.rawQuery(query, new String[]{makh});

        if (cursor != null) {
            int maXeColumnIndex = cursor.getColumnIndex("Maxe");
            int tenXeColumnIndex = cursor.getColumnIndex("Tenxe");
            int trangThaiColumnIndex = cursor.getColumnIndex("Tinhtrang");
            int hinhAnhColumnIndex = cursor.getColumnIndex("Hinhanh");

            while (cursor.moveToNext()) {
                // Truy cập dữ liệu từ các cột đã xác định
                String madon = cursor.getString(maXeColumnIndex); // Mã đơn (MaXe)
                String tenxe = cursor.getString(tenXeColumnIndex); // Tên xe (TenXe)
                String tinhtrang = cursor.getString(trangThaiColumnIndex); // Trạng thái (TrangThai)
                String anhxe = cursor.getString(hinhAnhColumnIndex); // Hình ảnh (HinhAnh)

                // Tạo đối tượng myCar từ dữ liệu lấy được
                myCar car = new myCar(tenxe, madon, tinhtrang, anhxe);
                myCarList.add(car);
            }
            cursor.close();
        }

        db.close();
        return myCarList;
    }
    public Cursor getThuexe(String mathue) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT Thuexe.*, Xe.Gia, Xe.Tenxe, Xe.Bienso " +
                "FROM Thuexe " +
                "JOIN Xe ON Thuexe.Maxe = Xe.Maxe " +
                "WHERE Thuexe.Mathuexe = ?";
        return db.rawQuery(query, new String[]{mathue});
    }
    // Phương thức xóa tài khoản theo mã khách hàng
    public boolean deleteUserById(String makh) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Kiểm tra xem khách hàng có tồn tại trong cơ sở dữ liệu không
        Cursor cursor = db.rawQuery("SELECT * FROM khachhang WHERE Makh = ?", new String[]{makh});

        if (cursor != null && cursor.moveToFirst()) {
            cursor.close();

            // Xóa thông tin trong bảng Thuexe (nếu có liên quan)
            db.delete("Thuexe", "Makh = ?", new String[]{makh});

            // Xóa thông tin trong bảng khachhang
            int result = db.delete("khachhang", "Makh = ?", new String[]{makh});
            db.close();

            // Kiểm tra kết quả xóa
            return result > 0;  // Nếu xóa thành công, trả về true
        } else {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
            return false;  // Nếu không tìm thấy khách hàng, trả về false
        }
    }


}


