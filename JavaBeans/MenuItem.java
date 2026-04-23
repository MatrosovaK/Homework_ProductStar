package org.example.JavaBeans;

public  abstract class MenuItem {
    private final String name;
    private final double price;

    public MenuItem(String name, double price) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}
