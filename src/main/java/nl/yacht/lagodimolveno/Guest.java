package nl.yacht.lagodimolveno;

import java.util.HashMap;
import java.util.List;

public class Guest {
    private String name;
    private String telephoneNumber;
    private boolean hasReservation;
    private boolean isHotelGuest;

    //region getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public boolean isHasReservation() {
        return hasReservation;
    }

    public void setHasReservation(boolean hasReservation) {
        this.hasReservation = hasReservation;
    }

    public boolean isHotelGuest() {
        return isHotelGuest;
    }

    public void setHotelGuest(boolean hotelGuest) {
        isHotelGuest = hotelGuest;
    }
    //endregion

    public Guest(String name, String telephoneNumber, boolean hasReservation, boolean isHotelGuest) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.hasReservation = hasReservation;
        this.isHotelGuest = isHotelGuest;
    }

    public void orderFood(List<Drink> drinks, HashMap<Integer, Object> hmap){
        //logica maken
    }

    public void payBill(Order order){
        //logica maken
    }

}
