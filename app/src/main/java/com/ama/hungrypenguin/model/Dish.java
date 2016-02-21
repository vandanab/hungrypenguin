package com.ama.hungrypenguin.model;

import java.util.ArrayList;

/**
 * Created by akshay on 2/20/16.
 */
public class Dish {
    String imageUrl;
    String name;
    double cost;

    public Dish(String imageUrl, String name, double cost){
        this.imageUrl = imageUrl;
        this.name = name;
        this.cost = cost;
    }

}
