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

import com.bw.f22920.Models.ItemModels.FragmentsSaleModels;
import com.bw.f22920.Models.ItemModels.FragmentsUsualModels;
import com.bw.f22920.R;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class SaleFragRViewAdapter extends RecyclerView.Adapter<SaleFragRViewAdapter.ViewHolder> {

    private List<FragmentsSaleModels> items;
    private Context context;

    public SaleFragRViewAdapter( Context context, List<FragmentsSaleModels> items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_sale_array, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
    final FragmentsSaleModels arrayitems = items.get(position);
    holder.itemName.setText(arrayitems.getItemName());
    holder.price.setText(String.valueOf("$ " +arrayitems.getPrice()));
    holder.quantity.setNumber(String.valueOf(arrayitems.getQuantity()));
    holder.image.setImageResource(arrayitems.picturedata);

    holder.card.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "userClicked");
            Log.d(TAG, "Clicked on this position" +arrayitems);
        }
    });

    holder.quantity.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
        @Override
        public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
            arrayitems.setQuantity((newValue));

            if (newValue != 0){
                String datavalue = holder.itemName.getText().toString();
                String dataprice = holder.price.getText().toString();
                int dataquantity = Integer.parseInt(holder.quantity.getNumber());

                DatabaseReference data = FirebaseDatabase.getInstance().getReference("itemdata");

                if (datavalue == "Polo"){
                    DatabaseReference newdata = data.child("Polo");
                    newdata.child("dataname").setValue(datavalue);
                    newdata.child("dataprice").setValue(dataprice);
                    newdata.child("dataquantity").setValue(dataquantity);
                }

                if (datavalue == "Tshirt"){
                    DatabaseReference newdata = data.child("Tshirt");
                    newdata.child("dataname").setValue(datavalue);
                    newdata.child("dataprice").setValue(dataprice);
                    newdata.child("dataquantity").setValue(dataquantity);
                }

                if (datavalue == "Keyboard"){
                    DatabaseReference newdata = data.child("Keyboard");
                    newdata.child("dataname").setValue(datavalue);
                    newdata.child("dataprice").setValue(dataprice);
                    newdata.child("dataquantity").setValue(dataquantity);
                }

                if (datavalue == "Mousepad"){
                    DatabaseReference newdata = data.child("Mousepad");
                    newdata.child("dataname").setValue(datavalue);
                    newdata.child("dataprice").setValue(dataprice);
                    newdata.child("dataquantity").setValue(dataquantity);
                }

                if (datavalue == "Mouse"){
                    DatabaseReference newdata = data.child("Mouse");
                    newdata.child("dataname").setValue(datavalue);
                    newdata.child("dataprice").setValue(dataprice);
                    newdata.child("dataquantity").setValue(dataquantity);
                }

                if (datavalue == "Earphones"){
                    DatabaseReference newdata = data.child("Earphones");
                    newdata.child("dataname").setValue(datavalue);
                    newdata.child("dataprice").setValue(dataprice);
                    newdata.child("dataquantity").setValue(dataquantity);
                }

                if (datavalue == "Jacket"){
                    DatabaseReference newdata = data.child("Jacket");
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        ImageView image;
        TextView itemName;
        TextView price;
        ElegantNumberButton quantity;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        card = itemView.findViewById(R.id.scard);
        image = itemView.findViewById(R.id.simage);
        itemName = itemView.findViewById(R.id.sitemName);
        price = itemView.findViewById(R.id.sprice);
        quantity = itemView.findViewById(R.id.squantity);




    }
}
}
