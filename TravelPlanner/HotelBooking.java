package org.TravelPlanner;

public class HotelBooking {

    private String hotelName;
    private int nights;
    private boolean breakfastIncluded;

    static class Builder{
        private String hotelName;
        private int nights;
        private boolean breakfastIncluded;

        Builder(String hotelName) {
            this.hotelName = hotelName;
        }

        Builder nights(int nights){
            this.nights=nights;
            return this;
        }

        Builder breakfastIncluded(boolean breakfastIncluded) {
            this.breakfastIncluded = breakfastIncluded;
            return this;
        }

        HotelBooking build(){
            return new HotelBooking(this);
        }



    }
    private HotelBooking(final Builder builder){
        this.hotelName=builder.hotelName;
        this.nights= builder.nights;
        this.breakfastIncluded = builder.breakfastIncluded;
    }


    @Override
    public String toString() {
        return "Отель" + hotelName +
                "\nКоличество ночей: " + nights +
                "\nЗавтрак: " + breakfastIncluded +
                '}';
    }
}
