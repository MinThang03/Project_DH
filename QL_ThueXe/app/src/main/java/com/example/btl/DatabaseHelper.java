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
            // Tạo thư mục nếu chưa tồn tại
            File databaseDir = new File(DATABASE_PATH);
            if (!databaseDir.exists()) {
                databaseDir.mkdirs();
            }

            // Kiểm tra xem cơ sở dữ liệu đã tồn tại trên thiết bị chưa
            if (!checkDatabaseExists()) {
                this.getReadableDatabase();
                this.close();
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
            // Tạo thư mục nếu chưa tồn tại
            File databaseDir = new File(DATABASE_PATH);
            if (!databaseDir.exists()) {
                databaseDir.mkdirs();
            }

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
    // Lấy thống kê số lượng xe theo ngày
    public Cursor getVehicleCountByType() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT Maloaixe, COUNT(*) as SoLuong FROM Xe GROUP BY Maloaixe";
        return getData(query);
    }
    public Cursor getVehicleCountByDate(String date) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) as SoLuong FROM Thuexe WHERE Ngaydat = ?";
        return db.rawQuery(query, new String[]{date});
    }

    // Lấy thống kê doanh thu theo ngày
    public Cursor getRevenueByDate(String date) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT SUM(Tongtien) as DoanhThu FROM Thuexe WHERE Ngaydat = ?";
        return db.rawQuery(query, new String[]{date});
    }

    // Lấy thống kê số lượng xe thuê theo tuần
    public Cursor getVehicleCountByWeek(String weekStart, String weekEnd) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) as SoLuong FROM Thuexe WHERE Ngaydat BETWEEN ? AND ?";
        return db.rawQuery(query, new String[]{weekStart, weekEnd});
    }

    // Lấy thống kê doanh thu theo tuần
    public Cursor getRevenueByWeek(String weekStart, String weekEnd) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT SUM(Tongtien) as DoanhThu FROM Thuexe WHERE Ngaydat BETWEEN ? AND ?";
        return db.rawQuery(query, new String[]{weekStart, weekEnd});
    }

    // Lấy thống kê số lượng xe thuê theo tháng
    public Cursor getVehicleCountByMonth(String monthStart, String monthEnd) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) as SoLuong FROM Thuexe WHERE Ngaydat BETWEEN ? AND ?";
        return db.rawQuery(query, new String[]{monthStart, monthEnd});
    }

    // Lấy thống kê doanh thu theo tháng
    public Cursor getRevenueByMonth(String monthStart, String monthEnd) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT SUM(Tongtien) as DoanhThu FROM Thuexe WHERE Ngaydat BETWEEN ? AND ?";
        return db.rawQuery(query, new String[]{monthStart, monthEnd});
    }

    // Lấy thống kê số lượng xe thuê theo năm
    public Cursor getVehicleCountByYear(String year) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) as SoLuong FROM Thuexe WHERE Ngaydat LIKE ?";
        return db.rawQuery(query, new String[]{year + "%"});
    }

    // Lấy thống kê doanh thu theo năm
    public Cursor getRevenueByYear(String year) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT SUM(Tongtien) as DoanhThu FROM Thuexe WHERE Ngaydat LIKE ?";
        return db.rawQuery(query, new String[]{year + "%"});
    }

    // Lấy số lượng xe trong kho (các xe chưa được thuê)
    public Cursor getVehicleCountInStock() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) as SoLuong FROM Xe WHERE Maxe NOT IN (SELECT Maxe FROM Thuexe)";
        return db.rawQuery(query, null);
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
        contentValues.put("Ngaysinh", " ");
        contentValues.put("Email", " ");
        contentValues.put("Diachi", " ");

        // Chèn dữ liệu vào bảng khachhang và lấy Makh tự động tạo
        long result = db.insert("khachhang", null, contentValues);
        if (result == -1) {
            db.close();
            return false; // Trả về false nếu có lỗi khi chèn vào bảng khachhang
        }

        // Tạo ContentValues mới cho bảng gplx
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("Makh", result);    // Sử dụng result (Makh) từ bảng khachhang
        contentValues2.put("Sogp", " ");       // Số GPLX ban đầu
        contentValues2.put("Hangbang", " ");   // Hạng bằng lái (có thể là " ")
        contentValues2.put("Noidk", " ");      // Nơi đăng ký
        contentValues2.put("Ngayhh", " ");     // Ngày hết hạn

        // Chèn dữ liệu vào bảng gplx
        long resultGPLX = db.insert("gplx", null, contentValues2);

        db.close();

        // Trả về true nếu chèn thành công vào cả 2 bảng
        return result != -1 && resultGPLX != -1;
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
    public List<QLcar> getQLCarList() {
        List<QLcar> cars = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Truy vấn bảng "Xe" và lấy dữ liệu
        Cursor cursor = db.rawQuery(
                "SELECT Xe.Maxe, Xe.Tenxe, Xe.Maloaixe, Xe.Hangxe, Xe.Bienso, Xe.Hinhanh, Xe.Gia, Xe.TrangThai, Thongtinxe.Soghe, Thongtinxe.Kieuso, Thongtinxe.Dongco, Thongtinxe.Copxe, Thongtinxe.Tocdo, Thongtinxe.Tuikhi, Thongtinxe.Mota, Thongtinxe.Anh1, Thongtinxe.Anh2, Thongtinxe.Anh3 " +
                        "FROM Xe " +
                        "JOIN Thongtinxe ON Xe.Maxe = Thongtinxe.Maxe " +
                        "JOIN Loaixe ON Xe.Maloaixe = Loaixe.Maloaixe " +
                        "WHERE Xe.Trangthai = 0", // Thêm điều kiện Xe.Trangthai = 0
                null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                // Lấy giá trị từ con trỏ Cursor
                int maxeIndex = cursor.getColumnIndex("Maxe");
                int tenxeIndex = cursor.getColumnIndex("Tenxe");
                int maloaixeIndex = cursor.getColumnIndex("Maloaixe");
                int hangxeIndex = cursor.getColumnIndex("Hangxe");
                int biensoIndex = cursor.getColumnIndex("Bienso");
                int hinhanhIndex = cursor.getColumnIndex("Hinhanh");
                int giaIndex = cursor.getColumnIndex("Gia");
                int trangthaiIndex = cursor.getColumnIndex("TrangThai");
                int sogheIndex = cursor.getColumnIndex("Soghe");
                int kieusoIndex = cursor.getColumnIndex("Kieuso");
                int dongcoIndex = cursor.getColumnIndex("Dongco");
                int copxeIndex = cursor.getColumnIndex("Copxe");
                int tocdoIndex = cursor.getColumnIndex("Tocdo");
                int tuikhiIndex = cursor.getColumnIndex("Tuikhi");
                int motaIndex = cursor.getColumnIndex("Mota");
                int anh1Index = cursor.getColumnIndex("Anh1");
                int anh2Index = cursor.getColumnIndex("Anh2");
                int anh3Index = cursor.getColumnIndex("Anh3");

                // Kiểm tra các chỉ mục hợp lệ
                if (maxeIndex != -1 && tenxeIndex != -1 && maloaixeIndex != -1 && hangxeIndex != -1) {
                    // Lấy giá trị từ con trỏ
                    String maxe = cursor.getString(maxeIndex);
                    String tenxe = cursor.getString(tenxeIndex);
                    String maloaixe = cursor.getString(maloaixeIndex);
                    String hangxe = cursor.getString(hangxeIndex);
                    String bienso = cursor.getString(biensoIndex);
                    String hinhanh = cursor.getString(hinhanhIndex);
                    int priceValue = cursor.getInt(giaIndex);
                    String price = NumberFormat.getNumberInstance(Locale.GERMANY).format(priceValue);
                    String trangthai = cursor.getString(trangthaiIndex);
                    String soghe = cursor.getString(sogheIndex);
                    String kieuso = cursor.getString(kieusoIndex);
                    String dongco = cursor.getString(dongcoIndex);
                    String copxe = cursor.getString(copxeIndex);
                    String tocdo = cursor.getString(tocdoIndex);
                    String tuikhi = cursor.getString(tuikhiIndex);
                    String mota = cursor.getString(motaIndex);
                    String anh1 = cursor.getString(anh1Index);
                    String anh2 = cursor.getString(anh2Index);
                    String anh3 = cursor.getString(anh3Index);

                    cars.add(new QLcar(maxe, tenxe, maloaixe, hangxe, bienso, hinhanh, price, trangthai, soghe, kieuso, dongco, copxe, tocdo, tuikhi, mota, anh1, anh2, anh3));
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
    public boolean addThuexe(String hotenthue, String sdtthue, String emailthue, String ghichu, String hinhthuc, String diachinhanxe, String timenhan, String timetra, String phuongthuctt, int tongtien, String carName, String makh, String ngay) {
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
            values.put("Tinhtrang", "Chưa xử lý");
            values.put("Ngaydat", ngay);// Tổng tiền

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
        String query = "SELECT Thuexe.Mathuexe, Xe.Tenxe, Thuexe.Tinhtrang, Xe.Hinhanh " +
                "FROM Thuexe " +
                "INNER JOIN Xe ON Thuexe.Maxe = Xe.Maxe " +
                "WHERE Thuexe.Makh = ?";

        // Thực thi truy vấn với makh là tham số
        Cursor cursor = db.rawQuery(query, new String[]{makh});

        if (cursor != null) {
            int maXeColumnIndex = cursor.getColumnIndex("Mathuexe");
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
    public boolean updatePassword(String makh, String oldPassword, String newPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;
        boolean isUpdated = false;

        try {
            // Check if the old password matches
            cursor = db.query("khachhang", new String[]{"Makh"},
                    "Makh=? AND Mk=?",
                    new String[]{makh, oldPassword}, null, null, null);

            if (cursor != null && cursor.getCount() > 0) {
                // Old password matches, proceed to update
                ContentValues values = new ContentValues();
                values.put("Mk", newPassword);
                int rowsAffected = db.update("khachhang", values, "Makh=?", new String[]{makh});
                isUpdated = rowsAffected > 0; // true if at least one row was updated
            }
        } catch (Exception e) {
            Log.e("DatabaseHelper", "Error updating password", e);
        } finally {
            if (cursor != null) cursor.close();
            db.close();
        }
        return isUpdated;
    }
    // Phương thức cập nhật thông tin người dùng
    public boolean updateUserInfo(String makh, String newHoten, String newNgaysinh, String newSdt, String newEmail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // Đặt các giá trị mới cho các cột cần cập nhật
        values.put("Tenkh", newHoten);
        values.put("Ngaysinh", newNgaysinh);
        values.put("Sdt", newSdt);
        values.put("Email", newEmail);

        // Cập nhật thông tin trong bảng khachhang
        int rowsAffected = db.update("khachhang", values, "Makh=?", new String[]{makh});
        db.close();

        // Trả về true nếu ít nhất một dòng đã được cập nhật thành công
        return rowsAffected > 0;
    }
    public Cursor getUserInfo(String makh) {
        SQLiteDatabase db = this.getReadableDatabase();
        // Truy vấn thông tin người dùng theo Makh
        return db.rawQuery("SELECT Tenkh, Ngaysinh, Sdt, Email FROM khachhang WHERE Makh = ?", new String[]{makh});
    }
    public boolean updatebang(String makh, String sogp, String hangbang, String noidk, String ngayhh) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // Đặt các giá trị mới cho các cột cần cập nhật
        values.put("Sogp", sogp);
        values.put("Hangbang", hangbang);
        values.put("Noidk", noidk);
        values.put("Ngayhh", ngayhh);

        // Cập nhật thông tin trong bảng gplx
        int rowsAffected = db.update("gplx", values, "Makh=?", new String[]{makh});
        db.close();

        // Trả về true nếu ít nhất một dòng đã được cập nhật thành công
        return rowsAffected > 0;
    }
    public Cursor getbang(String makh) {
        SQLiteDatabase db = this.getReadableDatabase();
        // Truy vấn thông tin người dùng theo Makh
        return db.rawQuery("SELECT Sogp, Hangbang, Noidk, Ngayhh FROM gplx WHERE Makh = ?", new String[]{makh});
    }
    public boolean updatediachi(String makh, String dc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // Đặt các giá trị mới cho các cột cần cập nhật
        values.put("Diachi", dc);
        // Cập nhật thông tin trong bảng gplx
        int rowsAffected = db.update("khachhang", values, "Makh=?", new String[]{makh});
        db.close();
        // Trả về true nếu ít nhất một dòng đã được cập nhật thành công
        return rowsAffected > 0;
    }
    public Cursor getdiachi(String makh) {
        SQLiteDatabase db = this.getReadableDatabase();
        // Truy vấn thông tin người dùng theo Makh
        return db.rawQuery("SELECT Diachi FROM khachhang WHERE Makh = ?", new String[]{makh});
    }
    public Cursor getsuaxe(String maxe) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT Xe.Maxe, Xe.Tenxe, Xe.Maloaixe, Xe.Hangxe, Xe.Bienso, Xe.Hinhanh, Xe.Gia, Xe.TrangThai, " +
                "Thongtinxe.Soghe,Thongtinxe.Kieuso,Thongtinxe.Dongco,Thongtinxe.Copxe, Thongtinxe.Tocdo,Thongtinxe.Tuikhi, Thongtinxe.Mota, Thongtinxe.Anh1, Thongtinxe.Anh2, Thongtinxe.Anh3 " +
                "FROM Xe " +
                "INNER JOIN Thongtinxe ON Xe.Maxe = Thongtinxe.Maxe " +
                "WHERE Xe.Maxe = ?";
        return db.rawQuery(query, new String[]{maxe});
    }


    public boolean insertHotro(String makh, String ht, String sdt, String email, String chude, String dichvu, String mota) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // Đặt các giá trị mới cho các cột
        values.put("Makh", makh);
        values.put("Hoten", ht);
        values.put("Sdt", sdt);
        values.put("Email", email);
        values.put("Chude", chude);
        values.put("Dichvu", dichvu);
        values.put("Mota", mota);

        // Chèn vào bảng Hotro
        long result = db.insert("Hotro", null, values);
        db.close(); // Đảm bảo đóng cơ sở dữ liệu sau khi thực hiện

        return result != -1; // Trả về true nếu chèn thành công, false nếu có lỗi
    }

    public boolean updateXe(String maxe, String tenxe, String maloaixe, String hangxe, String bienso, String hinhanh, String gia, String trangthai, String soghe, String kieuso, String dongco, String copxe, String tocdo, String tuikhi, String mota, String anh1, String anh2, String anh3) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues valuesXe = new ContentValues();
            ContentValues valuesThongtinXe = new ContentValues();

            // Cập nhật thông tin trong bảng Xe
            valuesXe.put("Tenxe", tenxe);
            valuesXe.put("Maloaixe", maloaixe);
            valuesXe.put("Hangxe", hangxe);
            valuesXe.put("Bienso", bienso);
            valuesXe.put("Hinhanh", hinhanh);
            valuesXe.put("Gia", gia);
            valuesXe.put("Trangthai", trangthai);

            // Cập nhật thông tin trong bảng Thongtinxe
            valuesThongtinXe.put("Soghe", soghe);
            valuesThongtinXe.put("Kieuso", kieuso);
            valuesThongtinXe.put("Dongco", dongco);
            valuesThongtinXe.put("Copxe", copxe);
            valuesThongtinXe.put("Tocdo", tocdo);
            valuesThongtinXe.put("Tuikhi", tuikhi);
            valuesThongtinXe.put("Mota", mota);
            valuesThongtinXe.put("Anh1", anh1);
            valuesThongtinXe.put("Anh2", anh2);
            valuesThongtinXe.put("Anh3", anh3);

            // Cập nhật thông tin trong bảng Xe
            int rowsAffectedXe = db.update("Xe", valuesXe, "Maxe=?", new String[]{maxe});
            // Cập nhật thông tin trong bảng Thongtinxe
            int rowsAffectedThongtinXe = db.update("Thongtinxe", valuesThongtinXe, "Maxe=?", new String[]{maxe});

            db.close();

            return rowsAffectedXe > 0 && rowsAffectedThongtinXe > 0;
        } catch (Exception e) {
            Log.e("Update Error", "Error while updating data: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    public boolean themxe(String tenxe, String maloaixe, String hangxe, String bienso, String hinhanh, String gia, String trangthai, String soghe, String kieuso, String dongco, String copxe, String tocdo, String tuikhi, String mota, String anh1, String anh2, String anh3) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues valuesXe = new ContentValues();
            ContentValues valuesThongtinXe = new ContentValues();

            // Thêm dữ liệu vào bảng Xe
            valuesXe.put("Tenxe", tenxe);
            valuesXe.put("Maloaixe", maloaixe);
            valuesXe.put("Hangxe", hangxe);
            valuesXe.put("Bienso", bienso);
            valuesXe.put("Hinhanh", hinhanh);
            valuesXe.put("Gia", gia);
            valuesXe.put("Trangthai", trangthai);

            // Chèn dữ liệu vào bảng Xe và lấy `rowId`
            long rowId = db.insert("Xe", null, valuesXe);
            if (rowId == -1) {
                db.close();
                return false; // Chèn thất bại
            }

            // Truy vấn để lấy `maxe` dựa trên `rowId`
            Cursor cursor = db.rawQuery("SELECT Maxe FROM Xe WHERE rowid = ?", new String[]{String.valueOf(rowId)});
            if (cursor != null && cursor.moveToFirst()) {
                int index = cursor.getColumnIndex("Maxe");
                    String maxe = cursor.getString(index);
                cursor.close();

                // Thêm dữ liệu vào bảng Thongtinxe với `maxe` vừa lấy được
                valuesThongtinXe.put("Maxe", maxe);
                valuesThongtinXe.put("Soghe", soghe);
                valuesThongtinXe.put("Kieuso", kieuso);
                valuesThongtinXe.put("Dongco", dongco);
                valuesThongtinXe.put("Copxe", copxe);
                valuesThongtinXe.put("Tocdo", tocdo);
                valuesThongtinXe.put("Tuikhi", tuikhi);
                valuesThongtinXe.put("Mota", mota);
                valuesThongtinXe.put("Anh1", anh1);
                valuesThongtinXe.put("Anh2", anh2);
                valuesThongtinXe.put("Anh3", anh3);

                long rowsAffectedThongtinXe = db.insert("Thongtinxe", null, valuesThongtinXe);
                db.close();
                return rowsAffectedThongtinXe > 0;
            } else {
                if (cursor != null) {
                    cursor.close();
                }
                db.close();
                return false;
            }
        } catch (Exception e) {
            Log.e("Insert Error", "Error while inserting data: " + e.getMessage());
            e.printStackTrace();
            db.close();
            return false;
        }
    }
    public boolean deleteXe(String maxe) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            // Xóa dữ liệu từ bảng Thongtinxe trước dựa vào Maxe
            int rowsDeletedThongtinXe = db.delete("Thongtinxe", "Maxe = ?", new String[]{maxe});

            // Nếu không có hàng nào bị xóa trong bảng Thongtinxe, trả về false
            if (rowsDeletedThongtinXe == 0) {
                db.close();
                return false;
            }

            // Xóa dữ liệu từ bảng Xe dựa vào Maxe
            int rowsDeletedXe = db.delete("Xe", "Maxe = ?", new String[]{maxe});

            db.close();
            // Trả về true nếu có ít nhất một hàng bị xóa trong cả hai bảng
            return rowsDeletedXe > 0;
        } catch (Exception e) {
            Log.e("Delete Error", "Error while deleting data: " + e.getMessage());
            e.printStackTrace();
            db.close();
            return false;
        }
    }
    public List<QLkhachhang> getqlkh() {
        List<QLkhachhang> qlkhList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query để lấy thông tin từ bảng Thuexe và Xe với điều kiện makh
        String query = "SELECT * FROM khachhang";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            int mat = cursor.getColumnIndex("Makh");
            int tent = cursor.getColumnIndex("Tenkh");
            int tkt = cursor.getColumnIndex("Tentk");
            int sdtt = cursor.getColumnIndex("Sdt");
            int mkt = cursor.getColumnIndex("Mk");
            int nst = cursor.getColumnIndex("Ngaysinh");
            int emailt = cursor.getColumnIndex("Email");
            int dct = cursor.getColumnIndex("Diachi");

            while (cursor.moveToNext()) {
                // Truy cập dữ liệu từ các cột đã xác định
                String ma = cursor.getString(mat); // Mã đơn (MaXe)
                String ten = cursor.getString(tent); // Tên xe (TenXe)
                String tk = cursor.getString(tkt); // Trạng thái (TrangThai)
                String sdt = cursor.getString(sdtt);
                String mk = cursor.getString(mkt);
                String ns = cursor.getString(nst);
                String email = cursor.getString(emailt);
                String dc = cursor.getString(dct);// Hình ảnh (HinhAnh)

                // Tạo đối tượng myCar từ dữ liệu lấy được
                QLkhachhang kh = new QLkhachhang(ma,ten,tk,sdt,mk,ns,email,dc);
                qlkhList.add(kh);
            }
            cursor.close();
        }

        db.close();
        return qlkhList;
    }
    public boolean themKhachHang(String tenkh, String tentk, String sdt, String mk, String ngaysinh, String email, String diachi) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues valuesKhachHang = new ContentValues();

            // Thêm dữ liệu vào bảng Khachhang
            valuesKhachHang.put("Tenkh", tenkh);
            valuesKhachHang.put("Tentk", tentk);
            valuesKhachHang.put("Sdt", sdt);
            valuesKhachHang.put("Mk", mk);
            valuesKhachHang.put("Ngaysinh", ngaysinh);
            valuesKhachHang.put("Email", email);
            valuesKhachHang.put("Diachi", diachi);

            // Chèn dữ liệu vào bảng Khachhang
            long rowId = db.insert("khachhang", null, valuesKhachHang);
            db.close();

            // Kiểm tra kết quả chèn dữ liệu
            return rowId != -1;
        } catch (Exception e) {
            Log.e("Insert Error", "Error while inserting data: " + e.getMessage());
            e.printStackTrace();
            db.close();
            return false;
        }
    }
    public boolean suaKhachHang(String makh, String tenkh, String tentk, String sdt, String mk, String ngaysinh, String email, String diachi) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues valuesKhachHang = new ContentValues();

            // Cập nhật dữ liệu vào bảng Khachhang
            valuesKhachHang.put("Tenkh", tenkh);
            valuesKhachHang.put("Tentk", tentk);
            valuesKhachHang.put("Sdt", sdt);
            valuesKhachHang.put("Mk", mk);
            valuesKhachHang.put("Ngaysinh", ngaysinh);
            valuesKhachHang.put("Email", email);
            valuesKhachHang.put("Diachi", diachi);

            // Thực hiện cập nhật dữ liệu dựa trên Makh
            int rowsAffected = db.update("khachhang", valuesKhachHang, "Makh = ?", new String[]{makh});
            db.close();

            // Kiểm tra kết quả cập nhật dữ liệu
            return rowsAffected > 0;
        } catch (Exception e) {
            Log.e("Update Error", "Error while updating data: " + e.getMessage());
            e.printStackTrace();
            db.close();
            return false;
        }
    }
    public boolean xoaKhachHang(String makh) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            // Xóa khách hàng theo `Makh`
            int result = db.delete("khachhang", "Makh = ?", new String[]{makh});
            db.close();
            return result > 0; // Trả về true nếu xóa thành công
        } catch (Exception e) {
            Log.e("Delete Error", "Error while deleting customer: " + e.getMessage());
            e.printStackTrace();
            db.close();
            return false;
        }
    }
    public List<QLhoadon> getqlhd() {
        List<QLhoadon> qlhdList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query để lấy các cột cụ thể từ bảng Thuexe
        String query = "SELECT Mathuexe, Hotenthue, Tongtien, Tinhtrang FROM Thuexe";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null && cursor.moveToFirst()) {
            // Xác định chỉ số của các cột
            int mat = cursor.getColumnIndex("Mathuexe");
            int hotent = cursor.getColumnIndex("Hotenthue");
            int tongtient = cursor.getColumnIndex("Tongtien");
            int tinhtrangt = cursor.getColumnIndex("Tinhtrang");

            // Duyệt qua từng dòng trong kết quả
            do {
                // Truy cập dữ liệu từ các cột đã xác định
                String mathuexe = cursor.getString(mat);
                String hotenThue = cursor.getString(hotent);
                String tongTien = cursor.getString(tongtient);
                String tinhTrang = cursor.getString(tinhtrangt);

                // Tạo đối tượng QLhoadon từ dữ liệu lấy được
                QLhoadon hd = new QLhoadon(mathuexe, hotenThue, tinhTrang, tongTien);
                qlhdList.add(hd);
            } while (cursor.moveToNext());
            cursor.close();
        }

        db.close();
        return qlhdList;
    }
    public boolean updateTinhTrangHoaDon(String mathuexe) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            // Cập nhật dữ liệu vào bảng Thuexe
            values.put("Tinhtrang", "Đã xử lý");

            // Thực hiện cập nhật dữ liệu dựa trên Mathuexe
            int rowsAffected = db.update("Thuexe", values, "Mathuexe = ?", new String[]{mathuexe});
            db.close();

            // Kiểm tra kết quả cập nhật dữ liệu
            return rowsAffected > 0;
        } catch (Exception e) {
            Log.e("Update Error", "Error while updating data: " + e.getMessage());
            e.printStackTrace();
            db.close();
            return false;
        }
    }

}


