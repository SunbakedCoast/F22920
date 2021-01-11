package com.bw.f22920.Utilities.MessagingAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.f22920.Models.MessagingModels.MultiViewTypeModel;
import com.bw.f22920.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import me.himanshusoni.chatmessageview.ChatMessageView;

public class MultiViewTypeAdapter extends RecyclerView.Adapter {
   private ArrayList<MultiViewTypeModel> dataset;
   Context context;
   int total_types;

   public static class BotFirstMsgAutoTypeViewHolder extends RecyclerView.ViewHolder{
       ChatMessageView bubble;
       TextView text;


       public BotFirstMsgAutoTypeViewHolder(@NonNull View itemView) {
           super(itemView);
           bubble = itemView.findViewById(R.id.bot_first_message_automated_bubble);
           text = itemView.findViewById(R.id.bot_first_message_automated_text);
       }
   }

   public static class UserRepMiniCartAutoTypeViewHolder extends RecyclerView.ViewHolder{
        ChatMessageView bubble;
        LinearLayout itemlist;


       public UserRepMiniCartAutoTypeViewHolder(@NonNull View itemView) {
           super(itemView);
           bubble = itemView.findViewById(R.id.user_reply_minicart_automated_bubble);
           itemlist =itemView.findViewById(R.id.user_reply_minicart_automated_itemlist);

       }
   }

   public static class BotReplyAutomatedAutoTypeViewHolder extends RecyclerView.ViewHolder {
        ChatMessageView bubble;
        TextView text;
        CircleImageView image;
        TextView name;
        ConstraintLayout parentlayout;

       public BotReplyAutomatedAutoTypeViewHolder(@NonNull View itemView) {
           super(itemView);
           bubble = itemView.findViewById(R.id.bot_reply_automated_personalize_bubble);
           text = itemView.findViewById(R.id.bot_reply_automated_personalize_text);

           image = itemView.findViewById(R.id.bot_reply_automated_personalize_profilepic);
           name = itemView.findViewById(R.id.bot_reply_automated_personalize_name);
           parentlayout = itemView.findViewById(R.id.bot_reply_automated_parentlayout);
       }
   }

   public static class BotReplyTwoOptionsTypeViewHolder extends RecyclerView.ViewHolder{
        ChatMessageView bubble;
        TextView text;
        CircleImageView image;
        TextView name;
        ConstraintLayout parentlayout;

       public BotReplyTwoOptionsTypeViewHolder(@NonNull View itemView) {
           super(itemView);
           bubble = itemView.findViewById(R.id.bot_reply_twooptions_bubble);
           text = itemView.findViewById(R.id.bot_reply_twooptions_text);
           image = itemView.findViewById(R.id.bot_reply_twooptions_profilepic);
           name = itemView.findViewById(R.id.bot_reply_twooptions_name);
           parentlayout = itemView.findViewById(R.id.bot_reply_twooptions_parentlayout);
       }
   }

    public static class DelivererJoinedTypeViewHolder extends RecyclerView.ViewHolder{
        TextView text;

