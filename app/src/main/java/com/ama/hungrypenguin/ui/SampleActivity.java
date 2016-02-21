package com.ama.hungrypenguin.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import com.ama.hungrypenguin.R;
import com.ama.hungrypenguin.adapter.RVSampleAdapter;
import com.ama.hungrypenguin.data.RestaurantData;
import com.ama.hungrypenguin.model.Restaurant;
import com.ama.hungrypenguin.util.ItemClickListener;

import java.util.ArrayList;
import java.util.List;


public class SampleActivity extends AppCompatActivity {

    private RecyclerView rv;
    //final LinearLayoutManager llm;
    RVSampleAdapter adapter;
    List<Restaurant> restaurants;
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


        RestaurantData rd = new RestaurantData();
        List<Restaurant> restaurants = rd.getRestaurants();


        adapter = new RVSampleAdapter(restaurants, this);
        //adapter.setItemClickListener(this);
        rv.setAdapter(adapter);
    }

//    @Override
//    public void onItemClick(int position, View view) {
//        RestaurantData rd = new RestaurantData();
//        restaurants = rd.getRestaurants();
//        Restaurant r = restaurants.get(position);
//        String name = r.name;
//
//        Intent i = new Intent(getApplicationContext(), MainActivity.class);
//        i.putExtra("name", name);
//        startActivity(i);
//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
//    }
}
