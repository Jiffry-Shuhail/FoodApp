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

import com.example.foodreceipt.Home;
import com.example.foodreceipt.PlaceYourCardFragment;
import com.example.foodreceipt.ProductFragment;
import com.example.foodreceipt.R;
import com.example.foodreceipt.SingleProductFragment;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private String[] text;
    private int[] image;
    private ProductFragment productFragment;

    private LayoutInflater inflater;

    public ProductAdapter(ProductFragment productFragment, String[] text, int[] image) {
        this.productFragment=productFragment;
        this.context = productFragment.getContext();
        this.text = text;
        this.image = image;
        this.inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.product_items, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productImage.setImageResource(image[position]);
        holder.productName.setText(text[position]);
        holder.number.setText((position+1)+"");
    }

    @Override
    public int getItemCount() {
        return text.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView productImage;
        private TextView number,productName;
        public ViewHolder(@Nullable View itemView){
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            number = itemView.findViewById(R.id.number);
            productName = itemView.findViewById(R.id.productName);

//            itemView.setOnClickListener(v->((Home)productFragment.getActivity()).changeFragment(SingleProductFragment.class));
        }
    }
}
