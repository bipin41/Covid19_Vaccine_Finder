package com.example.covid_19vaccinefinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class resultListAdapter extends RecyclerView.Adapter<resultListAdapter.resultListViewHolder> {

    private Context context;
    private final ArrayList<objectData> list;

    public resultListAdapter(Context context, ArrayList<objectData> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public resultListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.object_layout, parent, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layout_view.setLayoutParams(params);
        resultListAdapter.resultListViewHolder rv = new resultListAdapter.resultListViewHolder(layout_view);
        return rv;
    }

    @Override
    public void onBindViewHolder(@NonNull resultListViewHolder holder, int position) {
        holder.tvCenter.setText(list.get(position).getCenterName());
        holder.tvDate.setText(list.get(position).getDate());
        holder.tvAddress.setText(list.get(position).getAddress() + "\n" + list.get(position).getPincode() + ", " + list.get(position).getDistrictName() + ", " + list.get(position).getStateName());
        holder.tvAge.setText(list.get(position).getAgeLimit() + "+");
        holder.tvAvailableCap.setText("Total: " + list.get(position).getAvailableCapacity()+ "\nDose 1: " + list.get(position).getDose1() + "\nDose 2: " + list.get(position).getDose2());
        holder.tvFeeType.setText(list.get(position).getFeeType());
        holder.tvFee.setText("Rs."+ list.get(position).getFee());
        holder.tvVaccine.setText(list.get(position).getVaccine());
        holder.tvTime.setText(list.get(position).getTimingFrom()+ " - " + list.get(position).getTimingTo());
        holder.tvSlots.setText(list.get(position).getSlots());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class resultListViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvCenter, tvDate, tvAddress, tvAge, tvAvailableCap, tvFeeType, tvFee, tvVaccine, tvTime, tvSlots;
        public resultListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCenter = itemView.findViewById(R.id.tvCenter);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvAvailableCap = itemView.findViewById(R.id.tvAvailableCap);
            tvFeeType = itemView.findViewById(R.id.tvFeeType);
            tvFee = itemView.findViewById(R.id.tvFee);
            tvVaccine = itemView.findViewById(R.id.tvVaccine);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvSlots = itemView.findViewById(R.id.tvSlots);
        }
    }
}
