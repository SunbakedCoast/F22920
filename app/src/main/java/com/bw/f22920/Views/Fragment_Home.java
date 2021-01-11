package com.bw.f22920.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.f22920.Models.MessagingModels.MultiViewTypeModel;
import com.bw.f22920.R;
import com.bw.f22920.Utilities.MessagingAdapters.MultiViewTypeAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Fragment_Home extends Fragment {

    private ArrayList<MultiViewTypeModel> msgitems = new ArrayList<>();
    TextView buttonOpenSheet;
    RecyclerView recyclerView;
    Button pay;
    Button viewcart;
    Button gtogo;
    ConstraintLayout buttons;
    ConstraintLayout userchat;
    ConstraintLayout buttonlayout;
    EditText usercont;
    Button send;
    ImageView cart;
    TextView qtext;
    ImageView arrowup;


    EditText usercont2;
    Button sendbtn2;
    ConstraintLayout userchat2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        buttonOpenSheet = view.findViewById(R.id.tapheretorep);
        recyclerView = view.findViewById(R.id.rView);
        pay = view.findViewById(R.id.pay);
        viewcart = view.findViewById(R.id.viewcart);
        gtogo = view.findViewById(R.id.gtogo);
        buttons = view.findViewById(R.id.buttons);
        userchat = view.findViewById(R.id.user_chat);
        usercont = view.findViewById(R.id.user_content);
        send = view.findViewById(R.id.sendbtn);
        buttonlayout = view.findViewById(R.id.buttonlayout);
        cart = view.findViewById(R.id.cart_home);
        qtext = view.findViewById(R.id.qtext);
        arrowup = view.findViewById(R.id.arrowup);



        userchat2 = view.findViewById(R.id.user_chat2);
        usercont2 = view.findViewById(R.id.user_content2);
        sendbtn2 = view.findViewById(R.id.sendbtn2);





        viewcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.bottomSheetCart);

            }
        });

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("itemdata");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    cart.setVisibility(View.VISIBLE);
                } else {
                    cart.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.bottomSheetCart);
            }
        });

       /* send.setOnClickListener(new View.OnClickListener() {

                @Override
            public void onClick(View v) {
                    String text = usercont.getText().toString();
                    msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.USER_REPLY_SEND, text, 7));
                    Log.d(TAG, "text: " +text);



            }
        });

        */





        OnBackPressedCallback back = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, back);

        Messages();



        //Linearlayout views



        buttonOpenSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.bottomSheetDialog);
            }
        });



        return view;
    }

    public void Messages (){
        final DatabaseReference db = FirebaseDatabase.getInstance().getReference("itemdata");
        Handler handler = new Handler();
       msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.BOT_FIRST_MESSAGE_AUTOMATED,"Hello what will be your to do today?", 0));
       msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.USER_REPLY_MINICART_AUTOMATED, "", 1));
       handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.BOT_REPLY_AUTOMATED_PERSONALIZE, "Would you like to personalize your items? Type the items you would like to personalize",2));
               db.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       if (dataSnapshot.exists()){
                           userchat.setVisibility(View.VISIBLE);
                           buttons.setVisibility(View.VISIBLE);
                       } else {
                           userchat.setVisibility(View.GONE);
                           buttons.setVisibility(View.GONE);
                       }
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });

               send.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       InputMethodManager inputmanager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                       inputmanager.hideSoftInputFromWindow(getView().getWindowToken(), 0);
                       String text = usercont.getText().toString();
                       msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.USER_REPLY_SEND, text, 7));
                       usercont.getText().clear();
                       qtext.setVisibility(View.VISIBLE);
                       userchat.setVisibility(View.GONE);
                       gtogo.setVisibility(View.GONE);
                       pay.setVisibility(View.VISIBLE);
                       viewcart.setVisibility(View.VISIBLE);
                       pay.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               buttons.setVisibility(View.GONE);
                               msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.DELIVERER_JOINED, "Sam Bridges Joined the chat", 4));
                               msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.PROFILE_PREVIEW, "Sam Bridges", R.mipmap.favorites_foreground));
                               msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.DELIVERER_REPLY, "Hello! I am ready to deliver your items! Your pin is: 29220", 6));
                               userchat2.setVisibility(View.VISIBLE);

                               sendbtn2.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       InputMethodManager inputmanager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                       inputmanager.hideSoftInputFromWindow(getView().getWindowToken(), 0);
                                       String text = usercont2.getText().toString();
                                       msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.USER_REPLY_SEND, text, 7));
                                       usercont2.getText().clear();
                                       msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.DELIVERER_TRACK_ME, "ETA: 30 mins", 8));


                                   }
                               });


                           }
                       });
                   }
               });


           }
       } ,2000);





        gtogo.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                qtext.setVisibility(View.VISIBLE);
               userchat.setVisibility(View.GONE);
               gtogo.setVisibility(View.GONE);
               pay.setVisibility(View.VISIBLE);
               pay.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       buttons.setVisibility(View.GONE);
                       msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.DELIVERER_JOINED, "Sam Bridges Joined the chat", 4));
                       msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.PROFILE_PREVIEW, "Sam Bridges", R.mipmap.favorites_foreground));
                       msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.DELIVERER_REPLY, "Hello, Request accepted! I am ready to deliver your items! Your pin is: 29220", 6));
                       userchat2.setVisibility(View.VISIBLE);

                       sendbtn2.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               InputMethodManager inputmanager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                               inputmanager.hideSoftInputFromWindow(getView().getWindowToken(), 0);
                               String text = usercont2.getText().toString();
                               msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.USER_REPLY_SEND, text, 7));
                               usercont2.getText().clear();
                               msgitems.add(new MultiViewTypeModel(MultiViewTypeModel.DELIVERER_TRACK_ME, "ETA: 30 mins", 8));
                           }
                       });





                   }
               });
               viewcart.setVisibility(View.VISIBLE);
           }
       });







        execMessageItems();
    }

    public void execMessageItems(){
        //RecyclerView recyclerView = view.findViewById(R.id.rView);
        MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(getActivity(), msgitems);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }









}
