package com.example.foodreceipt.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodreceipt.R;

public class BillingAdapter extends RecyclerView.Adapter<BillingAdapter.ViewHolder> {

    private Context context;
    private String[] text;

    LayoutInflater inflater;

    public BillingAdapter(Context context, String[] text) {
        this.context = context;
        this.text = text;
        this.inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.billing_goods, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.foodName.setText("FOOD"+(position+1));
    }

    @Override
    public int getItemCount() {
        return text.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView foodName;
        public ViewHolder(@Nullable View itemView){
            super(itemView);
            foodName = itemView.findViewById(R.id.foodName);
        }
    }
}
