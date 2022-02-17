package com.example.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context c;
    String[] myNames;
    String[] myLocation;

    public CustomAdapter(recycleVw m, String[] names, String[] location){

        c =m;
        myNames = names;
        myLocation = location;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(c).inflate(R.layout.recycle_test,null);
        MyViewHolder viewHolder = new MyViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.overrideInit.setText(myNames[position]);
        holder.test.setText(myLocation[position]);

    }

    @Override
    public int getItemCount() {
        return myNames.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView overrideInit;
        TextView test;

        public MyViewHolder(@NonNull View convertView) {
            super(convertView);
            overrideInit = convertView.findViewById(R.id.overridepr);
            test = convertView.findViewById(R.id.overridepr2);


        }
    }


}
