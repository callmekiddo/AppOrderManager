package com.kiddo.appmanagerclient.nhanvien.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kiddo.appmanagerclient.OnItemClickListener;
import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.model.DonHang;

import java.util.List;
import java.util.Locale;

public class ViewDHAdapter_nv extends RecyclerView.Adapter<ViewDHHolder_nv> {
    private List<DonHang> listDH;
    private OnItemClickListener onItemClickListener;

    public ViewDHAdapter_nv(List<DonHang> listDH, OnItemClickListener onItemClickListener){
        this.listDH = listDH;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewDHHolder_nv onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_ds_donhang_nv, parent, false);

        return new ViewDHHolder_nv(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewDHHolder_nv holder, int position) {
        DonHang dh = listDH.get(position);
        holder.id_dh.setText(String.format(Locale.getDefault(),"%d",dh.getId()));
        holder.create_date.setText(dh.getCreateAt());
        holder.bind(onItemClickListener);
    }

    @Override
    public int getItemCount() {
        if(listDH == null){
            return 0;
        }
        return listDH.size();
    }
}