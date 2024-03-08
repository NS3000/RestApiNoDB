package org.ayush;

import org.ayush.Entity.Product;

import java.util.HashMap;

public class Inventory {
    static HashMap<Integer, Product> productMap = new HashMap<>();
    static {
        Product Monitor = new Product(1,"Monitor",3);
        productMap.put(Monitor.getId(),Monitor);

        Product Keyboard = new Product(2,"Keyboard",7);
        productMap.put(Keyboard.getId(),Keyboard);

        Product Mouse = new Product(3,"Mouse",12);
        productMap.put(Mouse.getId(),Mouse);

        Product CPU = new Product(4,"CPU",4);
        productMap.put(CPU.getId(), CPU);

    }
}
