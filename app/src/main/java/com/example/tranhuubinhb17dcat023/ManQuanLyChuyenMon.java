package com.example.tranhuubinhb17dcat023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tranhuubinhb17dcat023.model.B17DCAT023_ChuyenMon;
import com.example.tranhuubinhb17dcat023.model.B17DCAT023_GiangVien;
import com.example.tranhuubinhb17dcat023.model.B17DCAT023_GiangVienChuyenMon;
import com.example.tranhuubinhb17dcat023.storage.SharedPrefManager;

import java.util.ArrayList;

public class ManQuanLyChuyenMon extends AppCompatActivity {

    String kinhnghiem[] = {"1", "2", "3", "4"};
    ArrayList<B17DCAT023_GiangVien> giangVienArrayList;
    ArrayList<B17DCAT023_ChuyenMon> chuyenMonArrayList;
    ArrayList<B17DCAT023_GiangVienChuyenMon> giangVienChuyenMonArrayList;
    Spinner spGiangVien, spChuyenMon, spNamKinhNghiem;
    Button btnQuanLyChuyenMon;

    int idGiangVien, idChuyenMon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_quan_ly_chuyen_mon);

        giangVienChuyenMonArrayList = SharedPrefManager.getInstace(this).getAllQuanLyChuyenMon();

        AnhXa();

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, kinhnghiem);
        spNamKinhNghiem.setAdapter(adapter1);

        // Thiết lập spinner cho giảng viên
        giangVienArrayList = SharedPrefManager.getInstace(this).getAllGiangVien();
        ArrayAdapter<B17DCAT023_GiangVien> adapter3 = new ArrayAdapter<B17DCAT023_GiangVien>(this, R.layout.support_simple_spinner_dropdown_item, giangVienArrayList);
        spGiangVien.setAdapter(adapter3);

        // Bắt sự kiện chọn một giảng viên
        spGiangVien.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                B17DCAT023_GiangVien giangVien = (B17DCAT023_GiangVien) parent.getSelectedItem();
                idGiangVien = giangVien.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Thiết lập spinner cho chuyên môn
        chuyenMonArrayList = SharedPrefManager.getInstace(this).getAllChuyenMon();
        ArrayAdapter<B17DCAT023_ChuyenMon> adapter4 = new ArrayAdapter<B17DCAT023_ChuyenMon>(this, R.layout.support_simple_spinner_dropdown_item, chuyenMonArrayList);
        spChuyenMon.setAdapter(adapter4);

        // Bắt sự kiện chọn một giảng viên
        spChuyenMon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                B17DCAT023_ChuyenMon chuyenMon = (B17DCAT023_ChuyenMon) parent.getSelectedItem();
                idChuyenMon = chuyenMon.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Bắt sự kiện click Đăng ký học
        quanLyChuyenMon();

    }

    private void quanLyChuyenMon() {
        btnQuanLyChuyenMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B17DCAT023_GiangVienChuyenMon giangVienChuyenMon = new B17DCAT023_GiangVienChuyenMon(
                        idGiangVien,
                        idChuyenMon,
                        spNamKinhNghiem.getSelectedItem().toString().trim()
                );

                giangVienChuyenMonArrayList.add(giangVienChuyenMon);

                SharedPrefManager sharedPrefManager = SharedPrefManager.getInstace(ManQuanLyChuyenMon.this);

                sharedPrefManager.quanLyChuyenMon(giangVienChuyenMonArrayList);

                Toast.makeText(ManQuanLyChuyenMon.this, "Cập nhật thành công", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ManQuanLyChuyenMon.this, ManChuyenMon.class);
                finish();
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        spGiangVien = findViewById(R.id.spGiangVien);
        spChuyenMon = findViewById(R.id.spChuyenMon);
        spNamKinhNghiem = findViewById(R.id.spNamKinhNghiem);
        btnQuanLyChuyenMon = findViewById(R.id.btnQuanLyChuyenMon);
    }
}