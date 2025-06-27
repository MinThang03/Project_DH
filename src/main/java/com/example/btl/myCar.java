package com.example.btl;

public class myCar {
    private String tenxe;
    private String madon;
    private String tinhtrang;
    private String anhxe;  // Đảm bảo ảnh được lưu dưới dạng tài nguyên drawable

    // Constructor
    public myCar(String tenxe, String madon, String tinhtrang, String anhxe) {
        this.tenxe = tenxe;
        this.madon = madon;
        this.tinhtrang = tinhtrang;
        this.anhxe = anhxe;
    }

    // Getter and Setter
    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public String getMadon() {
        return madon;
    }

    public void setMadon(String madon) {
        this.madon = madon;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getAnhxe() {
        return anhxe;
    }

    public void setAnhxe(String anhxe) {
        this.anhxe = anhxe;
    }
}


