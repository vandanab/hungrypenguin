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
import com.ama.hungrypenguin.model.Restaurant;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by akshay on 2/20/16.
 */
public class RVSampleAdapter extends RecyclerView.Adapter<RVSampleAdapter.SampleHolder>{

    List<Restaurant> restaurants;

    public static class SampleHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView thumbnail;
        TextView title;
        TextView cost;


        public SampleHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            title = (TextView) itemView.findViewById(R.id.title);
            cost = (TextView) itemView.findViewById(R.id.cost);
        }

    }

    RVSampleAdapter(List<Restaurant> restaurants){
        this.restaurants = restaurants;
    }

    @Override
    public SampleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.card_reference, parent, false);
        SampleHolder sh = new SampleHolder(v);
        return sh;
    }

    @Override
    public void onBindViewHolder(SampleHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }


}
