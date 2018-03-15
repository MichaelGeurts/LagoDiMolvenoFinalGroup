package nl.yacht.lagodimolveno;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        GenerateTestData.generate(restaurant);
        methodeDemoJurgen(restaurant);
    }

    private static void methodeDemoJurgen(Restaurant restaurant) {
        //Maak een nieuwe reservering
        makeReservation(restaurant);
        
        //Wijzig een reservering
        editReservation(restaurant);

        //Verwijder een reservering
        deleteReservation(restaurant);

    }

    private static void deleteReservation(Restaurant restaurant) {
        System.out.println("");
        printReservationList(restaurant, "---De reserveringen voordat er een reservering wordt verwijderd ---");
        System.out.println("");
        for(Reservation reservation : restaurant.getReservationList()){
            if(reservation.getGuest().getName().equals("Jurgen")){
                System.out.println(reservation.getGuest().getName() + " is er achter gekomen dat hij helemaal niet op die datum kan. Daarom annuleert hij nu de reservering...");
                reservation.cancel(reservation.getGuest());
                break;
            }
        }
        System.out.println("");
        printReservationList(restaurant, "---De reserveringen nadat er een reservering wordt verwijderd ---");
        System.out.println("");
    }

    private static void printReservationList(Restaurant restaurant, String s) {
        System.out.println(s);
        for(Reservation reservation : restaurant.getReservationList()){
            System.out.println("Gereserveerd door: " + reservation.getGuest().getName() + " | op datum: " + reservation.getReservationTime() + " | voor het aantal personen:" + reservation.getNumberOfPeople() + "| op tafelnummer: " + reservation.getTableNumber());
        }
    }

    private static void printTableList(Restaurant restaurant, String s){
        System.out.println(s);
        for(Table t : restaurant.getTableList()){
            System.out.println("Tafelnummer " + t.getTableNumber() + " heeft het aantal stoelen: " + t.getNumberOfSeats() + " en is beschikbaar: " + t.isAvailable());
        }
    }

    private static void editReservation(Restaurant restaurant) {
        //Bestaat nog niet, wordt gemaakt
    }

    private static void makeReservation(Restaurant restaurant) {
        Guest g = new Guest("Jurgen", "0625486745", false, false);
        System.out.println("");
        printTableList(restaurant, "---De tafels voordat er een reservering wordt gemaakt ---");
        System.out.println("");
        Reservation res = new Reservation(LocalDate.now(), 5, g);
        System.out.println(g.getName() + " heeft gereserveerd op " + res.getReservationTime() + "  voor " + res.getNumberOfPeople() + " personen");
        System.out.println("Doordat er " + res.getNumberOfPeople() + " personen zijn, is er tafel " + res.getTableNumber() + " gereserveerd want deze tafel was vrij en heeft " + getNumberOfSeatsOfReserverdTable(res.getTableNumber() , restaurant) + " stoelen");
        System.out.println("");
        printTableList(restaurant, "---De tafels nadat er een reservering wordt gemaakt ---");
        System.out.println("");
    }

    private static int getNumberOfSeatsOfReserverdTable(int tableNumber, Restaurant res) {
        int numberOfSeats = 0;
        for (Table t : res.getTableList()) {
            if (t.getTableNumber() == tableNumber) {
                numberOfSeats = t.getNumberOfSeats();
            }
        }
        return numberOfSeats;
    }
}
