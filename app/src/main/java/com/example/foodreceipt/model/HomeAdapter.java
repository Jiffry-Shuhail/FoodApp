package com.example.foodreceipt.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodreceipt.BillingFragment;
import com.example.foodreceipt.BillingInfoFragment;
import com.example.foodreceipt.Home;
import com.example.foodreceipt.HomeFragment;
import com.example.foodreceipt.PlaceYourCardFragment;
import com.example.foodreceipt.ProductFragment;
import com.example.foodreceipt.R;
import com.example.foodreceipt.StatusFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context context;
    private List<HomeEntity> homeEntities;
    private HomeFragment homeFragment;

    LayoutInflater inflater;

    public HomeAdapter(HomeFragment homeFragment, List<HomeEntity> homeEntities) {
        this.homeFragment=homeFragment;
        this.context = homeFragment.getContext();
        this.homeEntities = homeEntities;
        this.inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.home_grid_item, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(homeEntities.get(position).getImage());
        holder.textView.setText(homeEntities.get(position).getName());
        holder.view.setOnClickListener(v->{
            Home home = (Home) homeFragment.getActivity();
            home.setNavigationIcon(homeEntities.get(position).getNavigation());
            homeFragment.getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, homeEntities.get(position).getFragment(),null)
                .setReorderingAllowed(true)
                .addToBackStack("Home")
                .commit();
        });
    }

    @Override
    public int getItemCount() {
        return homeEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private View view;
        public ViewHolder(@Nullable View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.grid_image);
            textView = itemView.findViewById(R.id.item_name);
            view=itemView;
        }
    }
}
