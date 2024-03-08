package org.ayush.Entity;

public class Product {
    private Integer id;
    private String name;
    private Integer count;

    public Product( Integer id,String name, Integer count) {
        this.name = name;
        this.id = id;
        this.count = count;
    }

    @Override
    public String toString() {
        return "(<*>) Id: "+id+",   "+"Name: \"" + name + "\",   " + "In Stock: " + count;
    }

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public String getName() {
        return name;
    }
    public Integer getId() {
        return id;
    }

}
