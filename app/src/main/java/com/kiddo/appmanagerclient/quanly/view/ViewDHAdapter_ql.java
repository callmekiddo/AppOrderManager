package com.kiddo.appmanagerclient.quanly.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.model.DonHang;


import java.util.List;

public class ViewDHAdapter_ql extends RecyclerView.Adapter<ViewDHHolder_ql> {
    private List<DonHang> listDH;

    public ViewDHAdapter_ql(List<DonHang> listDH){
        this.listDH = listDH;
    }

    @NonNull
    @Override
    public ViewDHHolder_ql onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_ds_donhang_ql, parent, false);

        return new ViewDHHolder_ql(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewDHHolder_ql holder, int position) {
        DonHang dh = listDH.get(position);
        holder.id_dh.setText(dh.getId().toString());
        holder.create_date.setText(dh.getCreate_at().toString());
        holder.ten_nv.setText(dh.getNv_id().getName().toString());
    }

    @Override
    public int getItemCount() {
        if(listDH == null){
            return 0;
        }
        return listDH.size();
    }
}
