package nl.yacht.lagodimolveno;

import java.time.LocalDateTime;

public class Reservation {
    private LocalDateTime reservationTime;
    private int numberOfPeople;
    private Guest guest;

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
    }

    public void cancel(String reason, Guest guest) {

        // for guest =
        for (guest, reservationTime, numberOfPeople == guest, reservationTime, numberOfPeople) {



            // Voor gast, reserveringstijd en aantalmensen ==
            if (reason == null) {


            else


            }
        // ittereer door een lijst van reservaties
        // voor elke reservatie, is de reserveerder gelijk aan guest
        // haal reservatie uit lijst.
        //


        // Reden geven


        // Komt nog een Reservations<List> bij


    }
}
