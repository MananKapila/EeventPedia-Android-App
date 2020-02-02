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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.createDeviceProtectedStorageContext;
import static androidx.core.content.ContextCompat.startActivity;

//1
public class ExampleAdapter2 extends RecyclerView.Adapter<ExampleAdapter2.ExampleViewHolder>{
    //6.2
    private ArrayList<ExampleItem2> mExampleItem2;
    //2
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        //4
        public ImageView imageView2;
        public TextView textView2;
        public Button button5,button6,button7;
        public ExampleViewHolder(@NonNull final View itemView) {
            super(itemView);
            //4
            imageView2 = itemView.findViewById(R.id.imageView2);
            textView2 = itemView.findViewById(R.id.textView2);
            //TODO :Add functionality to buttons
            button5 = itemView.findViewById(R.id.button5);
            button6 = itemView.findViewById(R.id.button6);
            button7 = itemView.findViewById(R.id.button7);

            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(.this,"Kindly LogIn to Subscribe",Toast.LENGTH_SHORT).show();
                }
            });

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
    public ExampleAdapter2(ArrayList<ExampleItem2> exampleList2){
        mExampleItem2=exampleList2;
    }
    //3
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //5
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventpage, parent,false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(view);
        return exampleViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int position) {
        //7
        ExampleItem2 currentItem = mExampleItem2.get(position);
        exampleViewHolder.imageView2.setImageResource(currentItem.getmImageResource());
        exampleViewHolder.textView2.setText(currentItem.getmText());
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
        return mExampleItem2.size();
    }

}
