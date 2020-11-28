package com.iced.hf2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iced.hf2020.Utilities.Patient;
import com.iced.hf2020.*;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HospitalInformationPatientAdapter extends RecyclerView.Adapter<HospitalInformationPatientAdapter.ViewHolder> {

    private List<Patient> patients;
    private Context context;

    public HospitalInformationPatientAdapter(List<Patient> patients, Context context) {
        this.patients = patients;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.patient_list_item,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Patient p = patients.get(position);
        holder.txtvPatientName.setText(p.getFirstName() + " " + p.getLastName());
        holder.txtvPatientSickness.setText(p.getCondition().getSickness());
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtvPatientName, txtvPatientSickness;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtvPatientName = itemView.findViewById(R.id.patient_list_item_txtv_name);
            txtvPatientSickness = itemView.findViewById(R.id.patient_list_item_txtv_sickness);
        }
    }
}
