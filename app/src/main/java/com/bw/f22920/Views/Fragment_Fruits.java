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

import com.bw.f22920.Models.ItemModels.FragmentsFruitsModels;
import com.bw.f22920.R;
import com.bw.f22920.Utilities.ItemAdapters.FruitsFragRViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Fruits extends Fragment {

    private List<FragmentsFruitsModels> itemlist = new ArrayList<>();
    View view;
    ImageView backbtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fruits, container, false);

        execCards();

        TextView donebtn = view.findViewById(R.id.fdonebtn);
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

        backbtn = view.findViewById(R.id.fragment_fruits_backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_global_fragment_HomeSecond);

            }
        });

        return view;
    }

    public void execCards(){
        FragmentsFruitsModels item = new FragmentsFruitsModels("Banana", 2.99, 0, R.mipmap.banana_foreground);
        itemlist.add(item);

        item = new FragmentsFruitsModels("Mango", 2.99, 0,R.mipmap.mango_foreground);
        itemlist.add(item);

        item = new FragmentsFruitsModels("Apple", 99.99, 0, R.mipmap.apple_foreground);
        itemlist.add(item);

        item = new FragmentsFruitsModels("Dragon Fruit", 5.99, 0, R.mipmap.dragonfruit_foreground);
        itemlist.add(item);

        item = new FragmentsFruitsModels("Grapes", 4.99, 0, R.mipmap.grapes_foreground);
        itemlist.add(item);

        item = new FragmentsFruitsModels("Orange", 4.99, 0, R.mipmap.orange_foreground);
        itemlist.add(item);

        item = new FragmentsFruitsModels("Watermelon", 5.99, 0, R.mipmap.watermelon_foreground);
        itemlist.add(item);


        execRecyclerView();
    }

    public void execRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.frecyclerview);
        FruitsFragRViewAdapter adapter = new FruitsFragRViewAdapter(getActivity(), itemlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
