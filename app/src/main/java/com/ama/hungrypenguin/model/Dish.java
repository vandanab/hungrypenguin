package com.ama.hungrypenguin.model;

/**
 * Created by akshay on 2/20/16.
 */
public class Dish {
    public String imageUrl;
    public String name;
    public double cost;

    public Dish(String imageUrl, String name, double cost) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.cost = cost;
    }
}
