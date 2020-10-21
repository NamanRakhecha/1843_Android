package com.example.recycledeleteundo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    private Context mcontext;
    private ArrayList<model> list;
    View view;
    model temp;

    public Adapter (Context mcontext,ArrayList<model> list){
        this.mcontext = mcontext;
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view= LayoutInflater.from(mcontext).inflate(R.layout.item,parent,false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
        holder.textView.setText(list.get(position).getName());
        holder.imageView.setImageResource(list.get(position).getImage());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp=new model(list.get(position).getName(),list.get(position).getImage());
                deleteItem(position,view);
            }
        });
    }
    private void deleteItem(final int position, View view)
    {
        list.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,list.size());
        Snackbar.make(view,"UNDO"+temp.getName(),Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add(position,temp);
                notifyItemInserted(position);
                notifyItemRangeChanged(position,list.size());

            }
        }).setActionTextColor(mcontext.getResources().getColor(android.R.color.holo_blue_dark)).show();
    }
    @Override
    public int getItemCount() {
        return list.size();
    }


    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView,delete;
        TextView textView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            delete=itemView.findViewById(R.id.delete);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}
