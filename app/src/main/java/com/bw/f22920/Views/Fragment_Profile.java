package com.bw.f22920.Views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.f22920.Models.ProfileModels.ProfileModels;
import com.bw.f22920.R;
import com.bw.f22920.Utilities.ProfileAdapters.ProfileAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Profile extends Fragment {


    private List<ProfileModels> commentitems = new ArrayList<>();
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deliverer_profile_main, container, false);
       recyclerView = view.findViewById(R.id.fragment_deliverer_profile_main_rview);
        final NavController navigator = Navigation.findNavController(getActivity(), R.id.fragment_host);


       initComments();

        return view;



    }



    public void initComments(){
        ProfileModels comment = new ProfileModels("William Henry liked Sam Bridges", "Hey this guys is right on time!", R.mipmap.bot_icon);
        commentitems.add(comment);

        comment = new ProfileModels("Henry Williams liked Sam Bridges", "This guy is awesome!",R.mipmap.favorites_foreground);
        commentitems.add(comment);

        comment = new ProfileModels("Henry Williams liked Sam Bridges", "Kind and outgoing most of all right on time!",R.mipmap.favorites_foreground);
        commentitems.add(comment);

        comment = new ProfileModels("Henry Williams liked Sam Bridges", "Man, this guy is unbelievable I just looked at the maps earlier and it was traffic as hell I can't believe this guy made is",R.mipmap.favorites_foreground);
        commentitems.add(comment);

        comment = new ProfileModels("Henry Williams liked Sam Bridges", "I like this guy I wish he'll be my delivery guy again",R.mipmap.favorites_foreground);
        commentitems.add(comment);

        comment = new ProfileModels("Henry Williams liked Sam Bridges", "GIVE THIS GUY A 10 STAR MAN! HE DESERVE IT!",R.mipmap.favorites_foreground);
        commentitems.add(comment);

        comment = new ProfileModels("Henry Williams liked Sam Bridges", "10/10 would recommend",R.mipmap.favorites_foreground);
        commentitems.add(comment);

        comment = new ProfileModels("Henry Williams liked Sam Bridges", "DELIVERY IS ALWAYS BEEN AWESOME THIS GUY MADE IT MODE AWESOME!",R.mipmap.favorites_foreground);
        commentitems.add(comment);

        comment = new ProfileModels("Henry Williams liked Sam Bridges", "Not all heroes wear capes some are delivery guys of this app!",R.mipmap.favorites_foreground);
        commentitems.add(comment);
        initRecyclerView();
    }

    public void initRecyclerView(){
        ProfileAdapter adapter = new ProfileAdapter(getContext(), commentitems);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}
