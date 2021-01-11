package com.bw.f22920.Utilities.ProfileAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.f22920.Models.ProfileModels.ProfileModels;
import com.bw.f22920.R;

import org.w3c.dom.Text;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    private List<ProfileModels> items;
    private Context context;

    public ProfileAdapter(Context context,List<ProfileModels> items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_profile_comments_array, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProfileModels arrayitems = items.get(position);

        holder.image.setImageResource(arrayitems.profilepic);
        holder.name.setText(arrayitems.name);
        holder.comment.setText(arrayitems.comment);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView name;
        TextView comment;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.view_profile_comments_array_profilepic);
            name = itemView.findViewById(R.id.view_profile_comments_array_name);
            comment = itemView.findViewById(R.id.view_profile_comments_array_comment_text);
        }
    }
}
