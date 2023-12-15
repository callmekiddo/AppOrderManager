package com.kiddo.appmanagerclient.quanly.view;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.model.DonHang;


import java.util.List;
import java.util.Locale;

public class ViewDHAdapter_ql extends RecyclerView.Adapter<ViewDHHolder_ql> {
    private List<DonHang> listDH;
    private OnItemClickListener onItemClickListener;
    public ViewDHAdapter_ql(List<DonHang> listDH,OnItemClickListener onItemClickListener){
        this.listDH = listDH;
        this.onItemClickListener = onItemClickListener;
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
        holder.id_dh.setText(String.format(Locale.getDefault(),"%d",dh.getId()));
        holder.bind(onItemClickListener);
        holder.create_date.setText(dh.getCreateAt());
    }

    @Override
    public int getItemCount() {
        if(listDH == null){
            return 0;
        }
        return listDH.size();
    }

}
