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
import android.widget.Button;

import com.example.foodreceipt.model.BillingAdapter;

public class BillingFragment extends Fragment {

    private RecyclerView goodsView;
    private BillingAdapter billingAdapter;
    private Button submit;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        goodsView=view.findViewById(R.id.goodsView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        goodsView.setLayoutManager(layoutManager);
        billingAdapter=new BillingAdapter(getContext(),new String[3]);
        goodsView.setAdapter(billingAdapter);
        submit=view.findViewById(R.id.submit);
        submit.setOnClickListener(v->((Home)getActivity()).changeFragment(PrintFragment.class));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_billing, container, false);
    }
}