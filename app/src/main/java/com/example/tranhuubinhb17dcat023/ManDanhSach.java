package com.example.tranhuubinhb17dcat023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.tranhuubinhb17dcat023.adapter.adapterGiangVien;
import com.example.tranhuubinhb17dcat023.model.B17DCAT023_GiangVien;
import com.example.tranhuubinhb17dcat023.storage.SharedPrefManager;

import java.util.ArrayList;

public class ManDanhSach extends AppCompatActivity {

    ListView lvKetQua;

    ArrayList<B17DCAT023_GiangVien> giangVienArrayList;
    ArrayList<B17DCAT023_GiangVien> giangVien5ArrayList = new ArrayList<>();

    adapterGiangVien adapterGiangVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_danh_sach);

        lvKetQua = (ListView) findViewById(R.id.lvKetQua);

        // Hiển thị danh sách giảng viên có số năm kinh nghiệm lớn hơn 5
        giangVienArrayList = SharedPrefManager.getInstace(this).getAllGiangVien();
        for (int i = 0; i < giangVienArrayList.size(); i++) {
            if (Integer.parseInt(giangVienArrayList.get(i).getKinhnghiem()) > 5) {
                giangVien5ArrayList.add(giangVienArrayList.get(i));
            }
        }

        adapterGiangVien = new adapterGiangVien(getApplicationContext(), giangVien5ArrayList);
        lvKetQua.setAdapter(adapterGiangVien);
    }
}