        public DelivererJoinedTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.deliverer_joined_text);
        }
    }

    public static class ProfilePreviewTypeViewHolder extends RecyclerView.ViewHolder{
       CardView card;
       TextView text;
       ImageView image;
       CardView cardtoclick;

        public ProfilePreviewTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.profile_preview_cardview);
            text = itemView.findViewById(R.id.profile_preview_text);
            image = itemView.findViewById(R.id.profile_preview_image);
            cardtoclick = itemView.findViewById(R.id.profile_preview_cardtoclick);
        }
    }

    public static class DelivererReplyTypeViewHolder extends RecyclerView.ViewHolder {
       ChatMessageView bubble;
       TextView text;
       CircleImageView image;
       TextView name;
       ConstraintLayout parentlayout;

        public DelivererReplyTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            bubble = itemView.findViewById(R.id.deliverer_reply_bubble);
            text = itemView.findViewById(R.id.deliverer_reply_text);
            image = itemView.findViewById(R.id.deliverer_reply_profilepic);
            name = itemView.findViewById(R.id.deliverer_reply_name);
            parentlayout = itemView.findViewById(R.id.deliverer_reply_parentlayout);
        }
    }

    public static class UserReplySendTypeViewHolder extends RecyclerView.ViewHolder{
       ChatMessageView bubble;
       TextView text;


        public UserReplySendTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            bubble = itemView.findViewById(R.id.user_reply_send_bubble);
            text = itemView.findViewById(R.id.user_reply_send_text);
        }
    }

    public static class DelivererTrackMeTypeViewHolder extends RecyclerView.ViewHolder {
        ChatMessageView bubble;
        TextView text;
        CircleImageView image;
        TextView name;
        ConstraintLayout parentlayout;

        public DelivererTrackMeTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            bubble = itemView.findViewById(R.id.deliverer_track_me_bubble);
            text = itemView.findViewById(R.id.deliverer_track_me_text);
            image = itemView.findViewById(R.id.deliverer_track_me_profilepic);
            name = itemView.findViewById(R.id.deliverer_track_me_name);
            parentlayout = itemView.findViewById(R.id.deliverer_track_me_parentlayout);
        }
    }



    public MultiViewTypeAdapter(Context context, ArrayList<MultiViewTypeModel> dataset) {
        this.dataset = dataset;
        this.context = context;
        total_types = dataset.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case MultiViewTypeModel.BOT_FIRST_MESSAGE_AUTOMATED:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_first_message_automated, parent, false);
                return new BotFirstMsgAutoTypeViewHolder(view);

            case MultiViewTypeModel.USER_REPLY_MINICART_AUTOMATED:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_reply_minicart_automated, parent, false);
                return new UserRepMiniCartAutoTypeViewHolder(view);

            case MultiViewTypeModel.BOT_REPLY_AUTOMATED_PERSONALIZE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_reply_automated_personalize, parent, false);
                return new BotReplyAutomatedAutoTypeViewHolder(view);

            case MultiViewTypeModel.BOT_REPLY_TWOOPTIONS:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_reply_twooptions,parent, false);
                return new BotReplyTwoOptionsTypeViewHolder(view);

            case MultiViewTypeModel.DELIVERER_JOINED:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deliverer_joined, parent, false);
                return new DelivererJoinedTypeViewHolder(view);

            case MultiViewTypeModel.PROFILE_PREVIEW:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_preview, parent, false);
                return new ProfilePreviewTypeViewHolder(view);

            case MultiViewTypeModel.DELIVERER_REPLY:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deliverer_reply, parent, false);
                return new DelivererReplyTypeViewHolder(view);

            case MultiViewTypeModel.USER_REPLY_SEND:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_reply_send, parent, false);
                return new UserReplySendTypeViewHolder(view);

            case MultiViewTypeModel.DELIVERER_TRACK_ME:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deliverer_track_me, parent, false);
                return new DelivererTrackMeTypeViewHolder(view);


        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        switch (dataset.get(position).type){
            case 0:
                return MultiViewTypeModel.BOT_FIRST_MESSAGE_AUTOMATED;
            case 1:
                return MultiViewTypeModel.USER_REPLY_MINICART_AUTOMATED;
            case 2:
                return MultiViewTypeModel.BOT_REPLY_AUTOMATED_PERSONALIZE;
            case 3:
                return MultiViewTypeModel.BOT_REPLY_TWOOPTIONS;
            case 4:
                return MultiViewTypeModel.DELIVERER_JOINED;
            case 5:
                return MultiViewTypeModel.PROFILE_PREVIEW;
            case 6:
                return MultiViewTypeModel.DELIVERER_REPLY;
            case 7:
                return MultiViewTypeModel.USER_REPLY_SEND;
            case 8:
                return MultiViewTypeModel.DELIVERER_TRACK_ME;
                default:
                    return -1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        MultiViewTypeModel object = dataset.get(position);
        final DatabaseReference data = FirebaseDatabase.getInstance().getReference("itemdata");
        if (object != null){
            switch (object.type){
                case MultiViewTypeModel.BOT_FIRST_MESSAGE_AUTOMATED:
                    ((BotFirstMsgAutoTypeViewHolder) holder).text.setText(object.text);

                    break;

                case MultiViewTypeModel.USER_REPLY_MINICART_AUTOMATED:
                    ((UserRepMiniCartAutoTypeViewHolder) holder).bubble.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Navigation.findNavController(v).navigate(R.id.bottomSheetCart);

                        }
                    });

                    final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
                    );
                    data.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()){
                                ((UserRepMiniCartAutoTypeViewHolder) holder).bubble.setVisibility(View.VISIBLE);
                            }


                            //Favorites
                            if (dataSnapshot.hasChild("potato")){
                                String dataname = String.valueOf(dataSnapshot.child("potato").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("potato").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }
                            if (dataSnapshot.hasChild("Mango")){
                                String dataname = String.valueOf(dataSnapshot.child("Mango").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Mango").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Onions")){
                                String dataname  = String.valueOf(dataSnapshot.child("Onions").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Onions").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Tomato")){
                                String dataname = String.valueOf(dataSnapshot.child("Tomato").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Tomato").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Lettuce")){
                                String dataname = String.valueOf(dataSnapshot.child("Lettuce").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Lettuce").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Apple")){
                                String dataname = String.valueOf(dataSnapshot.child("Apple").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Apple").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Orange")){
                                String dataname = String.valueOf(dataSnapshot.child("Orange").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Orange").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            //Sale


                            if (dataSnapshot.hasChild("Polo")){
                                String dataname = String.valueOf(dataSnapshot.child("Polo").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Polo").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Tshirt")){
                                String dataname = String.valueOf(dataSnapshot.child("Tshirt").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Tshirt").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Keyboard")){
                                String dataname = String.valueOf(dataSnapshot.child("Keyboard").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Keyboard").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Mousepad")){
                                String dataname = String.valueOf(dataSnapshot.child("Mousepad").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Mousepad").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Mouse")){
                                String dataname = String.valueOf(dataSnapshot.child("Mouse").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Mouse").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Earphones")){
                                String dataname = String.valueOf(dataSnapshot.child("Earphones").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Earphones").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Jacket")){
                                String dataname = String.valueOf(dataSnapshot.child("Jacket").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Jacket").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            //Clothes

                            if (dataSnapshot.hasChild("Jeans")){
                                String dataname = String.valueOf(dataSnapshot.child("Jeans").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Jeans").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Shorts")){
                                String dataname = String.valueOf(dataSnapshot.child("Shorts").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Shorts").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Hawaiian Shirt")){
                                String dataname = String.valueOf(dataSnapshot.child("Hawaiian Shirt").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Hawaiian Shirt").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Ripped Jeans")){
                                String dataname = String.valueOf(dataSnapshot.child("Ripped Jeans").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Ripped Jeans").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Sandals")){
                                String dataname = String.valueOf(dataSnapshot.child("Sandals").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Sandals").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Banana")){
                                String dataname = String.valueOf(dataSnapshot.child("Banana").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Banana").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Dragon Fruit")){
                                String dataname = String.valueOf(dataSnapshot.child("Dragon Fruit").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Dragon Fruit").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Grapes")){
                                String dataname = String.valueOf(dataSnapshot.child("Grapes").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Grapes").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Watermelon")){
                                String dataname = String.valueOf(dataSnapshot.child("Watermelon").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Watermelon").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Egg")){
                                String dataname = String.valueOf(dataSnapshot.child("Egg").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Egg").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Cereal")){
                                String dataname = String.valueOf(dataSnapshot.child("Cereal").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Cereal").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Bread")){
                                String dataname = String.valueOf(dataSnapshot.child("Bread").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Bread").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Yogurt")){
                                String dataname = String.valueOf(dataSnapshot.child("Yogurt").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Yogurt").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Cranberry Juice")){
                                String dataname = String.valueOf(dataSnapshot.child("Cranberry Juice").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Cranberry Juice").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Pork Ribs")){
                                String dataname = String.valueOf(dataSnapshot.child("Pork Ribs").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Pork Ribs").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Chicken")){
                                String dataname = String.valueOf(dataSnapshot.child("Chicken").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Chicken").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Pork Belly")){
                                String dataname = String.valueOf(dataSnapshot.child("Pork Belly").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Pork Belly").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Beef")){
                                String dataname = String.valueOf(dataSnapshot.child("Beef").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Beef").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Turkey")){
                                String dataname = String.valueOf(dataSnapshot.child("Turkey").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Turkey").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Beef Ribs")){
                                String dataname = String.valueOf(dataSnapshot.child("Beef Ribs").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Beef Ribs").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }

                            if (dataSnapshot.hasChild("Sausage")){
                                String dataname = String.valueOf(dataSnapshot.child("Sausage").child("dataname").getValue());
                                String dataquantity = String.valueOf(dataSnapshot.child("Sausage").child("dataquantity").getValue());

                                TextView text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText(dataname);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                                text = new TextView(context);
                                text.setLayoutParams(layoutParams);
                                text.setText("X" +dataquantity);
                                ((UserRepMiniCartAutoTypeViewHolder) holder).itemlist.addView(text);

                            }


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    break;

                case MultiViewTypeModel.BOT_REPLY_AUTOMATED_PERSONALIZE:
                    ((BotReplyAutomatedAutoTypeViewHolder) holder).text.setText(object.text);

                    data.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()){
                                ((BotReplyAutomatedAutoTypeViewHolder) holder).parentlayout.setVisibility(View.VISIBLE);

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    break;

                case MultiViewTypeModel.BOT_REPLY_TWOOPTIONS:
                    ((BotReplyTwoOptionsTypeViewHolder) holder).text.setText(object.text);


                    break;

                case MultiViewTypeModel.DELIVERER_JOINED:
                    ((DelivererJoinedTypeViewHolder) holder).text.setText(object.text);
                    break;

                case MultiViewTypeModel.PROFILE_PREVIEW:
                    ((ProfilePreviewTypeViewHolder) holder).text.setText(object.text);
                    ((ProfilePreviewTypeViewHolder) holder).image.setImageResource(object.data);

                    break;

                case MultiViewTypeModel.DELIVERER_REPLY:
                    ((DelivererReplyTypeViewHolder) holder).text.setText(object.getText());


                    break;

                case MultiViewTypeModel.USER_REPLY_SEND:
                    ((UserReplySendTypeViewHolder) holder).text.setText(object.text);



                    break;

                case MultiViewTypeModel.DELIVERER_TRACK_ME:
                    ((DelivererTrackMeTypeViewHolder) holder).text.setText(object.text);

                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
