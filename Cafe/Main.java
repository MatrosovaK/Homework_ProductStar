package org.Cafe;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException{

        Cafe cafe = new Cafe();

        Thread.sleep(1000);
        Thread chef = new Thread(new Chef(cafe));

        Thread visitorGenerator = Visitor.startVisitors(cafe);

        chef.start();
        chef.join();

        visitorGenerator.interrupt();
        visitorGenerator.join();
        System.out.println("все");

    }
}