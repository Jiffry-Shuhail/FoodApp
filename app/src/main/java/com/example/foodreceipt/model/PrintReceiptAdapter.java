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

import com.example.foodreceipt.ProductFragment;
import com.example.foodreceipt.R;
import com.example.foodreceipt.SingleProductFragment;

public class PrintReceiptAdapter extends RecyclerView.Adapter<PrintReceiptAdapter.ViewHolder> {

    private Context context;
    private String[] text;

    private LayoutInflater inflater;

    public PrintReceiptAdapter(Context context, String[] text) {
        this.context = context;
        this.text = text;
        this.inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.invoice_items, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.number.setText((position+1)+"");
    }

    @Override
    public int getItemCount() {
        return text.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView number,productName,qty,unit;
        public ViewHolder(@Nullable View itemView){
            super(itemView);
            number = itemView.findViewById(R.id.number);
            productName = itemView.findViewById(R.id.productName);
            qty = itemView.findViewById(R.id.qty);
            unit = itemView.findViewById(R.id.unit);
        }
    }
}
