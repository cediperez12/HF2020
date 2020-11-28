package com.iced.hf2020.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iced.hf2020.Utilities.Hospital;
import com.iced.hf2020.*;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HospitalListAdapter extends RecyclerView.Adapter<HospitalListAdapter.ViewHolder> {

    private List<Hospital> hospitals;
    private Context context;

    public HospitalListAdapter(List<Hospital> hospitals, Context context) {
        this.hospitals = hospitals;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hospital_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Hospital h = hospitals.get(position);
        holder.hospitalNameTxtv.setText(h.getHospitalName());
        holder.hospitalNameTxtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,HospitalInformationActivity.class);
                intent.putExtra("HOSPITAL_ID",h.getPushId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hospitals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView hospitalNameTxtv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hospitalNameTxtv = itemView.findViewById(R.id.hospital_list_item_txtv_hospital_name);
        }
    }

}
