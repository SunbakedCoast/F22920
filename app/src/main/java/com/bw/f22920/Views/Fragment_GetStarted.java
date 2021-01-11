package com.bw.f22920.Views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bw.f22920.R;

public class Fragment_GetStarted extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_getstarted, container, false);

        //Views
        final Button getstartedbtn = view.findViewById(R.id.getstartedbtn);



        final NavController navigator = Navigation.findNavController(getActivity(),R.id.fragment_host);

        getstartedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_global_fragment_HomeSecond);
            }
        });

        return view;

    }
}
