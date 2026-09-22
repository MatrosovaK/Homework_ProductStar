package org.TravelPlanner;

public class TravelPlanner {
    private HotelBooking hotelBooking;
    private TravelStrategyFactory travelStrategyFactory;

    public TravelPlanner() {
        this.travelStrategyFactory = new TravelStrategyFactory();
    }

    public void bookHotel(final HotelBooking booking){
        this.hotelBooking = booking;
    }

    public String planTrip(final String travelMethod, final String from, final String to){
        final TravelStrategy strategy = this.travelStrategyFactory.getTravelStrategy(travelMethod);

        final String travel = strategy.travelPlan(from, to);
        final String hotel = hotelBooking!= null ? hotelBooking.toString(): "Отель не забронирован";

        return travel + "\n" + hotel;
    }
}
