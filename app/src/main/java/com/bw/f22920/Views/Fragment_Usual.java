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

import com.bw.f22920.MainActivity;
import com.bw.f22920.Models.ItemModels.FragmentsUsualModels;
import com.bw.f22920.R;
import com.bw.f22920.Utilities.ItemAdapters.UsualFragRViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Usual extends Fragment {

    private List<FragmentsUsualModels> itemslist = new ArrayList<>();
    View view;
    TextView donebtn;
    ImageView backbtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         view = inflater.inflate(R.layout.fragment_usual, container, false);

         donebtn = view.findViewById(R.id.udonebtn);
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

        backbtn = view.findViewById(R.id.fragment_usual_backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_global_fragment_HomeSecond);
            }
        });

         //receive data from adapter

        //receive data from adapter

        execCards();

        return view;

    }

    public void execCards(){
        FragmentsUsualModels item = new FragmentsUsualModels("Potato",  3.55,  0, R.mipmap.potato_foreground);
        itemslist.add(item);


        item = new FragmentsUsualModels("Mango", 1.99, 0, R.mipmap.mango_foreground );
        itemslist.add(item);

        item = new FragmentsUsualModels("Onions", 1.99, 0, R.mipmap.onions_foreground);
        itemslist.add(item);

        item = new FragmentsUsualModels("Tomato",  2.99, 0, R.mipmap.tomato_foreground);
        itemslist.add(item);

        item = new FragmentsUsualModels("Lettuce",  3.99, 0, R.mipmap.lettuce_foreground);
        itemslist.add(item);

        item = new FragmentsUsualModels("Apple",  4.99, 0, R.mipmap.apple_foreground);
        itemslist.add(item);

        item = new FragmentsUsualModels("Orange",  2.99, 0, R.mipmap.orange_foreground);
        itemslist.add(item);





        execRecyclerView();

    }

    public void execRecyclerView () {

        RecyclerView recyclerView = view.findViewById(R.id.urecyclerview);
        UsualFragRViewAdapter adapter = new UsualFragRViewAdapter(getActivity(), itemslist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    }

    public void donebtnmsg(){

    }

}
