package com.example.tranhuubinhb17dcat023.model;

public class B17DCAT023_GiangVienChuyenMon {
    private int giangvien_id;
    private int chuyenmon_id;
    private String namkinhnghiem;

    public B17DCAT023_GiangVienChuyenMon(int chuyenmon_id, String namkinhnghiem) {
        this.chuyenmon_id = chuyenmon_id;
        this.namkinhnghiem = namkinhnghiem;
    }

    public B17DCAT023_GiangVienChuyenMon(int giangvien_id, int chuyenmon_id, String namkinhnghiem) {
        this.giangvien_id = giangvien_id;
        this.chuyenmon_id = chuyenmon_id;
        this.namkinhnghiem = namkinhnghiem;
    }

    public int getGiangvien_id() {
        return giangvien_id;
    }

    public void setGiangvien_id(int giangvien_id) {
        this.giangvien_id = giangvien_id;
    }

    public int getChuyenmon_id() {
        return chuyenmon_id;
    }

    public void setChuyenmon_id(int chuyenmon_id) {
        this.chuyenmon_id = chuyenmon_id;
    }

    public String getNamkinhnghiem() {
        return namkinhnghiem;
    }

    public void setNamkinhnghiem(String namkinhnghiem) {
        this.namkinhnghiem = namkinhnghiem;
    }
}
