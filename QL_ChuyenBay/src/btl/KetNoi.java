/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class KetNoi {

    public Connection ketnoi() {
        Connection kn = null;
        String url = "jdbc:mysql://localhost:3306/qlvemaybay";
        String user = "root";
        String password = "";
        try {
            kn = DriverManager.getConnection(url, user, password);
            System.out.println("Ket Noi Thanh Cong");
        } catch (Exception e) {
            System.out.println("Loi" + e.toString());
        }
        return kn;
    }

    public ResultSet getdata(String sql) {
        try {
            Statement st = ketnoi().createStatement();
            return st.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("Loi" + e.toString());
        }
        return null;
    }

    public ResultSet laykqvct() {
        String sql = "select * from vecuatoi";
        return getdata(sql);
    }

    public ResultSet laykqkh() {
        String sql = "select * from qlkhachhang";
        return getdata(sql);
    }

    public ResultSet laykqsb() {
        String sql = "select * from qlsanbay";
        return getdata(sql);
    }

    public ResultSet laykqcb() {
        String sql = "select * from qlchuyenbay";
        return getdata(sql);
    }

    public ResultSet laykqtb() {
        String sql = "select * from tuyenbay";
        return getdata(sql);
    }

    public ResultSet layhoso() {
        String sql = "select * from hoso";
        return getdata(sql);
    }

    public ResultSet laykqcbb() {
        String sql = "select tinhthanh from qlsanbay";
        return getdata(sql);
    }

    public ResultSet laymave() {
        String sql = "select mave from vecuatoi";
        return getdata(sql);
    }

    public ResultSet laymahd() {
        String sql = "select mahd from tchoadon";
        return getdata(sql);
    }

    public ResultSet layhd() {
        String sql = "select * from tchoadon";
        return getdata(sql);
    }

    public ResultSet laymacb() {
        String sql = "select macb from qlchuyenbay";
        return getdata(sql);
    }

    public ResultSet laykqcbbmatb() {
        String sql = "select matb from tuyenbay";
        return getdata(sql);
    }

    public ResultSet laykqtk() {
        String sql = "select * from vemaybay";
        return getdata(sql);
    }

    public void timthongke(String diemdi, String diemden, String ngaydv, JTable tb) throws SQLException {
        Connection kn = ketnoi();
        String query = "SELECT * FROM vemaybay WHERE ngaydv =? and noidi = ? AND diemden = ?";
        try (PreparedStatement st = kn.prepareStatement(query)) {
            st.setString(1, ngaydv);
            st.setString(2, diemdi);
            st.setString(3, diemden);
            ResultSet kq = st.executeQuery();
            loadTable(kq, tb);
        }
    }
    public void timmacb(String macb, JTable tb) throws SQLException {
        Connection kn = ketnoi();
        String query = "SELECT * FROM tchoadon WHERE macb = ?";
        try (PreparedStatement st = kn.prepareStatement(query)) {
            st.setString(1, macb);
            ResultSet kq = st.executeQuery();
            loadTable(kq, tb);
        }
    }

    public void timdatve(String diemkh, String diemden, JTable tb) throws SQLException {
        Connection kn = ketnoi();
        String query = "SELECT qlchuyenbay.macb, qlchuyenbay.ngaybay, qlchuyenbay.thoigianbay, tuyenbay.Sanbd, tuyenbay.Sanden "
                + "FROM qlchuyenbay "
                + "JOIN tuyenbay ON qlchuyenbay.matb = tuyenbay.matb "
                + "WHERE tuyenbay.Noikh = ? AND tuyenbay.diemden = ?";
        try (PreparedStatement st = kn.prepareStatement(query)) {
            st.setString(1, diemkh);
            st.setString(2, diemden);
            ResultSet kq = st.executeQuery();
            loadTable(kq, tb);
        }
    }

    public void xemdatve(String ngaybay, JTable tb) throws SQLException {
        Connection kn = ketnoi();
        String query = "SELECT qlchuyenbay.macb, qlchuyenbay.ngaybay, qlchuyenbay.thoigianbay, tuyenbay.Sanbd, tuyenbay.Sanden "
                + "FROM qlchuyenbay "
                + "JOIN tuyenbay ON qlchuyenbay.matb = tuyenbay.matb "
                + "WHERE qlchuyenbay.ngaybay = ?";
        try (PreparedStatement st = kn.prepareStatement(query)) {
            st.setString(1, ngaybay);
            ResultSet kq = st.executeQuery();
            loadTable(kq, tb);
        }
    }

    public String[] getdata() throws SQLException {
        Connection kn = ketnoi();
        Statement stmt = null;
        String[] data = new String[3]; // Mảng để chứa dữ liệu
        try {
            stmt = kn.createStatement();
            String query = "SELECT makh,hoten,sdt from qlkhachhang where makh='A01'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                data[0] = rs.getString("makh");
                data[1] = rs.getString("hoten");
                data[2] = rs.getString("sdt");
            }
            rs.close();
            stmt.close();
            kn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return data;
    }

    public String[] getdulieu(String mahd) throws SQLException {
        Connection kn = ketnoi();
        PreparedStatement st = null;
        String[] data = new String[15]; // Mảng để chứa dữ liệu
        try {
            String query = "SELECT tchoadon.mahd, tchoadon.mave, tchoadon.hoten, tchoadon.cccd, tchoadon.macb, "
                    + "tuyenbay.Sanbd, tuyenbay.Sanden, qlchuyenbay.ngaybay, qlchuyenbay.thoigianbay, "
                    + "vecuatoi.soghe, vecuatoi.hangghe, vecuatoi.giave, vecuatoi.thue, vecuatoi.tongtien, vecuatoi.trangthai "
                    + "FROM tchoadon "
                    + "JOIN vecuatoi ON tchoadon.mave = vecuatoi.mave "
                    + "JOIN qlchuyenbay ON tchoadon.macb = qlchuyenbay.macb "
                    + "JOIN tuyenbay ON qlchuyenbay.matb = tuyenbay.matb "
                    + "WHERE tchoadon.mahd = ?";
            st = kn.prepareStatement(query);
            st.setString(1, mahd);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                data[0] = rs.getString("mahd");
                data[1] = rs.getString("mave");
                data[2] = rs.getString("hoten");
                data[3] = rs.getString("cccd");
                data[4] = rs.getString("macb");
                data[5] = rs.getString("Sanbd");
                data[6] = rs.getString("Sanden");
                data[7] = rs.getString("ngaybay");
                data[8] = rs.getString("thoigianbay");
                data[9] = rs.getString("soghe");
                data[10] = rs.getString("hangghe");
                data[11] = rs.getString("giave");
                data[12] = rs.getString("thue");
                data[13] = rs.getString("tongtien");
                data[14] = rs.getString("trangthai");
            }
            rs.close();
            st.close();
            kn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            if (kn != null) {
                try {
                    kn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
        return data;
    }

    public void thongke(String ngayBatDau, String ngayKetThuc, JTable tb) throws SQLException {
        Connection kn = ketnoi();
        String query = "SELECT * FROM vemaybay WHERE ngaydv BETWEEN ? AND ?";
        try (PreparedStatement st = kn.prepareStatement(query)) {
            st.setString(1, ngayBatDau);
            st.setString(2, ngayKetThuc);
            ResultSet kq = st.executeQuery();
            loadTable(kq, tb);
        }
    }

    public String getTensb(String tinhthanh) {
        String tensb = "";
        try {
            String query = "SELECT Tensb FROM qlsanbay WHERE Tinhthanh = ?";
            PreparedStatement st = null;
            Connection kn = ketnoi();
            st = kn.prepareStatement(query);
            st.setString(1, tinhthanh);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                tensb = resultSet.getString("Tensb");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tensb;
    }
    public String getMasb(String tinhthanh) {
        String masb = "";
        try {
            String query = "SELECT Masb FROM qlsanbay WHERE Tinhthanh = ?";
            PreparedStatement st = null;
            Connection kn = ketnoi();
            st = kn.prepareStatement(query);
            st.setString(1, tinhthanh);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                masb = resultSet.getString("Masb");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return masb;
    }

    public String getmacb(String sbdi, String sbden) {
        String macb = null;
        try {
            String query = "SELECT qlchuyenbay.macb "
                    + "FROM qlchuyenbay "
                    + "JOIN tuyenbay ON qlchuyenbay.matb = tuyenbay.Matb "
                    + "WHERE tuyenbay.Sanbd = ? AND tuyenbay.Sanden = ?";
            PreparedStatement st = null;
            Connection kn = ketnoi();
            st = kn.prepareStatement(query);
            st.setString(1, sbdi);
            st.setString(2, sbden);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                macb = resultSet.getString("macb");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return macb;
    }

    public void loadTable(ResultSet kq, JTable tb) {
        int n = tb.getColumnCount();
        Object hang[] = new Object[n]; // Khai báo 1 bảng gồm n cột
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        //Đưa về bảng rỗng
        model.setRowCount(0); // clear bảng
        try {
            while (kq.next()) {
                for (int i = 0; i < n; i++) {
                    hang[i] = kq.getString(i + 1);
                }
                model.addRow(hang);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void updatedata(String sql) {
        try {
            Statement st = ketnoi().createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Loi" + e.toString());
        }
    }

    public void xoakh(String makh) {
        String sql = "delete from qlkhachhang where makh = '" + makh + "'";
        updatedata(sql);
    }

    public void xoatb(String matb) {
        String sql = "delete from tuyenbay where Matb = '" + matb + "'";
        updatedata(sql);
    }
    public void xoave(String mave) {
        String sql = "delete from vecuatoi where mave = '" + mave + "'";
        updatedata(sql);
    }

    public void xoasb(String masb) {
        String sql = "delete from qlsanbay where Masb = '" + masb + "'";
        updatedata(sql);
    }

    public void xoacb(String macb) {
        String sql = "delete from qlchuyenbay where Macb = '" + macb + "'";
        updatedata(sql);
    }

    public void timkh(String tenkh, JTable tb) {
        String sql = "select * from qlkhachhang where hoten like'%" + tenkh + "%'";
        ResultSet kq = getdata(sql);
        loadTable(kq, tb);
    }

    public void timsb(String tensb, JTable tb) {
        String sql = "select * from qlsanbay where Tensb like'%" + tensb + "%'";
        ResultSet kq = getdata(sql);
        loadTable(kq, tb);
    }

    public void timcb(String macb, JTable tb) {
        String sql = "select * from qlchuyenbay where macb like'%" + macb + "%'";
        ResultSet kq = getdata(sql);
        loadTable(kq, tb);
    }

    public void themvct(String maVe, String hoTen, String cccd, String macb, String soGhe, String hangGhe, double giaVe, double thue, double tongTien, String trangthai) throws SQLException {
        Connection kn = ketnoi();
        PreparedStatement st = null;
        String sql = "INSERT INTO vecuatoi (mave, hoten, cccd, macb, soghe, hangghe, giave, thue, tongtien,trangthai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        st = kn.prepareStatement(sql);
        st.setString(1, maVe);
        st.setString(2, hoTen);
        st.setString(3, cccd);
        st.setString(4, macb);
        st.setString(5, soGhe);
        st.setString(6, hangGhe);
        st.setDouble(7, giaVe);
        st.setDouble(8, thue);
        st.setDouble(9, tongTien);
        st.setString(10, trangthai);
        st.executeUpdate();
    }

    public void themqlkh(String ma, String ten, String cccd, String sdt, String gt, String email) throws SQLException {
        Connection kn = ketnoi();
        PreparedStatement st = null;
        String sql = "insert into qlkhachhang (makh,hoten,socccd,sdt,gioitinh,email) values(?,?,?,?,?,?)";
        st = kn.prepareStatement(sql);
        st.setString(1, ma);
        st.setString(2, ten);
        st.setString(3, cccd);
        st.setString(4, sdt);
        st.setString(5, gt);
        st.setString(6, email);
        st.executeUpdate();
    }

    public void themqlsb(String masb, String tensb, String tinhthanh) throws SQLException {
        Connection kn = ketnoi();
        PreparedStatement st = null;
        String sql = "insert into qlsanbay (Masb,Tensb,Tinhthanh) values(?,?,?)";
        st = kn.prepareStatement(sql);
        st.setString(1, masb);
        st.setString(2, tensb);
        st.setString(3, tinhthanh);
        st.executeUpdate();
    }

    public void themqlch(String macb, String matb, String ngaybay, String time, String soghe, String ctcb) throws SQLException {
        Connection kn = ketnoi();
        PreparedStatement st = null;
        String sql = "insert into qlchuyenbay (macb,matb,ngaybay,thoigianbay,soghe,machitietcb) values(?,?,?,?,?,?)";
        st = kn.prepareStatement(sql);
        st.setString(1, macb);
        st.setString(2, matb);
        st.setString(3, ngaybay);
        st.setString(4, time);
        st.setString(5, soghe);
        st.setString(6, ctcb);
        st.executeUpdate();
    }

    public void themhoadon(String mahd, String mave, String hoten, String cccd, String macb, double tongtien) throws SQLException {
        Connection kn = ketnoi();
        PreparedStatement st = null;
        String sql = "insert into tchoadon (mahd,mave,hoten,cccd,macb,tongtien) values(?,?,?,?,?,?)";
        st = kn.prepareStatement(sql);
        st.setString(1, mahd);
        st.setString(2, mave);
        st.setString(3, hoten);
        st.setString(4, cccd);
        st.setString(5, macb);
        st.setDouble(6, tongtien);
        st.executeUpdate();
    }

    public void themqltb(String matb, String noikh, String sanbaydi, String diemden, String sanbayden, String chieudai, String masbdi, String masbden) throws SQLException {
        Connection kn = ketnoi();
        PreparedStatement st = null;
        String sql = "insert into tuyenbay (Matb,Masbdi,Noikh,Sanbd,Masbden,Diemden,Sanden,Chieudai) values(?,?,?,?,?,?,?,?)";
        st = kn.prepareStatement(sql);
        st.setString(1, matb);
        st.setString(2, masbdi);
        st.setString(3, noikh);
        st.setString(4, sanbaydi);
        st.setString(5, masbden);
        st.setString(6, diemden);
        st.setString(7, sanbayden);
        st.setString(8, chieudai);
        st.executeUpdate();
    }

    public void suaqlsb(String masb, String tensb, String tinhthanh) throws SQLException {
        Connection kn = ketnoi();
        PreparedStatement st = null;
        String sql = "update qlsanbay set Tensb=?, Tinhthanh=? where Masb=?";
        st = kn.prepareStatement(sql);
        st.setString(1, tensb);
        st.setString(2, tinhthanh);
        st.setString(3, masb);
        st.executeUpdate();
    }

    public void suaqlkh(String ma, String ten, String cccd, String sdt, String gt, String email) throws SQLException {
        Connection kn = ketnoi();
        PreparedStatement st = null;
        String sql = "update qlkhachhang set hoten=?, socccd=?, sdt=?, gioitinh=?, email=? where makh=?";
        st = kn.prepareStatement(sql);
        st.setString(1, ten);
        st.setString(2, cccd);
        st.setString(3, sdt);
        st.setString(4, gt);
        st.setString(5, email);
        st.setString(6, ma);
        st.executeUpdate();
    }

    public void suaqlcb(String macb, String matb, String ngaybay, String time, String soghe, String ctcb) throws SQLException {
        Connection kn = ketnoi();
        PreparedStatement st = null;
        String sql = "update qlchuyenbay set matb=?, ngaybay=?, thoigianbay=?, soghe=?, machitietcb=? where macb=?";
        st = kn.prepareStatement(sql);
        st.setString(1, matb);
        st.setString(2, ngaybay);
        st.setString(3, time);
        st.setString(4, soghe);
        st.setString(5, ctcb);
        st.setString(6, macb);
        st.executeUpdate();
    }

    public void suaqltb(String matb, String noikh, String sanbaydi, String diemden, String sanbayden, String chieudai,String masbdi, String masbden) throws SQLException {
        Connection kn = ketnoi();
        PreparedStatement st = null;
        String sql = "update tuyenbay set Masbdi=?,Noikh=?,Sanbd=?,Masbden=?,Diemden=?,Sanden=?,Chieudai=? where Matb=?";
        st = kn.prepareStatement(sql);
        st.setString(1, masbdi);
        st.setString(2, noikh);
        st.setString(3, sanbaydi);
        st.setString(4, masbden);
        st.setString(5, diemden);
        st.setString(6, sanbayden);
        st.setString(7, chieudai);
        st.setString(8, matb);
        st.executeUpdate();
    }

    public void suahoso(String cccd, String hoten, String gt, String ngaysinh, String sdt, String diachi, String email) throws SQLException {
        Connection kn = ketnoi();
        PreparedStatement st = null;
        String sql = "update hoso set hoten=?,gioitinh=?,ngaysinh=?,diachi=?,sdt=?,email=?,cccd=?";
        st = kn.prepareStatement(sql);
        st.setString(1, hoten);
        st.setString(2, gt);
        st.setString(3, ngaysinh);
        st.setString(4, diachi);
        st.setString(5, sdt);
        st.setString(6, email);
        st.setString(7, cccd);
        st.executeUpdate();
    }

    public void suavct(String mave, String trangthai) throws SQLException {
        Connection kn = ketnoi();
        PreparedStatement st = null;
        String sql = "update vecuatoi set trangthai=? where mave=?";
        st = kn.prepareStatement(sql);
        st.setString(1, trangthai);
        st.setString(2, mave);
        st.executeUpdate();
    }
    public boolean ktratrungmaqlkh(String ma){
        String sql ="select * from qlkhachhang where makh = '"+ma+"'";
        ResultSet kq = getdata(sql);
        try {
            if(kq.next()){
                return true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi : "+e.toString());
        }
        return false;
    }
    public boolean ktratrungmaqlsb(String ma){
        String sql ="select * from qlsanbay where masb = '"+ma+"'";
        ResultSet kq = getdata(sql);
        try {
            if(kq.next()){
                return true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi : "+e.toString());
        }
        return false;
    }
    public boolean ktratrungmaqlcb(String ma){
        String sql ="select * from qlchuyenbay where macb = '"+ma+"'";
        ResultSet kq = getdata(sql);
        try {
            if(kq.next()){
                return true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi : "+e.toString());
        }
        return false;
    }
    public boolean ktratrungmaqltb(String ma){
        String sql ="select * from tuyenbay where Matb = '"+ma+"'";
        ResultSet kq = getdata(sql);
        try {
            if(kq.next()){
                return true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi : "+e.toString());
        }
        return false;
    }
    public boolean ktratrungmacccd(String ma){
        String sql ="select * from hoso where cccd = '"+ma+"'";
        ResultSet kq = getdata(sql);
        try {
            if(kq.next()){
                return true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi : "+e.toString());
        }
        return false;
    }
    public int getSoLuongKhachHang() throws SQLException {
        Connection conn = ketnoi();
        Statement stmt = null;
        ResultSet rs = null;
        int soLuong = 0;

        try {
            stmt = conn.createStatement();
            String query = "SELECT COUNT(*) AS soLuong FROM qlkhachhang";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                soLuong = rs.getInt("soLuong");
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return soLuong;
    }
    public int getSoLuongSanbay() throws SQLException {
        Connection conn = ketnoi();
        Statement stmt = null;
        ResultSet rs = null;
        int soLuong = 0;

        try {
            stmt = conn.createStatement();
            String query = "SELECT COUNT(*) AS soLuong FROM qlsanbay";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                soLuong = rs.getInt("soLuong");
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return soLuong;
    }
    public int getSoLuongCB() throws SQLException {
        Connection conn = ketnoi();
        Statement stmt = null;
        ResultSet rs = null;
        int soLuong = 0;

        try {
            stmt = conn.createStatement();
            String query = "SELECT COUNT(*) AS soLuong FROM qlchuyenbay";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                soLuong = rs.getInt("soLuong");
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return soLuong;
    }
    public int getSoLuongTB() throws SQLException {
        Connection conn = ketnoi();
        Statement stmt = null;
        ResultSet rs = null;
        int soLuong = 0;

        try {
            stmt = conn.createStatement();
            String query = "SELECT COUNT(*) AS soLuong FROM tuyenbay";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                soLuong = rs.getInt("soLuong");
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return soLuong;
    }
    public int getSoLuongHD() throws SQLException {
        Connection conn = ketnoi();
        Statement stmt = null;
        ResultSet rs = null;
        int soLuong = 0;

        try {
            stmt = conn.createStatement();
            String query = "SELECT COUNT(*) AS soLuong FROM tchoadon";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                soLuong = rs.getInt("soLuong");
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return soLuong;
    }
    public int getSoLuongVE() throws SQLException {
        Connection conn = ketnoi();
        Statement stmt = null;
        ResultSet rs = null;
        int soLuong = 0;

        try {
            stmt = conn.createStatement();
            String query = "SELECT COUNT(*) AS soLuong FROM vecuatoi";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                soLuong = rs.getInt("soLuong");
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return soLuong;
    }
    public double getDoanhThu() throws SQLException {
        Connection conn = ketnoi();
        Statement stmt = null;
        ResultSet rs = null;
        int soLuong = 0;

        try {
            stmt = conn.createStatement();
            String query = "SELECT SUM(tongtien) AS tongDoanhThu FROM tchoadon";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                soLuong = rs.getInt("tongDoanhThu");
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return soLuong;
    }

}
