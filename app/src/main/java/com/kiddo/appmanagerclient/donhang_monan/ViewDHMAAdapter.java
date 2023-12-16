package com.kiddo.appmanagerclient.donhang_monan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kiddo.appmanagerclient.Constants;
import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.model.DonHang;
import com.kiddo.appmanagerclient.model.DonHang_MonAn;
import com.kiddo.appmanagerclient.nhanvien.view.ViewDHHolder_nv;

import java.util.ArrayList;
import java.util.List;

public class ViewDHMAAdapter extends RecyclerView.Adapter<ViewDHMAHolder> {

    List<DonHang_MonAn> listDHMA;

    public ViewDHMAAdapter(List<DonHang_MonAn> listDH){
        this.listDHMA = listDHMA;
    }

    @NonNull
    @Override
    public ViewDHMAHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_monan_donhang, parent, false);

        return new ViewDHMAHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewDHMAHolder holder, int position) {
        DonHang_MonAn dhma = listDHMA.get(position);
        Glide
                .with(holder.itemView)
                .load(Constants.API_PREFIX + dhma.getImageUrl())
                .error(android.R.drawable.stat_notify_error)
                .skipMemoryCache(true)
                .into(holder.img);

        holder.ten.setText(dhma.getName());
        holder.tien.setText(dhma.getPrice().toString());
        holder.so_lg.setText(String.valueOf(dhma.getQuantity()));
    }
    public void setList(List<DonHang_MonAn> list){
        listDHMA = list;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(listDHMA == null){
            return  0;
        }
        return listDHMA.size();
    }
}
