package com.example.eventpedia;


import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

//1
public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>{
    //6.2
    private ArrayList<ExampleItem> mExampleItem;
    //2
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        //4
        public ImageView imageView;
        public TextView textView;
        public Button button1,button2,button3;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            //4
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            //TODO :Add functionality to buttons
            button1 = itemView.findViewById(R.id.button1);
            button2 = itemView.findViewById(R.id.button2);
            button3 = itemView.findViewById(R.id.button3);



//            button2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                   Intent browserIntent = new Intent(
//                            Intent.ACTION_VIEW,
//                            Uri.parse("http://android.okhelp.cz/category/software/"));
//                    startActivity(browserIntent);
//                    Log.i("TAG","Button Clicked");
//                }
//            });
        }
    }
    //6.1
    public ExampleAdapter(ArrayList<ExampleItem> exampleList){
        mExampleItem=exampleList;
    }
    //3
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //5
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.societypage, parent,false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(view);
        return exampleViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int position) {
        //7
        ExampleItem currentItem = mExampleItem.get(position);
        exampleViewHolder.imageView.setImageResource(currentItem.getmImageResource());
        exampleViewHolder.textView.setText(currentItem.getmText());
//        exampleViewHolder.button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent browserIntent = new Intent(CardView.this, Main2Activity.class);
//                startActivity(browserIntent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mExampleItem.size();
    }

}
