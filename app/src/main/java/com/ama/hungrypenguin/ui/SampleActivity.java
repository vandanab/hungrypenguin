package com.ama.hungrypenguin.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ama.hungrypenguin.R;
import com.ama.hungrypenguin.adapter.RVSampleAdapter;
import com.ama.hungrypenguin.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class SampleActivity extends AppCompatActivity {

    private RecyclerView rv;
    //final LinearLayoutManager llm;
    RVSampleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        rv = (RecyclerView) findViewById(R.id.reView);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);




        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        Restaurant r1 = new Restaurant("http://i.kinja-img.com/gawker-media/image/upload/s--Iuw1yxhh--/wojsrqpmxrfhjajjzaz6.gif", "Burger");
        Restaurant r2 = new Restaurant("http://i.kinja-img.com/gawker-media/image/upload/s--Iuw1yxhh--/wojsrqpmxrfhjajjzaz6.gif", "Akshay");

        restaurants.add(r1);
        restaurants.add(r2);

        adapter = new RVSampleAdapter(restaurants);
        rv.setAdapter(adapter);
    }

}
