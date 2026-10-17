package org.Cafe;

import java.util.List;

public class Chef implements Runnable {
   private final Cafe cafe;

    public Chef(Cafe cafe) {
        this.cafe = cafe;
    }

    private final List<String> menu = List.of("Бургер", "Паста", "Кусок хлеба",
            "Помытое шефом яблоко", "Половина арбуза", "Жареная картошечка", "Фрикадельки");


    @Override
    public void run() {


        try{
            for(int i = 0; i < 7; i++){

                Thread.sleep(3000);
                cafe.addDish(menu.get(i));
            }

            cafe.finishCooking();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
