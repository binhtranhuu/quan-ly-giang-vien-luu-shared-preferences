package com.example.tranhuubinhb17dcat023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tranhuubinhb17dcat023.model.B17DCAT023_ChuyenMon;
import com.example.tranhuubinhb17dcat023.storage.SharedPrefManager;

import java.util.ArrayList;

public class ManAddChuyenMon extends AppCompatActivity {

    EditText edTenCM, edMoTaCM;
    Button btnThemCM;

    ArrayList<B17DCAT023_ChuyenMon> chuyenMonArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_add_chuyen_mon);

        chuyenMonArrayList = SharedPrefManager.getInstace(this).getAllChuyenMon();

        // Ánh xạ
        edTenCM = findViewById(R.id.edTenCM);
        edMoTaCM = findViewById(R.id.edMoTaCM);
        btnThemCM = findViewById(R.id.btnThemCM);

        // Bắt sự kiện click thêm lớp học
        btnThemCM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B17DCAT023_ChuyenMon chuyenMon = new B17DCAT023_ChuyenMon(chuyenMonArrayList.size() + 1, edTenCM.getText().toString().trim(),
                        edMoTaCM.getText().toString().trim());

                chuyenMonArrayList.add(chuyenMon);

                SharedPrefManager sharedPrefManager = SharedPrefManager.getInstace(ManAddChuyenMon.this);

                sharedPrefManager.saveChuyenMon(chuyenMonArrayList);

                Toast.makeText(ManAddChuyenMon.this, "Thêm mới thành công", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ManAddChuyenMon.this, ManChuyenMon.class);
                finish();
                startActivity(intent);
            }
        });
    }
}