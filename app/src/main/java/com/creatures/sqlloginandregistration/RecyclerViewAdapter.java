package com.creatures.sqlloginandregistration;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.recycler_view_holder> {

    @NonNull
    ArrayList<model_user_registration_data> arrayList;
    OnItemClickListener mListener;
    boolean flag=false;
    int a=0;

    //Onclick Interface
    public interface OnItemClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    //Constructor
    public RecyclerViewAdapter(@NonNull ArrayList<model_user_registration_data> arrayList) {
        this.arrayList = arrayList;
    }

    // Override Methods for Recycler View Holder
    @Override
    public recycler_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reg_user_details,parent,false);
        return new recycler_view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recycler_view_holder holder, int position) {

        holder.tv_u_name.setText(arrayList.get(position).getUser_name());
        holder. tv_u_mail.setText(arrayList.get(position).getUser_mail());

        Random rnd = new Random();
        int currentColor = Color.argb(130, rnd.nextInt(126), rnd.nextInt(216), rnd.nextInt(236));
        holder.recyclerview_linearLayout.setBackgroundColor(currentColor);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    // recycler View Holder Class which extends View Holder
    class recycler_view_holder extends RecyclerView.ViewHolder
    {
        TextView tv_u_name,tv_u_mail;
        LinearLayout recyclerview_linearLayout;
        ImageView imageView_notification;

        public recycler_view_holder(@NonNull View itemView) {
            super(itemView);

          tv_u_name=(TextView)itemView.findViewById(R.id.text_view_recycler_view_user_name_display);
          tv_u_mail=(TextView)itemView.findViewById(R.id.text_view_recycler_view_user_mail_display);
          recyclerview_linearLayout=(LinearLayout)itemView.findViewById(R.id.rv_linear_layout);


        }
    }


}
