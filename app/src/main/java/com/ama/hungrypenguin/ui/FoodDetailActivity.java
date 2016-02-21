package com.ama.hungrypenguin.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ama.hungrypenguin.R;
import com.ama.hungrypenguin.data.SampleData;
import com.ama.hungrypenguin.model.Dish;
import com.ama.hungrypenguin.util.CircleCheckBox;

public class FoodDetailActivity extends AppCompatActivity {

    private Dish dish;
    private TextView titleView;
    private TextView costView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        int id = getIntent().getIntExtra("id", 0);
        dish = SampleData.getDish(id);

        titleView = (TextView) findViewById(R.id.title);
        costView = (TextView) findViewById(R.id.cost);
        titleView.setText(dish.name);
        costView.setText("$" + dish.cost);
        CircleCheckBox checkBox = new CircleCheckBox(getApplicationContext());
        checkBox.setOnCheckedChangeListener(new CircleCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CircleCheckBox view, boolean isChecked) {
                System.out.println("CHECK " + isChecked);
            }
        });
    }

}