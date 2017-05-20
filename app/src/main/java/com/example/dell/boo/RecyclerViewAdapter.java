package com.example.dell.boo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.boo.Model.SetDataModel;

import java.util.ArrayList;

/**
 * Created by SUMIT_THAKUR on 07/05/17.
 */

public class RecyclerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<SetDataModel>setDataModels;

    public RecyclerViewAdapter(Context context, ArrayList<SetDataModel> setDataModels) {
   this.context=context;
        this.setDataModels=setDataModels;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View convertView;
        convertView = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        SetDataModel obj = setDataModels.get(position);
        holder.tvInfo.setText(obj.getmInfo());
        holder.tvLocation.setText(obj.getmLocation());
        holder.tvPrice.setText(obj.getmReviews());
        holder.tvproduct.setText(obj.getmCityName());
        holder.tvTime.setText(obj.getmTime());
        holder.tvName.setText(obj.getmName());
    }

    @Override
    public int getItemCount() {
        return setDataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvproduct, tvLocation, tvName, tvTime, tvPrice, tvInfo;
        public ViewHolder(View itemView) {
            super(itemView);
            tvproduct = (TextView) itemView.findViewById(R.id.tvCityName);
            tvLocation = (TextView) itemView.findViewById(R.id.tvLocation);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            tvPrice = (TextView) itemView.findViewById(R.id.tvReviews);
            tvInfo = (TextView) itemView.findViewById(R.id.tvInfo);

        }
    }
}
