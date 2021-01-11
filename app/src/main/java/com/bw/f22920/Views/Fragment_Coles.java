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

import com.bw.f22920.Models.ItemModels.FragmentColesModels;
import com.bw.f22920.Models.ItemModels.FragmentsClothesModels;
import com.bw.f22920.R;
import com.bw.f22920.Utilities.ItemAdapters.ColesFragRViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Coles extends Fragment {

    private List<FragmentColesModels> itemlist = new ArrayList<>();
    View view;
    ImageView backbtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_coles, container, false);

        execCards();

        TextView donebtn = view.findViewById(R.id.clsdonebtn);
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

        backbtn = view.findViewById(R.id.fragment_coles_backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_global_fragment_HomeSecond);
            }
        });

        return view;
    }

    public void execCards(){
        FragmentColesModels item = new FragmentColesModels("Egg", 1.99, 0,R.mipmap.egg_foreground);
        itemlist.add(item);

        item = new FragmentColesModels("Onions", 1.99, 0, R.mipmap.onions_foreground);
        itemlist.add(item);

        item = new FragmentColesModels("Tomato", 1.99, 0, R.mipmap.tomato_foreground);
        itemlist.add(item);

        item = new FragmentColesModels("Cereal", 4.99, 0, R.mipmap.cereal_foreground);
        itemlist.add(item);

        item = new FragmentColesModels("Bread", 2.99, 0, R.mipmap.bread_foreground);
        itemlist.add(item);

        item = new FragmentColesModels("Yogurt", 1.99, 0,R.mipmap.yogurt_foreground);
        itemlist.add(item);

        item = new FragmentColesModels("Cranberry Juice", 3.99, 0, R.mipmap.cranberry_foreground);
        itemlist.add(item);

        execRecyclerView();
    }

    public void execRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.clsrecyclerview);
        ColesFragRViewAdapter adapter = new ColesFragRViewAdapter(getActivity(), itemlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
