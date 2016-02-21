package com.ama.hungrypenguin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ama.hungrypenguin.data.SampleData;
import com.ama.hungrypenguin.model.Dish;

import java.util.ArrayList;
import java.util.List;


public class DishListFragment extends Fragment {
    private static final String ARG_PARAM1 = "page";
    private List<Dish> dishes;

    private int mpage;

    public static DishListFragment newInstance(int page) {
        DishListFragment fragment = new DishListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, page);
        fragment.setArguments(args);
        return fragment;
    }

    public DishListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mpage = getArguments().getInt(ARG_PARAM1);
            dishes = SampleData.getDishesData().get(mpage);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dish_list, container, false);
    }
}
