package org.TripScheduleSerialization;

import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, JsonProcessingException{

        TripManager tripManager = new TripManager();
        User user1 = new User("Васильев Василий", "RUS123123", 32, "Vas@vas.ru");
        User user2 = new User("Петров Петр", "UK321311", 21, "Pet@pet.ru");

        Destination destination1 = new Destination("Россия", "Москва", "Московская 2-22");
        Destination destination2 = new Destination("ЮК", "Лондон", "Трафальгарская площадь 34");
        Destination destination3 = new Destination("Швейцария", "Майлен", "Майленштрассе 1-212");
        Destination destination4 = new Destination("Россия", "Мурманск", "Мурманская площадь 13");

        StartingPoint startingPoint1 = new StartingPoint("Россия","Владивосток");
        StartingPoint startingPoint2 = new StartingPoint("Россия","Москва");
        StartingPoint startingPoint3 = new StartingPoint("Россия","Хабаровск");
        StartingPoint startingPoint4 = new StartingPoint("Россия","Мурманск");



        Trip trip1 = new Trip(1, user1, startingPoint1, destination1, "поезд");
        Trip trip2 = new Trip(2, user1, startingPoint2, destination2, "лошадка");

        Trip trip3 = new Trip(3, user2, startingPoint3, destination4, "самолет");
        Trip trip4 = new Trip(4, user2, startingPoint4, destination3, "пешком");

        tripManager.addTrip(trip1);
        tripManager.addTrip(trip2);
        tripManager.addTrip(trip3);
        tripManager.addTrip(trip4);

        TripSerializer.save(tripManager.getTrips());
        List<Trip> loadedTrips = TripSerializer.load();



        for(Trip t:loadedTrips){
            System.out.println("\nПоездка No " + t.getId());
            System.out.println("Пользователь " + t.getTripForUser().getFullName()+ " (номер паспорта: " + t.getTripForUser().getPassportNumber() + " )");
            System.out.println("Маршрут: " +
                    "\nНачальная точка: " + t.getStartingPoint().getCountry() + " - " + t.getStartingPoint().getCity() +
                    "\nКонечная точка: " + t.getDestination().getCountry() + " - " + t.getDestination().getCity() + " (адрес: " + t.getDestination().getAddress() + " )");
            System.out.println("Тип транспорта: " + t.getTransportType());

        }


        String json = TripJsonSerializer.toJson(tripManager.getTrips());
        System.out.println("\nto JSON: \n");
        System.out.println(json);

        List<Trip> jsonTrips = TripJsonSerializer.fromJson(json);
        System.out.println("\nfrom JSON: ");
for(Trip t:jsonTrips) {
    System.out.println("\nПоездка No " + t.getId());
    System.out.println("Пользователь " + t.getTripForUser().getFullName() + " (номер паспорта: " + t.getTripForUser().getPassportNumber() + " )");
    System.out.println("Маршрут: " +
            "\nНачальная точка: " + t.getStartingPoint().getCountry() + " - " + t.getStartingPoint().getCity() +
            "\nКонечная точка: " + t.getDestination().getCountry() + " - " + t.getDestination().getCity() + " (адрес: " + t.getDestination().getAddress() + " )");
    System.out.println("Тип транспорта: " + t.getTransportType());
}

    }
}