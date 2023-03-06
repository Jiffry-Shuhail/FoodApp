package com.example.foodreceipt;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.foodreceipt.model.HomeAdapter;
import com.example.foodreceipt.model.HomeEntity;
import java.util.Arrays;

public class HomeFragment extends Fragment {

    private final static HomeEntity HOME_ENTITIES[]= {
            new HomeEntity(R.drawable.home_billing,"BILLING",R.id.billing,PlaceYourCardFragment.class),
            new HomeEntity(R.drawable.home_bill_info,"BILL INFO",R.id.billInfo,BillingInfoFragment.class),
            new HomeEntity(R.drawable.home_product,"PRODUCT",R.id.placeholder,ProductFragment.class),
            new HomeEntity(R.drawable.iwwa_chart,"STATUS",R.id.status,StatusFragment.class),
    };
    private RecyclerView gridView;

    private HomeAdapter homeAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView=view.findViewById(R.id.gridView);
        homeAdapter=new HomeAdapter(this,Arrays.asList(HOME_ENTITIES));
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        gridView.setLayoutManager(gridLayoutManager);
        gridView.setAdapter(homeAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}