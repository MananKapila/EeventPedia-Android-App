package com.example.eventpedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CardView2 extends AppCompatActivity {
    ArrayList<ExampleItem2> exampleList2;
    private RecyclerView recyclerView2;
    private RecyclerView.Adapter adapter2;
    private RecyclerView.LayoutManager layoutManager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view2);

        ArrayList<ExampleItem2> exampleList2 = new ArrayList<>();

        exampleList2.add(new ExampleItem2(R.drawable.ls, " Event by Literary Society"));
        exampleList2.add(new ExampleItem2(R.drawable.econ_event, "Event by Econ"));
        exampleList2.add(new ExampleItem2(R.drawable.econ_two, "Event by Econ"));
        exampleList2.add(new ExampleItem2(R.drawable.acs, "Event by Adventure Club"));
        exampleList2.add(new ExampleItem2(R.drawable.hackowasp, "Event by Owasp"));

        recyclerView2 = findViewById(R.id.recyclerView2);
        //Performance
        recyclerView2.setHasFixedSize(true);
        layoutManager2 = new LinearLayoutManager(CardView2.this);
        adapter2 = new ExampleAdapter2(exampleList2);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(adapter2);

    }
}
