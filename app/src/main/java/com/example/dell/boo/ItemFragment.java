package com.example.dell.boo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.boo.Model.SetDataModel;

import java.util.ArrayList;

/**
 * Created by SUMIT_THAKUR on 06/05/17.
 */

public class ItemFragment extends Fragment {
    private ArrayList<SetDataModel> setDataModels;
    private RecyclerView recyclerView;
    private SetDataModel setDataModel;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item, container, false);
        setDataModels = new ArrayList<>();
        init(view);
        setDataModels.add(setDataModel);
        setDataModels.add(setDataModel);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), setDataModels);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        return view;
    }

    private void init(View view){
        setDataModel = new SetDataModel("iPhone6s", "Delhi", "Apple Authorised Dealers", "6d 2h left",
                "Rs. 37000/-", "iphone 6 is'nt simply bigger it's better in everyDay"
                + "The biggest iOS release ever.");
        recyclerView = (RecyclerView) view.findViewById(R.id.rvHome);

    }
}
