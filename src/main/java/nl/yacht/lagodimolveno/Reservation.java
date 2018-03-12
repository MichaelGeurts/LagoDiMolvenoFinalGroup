package nl.yacht.lagodimolveno;

import java.time.LocalDateTime;
import java.util.List;

public class Reservation {
    private LocalDateTime reservationTime;
    private int numberOfPeople;
    private Guest guest;
//  private String reasonOfCancel;

    //region getters and setters
    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
    //endregion

    public Reservation(LocalDateTime reservationTime, int numberOfPeople, Guest guest) {
        this.reservationTime = reservationTime;
        this.numberOfPeople = numberOfPeople;
        this.guest = guest;

        // voeg deze reservatie toe aan lijst van reservaties
        Restaurant.getReservationList().add(this);

        List<Table> tableList =
    }

    public void cancel(String reason, Guest guest) {

        List<Reservation> reservationList = Restaurant.getReservationList();

        // Go through the list of reservations
        for (Reservation res : reservationList) {
            int index = 0;
            if (guest.equals(res.guest)) {
                reservationList.remove(index);
            }
            index++;
            // Gaat in de lijst verder zoeken index +1

        }

        // evt reden geven met  reasonOfCancel;


    }
}
