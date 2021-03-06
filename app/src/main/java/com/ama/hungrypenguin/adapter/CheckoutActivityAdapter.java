package com.ama.hungrypenguin.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ama.hungrypenguin.R;
import com.ama.hungrypenguin.model.Checkout;
import com.ama.hungrypenguin.model.Dish;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Knock on 2/20/16.
 */

public class CheckoutActivityAdapter extends RecyclerView.Adapter<CheckoutActivityAdapter.CheckoutItemsHolder> {

    List<Checkout> dishes;

    public static class CheckoutItemsHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView imageUrl;
        TextView name;
        TextView cost;
        TextView quantity;


        public CheckoutItemsHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.checkoutcv);
            imageUrl = (ImageView) itemView.findViewById(R.id.thumbnail);
            name = (TextView) itemView.findViewById(R.id.title);
            cost = (TextView) itemView.findViewById(R.id.cost);
            quantity = (TextView) itemView.findViewById(R.id.qtyValue);
        }

    }

    public CheckoutActivityAdapter(List<Checkout> dishes) {
        this.dishes = dishes;
    }

    @Override
    public CheckoutItemsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.checkout_card, parent, false);
        CheckoutItemsHolder sh = new CheckoutItemsHolder(v);
        return sh;
    }

    @Override
    public void onBindViewHolder(CheckoutItemsHolder holder, int position) {
        // TODO: set binding from dishes

        Checkout currDish  = dishes.get(position);

        holder.name.setText(currDish.name);
        holder.cost.setText("$" +  String.valueOf(currDish.cost));

        Uri uri = Uri.parse(currDish.imageUrl);

        final Context mContext = holder.imageUrl.getContext();
        Glide.with(mContext).load(uri).asGif().into(holder.imageUrl);

        holder.quantity.setText(String.valueOf(currDish.qty));
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }
}