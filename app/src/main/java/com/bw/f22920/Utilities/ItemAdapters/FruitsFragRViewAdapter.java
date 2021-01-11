package com.bw.f22920.Utilities.ItemAdapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.f22920.Models.ItemModels.FragmentsFruitsModels;
import com.bw.f22920.R;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FruitsFragRViewAdapter extends RecyclerView.Adapter <FruitsFragRViewAdapter.ViewHolder> {

    private List<FragmentsFruitsModels> items;
    private Context context;

    public FruitsFragRViewAdapter(Context context,List<FragmentsFruitsModels> items ) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_fruits_array, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final FragmentsFruitsModels arrayitems = items.get(position);
        holder.itemName.setText(arrayitems.getItemName());
        holder.price.setText(String.valueOf("$ " +arrayitems.getPrice()));
        holder.quantity.setNumber(String.valueOf(arrayitems.getQuantity()));
        holder.image.setImageResource(arrayitems.picturedata);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "userClicked");
                Log.d(TAG, "Clicked in this position: " +arrayitems);
            }
        });

        holder.quantity.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                arrayitems.setQuantity(newValue);

                if (newValue !=0){
                    String datavalue = holder.itemName.getText().toString();
                    String dataprice = holder.price.getText().toString();
                    int dataquantity = Integer.parseInt(holder.quantity.getNumber());

                    DatabaseReference data = FirebaseDatabase.getInstance().getReference("itemdata");

                    if (datavalue == "Banana"){
                        DatabaseReference newdata = data.child("Banana");
                        newdata.child("dataname").setValue(datavalue);
                        newdata.child("dataprice").setValue(dataprice);
                        newdata.child("dataquantity").setValue(dataquantity);
                    }

                    if (datavalue == "Mango"){
                        DatabaseReference newdata = data.child("Mango");
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

                    if (datavalue == "Dragon Fruit"){
                        DatabaseReference newdata = data.child("Dragon Fruit");
                        newdata.child("dataname").setValue(datavalue);
                        newdata.child("dataprice").setValue(dataprice);
                        newdata.child("dataquantity").setValue(dataquantity);
                    }

                    if (datavalue == "Grapes"){
                        DatabaseReference newdata = data.child("Grapes");
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

                    if (datavalue == "Watermelon"){
                        DatabaseReference newdata = data.child("Watermelon");
                        newdata.child("dataname").setValue(datavalue);
                        newdata.child("dataprice").setValue(dataprice);
                        newdata.child("dataquantity").setValue(dataquantity);
                    }

                    Log.d(TAG, "the new value of this data is: " +dataquantity);
                    Log.d(TAG, "the itemname of this position is:  "+datavalue);
                    Log.d(TAG, "the price of this item in this position is: " +dataprice);
                }

                Log.d(TAG, "user changed the quantity in this position to " +arrayitems);

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        ImageView image;
        TextView itemName;
        TextView price;
        ElegantNumberButton quantity;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.fcard);
            image = itemView.findViewById(R.id.fimage);
            itemName = itemView.findViewById(R.id.fitemName);
            price = itemView.findViewById(R.id.fprice);
            quantity = itemView.findViewById(R.id.fquantity);
        }
    }

}
