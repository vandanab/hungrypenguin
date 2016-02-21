package com.ama.hungrypenguin.data;

import com.ama.hungrypenguin.model.Dish;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vbachani on 2/20/16.
 */
public class SampleData {
    private static List<Dish> dishes = new ArrayList<Dish>();

    static {
        dishes.add(new Dish(
                0,
                "http://49.media.tumblr.com/f93587d0411932810f73763ac70fe173/tumblr_nqoenqtreF1sfet3to1_500.gif",
                "Ramen",
                5.00, new ArrayList<String>() {{add("Egg");add("Chicken");add("Chilli peppers");}}
        ));
        dishes.add(new Dish(
                1,
                "http://45.media.tumblr.com/54b57b27e4c624616cd37684168bcd15/tumblr_nmfy5vqref1qdt6e2o3_1280.gif",
                "Ultimate cupcake",
                6.00, new ArrayList<String>() {{add("Chocolate sprinkles");add("Extra frosting");add("Cherry");}}
        ));
        dishes.add(new Dish(
                2,
                "http://45.media.tumblr.com/9c81bd5d13c04253b42e31b4be1f5d06/tumblr_nqz1tsWQxh1rq6lflo5_400.gif",
                "Croissants",
                2.00, new ArrayList<String>() {{add("Chocolate");add("Cheese");}}
        ));
        dishes.add(new Dish(
                3,
                "http://49.media.tumblr.com/1ed213d5ac1c2ab2122095fa70b37ed7/tumblr_njb8p27oyC1qz6f9yo3_500.gif",
                "Coffee",
                3.50, new ArrayList<String>() {{add("Whipped cream");add("Sugar");add("Chocolate chips");add("Milk");}}
        ));
    }

    public static List<Dish> getDishes() {
        return dishes;
    }

    public static List<Dish> getTrendingDishes() {
        return dishes.subList(2, 4);
    }

    public static List<Dish> getInterestingDishes() {
        return dishes.subList(0, 1);
    }

    public static Dish getDish(int index) {
        return dishes.get(index);
    }

    public static List<List<Dish>> getDishesData() {
        List<List<Dish>> dishesLists = new ArrayList<>();
        dishesLists.add(getDishes());
        dishesLists.add(getTrendingDishes());
        dishesLists.add(getInterestingDishes());
        return dishesLists;
    }
}
