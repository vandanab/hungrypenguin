package com.ama.hungrypenguin.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ama.hungrypenguin.R;
import com.ama.hungrypenguin.model.Dish;
import com.ama.hungrypenguin.ui.FoodDetailActivity;
import com.ama.hungrypenguin.ui.MainActivity;
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
    private Context context;

    public DishesAdapter(Context parent, List<Dish> data, SharedPrefsHelper helper,
            PrefsEventHandler handler) {
        dishes = data;
        sharedPrefsHelper = helper;
        this.context = parent;
        this.handler = handler;
    }

    @Override
    public DishesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.dish_order_card, parent, false);
        DishesAdapter.ViewHolder vh = new DishesAdapter.ViewHolder(v, context);
        return vh;
    }

    @Override
    public void onBindViewHolder(DishesAdapter.ViewHolder holder, int position) {
        Dish dish = dishes.get(position);
        holder.item = dish;
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

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Dish item;
        ImageView thumbnail;
        TextView title;
        Button cost;
        Context context;

        public ViewHolder(View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            title = (TextView) itemView.findViewById(R.id.title);
            cost = (Button) itemView.findViewById(R.id.costButton);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(context, FoodDetailActivity.class);
            i.putExtra("id", item.id);
            context.startActivity(i);
        }
    }
}
