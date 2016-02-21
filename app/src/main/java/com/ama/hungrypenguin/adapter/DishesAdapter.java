package com.ama.hungrypenguin.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ama.hungrypenguin.R;
import com.ama.hungrypenguin.model.Dish;
import com.ama.hungrypenguin.util.PrefsEventHandler;
import com.ama.hungrypenguin.util.SharedPrefsHelper;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by vbachani on 2/20/16.
 */
public class DishesAdapter extends
        RecyclerView.Adapter<DishesAdapter.ViewHolder> {
    private List<Dish> dishes;
    private SharedPrefsHelper sharedPrefsHelper;
    private PrefsEventHandler handler;

    public DishesAdapter(List<Dish> data, SharedPrefsHelper helper, PrefsEventHandler handler) {
        dishes = data;
        sharedPrefsHelper = helper;
        this.handler = handler;
    }

    @Override
    public DishesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.dish_order_card, parent, false);
        DishesAdapter.ViewHolder vh = new DishesAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DishesAdapter.ViewHolder holder, int position) {
        Dish dish = dishes.get(position);
        holder.title.setText(dish.name);
        holder.cost.setText(Double.toString(dish.cost));
        holder.cost.setTag(dish.id);
        Uri uri = Uri.parse(dish.imageUrl);

        final Context mContext = holder.thumbnail.getContext();
        Glide.with(mContext).load(uri).asGif().into(holder.thumbnail);

        holder.cost.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               sharedPrefsHelper.updateOrder((Integer) v.getTag(), 1);
               handler.showState();
           }
        });
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView thumbnail;
        TextView title;
        Button cost;

        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            title = (TextView) itemView.findViewById(R.id.title);
            cost = (Button) itemView.findViewById(R.id.costButton);
        }
    }
}
