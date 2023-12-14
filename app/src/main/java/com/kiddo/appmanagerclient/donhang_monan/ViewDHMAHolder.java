package com.kiddo.appmanagerclient.donhang_monan;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kiddo.appmanagerclient.R;

public class ViewDHMAHolder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView ten, tien, so_lg;
    public ViewDHMAHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
        ten = itemView.findViewById(R.id.ten_ma);
        tien = itemView.findViewById(R.id.tien_ma);
        so_lg = itemView.findViewById(R.id.so_luong);
    }
}
