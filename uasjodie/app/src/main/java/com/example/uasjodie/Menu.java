package com.example.uasjodie;

public class Menu {
    private  String nama;
    private  String jabatan;
    private  String gambar;

    public Menu(String datanama,String datajabatan,String datagambar){
        nama= datanama;
        jabatan= datajabatan;
        gambar= datagambar;
    }

    public String getNama() {
        return nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public String getGambar() {
        return gambar;
    }
}
