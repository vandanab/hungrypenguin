package com.ama.hungrypenguin;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MenusFragment extends Fragment {
    private static final String ARG_PARAM1 = "page";
    private static final String ARG_PARAM2 = "title";

    private int mpage;
    private String mtitle;

    public static MenusFragment newInstance(int page, String title) {
        MenusFragment fragment = new MenusFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, page);
        args.putString(ARG_PARAM2, title);
        fragment.setArguments(args);
        return fragment;
    }

    public MenusFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mpage = getArguments().getInt(ARG_PARAM1);
            mtitle = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menus, container, false);
    }
}
