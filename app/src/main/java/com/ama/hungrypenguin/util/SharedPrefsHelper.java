package com.ama.hungrypenguin.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vbachani on 2/20/16.
 */
public class SharedPrefsHelper {
    private Context context;
    private SharedPreferences order;

    public SharedPrefsHelper(Context context) {
        this.context = context;
        order = context.getSharedPreferences("order", 0);
    }

    public void updateOrder(int dishIndex, int quantity) {
        SharedPreferences.Editor editor = order.edit();
        String key = Integer.toString(dishIndex);
        if (order.contains(key)) {
            int currentQuantity = order.getInt(key, 0);
            editor.putInt(key, currentQuantity + quantity);
        } else {
            editor.putInt(key, quantity);
        }
        editor.commit();
    }

    // Dish index -> quantity
    public Map<Integer, Integer> getOrder() {
        Map<Integer, Integer> orderMap = new HashMap<Integer, Integer>();
        Map<String, ?> keysMap = order.getAll();
        for (String key : keysMap.keySet()) {
            orderMap.put(Integer.parseInt(key), order.getInt(key, 0));
        }
        return orderMap;
    }

}
