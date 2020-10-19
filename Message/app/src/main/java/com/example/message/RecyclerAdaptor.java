package com.example.message;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.MyViewHodler> {

    ArrayList<Message> texts;
    String user;
    int count = 0;

    public RecyclerAdaptor(ArrayList<Message> texts, String user) {
        this.texts=texts;
        this.user = user;
    }

    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =null;
        if(viewType==0){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            view = layoutInflater.inflate(R.layout.msgs,parent,false);
        }
        else{
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            view = layoutInflater.inflate(R.layout.msgr,parent,false);
        }
        MyViewHodler viewHodler = new MyViewHodler(view);

        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler holder, int position) {

        holder.txt.setText(texts.get(position).message);
    }

    @Override
    public int getItemViewType(int position) {

        count=position;
        if (texts.get(count).sentby == user) {
            return 0;
        }
        else
            return 1;
    }

    @Override
    public int getItemCount() {
        return texts.size();
    }

    class MyViewHodler extends RecyclerView.ViewHolder{
        TextView txt;

        public MyViewHodler(@NonNull View itemView) {
            super(itemView);
            if(texts.get(count).sentby==user){
                txt = itemView.findViewById(R.id.msgs);
            }
            else{
                txt = itemView.findViewById(R.id.msgr);
            }
        }
    }

}
