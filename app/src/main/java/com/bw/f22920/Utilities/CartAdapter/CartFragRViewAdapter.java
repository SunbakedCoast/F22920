package com.bw.f22920.Utilities.CartAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.f22920.Models.CartModel.CartArrayModel;
import com.bw.f22920.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class CartFragRViewAdapter extends RecyclerView.Adapter<CartFragRViewAdapter.ViewHolder> {
    private List<CartArrayModel> items;
    private Context context;

    public CartFragRViewAdapter(Context context, List<CartArrayModel> items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_sheet_cart_array, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final CartArrayModel arrayitems = items.get(position);
        holder.itemname.setText(arrayitems.itemName);
        holder.quantity.setText(arrayitems.quantity);
        holder.price.setText(arrayitems.price);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        TextView itemname;
        TextView quantity;
        TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cart_array_card);
            itemname = itemView.findViewById(R.id.cart_array_itemname);
            quantity = itemView.findViewById(R.id.cart_array_quantity);
            price = itemView.findViewById(R.id.cart_array_price);
        }
    }
}
