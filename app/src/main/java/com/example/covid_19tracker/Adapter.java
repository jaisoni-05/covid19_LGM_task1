package com.example.covid_19tracker;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    @NonNull
    private ArrayList<Model>stateArrayList;
    private Context context;

    public Adapter(@NonNull ArrayList<Model> modelArrayList, Context context) {
        this.stateArrayList = modelArrayList;
        this.context = context;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.block, parent, false);
        return new Adapter.ViewHolder(view);
    }
    
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model statemodel= stateArrayList.get(position);
        holder.nameData.setText(statemodel.getSname());
        holder.cityNameData.setText(statemodel.getDname());
        holder.RVConfirmed.setText(""+Math.toIntExact((Long) statemodel.getConfirmed()));
        holder.RVDecreased.setText(""+Math.toIntExact((Long) statemodel.getDecreased()));
        holder.RVRecovered.setText(""+Math.toIntExact((Long) statemodel.getRecovered()));
        holder.activeData.setText(""+Math.toIntExact((Long) statemodel.getActive()));
    }

    @Override
    public int getItemCount() {
        return stateArrayList.size();
    }

    public void filterList(ArrayList<Model> filteredlist) {
        stateArrayList=filteredlist;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  TextView  nameData;
        private  TextView  cityNameData;
        private final TextView activeData;
        private TextView  RVRecovered;
        private TextView  RVDecreased;
        private TextView  RVConfirmed;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            cityNameData=itemView.findViewById(R.id.idlistdistrict);
            activeData= itemView.findViewById(R.id.idActivecases);
            RVRecovered= itemView.findViewById(R.id.idRecoveredcases);
            RVDecreased= itemView.findViewById(R.id.idDecreasedcases);
            RVConfirmed= itemView.findViewById(R.id.idConfirmedcases);
            nameData= itemView.findViewById(R.id.idlistState);
        }
    }
}