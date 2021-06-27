package com.example.tranhuubinhb17dcat023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.tranhuubinhb17dcat023.adapter.adapterChuyenMon;
import com.example.tranhuubinhb17dcat023.model.B17DCAT023_ChuyenMon;
import com.example.tranhuubinhb17dcat023.storage.SharedPrefManager;

import java.util.ArrayList;

public class ManChuyenMon extends AppCompatActivity {

    ListView lvChuyenMon;
    Button btnAddChuyenMon, btnQLChuyenMon;

    ArrayList<B17DCAT023_ChuyenMon> chuyenMonArrayList;

    adapterChuyenMon adapterChuyenMon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_chuyen_mon);

        lvChuyenMon = findViewById(R.id.lvChuyenMon);
        btnAddChuyenMon = findViewById(R.id.btnAddChuyenMon);
        btnQLChuyenMon = findViewById(R.id.btnQLChuyenMon);

        btnAddChuyenMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManChuyenMon.this, ManAddChuyenMon.class);
                startActivity(intent);
            }
        });

        btnQLChuyenMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManChuyenMon.this, ManQuanLyChuyenMon.class);
                startActivity(intent);
            }
        });


        chuyenMonArrayList = SharedPrefManager.getInstace(this).getAllChuyenMon();
        adapterChuyenMon = new adapterChuyenMon(getApplicationContext(), chuyenMonArrayList);
        lvChuyenMon.setAdapter(adapterChuyenMon);
    }
}