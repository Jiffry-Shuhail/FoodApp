package com.example.foodreceipt;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodreceipt.model.BillingAdapter;
import com.example.foodreceipt.model.ProductAdapter;

public class ProductFragment extends Fragment {

    private RecyclerView productList;
    private final static String[] TEXT ={"EGG", "FISH", "CHEESE", "MEATS", "CRAB"};
    private final static int[] IMAGES={R.drawable.egg, R.drawable.fish, R.drawable.cheese, R.drawable.meats,R.drawable.crab};
    private ProductAdapter productAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productList=view.findViewById(R.id.productList);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        productList.setLayoutManager(layoutManager);
        productAdapter=new ProductAdapter(this,TEXT,IMAGES);
        productList.setAdapter(productAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product, container, false);
    }
}