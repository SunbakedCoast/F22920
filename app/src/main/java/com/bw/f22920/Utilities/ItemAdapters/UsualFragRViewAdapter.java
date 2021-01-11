package com.bw.f22920.Utilities.ItemAdapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.f22920.MainActivity;
import com.bw.f22920.Views.Fragment_Home;
import com.bw.f22920.Models.ItemModels.FragmentsUsualModels;
import com.bw.f22920.R;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.view.View.inflate;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class UsualFragRViewAdapter extends RecyclerView.Adapter <UsualFragRViewAdapter.ViewHolder>  {

    private List<FragmentsUsualModels> items;
    private Context context;


    public UsualFragRViewAdapter( Context context,List<FragmentsUsualModels> items ) {
        this.context = context;
        this.items = items;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_usual_array, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final FragmentsUsualModels arrayitems = items.get(position);
        holder.itemName.setText(arrayitems.getItemName());
        holder.price.setText(String.valueOf("$ " +arrayitems.getPrice()));
        holder.quantity.setNumber(String.valueOf(arrayitems.getQuantity()));
        holder.image.setImageResource(arrayitems.picturedata);


        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String datavalue = holder.itemName.getText().toString();
               // DatabaseReference data = FirebaseDatabase.getInstance().getReference("itemdata");
                //DatabaseReference newData = data.push();



                //if (datavalue == "potato"){
                    //newData.child("itemname").setValue(datavalue);
                //}

            }
        });

        holder.quantity.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() { //all items are located in its positions
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) { //Need to pass all non-zero items as chatview
                arrayitems.setQuantity(newValue);




                if (newValue !=0){
                    String datavalue = holder.itemName.getText().toString();
                    String dataprice = holder.price.getText().toString();
                    int dataquantity = Integer.parseInt(holder.quantity.getNumber());


                    DatabaseReference data = FirebaseDatabase.getInstance().getReference("itemdata");
                    //Map<String,Object> values = new HashMap<>();
                    //values.put("dataname", datavalue);
                    //values.put("dataprice", dataprice);
                    //values.put("dataquantity", dataquantity);
                    //data.setValue(values);



                    if (datavalue == "Potato") {
                        DatabaseReference newdata = data.child("potato");
                        newdata.child("dataname").setValue(datavalue);
                        newdata.child("dataprice").setValue(dataprice);
                        newdata.child("dataquantity").setValue(dataquantity);



                        if (newValue == 0){
                            Log.d(TAG, "data" +dataquantity);//supposed to remove the data from database when value is 0
                            newdata.removeValue();
                        }

                    }

                    if (datavalue == "Mango"){
                        DatabaseReference newdata = data.child("Mango");
                        newdata.child("dataname").setValue(datavalue);
                        newdata.child("dataprice").setValue(dataprice);
                        newdata.child("dataquantity").setValue(dataquantity);
                    }

                    if (datavalue == "Onions"){
                        DatabaseReference newdata = data.child("Onions");
                        newdata.child("dataname").setValue(datavalue);
                        newdata.child("dataprice").setValue(dataprice);
                        newdata.child("dataquantity").setValue(dataquantity);
                    }

                    if (datavalue == "Tomato"){
                        DatabaseReference newdata = data.child("Tomato");
                        newdata.child("dataname").setValue(datavalue);
                        newdata.child("dataprice").setValue(dataprice);
                        newdata.child("dataquantity").setValue(dataquantity);
                    }

                    if (datavalue == "Lettuce"){
                        DatabaseReference newdata = data.child("Lettuce");
                        newdata.child("dataname").setValue(datavalue);
                        newdata.child("dataprice").setValue(dataprice);
                        newdata.child("dataquantity").setValue(dataquantity);
                    }

                    if (datavalue == "Apple"){
                        DatabaseReference newdata = data.child("Apple");
                        newdata.child("dataname").setValue(datavalue);
                        newdata.child("dataprice").setValue(dataprice);
                        newdata.child("dataquantity").setValue(dataquantity);
                    }

                    if (datavalue == "Orange"){
                        DatabaseReference newdata = data.child("Orange");
                        newdata.child("dataname").setValue(datavalue);
                        newdata.child("dataprice").setValue(dataprice);
                        newdata.child("dataquantity").setValue(dataquantity);
                    }




                    //newData.child("dataprice").setValue(dataprice);
                    //newData.child("dataquantity").setValue(dataquantity);


                    //Log.d(TAG, "the new value of this data is: " +dataquantity);
                    //Log.d(TAG, "the itemname of this position is:  "+datavalue);
                    //Log.d(TAG, "the price of this item in this position is: " +dataprice);
                }




                Log.d(TAG, "user changed the quantity in this position to " +newValue);

            }

        });
    }




    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        ImageView image;
        TextView itemName;
        TextView price;
        ElegantNumberButton quantity;






        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.ucard);
            image = itemView.findViewById(R.id.uimage);
            itemName = itemView.findViewById(R.id.uitemName);
            price = itemView.findViewById(R.id.uprice);
            quantity = itemView.findViewById(R.id.uquantity);






        }

    }



}
