package com.kiddo.appmanagerclient.nhanvien.view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kiddo.appmanagerclient.OnItemClickListener;
import com.kiddo.appmanagerclient.R;

public class ViewDHHolder_nv extends RecyclerView.ViewHolder {
    TextView id_dh, id_kh, create_date;
    public ViewDHHolder_nv(@NonNull View itemView) {
        super(itemView);
        id_dh = itemView.findViewById(R.id.id_dh);
        create_date = itemView.findViewById(R.id.create_date);
    }
    public void bind(OnItemClickListener onItemClickListener){
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(Long.parseLong(id_dh.getText().toString()));
            }
        });
    }
}
