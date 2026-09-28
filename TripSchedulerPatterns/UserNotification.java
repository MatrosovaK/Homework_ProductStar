package org.TripSchedulerPatterns;

public class UserNotification implements TripObserver{

    private String username;

    public UserNotification(String username){
        this.username = username;
    }

    @Override
    public void update(Trip trip) {
        System.out.println("\nУведомление для пользователя " + username + ": \nПоездка в " +
                trip.getDestination() + " изменила статус на : " + trip.getStatus());
    }
}
