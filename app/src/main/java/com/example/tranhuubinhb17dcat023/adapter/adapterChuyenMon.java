package com.example.tranhuubinhb17dcat023.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tranhuubinhb17dcat023.R;
import com.example.tranhuubinhb17dcat023.model.B17DCAT023_ChuyenMon;

import java.util.ArrayList;

public class adapterChuyenMon extends BaseAdapter {

    private Context context;
    private ArrayList<B17DCAT023_ChuyenMon> chuyenMonArrayList;

    public adapterChuyenMon(Context context, ArrayList<B17DCAT023_ChuyenMon> chuyenMonArrayList) {
        this.context = context;
        this.chuyenMonArrayList = chuyenMonArrayList;
    }

    @Override
    public int getCount() {
        return chuyenMonArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return chuyenMonArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.chuyenmon, null);

        TextView tenLopHoc = (TextView) convertView.findViewById(R.id.tenChuyenMon);
        TextView moTaLop = (TextView) convertView.findViewById(R.id.moTaChuyenMon);

        B17DCAT023_ChuyenMon chuyenmon = chuyenMonArrayList.get(position);

        tenLopHoc.setText(chuyenmon.getName());
        moTaLop.setText(chuyenmon.getDetail());

        return convertView;
    }
}
