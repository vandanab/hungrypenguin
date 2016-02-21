package com.ama.hungrypenguin.model;

import java.util.ArrayList;

/**
 * Created by akshay on 2/20/16.
 */
public class Dish {
    public int id;
    public String imageUrl;
    public String name;
    public double cost;
    public ArrayList<String> ingredients;

    public Dish(int id, String imageUrl, String name, double cost, ArrayList<String> ingredients) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.cost = cost;
        this.ingredients = ingredients;
    }
}
