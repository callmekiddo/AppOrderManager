package com.kiddo.appmanagerclient.donhang_monan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.model.DonHang;
import com.kiddo.appmanagerclient.model.DonHang_MonAn;
import com.kiddo.appmanagerclient.nhanvien.view.ViewDHHolder_nv;

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
        holder.img.setImageResource(Integer.parseInt(dhma.getMa_id().getHinh_anh().toString()));
        holder.ten.setText(dhma.getMa_id().getTen());
        holder.tien.setText(dhma.getMa_id().getTien());
        holder.so_lg.setText(dhma.getSo_luong());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
