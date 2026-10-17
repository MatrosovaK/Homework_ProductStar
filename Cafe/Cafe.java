package org.Cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {

    private final List<String> orders = new ArrayList<>();
    private boolean finished = false;

    public synchronized void addDish(String dish){
        orders.add(dish);
        System.out.println("Повар приготовил " + dish);
        notifyAll();
    }

    public synchronized String takeDish (int visitorID) throws InterruptedException{
        while(orders.isEmpty() && !finished){
            System.out.println("Готовой еды нет. Посетитель " + visitorID + " ждет");
            wait();
        }
        if(orders.isEmpty() && finished){
            System.out.println("Еда закончилась. Посетители уходят");
            return null;
        }

        return orders.remove(0);
    }

    public synchronized void finishCooking(){
        finished = true;
        System.out.println("Повар закончил готовить");
        notifyAll();
    }


    public synchronized boolean isFinished(){
        return finished;
    }
}
