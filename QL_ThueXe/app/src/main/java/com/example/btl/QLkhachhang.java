package com.example.btl;

public class QLkhachhang {
    private String makh;
    private String hoten;
    private String tentk;
    private String sdt;
    private String mk;
    private String ngaysinh;
    private String email;
    private String diachi;

    // Constructor với tất cả các thuộc tính
    public QLkhachhang(String makh, String hoten, String tentk, String sdt, String mk, String ngaysinh, String email, String diachi) {
        this.makh = makh;
        this.hoten = hoten;
        this.tentk = tentk;
        this.sdt = sdt;
        this.mk = mk;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.diachi = diachi;
    }

    // Các phương thức getter
    public String getMakh() {
        return makh;
    }

    public String getHoten() {
        return hoten;
    }

    public String getTentk() {
        return tentk;
    }

    public String getSdt() {
        return sdt;
    }

    public String getMk() {
        return mk;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getEmail() {
        return email;
    }

    public String getDiachi() {
        return diachi;
    }
}
