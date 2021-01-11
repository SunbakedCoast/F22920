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

import com.bw.f22920.Models.ItemModels.FragmentsClothesModels;
import com.bw.f22920.R;
import com.bw.f22920.Utilities.ItemAdapters.ClothesFragRViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Clothes extends Fragment {

    private List<FragmentsClothesModels> itemlist = new ArrayList<>();
    View view;
    ImageView backbtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_clothes, container, false);

        //cards here
        execCards();


        TextView donebtn = view.findViewById(R.id.cdonebtn);
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

        backbtn = view.findViewById(R.id.fragment_clothes_backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_global_fragment_HomeSecond);
            }
        });

        return view;
    }

    public void execCards(){
        FragmentsClothesModels item = new FragmentsClothesModels("Polo", 10.55, 0, R.mipmap.polo_foreground);
        itemlist.add(item);

        item = new FragmentsClothesModels("Jeans", 20.99, 0, R.mipmap.jeans_foreground);
        itemlist.add(item);

        item = new FragmentsClothesModels("Shorts", 10.99, 0, R.mipmap.short_foreground);
        itemlist.add(item);

        item = new FragmentsClothesModels("Hawaiian Shirt", 15.99, 0, R.mipmap.hawshirt_foreground);
        itemlist.add(item);

        item = new FragmentsClothesModels("Ripped Jeans", 25.99, 0, R.mipmap.rippedjeans_foreground);
        itemlist.add(item);

        item = new FragmentsClothesModels("Sandals", 29.99, 0, R.mipmap.sandals_foreground);
        itemlist.add(item);

        item = new FragmentsClothesModels("Jacket", 25.99, 0, R.mipmap.jacket_foreground);
        itemlist.add(item);

        execRecyclerView();
    }

    public void execRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.crecyclerview);
        ClothesFragRViewAdapter adapter = new ClothesFragRViewAdapter(getActivity(), itemlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

}
