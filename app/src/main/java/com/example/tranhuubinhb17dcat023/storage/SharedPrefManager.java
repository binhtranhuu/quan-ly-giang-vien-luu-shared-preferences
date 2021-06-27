package com.example.tranhuubinhb17dcat023.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tranhuubinhb17dcat023.model.B17DCAT023_GiangVien;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "TRANHUUBINH_QLGV";
    private static SharedPrefManager mInstance;
    private Context ctx;

    private SharedPrefManager(Context ctx) {
        this.ctx = ctx;
    }

    public static synchronized SharedPrefManager getInstace(Context ctx) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(ctx);
        }
        return mInstance;
    }

    // Thêm mới giảng viên
    public void saveGiangVien(ArrayList<B17DCAT023_GiangVien> giangVienArrayList) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(giangVienArrayList);
        editor.putString("giang vien", json);
        editor.apply();
    }

    // Lấy tất cả giảng viên
    public ArrayList<B17DCAT023_GiangVien> getAllGiangVien() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        ArrayList<B17DCAT023_GiangVien> giangVienArrayList = new ArrayList<>();

        Gson gson = new Gson();
        String json = sharedPreferences.getString("giang vien", null);
        Type type = new TypeToken<ArrayList<B17DCAT023_GiangVien>>() {
        }.getType();
        giangVienArrayList = gson.fromJson(json, type);

        if (giangVienArrayList == null) {
            giangVienArrayList = new ArrayList<>();
        }

        return giangVienArrayList;
    }
}
