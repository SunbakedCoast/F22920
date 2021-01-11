package com.bw.f22920.Views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.f22920.Models.ItemModels.FragmentMeatModels;
import com.bw.f22920.R;
import com.bw.f22920.Utilities.ItemAdapters.MeatFragRViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Meat extends Fragment {
    private List<FragmentMeatModels> itemlist = new ArrayList<>();
    View view;
    ImageView backbtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_meat, container, false);


        execCards();

        TextView donebtn = view.findViewById(R.id.mdonebtn);
        final NavController navigator = Navigation.findNavController(getActivity(), R.id.fragment_host);
        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_global_fragment_HomeSecond);
            }
        });

        OnBackPressedCallback back = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navigator.navigate(R.id.action_global_fragment_HomeSecond);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, back);

        backbtn = view.findViewById(R.id.fragment_meat_backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_global_fragment_HomeSecond);

            }
        });

        return view;
    }

    public void execCards(){
        FragmentMeatModels item = new FragmentMeatModels("Pork Ribs", 10.99, 0, R.mipmap.porkribs_foreground);
        itemlist.add(item);

        item = new FragmentMeatModels("Chicken", 6.99, 0, R.mipmap.chicken_foreground);
        itemlist.add(item);

        item = new FragmentMeatModels("Pork Belly", 10.99, 0, R.mipmap.porkbelly_foreground);
        itemlist.add(item);

        item = new FragmentMeatModels("Beef", 15.99, 0, R.mipmap.beef_foreground);
        itemlist.add(item);

        item = new FragmentMeatModels("Turkey", 20.99, 0, R.mipmap.turkey_foreground);
        itemlist.add(item);

        item = new FragmentMeatModels("Beef Ribs", 15.99, 0, R.mipmap.beefribs_foreground);
        itemlist.add(item);

        item = new FragmentMeatModels("Sausage", 6.99, 0, R.mipmap.sausage_foreground);
        itemlist.add(item);


        execRecyclerView();
    }

    public void execRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.mrecyclerview);
        MeatFragRViewAdapter adapter = new MeatFragRViewAdapter(getActivity(), itemlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
