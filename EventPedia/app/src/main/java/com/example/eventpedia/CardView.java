package com.example.eventpedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class CardView extends AppCompatActivity {

    ArrayList<ExampleItem> exampleList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
//    private EditText editTextadd, editTextdelete;
//    private Button buttonAdd, buttonDelete;
//    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();

        exampleList.add(new ExampleItem(R.drawable.ac, "Adventure Club"));
        exampleList.add(new ExampleItem(R.drawable.ccs, "Competitive Coding Society"));
        exampleList.add(new ExampleItem(R.drawable.faps, "Fine Arts and Photography Society"));
        exampleList.add(new ExampleItem(R.drawable.msc, "Microsoft Student Chapter"));
        exampleList.add(new ExampleItem(R.drawable.owasp, "Literary Society"));
        exampleList.add(new ExampleItem(R.drawable.lss, "Owasp Student Chapter"));


        recyclerView = findViewById(R.id.recyclerView);
        //Performance
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(CardView.this);
        adapter = new ExampleAdapter(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

//
//    }
    }
}
