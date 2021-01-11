package com.bw.f22920.Utilities.CartAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.f22920.Models.CartModel.CartArrayModel;
import com.bw.f22920.Models.CartModel.CartArrayModelHometwo;
import com.bw.f22920.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class CartFragRViewAdapterHomeTwo extends RecyclerView.Adapter<CartFragRViewAdapterHomeTwo.ViewHolder> {
    private List<CartArrayModelHometwo> items;
    private Context context;

    public CartFragRViewAdapterHomeTwo(Context context, List<CartArrayModelHometwo> items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_sheet_cart_array_hometwo, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final  CartArrayModelHometwo arrayitems = items.get(position);
        holder.itemname.setText(arrayitems.itemname);
        holder.quantity.setText(arrayitems.quantity);
        holder.price.setText(arrayitems.price);
        holder.removeitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = (String) holder.itemname.getText();
                Log.d(TAG, "pos: " +text);
                items.remove(position);
                notifyItemRemoved(position);



                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("itemdata");

                if (text == "Potato"){
                    databaseReference.child("potato").removeValue();


                }
                if (text == "Mango"){
                    databaseReference.child("Mango").removeValue();


                }

                if (text == "Onions"){
                    databaseReference.child("Onions").removeValue();


                }

                if (text == "Tomato"){
                    databaseReference.child("Tomato").removeValue();

                }

                if (text == "Lettuce"){
                    databaseReference.child("Lettuce").removeValue();

                }

                if (text == "Apple"){
                    databaseReference.child("Apple").removeValue();

                }

                if (text == "Orange"){
                    databaseReference.child("Orange").removeValue();

                }

                if (text == "Polo"){
                    databaseReference.child("Polo").removeValue();

                }

                if (text == "Tshirt"){
                    databaseReference.child("Tshirt").removeValue();

                }

                if (text == "Keyboard"){
                    databaseReference.child("Keyboard").removeValue();

                }

                if (text == "Mousepad"){
                    databaseReference.child("Mousepad").removeValue();

                }

                if (text == "Mouse"){
                    databaseReference.child("Mouse").removeValue();

                }

                if (text == "Earphones"){
                    databaseReference.child("Earphones").removeValue();

                }

                if (text == "Jacket"){
                    databaseReference.child("Jacket").removeValue();

                }

                if (text == "Jeans"){
                    databaseReference.child("Jeans").removeValue();

                }

                if (text == "Shorts"){
                    databaseReference.child("Shorts").removeValue();

                }

                if (text == "Hawaiian Shirt"){
                    databaseReference.child("Hawaiian Shirt").removeValue();

                }

                if (text == "Ripped Jeans"){
                    databaseReference.child("Ripped Jeans").removeValue();

                }

                if (text == "Sandals"){
                    databaseReference.child("Sandals").removeValue();

                }

                if (text == "Banana"){
                    databaseReference.child("Banana").removeValue();

                }

                if (text == "Dragon Fruit"){
                    databaseReference.child("Dragon Fruit").removeValue();

                }

                if (text == "Grapes"){
                    databaseReference.child("Grapes").removeValue();

                }

                if (text == "Watermelon"){
                    databaseReference.child("Watermelon").removeValue();

                }

                if (text == "Egg"){
                    databaseReference.child("Egg").removeValue();

                }

                if (text == "Cereal"){
                    databaseReference.child("Cereal").removeValue();

                }

                if (text == "Bread"){
                    databaseReference.child("Bread").removeValue();

                }

                if (text == "Yogurt"){
                    databaseReference.child("Yogurt").removeValue();

                }

                if (text == "Cranberry Juice"){
                    databaseReference.child("Cranberry Juice").removeValue();

                }

                if (text == "Pork Ribs"){
                    databaseReference.child("Pork Ribs").removeValue();

                }

                if (text == "Chicken"){
                    databaseReference.child("Chicken").removeValue();

                }

                if (text == "Pork Belly"){
                    databaseReference.child("Pork Belly").removeValue();

                }

                if (text == "Beef"){
                    databaseReference.child("Beef").removeValue();

                }

                if (text == "Turkey"){
                    databaseReference.child("Turkey").removeValue();

                }

                if (text == "Beef Ribs"){
                    databaseReference.child("Beef Ribs").removeValue();

                }

                if (text == "Sausage"){
                    databaseReference.child("Sausage").removeValue();

                }



            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    CardView card;
    TextView itemname;
    TextView quantity;
    TextView price;
    ImageView removeitem;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        card = itemView.findViewById(R.id.cart_array_card_hometwo);
        itemname = itemView.findViewById(R.id.cart_array_itemname_hometwo);
        quantity = itemView.findViewById(R.id.cart_array_quantity_hometwo);
        price = itemView.findViewById(R.id.cart_array_price_hometwo);
        removeitem = itemView.findViewById(R.id.cart_array_removeitem);



    }
}


}
