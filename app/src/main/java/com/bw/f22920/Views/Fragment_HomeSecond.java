package com.bw.f22920.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.f22920.MainActivity;
import com.bw.f22920.Models.MessagingModels.MultiViewTypeModel;
import com.bw.f22920.R;
import com.bw.f22920.Utilities.MessagingAdapters.MultiViewTypeAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Fragment_HomeSecond extends Fragment {

    private ArrayList<MultiViewTypeModel> msgitems = new ArrayList<>();
    TextView buttonOpenSheet;
    RecyclerView recyclerView;
    ImageView carthomesec;
    ConstraintLayout sbuttonlayout;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homesecond, container, false);
        buttonOpenSheet = view.findViewById(R.id.stapheretorep);
        recyclerView = view.findViewById(R.id.srView);
        carthomesec = view.findViewById(R.id.cart_homesecond);
        sbuttonlayout = view.findViewById(R.id.sbuttonlayout);

        carthomesec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.bottomSheetCartHomeTwo);

            }
        });

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("itemdata");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    carthomesec.setVisibility(View.VISIBLE);
                } else {
                    carthomesec.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        final NavController navigator = Navigation.findNavController(getActivity(), R.id.fragment_host);


        OnBackPressedCallback back = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);

            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, back);
        Messages();


        buttonOpenSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_fragment_HomeSecond_to_bottomSheetDialog);
            }
        });

        sbuttonlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_fragment_HomeSecond_to_bottomSheetDialog);

            }
        });

        return view;
    }


    public void Messages(){
        msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.BOT_FIRST_MESSAGE_AUTOMATED, "Hello what will be your to do today?",0 ));












        execMessageItems();
    }

    public void execMessageItems(){
        MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(getActivity(), msgitems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }
}
