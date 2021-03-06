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
import android.widget.TextView;

import com.ama.hungrypenguin.R;
import com.ama.hungrypenguin.adapter.CheckoutActivityAdapter;
import com.ama.hungrypenguin.data.SampleData;
import com.ama.hungrypenguin.model.Checkout;
import com.ama.hungrypenguin.model.Dish;
import com.ama.hungrypenguin.model.Order;
import com.ama.hungrypenguin.util.MockAction;
import com.ama.hungrypenguin.util.MockActionCallback;
import com.ama.hungrypenguin.util.SharedPrefsHelper;
import com.ama.hungrypenguin.util.ThreadExecutor;
import com.github.jorgecastilloprz.FABProgressCircle;
import com.github.jorgecastilloprz.listeners.FABProgressListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Knock on 2/20/16.
 */

public class CheckoutActivity extends AppCompatActivity implements MockActionCallback, FABProgressListener {

    private FABProgressCircle fabProgressCircle;
    private boolean taskRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViews();
        attachListeners();
        //final Intent i = new Intent(CheckoutActivity.this, PostOrderActivity.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                fabProgressCircle.show();
//                startActivity(i);
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//            }
//        });

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);


        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);

        List<Checkout> myOrders = new ArrayList<Checkout>();


        SharedPrefsHelper mSharedPrefsHelper = new SharedPrefsHelper(this);
        Map<Integer, Integer> orders = mSharedPrefsHelper.getOrder();

        for(Integer orderId: orders.keySet()) {
            Dish currDish = SampleData.getDish(orderId);
            int qty = orders.get(orderId);

            Checkout currCh = new Checkout(currDish.imageUrl, currDish.name, currDish.cost, qty);
            myOrders.add(currCh);
        }
//        mSharedPrefsHelper.clear();

        Order myOrder = new Order(myOrders);
        CheckoutActivityAdapter cAv = new CheckoutActivityAdapter(myOrder.getOrderList());
        rv.setAdapter(cAv);
        final TextView totalPrice = (TextView) findViewById(R.id.totalPrice);
        totalPrice.setText(String.valueOf("$" + myOrder.getTotalPrice()));
    }

    private void initViews() {
        fabProgressCircle = (FABProgressCircle) findViewById(R.id.fabProgressCircle);
    }

    private void attachListeners() {
        fabProgressCircle.attachListener(this);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                if (!taskRunning) {
                    fabProgressCircle.show();
                    runMockInteractor();
                }
            }
        });
    }

    private void runMockInteractor() {
        ThreadExecutor executor = new ThreadExecutor();
        executor.run(new MockAction(this));
        taskRunning = true;
    }

    @Override public void onMockActionComplete() {
        taskRunning = false;
        fabProgressCircle.beginFinalAnimation();
        //fabProgressCircle.hide();
    }

    @Override
    public void onFABProgressAnimationEnd() {
        Snackbar.make(fabProgressCircle, "Order Placed!", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show();
        final Intent i = new Intent(CheckoutActivity.this, PostOrderActivity.class);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    startActivity(i);
                }
            }
        };
        timerThread.start();

    }
}
