package org.TravelPlanner;

public class TravelApp {

    public static void main(String[]args){

        final TravelPlanner planner = new TravelPlanner();
        HotelBooking hotelBooking = new HotelBooking.Builder(" Ritz")
                .nights(3)
                .breakfastIncluded(true)
                .build();


        planner.bookHotel(hotelBooking);

        String from = "Москва";
        String to = "нчк";

        System.out.println(planner.planTrip("train", from, to));
        System.out.println(planner.planTrip("airplane", from, to));

    }
}
