package com.example.tranhuubinhb17dcat023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ManChuyenMon extends AppCompatActivity {

    ListView lvChuyenMon;
    Button btnAddChuyenMon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_chuyen_mon);

        lvChuyenMon = findViewById(R.id.lvChuyenMon);
        btnAddChuyenMon = findViewById(R.id.btnAddChuyenMon);

        btnAddChuyenMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManChuyenMon.this, ManAddChuyenMon.class);
                startActivity(intent);
            }
        });
    }
}