package nl.yacht.lagodimolveno;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Reservation {
    private LocalDateTime reservationTime;
    private int numberOfPeople;
    private Guest guest;
    private int tableNumber;

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

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
    //endregion

    public Reservation(LocalDateTime reservationTime, int numberOfPeople, Guest guest) {
        this.reservationTime = reservationTime;
        this.numberOfPeople = numberOfPeople;
        this.guest = guest;

        // Adds reservation to list of reservations
        List<Table> tableList = Restaurant.getTableList();

        // Finds tables in the list, checks if available and sets false to reserve a table
        for (Table tabl : tableList) {
            if (tabl.isAvailable()) {
                tabl.setAvailable(false);

                this.tableNumber = tabl.getTableNumber();
            }
        }
        Restaurant.getReservationList().add(this);
    }

    public void cancel(Guest guest) {


        List<Reservation> reservationList = Restaurant.getReservationList();
        // Go through the list of reservations
        int index = 0;
        for (Reservation res : reservationList) {
            if (guest.equals(res.guest)) {
                reservationList.remove(index);

                // Als de tafel gelijk is aan de gereserveerde tafel: maak de tafel available
                for (Table tabl : Restaurant.getTableList()) {
                    if (tabl.getTableNumber() == res.tableNumber) {
                        tabl.setAvailable(true);
                        //
                    }
                }

            }
            index++;
            // Gaat in de lijst verder zoeken index +1
        }
    }
}

