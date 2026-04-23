package org.example.JavaBeans;

public class Coffee extends MenuItem implements Preparable{
    private int strength;


    public Coffee(String name, double price, int strength) {
        super(name, price);
        this.strength=strength;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing coffee. Strength is " + strength);
        System.out.println("Boiling water...");
        System.out.println("Pouring into cup...");
        System.out.println("Coffee is ready!");
    }
}
