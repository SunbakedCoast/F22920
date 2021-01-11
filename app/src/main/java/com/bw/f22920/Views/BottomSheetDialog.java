package com.bw.f22920.Views;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bw.f22920.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.bottom_sheet, container, false);
        //Views
        ImageView usual = view.findViewById(R.id.usual);
        ImageView sale = view.findViewById(R.id.sale);
        ImageView clothes = view.findViewById(R.id.clothes);
        ImageView fruits = view.findViewById(R.id.fruits);
        ImageView coles = view.findViewById(R.id.coles);
        ImageView meat = view.findViewById(R.id.meat);
        final NavController navigator = Navigation.findNavController(getActivity(), R.id.fragment_host);

        usual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navigator.navigate(R.id.action_bottomSheetDialog_to_usualFrag);
                Log.d(TAG, "user clicked" );
            }
        });

        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_bottomSheetDialog_to_fragment_Sale);
            }
        });

        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_bottomSheetDialog_to_fragment_Clothes);
            }
        });

        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_bottomSheetDialog_to_fragment_Fruits);
            }
        });

        coles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_bottomSheetDialog_to_fragment_Coles);
            }
        });

        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigate(R.id.action_bottomSheetDialog_to_fragment_Meat);
            }
        });
        return view;
    }
}
