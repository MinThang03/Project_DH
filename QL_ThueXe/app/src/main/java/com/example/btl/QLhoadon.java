package com.example.btl;

public class QLhoadon {
    private String madon;
    private String name;
    private String trangthai;
    private String tong;

    public QLhoadon(String madon, String name, String trangthai, String tong) {
        this.madon = madon;
        this.name = name;
        this.trangthai = trangthai;
        this.tong = tong;
    }

    public String getMadon() { return madon; }
    public String getName() { return name; }
    public String getTrangthai() { return trangthai; }
    public String getTong() { return tong; }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}

