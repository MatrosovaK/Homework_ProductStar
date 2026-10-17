package org.Cafe;

public class Visitor implements Runnable{
    private final Cafe cafe;
    private final int visitorID;
    private static int visitorCounter = 0;

    public Visitor(Cafe cafe, int visitorID) {
        this.cafe = cafe;
        this.visitorID = visitorID;
    }

    public static Thread startVisitors(Cafe cafe) {
        Thread generator = new Thread(() ->{
            while(!Thread.currentThread().isInterrupted() && !cafe.isFinished()){
                int id;
                synchronized (Visitor.class){
                id = ++visitorCounter;
            }

            new Thread(new Visitor(cafe, id)).start();
                try{
                    Thread.sleep(2500);

                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                    break;
                }


            }});
        generator.start();
        return generator;
        }




    @Override
    public void run() {


        System.out.println("Посетитель " + visitorID + " зашел в кафе");
        try{
            String dish = cafe.takeDish(visitorID);
            if(dish != null){
                System.out.println("Посетитель " + visitorID + " съел " + dish);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }



    }
}
