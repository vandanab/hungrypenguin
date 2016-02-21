package com.ama.hungrypenguin.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ama.hungrypenguin.R;
import com.ama.hungrypenguin.model.Restaurant;
import com.ama.hungrypenguin.ui.MainActivity;
import com.ama.hungrypenguin.ui.SampleActivity;
import com.ama.hungrypenguin.util.ItemClickListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by akshay on 2/20/16.
 */
public class RVSampleAdapter extends RecyclerView.Adapter<RVSampleAdapter.SampleHolder>{

    List<Restaurant> restaurants;
    private ItemClickListener itemClickListener;
    Context context;

    public class SampleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RelativeLayout rv;
        ImageView thumbnail;
        TextView title;
        TextView address;
        TextView dollar;
        Context c;

        public SampleHolder(View itemView, int viewType, Context cntxt) {
            super(itemView);
            this.c = cntxt;
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            rv = (RelativeLayout)itemView.findViewById(R.id.restaurantrv);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            title = (TextView) itemView.findViewById(R.id.title);
            address = (TextView) itemView.findViewById(R.id.address);
            dollar = (TextView) itemView.findViewById(R.id.dollar);
        }


        @Override
        public void onClick(View v) {
            Toast.makeText(context, restaurants.get(getPosition()).name, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra("name", restaurants.get(getPosition()).name);
            context.startActivity(i);
        }
    }

    public RVSampleAdapter(List<Restaurant> restaurants, Context passedContext){
        this.restaurants = restaurants;
        this.context = passedContext;
    }

    @Override
    public SampleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.restaurant_card, parent, false);
        SampleHolder sh = new SampleHolder(v, viewType, context);
        return sh;
    }

    @Override
    public void onBindViewHolder(SampleHolder holder, final int position) {
        holder.title.setText(restaurants.get(position).name);
        Log.d("AKSHAY", restaurants.get(position).imageUrl);
        holder.address.setText(restaurants.get(position).address);
        holder.dollar.setText(restaurants.get(position).dollar);
        Glide.with(holder.itemView.getContext())
                .load(restaurants.get(position).imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                //.placeholder(R.drawable.def_bg)
                .into(holder.thumbnail);
//        Glide.with(holder.itemView.getContext()).load("http://goo.gl/gEgYUd").into(holder.thumbnail);

//        holder.rv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("AP", restaurants.get(position).name);
//                Intent i = new Intent(context, MainActivity.class);
//                i.putExtra("name", restaurants.get(position).name);
//                startActivity(i);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
