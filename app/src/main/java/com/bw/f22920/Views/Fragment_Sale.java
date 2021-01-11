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

import com.bw.f22920.Models.ItemModels.FragmentsSaleModels;
import com.bw.f22920.Models.ItemModels.FragmentsUsualModels;
import com.bw.f22920.R;
import com.bw.f22920.Utilities.ItemAdapters.SaleFragRViewAdapter;
import com.bw.f22920.Utilities.ItemAdapters.UsualFragRViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Sale extends Fragment {


    private List<FragmentsSaleModels> itemlist = new ArrayList<>();
    View view;
    ImageView backbtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_sale, container, false);


       //cards here
        execCards();

        TextView sdonebutton = view.findViewById(R.id.sdonebtn);
        final NavController navigator = Navigation.findNavController(getActivity(), R.id.fragment_host);
        sdonebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //jpack nav
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

        backbtn = view.findViewById(R.id.fragment_sale_backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_global_fragment_HomeSecond);

            }
        });

        return view;
    }

    public void execCards(){
        FragmentsSaleModels item = new FragmentsSaleModels("Polo", 10, 0, R.mipmap.polo_foreground);
        itemlist.add(item);

        item = new FragmentsSaleModels("Tshirt", 5, 0, R.mipmap.tshirt_foreground);
        itemlist.add(item);

        item = new FragmentsSaleModels("Keyboard", 15.99, 0, R.mipmap.keyboard_foreground);
        itemlist.add(item);

        item = new FragmentsSaleModels("Mousepad", 11.99, 0, R.mipmap.mousepad_foreground);
        itemlist.add(item);

        item = new FragmentsSaleModels("Mouse", 10.99, 0, R.mipmap.mouse_foreground);
        itemlist.add(item);

        item = new FragmentsSaleModels("Earphones", 59.99, 0, R.mipmap.earphones_foreground);
        itemlist.add(item);

        item = new FragmentsSaleModels("Jacket", 20.99, 0, R.mipmap.jacket_foreground);
        itemlist.add(item);

        execRecyclerView();


    }

    public void execRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.srecyclerview);
        SaleFragRViewAdapter adapter = new SaleFragRViewAdapter(getActivity(), itemlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


}
