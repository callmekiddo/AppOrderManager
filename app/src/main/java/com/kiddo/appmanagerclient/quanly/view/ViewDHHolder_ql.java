package com.kiddo.appmanagerclient.quanly.view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kiddo.appmanagerclient.R;

public class ViewDHHolder_ql extends RecyclerView.ViewHolder {
    TextView id_dh, id_kh, create_date, ten_nv ;
    public ViewDHHolder_ql(@NonNull View itemView) {
        super(itemView);
        id_dh = itemView.findViewById(R.id.id_dh);
        create_date = itemView.findViewById(R.id.create_date);
        ten_nv = itemView.findViewById(R.id.ten_nv);
    }
}
