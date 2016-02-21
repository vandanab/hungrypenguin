package com.ama.hungrypenguin.model;

/**
 * Created by akshay on 2/20/16.
 */
public class Dish {
    public int id;
    public String imageUrl;
    public String name;
    public double cost;

    public Dish(int id, String imageUrl, String name, double cost) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.cost = cost;
    }
}
