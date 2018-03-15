package nl.yacht.lagodimolveno;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Reservation {
    private LocalDate reservationTime;
    private int numberOfPeople;
    private Guest guest;
    private int tableNumber;

    //region getters and setters
    public LocalDate getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDate reservationTime) {
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

    public Reservation(LocalDate reservationTime, int numberOfPeople, Guest guest) {
        this.reservationTime = reservationTime;
        this.numberOfPeople = numberOfPeople;
        this.guest = guest;

        if (numberOfPeople == 2 || numberOfPeople == 4 || numberOfPeople == 6) {
            checkNumberOfPeople(numberOfPeople, this);
        } else if (numberOfPeople == 8) {
            checkNumberOfPeople(8, this);
        } else if (numberOfPeople < 8) {
            checkNumberOfPeople(numberOfPeople + 1, this);
        }
    }

    private void checkNumberOfPeople(int numberOfPeople, Reservation res) {
        // Adds reservation to list of reservations
        List<Table> tableList = Restaurant.getTableList();
        boolean isRightTableAvailable = false;
        for (Table tabl : tableList) {
            if (tabl.isAvailable() && tabl.getNumberOfSeats() == numberOfPeople) {
                tabl.setAvailable(false);
                res.setTableNumber(tabl.getTableNumber());
                isRightTableAvailable = true;
                break;
            }
        }
        if(!isRightTableAvailable){
            System.out.println("Er is geen tafel voor het exacte aantal personen, misschien is er een tafel met meer plaatsen...");
            checkNumberOfPeople(numberOfPeople +2, res );
        }
        Restaurant.getReservationList().add(res);
    }

    public void cancel(Guest guest) {

        List<Reservation> reservationList = Restaurant.getReservationList();
        // Go through the list of reservations
        int index = 0;
        try {
            for (Reservation res : reservationList) {
                if (guest.equals(res.guest)) {
                    reservationList.remove(index);

                    // Als de tafel gelijk is aan de gereserveerde tafel: maak de tafel available
                    for (Table tabl : Restaurant.getTableList()) {
                        if (tabl.getTableNumber() == res.tableNumber) {
                            tabl.setAvailable(true);
                            break;
                        }
                    }
                }
                index++;
            }
        } catch (ConcurrentModificationException ex) {
            // Hier iets doen ivm exception
        }
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationTime=" + reservationTime +
                ", numberOfPeople=" + numberOfPeople +
                ", guest=" + guest +
                ", tableNumber=" + tableNumber +
                '}';
    }
}

