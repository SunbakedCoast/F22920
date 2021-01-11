package com.bw.f22920.Views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.f22920.Models.CartModel.CartArrayModel;
import com.bw.f22920.R;
import com.bw.f22920.Utilities.CartAdapter.CartFragRViewAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetCart extends BottomSheetDialog {
    private List<CartArrayModel> itemlist = new ArrayList<>();
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottomsheet_cart, container, false);



        cart();




        return view;


    }

    public void cart(){
        final DatabaseReference data = FirebaseDatabase.getInstance().getReference("itemdata");
        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("potato")){
                    String dataname = String.valueOf(dataSnapshot.child("potato").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("potato").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("potato").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Mango")){
                    String dataname = String.valueOf(dataSnapshot.child("Mango").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Mango").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Mango").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Onions")){
                    String dataname = String.valueOf(dataSnapshot.child("Onions").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Onions").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Onions").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Tomato")){
                    String dataname = String.valueOf(dataSnapshot.child("Tomato").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Tomato").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Tomato").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Lettuce")){
                    String dataname = String.valueOf(dataSnapshot.child("Lettuce").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Lettuce").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Lettuce").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Apple")){
                    String dataname = String.valueOf(dataSnapshot.child("Apple").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Apple").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Apple").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Orange")){
                    String dataname = String.valueOf(dataSnapshot.child("Orange").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Orange").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Orange").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Polo")){
                    String dataname = String.valueOf(dataSnapshot.child("Polo").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Polo").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Polo").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Tshirt")){
                    String dataname = String.valueOf(dataSnapshot.child("Tshirt").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Tshirt").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Tshirt").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Keyboard")){
                    String dataname = String.valueOf(dataSnapshot.child("Keyboard").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Keyboard").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Keyboard").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Mousepad")){
                    String dataname = String.valueOf(dataSnapshot.child("Mousepad").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Mousepad").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Mousepad").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Mouse")){
                    String dataname = String.valueOf(dataSnapshot.child("Mouse").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Mouse").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Mouse").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Earphones")){
                    String dataname = String.valueOf(dataSnapshot.child("Earphones").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Earphones").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Earphones").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Jacket")){
                    String dataname = String.valueOf(dataSnapshot.child("Jacket").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Jacket").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Jacket").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Jeans")){
                    String dataname = String.valueOf(dataSnapshot.child("Jeans").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Jeans").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Jeans").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Shorts")){
                    String dataname = String.valueOf(dataSnapshot.child("Shorts").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Shorts").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Shorts").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Hawaiian Shirt")){
                    String dataname = String.valueOf(dataSnapshot.child("Hawaiian Shirt").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Hawaiian Shirt").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Hawaiian Shirt").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Ripped Jeans")){
                    String dataname = String.valueOf(dataSnapshot.child("Ripped Jeans").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Ripped Jeans").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Ripped Jeans").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Sandals")){
                    String dataname = String.valueOf(dataSnapshot.child("Sandals").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Sandals").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Sandals").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Banana")){
                    String dataname = String.valueOf(dataSnapshot.child("Banana").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Banana").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Banana").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Dragon Fruit")){
                    String dataname = String.valueOf(dataSnapshot.child("Dragon Fruit").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Dragon Fruit").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Dragon Fruit").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Grapes")){
                    String dataname = String.valueOf(dataSnapshot.child("Grapes").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Grapes").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Grapes").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Watermelon")){
                    String dataname = String.valueOf(dataSnapshot.child("Watermelon").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Watermelon").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Watermelon").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Egg")){
                    String dataname = String.valueOf(dataSnapshot.child("Egg").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Egg").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Egg").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Cereal")){
                    String dataname = String.valueOf(dataSnapshot.child("Cereal").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Cereal").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Cereal").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Bread")){
                    String dataname = String.valueOf(dataSnapshot.child("Bread").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Bread").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Bread").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Yogurt")){
                    String dataname = String.valueOf(dataSnapshot.child("Yogurt").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Yogurt").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Yogurt").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Cranberry Juice")){
                    String dataname = String.valueOf(dataSnapshot.child("Cranberry Juice").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Cranberry Juice").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Cranberry Juice").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Pork Ribs")){
                    String dataname = String.valueOf(dataSnapshot.child("Pork Ribs").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Pork Ribs").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Pork Ribs").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Chicken")){
                    String dataname = String.valueOf(dataSnapshot.child("Chicken").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Chicken").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Chicken").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Pork Belly")){
                    String dataname = String.valueOf(dataSnapshot.child("Pork Belly").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Pork Belly").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Pork Belly").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Beef")){
                    String dataname = String.valueOf(dataSnapshot.child("Beef").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Beef").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Beef").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Turkey")){
                    String dataname = String.valueOf(dataSnapshot.child("Turkey").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Turkey").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Turkey").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Beef Ribs")){
                    String dataname = String.valueOf(dataSnapshot.child("Beef Ribs").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Beef Ribs").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Beef Ribs").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }

                if (dataSnapshot.hasChild("Sausage")){
                    String dataname = String.valueOf(dataSnapshot.child("Sausage").child("dataname").getValue());
                    String dataprice = (String.valueOf(dataSnapshot.child("Sausage").child("dataprice").getValue()));
                    String dataquantity = (String.valueOf(dataSnapshot.child("Sausage").child("dataquantity").getValue()));


                    CartArrayModel item = new CartArrayModel(dataname, dataquantity,dataprice );
                    itemlist.add(item);
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        execRecyclerView();
    }


    public void execRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.bottom_sheet_cart_rv);
        CartFragRViewAdapter adapter = new CartFragRViewAdapter(getActivity(), itemlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
