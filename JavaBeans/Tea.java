package org.example.JavaBeans;

public class Tea extends MenuItem implements Preparable{
    private String type;

    public Tea(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + type + " tea...");
        System.out.println("Boiling water...");
        System.out.println("Pouring into cup...");
        System.out.println(type + "tea is ready!");
    }
}
