package com.ama.hungrypenguin.model;

/**
 * Created by akshay on 2/20/16.
 */
public class Checkout {

    public String imageUrl;
    public String name;
    public double cost;
    public int qty;

    public Checkout(String imageUrl, String name, double cost, int qty) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.cost = cost;
        this.qty = qty;
    }

}
