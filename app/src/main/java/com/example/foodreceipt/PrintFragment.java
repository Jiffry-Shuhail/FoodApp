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

import com.example.foodreceipt.model.PrintReceiptAdapter;


public class PrintFragment extends Fragment {

    private RecyclerView productList;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productList=view.findViewById(R.id.productList);
        productList.setLayoutManager(new LinearLayoutManager(getContext()));
        productList.setAdapter(new PrintReceiptAdapter(getContext(),new String[5]));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_print, container, false);
    }
}