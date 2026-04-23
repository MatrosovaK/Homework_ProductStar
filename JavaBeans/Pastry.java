package org.example.JavaBeans;

public class Pastry extends MenuItem implements Preparable{
    private String type;

    public Pastry(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + type);
        System.out.println("knead the dough...");
        System.out.println("Baking " + type);
        System.out.println(type + " is ready!");

    }
}
