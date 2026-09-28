package org.TripSchedulerPatterns;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TripManager manager1 = TripManager.getInstance();
        TripManager manager2 = TripManager.getInstance();

        System.out.println(manager1 == manager2);

        Trip trip = new Trip.Builder()
                .destination("Петропавловск-Камчатский")
                .startingPoint("Москва")
                .duration(100)
                .participants(List.of("Аня", "Ваня","Валентин","Валентина"))
                .hotel(true)
                .build();


        System.out.println("Путешествие из города " + trip.getStartingPoint() + " в " + trip.getDestination()
        + " на " + trip.getDuration() + " дней.");
        System.out.println("Участники: " + String.join(", ", trip.getParticipants()));
        System.out.println("Отель: " + (trip.isHotel()? "Забронирован" : "Не забронирован"));


        TripFactory factory = new TripFactory();

        Trip.Builder builder = new Trip.Builder().destination("Караганда")
                .startingPoint("Москва")
                .duration(50)
                .participants(List.of("Аня", "Ваня"))
                .hotel(false);
        Trip businessTrip1 = factory.createTrip("Business", builder);

        //проверка
        System.out.println("\nТип поездки: " + businessTrip1.getClass().getSimpleName());


        //проверка
        manager1.addTrip(trip);
        System.out.println("\nКоличество поездок: " + manager1.getTrips().size());
        //проверка
        manager1.addTrip(businessTrip1);
        System.out.println("\nКоличество поездок: " + manager1.getTrips().size());


        manager1.addObserver(new UserNotification("Аня"));
        manager1.changeStatus(businessTrip1, "Подтверждена");



    }
}