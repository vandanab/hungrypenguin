package com.ama.hungrypenguin.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ama.hungrypenguin.R;
import com.ama.hungrypenguin.model.Dish;

import java.util.List;

/**
 * Created by Knock on 2/20/16.
 */

public class CheckoutActivityAdapter extends RecyclerView.Adapter<CheckoutActivityAdapter.CheckoutItemsHolder> {

    List<Dish> dishes;

    public static class CheckoutItemsHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView thumbnail;
        TextView name;
        TextView cost;


        public CheckoutItemsHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            name = (TextView) itemView.findViewById(R.id.title);
            cost = (TextView) itemView.findViewById(R.id.cost);
        }

    }

    CheckoutActivityAdapter(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public CheckoutItemsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.card_reference, parent, false);
        CheckoutItemsHolder sh = new CheckoutItemsHolder(v);
        return sh;
    }

    @Override
    public void onBindViewHolder(CheckoutItemsHolder holder, int position) {
        // TODO: set binding from dishes
//        holder.title.setText(dishes.get(position).name)
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }
}