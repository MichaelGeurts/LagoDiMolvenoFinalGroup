package nl.yacht.lagodimolveno;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        GenerateTestData.generate(restaurant);
        methodeDemoJurgen(restaurant);
        methodeDemoPetri(restaurant);
        methodeDemoMichael(restaurant);
    }

    //region Michael
    private static void methodeDemoMichael(Restaurant restaurant) {
        List<Dish> dishesFromRestaurant = restaurant.getDishList();
        List<Ingredient> ingredientsFromRestaurant = restaurant.getIngredientList();
        List<Special> specialsFromRestaurant = restaurant.getSpecialList();

        dishLogica(dishesFromRestaurant, ingredientsFromRestaurant);
        System.out.println("");
        specialLogica(specialsFromRestaurant, dishesFromRestaurant);
    }

    private static void specialLogica(List<Special> specialsFromRestaurant, List<Dish> dishesFromRestaurant) {
        Special s = specialsFromRestaurant.get(0);
        System.out.println(s.getName() + " heeft de volgende gerechten ");
        for(Dish d : s.getDishes()){
            System.out.println(d.getName());
        }
        System.out.println("");
        addDish(s,dishesFromRestaurant);
        System.out.println("");
        editDish(s, dishesFromRestaurant);
        System.out.println("");
        removeDish(s, dishesFromRestaurant);
    }

    private static void removeDish(Special s, List<Dish> dishesFromRestaurant) {
        System.out.println("We verwijderen het " + s.getDishes().get(0).getName());
        s.editSpecial(s,s.getDishes().get(0), null);
        System.out.println("");
        System.out.println("Nu bevat het gerecht de volgende gerechten: ");
        for(Dish d : s.getDishes()){
            System.out.println(d.getName());
        }
    }

    private static void editDish(Special s, List<Dish> dishesFromRestaurant) {
        System.out.println("We passen het " + s.getDishes().get(0).getName() + " aan naar " + dishesFromRestaurant.get(9).getName());
        s.editSpecial(s,s.getDishes().get(0), dishesFromRestaurant.get(9));
        System.out.println("");
        System.out.println("Nu bevat het gerecht de volgende gerechten: ");
        for(Dish d : s.getDishes()){
            System.out.println(d.getName());
        }
    }

    private static void addDish(Special s, List<Dish> dishesFromRestaurant) {
        System.out.println("We voegen het " + dishesFromRestaurant.get(4).getName() + " toe");
        s.addDishToSpecial(s,dishesFromRestaurant.get(4));
        System.out.println("");
        System.out.println("Nu bevat het gerecht de volgende gerechten: ");
        for(Dish d : s.getDishes()){
            System.out.println(d.getName());
        }
    }

    private static void dishLogica(List<Dish> dishesFromRestaurant, List<Ingredient>ingredientsFromRestaurant ) {
        Dish d = dishesFromRestaurant.get(2);
        System.out.println(d.getName() + " heeft de volgende ingredienten " );
        for(Ingredient i : d.getIngredients()){
            System.out.println(i.getName());
        }
        System.out.println("");
        addIngredient(d, ingredientsFromRestaurant);
        System.out.println("");
        editIngredient(d, ingredientsFromRestaurant);
        System.out.println("");
        removeIngredient(d, ingredientsFromRestaurant);
    }

    private static void removeIngredient(Dish d, List<Ingredient> ingredientsFromRestaurant) {
        System.out.println("We verwijderen het " + d.getIngredients().get(0).getName());
        d.editIngredient(d,d.getIngredients().get(0), null);
        System.out.println("");
        System.out.println("Nu bevat het gerecht de volgende ingredienten: ");
        for(Ingredient i : d.getIngredients()){
            System.out.println(i.getName());
        }
    }

    private static void editIngredient(Dish d, List<Ingredient> ingredientsFromRestaurant) {
        System.out.println("We passen het " + d.getIngredients().get(0).getName() + " aan naar " + ingredientsFromRestaurant.get(9).getName());
        d.editIngredient(d,d.getIngredients().get(0),ingredientsFromRestaurant.get(9));
        System.out.println("");
        System.out.println("Nu bevat het gerecht de volgende ingredienten: ");
        for(Ingredient i : d.getIngredients()){
            System.out.println(i.getName());
        }
    }

    private static void addIngredient(Dish d, List<Ingredient> ingredientsFromRestaurant) {
        System.out.println("We voegen het " + ingredientsFromRestaurant.get(4).getName() + " toe");
        d.addIngredient(d,ingredientsFromRestaurant.get(4));
        System.out.println("");
        System.out.println("Nu bevat het gerecht de volgende ingredienten: ");
        for(Ingredient i : d.getIngredients()){
            System.out.println(i.getName());
        }
    }
    //endregion

    //region Jurgen
    private static void methodeDemoJurgen(Restaurant restaurant) {
        //Maak een nieuwe reservering
        makeReservation(restaurant);

        //Wijzig een reservering
        editReservation(restaurant);

        //Verwijder een reservering
        deleteReservation(restaurant);

    }

    private static void makeReservation(Restaurant restaurant) {
        Guest g = new Guest("Jurgen", "0625486745", false, false);
        System.out.println("");
        printTableList(restaurant, "---De tafels voordat er een reservering wordt gemaakt ---");
        System.out.println("");
        Reservation res = makeReservation(g, 3);
        System.out.println(g.getName() + " heeft gereserveerd op " + res.getReservationTime() + "  voor " + res.getNumberOfPeople() + " personen");
        System.out.println("Doordat er " + res.getNumberOfPeople() + " personen zijn, is er tafel " + res.getTableNumber() + " gereserveerd want deze tafel was vrij en heeft " + getNumberOfSeatsOfReserverdTable(res.getTableNumber(), restaurant) + " stoelen");
        System.out.println("");
        printTableList(restaurant, "---De tafels nadat er een reservering wordt gemaakt ---");
        System.out.println("");
    }

    private static Reservation makeReservation(Guest g, int nop) {
        return new Reservation(LocalDate.now(), nop, g);
    }

    private static void editReservation(Restaurant restaurant) {
        //Bestaat nog niet, wordt gemaakt
    }

    private static void deleteReservation(Restaurant restaurant) {
        System.out.println("");
        printReservationList(restaurant, "---De reserveringen voordat er een reservering wordt verwijderd ---");
        System.out.println("");
        for (Reservation reservation : restaurant.getReservationList()) {
            if (reservation.getGuest().getName().equals("Jurgen")) {
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
        for (Reservation reservation : restaurant.getReservationList()) {
            System.out.println("Gereserveerd door: " + reservation.getGuest().getName() + " | op datum: " + reservation.getReservationTime() + " | voor het aantal personen:" + reservation.getNumberOfPeople() + "| op tafelnummer: " + reservation.getTableNumber());
        }
    }

    private static void printTableList(Restaurant restaurant, String s) {
        System.out.println(s);
        for (Table t : restaurant.getTableList()) {
            System.out.println("Tafelnummer " + t.getTableNumber() + " heeft het aantal stoelen: " + t.getNumberOfSeats() + " en is beschikbaar: " + t.isAvailable());
        }
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
    //endregion

    //region Petri
    private static void methodeDemoPetri(Restaurant restaurant) {
        Guest g = new Guest("Petri", "0624896715", false, false);
        Reservation res = makeReservation(g, 3);
        System.out.println("--- Het menu bestaat uit ---");
        printMenu(restaurant);
        Order order = new Order(selectDrinks(restaurant), selectDishes(restaurant), selectSpecials(restaurant), res.getTableNumber(), g);
        System.out.println(g.getName() + " Bestelt het volgende: ");
        printOrder(order);
        toevoegen(restaurant, order);
        wijzigen(restaurant, order);
        verwijderen(restaurant, order);
    }

    private static void verwijderen(Restaurant restaurant, Order order) {
        System.out.println("Er wordt 1 drankje verwijderd van de order namelijk: " + order.getDrinks().get(0).getName());
        order.removeDrinkFromOrder(order,order.getDrinks().get(0),1 );
        printOrder(order);
        System.out.println("Er wordt 1 gerecht verwijderd van de order namelijk: " + order.getDishes().get(0).getName());
        order.removeDishFromOrder(order,order.getDishes().get(0) );
        printOrder(order);
        System.out.println("Er wordt 1 special verwijderd van de order namelijk: " + order.getSpecials().get(0).getName());
        order.removeSpecialFromOrder(order,order.getSpecials().get(0));
        printOrder(order);
    }

    private static void wijzigen(Restaurant restaurant, Order order) {
        System.out.println("Er wordt 1 drankje gewijzigd van de order namelijk: " + order.getDrinks().get(0).getName() + " wordt: " + restaurant.getDrinkList().get(2).getName());
        order.changeDrinkInOrder(order,restaurant.getDrinkList().get(2), order.getDrinks().get(0), 1);
        printOrder(order);
        System.out.println("Er wordt 1 gerecht gewijzigd van de order namelijk: " + order.getDishes().get(0).getName() + " wordt: " + restaurant.getDishList().get(5).getName());
        order.changeDishInOrder(order,restaurant.getDishList().get(5), order.getDishes().get(0));
        printOrder(order);
        System.out.println("Er wordt 1 special gewijzigd van de order namelijk: " + order.getSpecials().get(0).getName() + " wordt: " + restaurant.getSpecialList().get(1).getName());
        order.changeSpecialInOrder(order,restaurant.getSpecialList().get(1), order.getSpecials().get(0));
        printOrder(order);
    }

    private static void toevoegen(Restaurant restaurant, Order order) {
        System.out.println("Er wordt 1 drankje toegevoegd aan de order namelijk: " + restaurant.getDrinkList().get(9).getName());
        order.addDrinkToOrder(order, restaurant.getDrinkList().get(9));
        printOrder(order);
        System.out.println("Er wordt 1 gerecht toegevoegd aan de order namelijk: " + restaurant.getDishList().get(4).getName());
        order.addDishToOrder(order, restaurant.getDishList().get(4));
        printOrder(order);
        System.out.println("Er wordt 1 special toegevoegd aan de order namelijk: " + restaurant.getSpecialList().get(0).getName());
        order.addSpecialToOrder(order, restaurant.getSpecialList().get(1));
        printOrder(order);
    }

    private static void printOrder(Order order) {
        System.out.println("--- Order ---");
        printDrinks(order.getDrinks(), true);
        printDishes("", order.getDishes(), true);
        printSpecials(order.getSpecials(), true);
        System.out.println("");
    }

    private static void printMenu(Restaurant restaurant) {
        System.out.println("-- Drankjes --");
        printDrinks(restaurant.getDrinkList(), false);
        System.out.println("");
        System.out.println("-- Gerechten --");
        determineCourseType(restaurant);
        System.out.println("");
        System.out.println("-- Specials --");
        printSpecials(restaurant.getSpecialList(), false);
    }

    private static void printSpecials(List<Special> specialList, boolean isOrder) {
        for(Special s : specialList){
            if(isOrder){
                System.out.println(s.getName());
            }else{
                System.out.println(s.getName() + " € " + s.getPrice());
                printDishes("- Inhoud -", s.getDishes(), true);
            }
        }
    }

    private static void printDrinks(List<Drink> drinkList, boolean isOrder) {
        for(Drink d : drinkList){
            if(isOrder){
                System.out.println(d.getName());
            }else{
                System.out.println(d.getName() + " € " + d.getPrice());
            }
        }
    }

    private static void determineCourseType(Restaurant restaurant) {
        List<Dish> starterDishes = new ArrayList<>();
        List<Dish> mainDishes = new ArrayList<>();
        List<Dish> dessertDishes = new ArrayList<>();

        for (Dish d : restaurant.getDishList()) {
            switch (d.getCourseType()) {
                case MAIN:
                    mainDishes.add(d);
                    break;
                case DESSERT:
                    dessertDishes.add(d);
                    break;
                case STARTER:
                    starterDishes.add(d);
                    break;
            }
        }

        printDishes("- Starter -", starterDishes, false);
        printDishes("- Main -", mainDishes, false);
        printDishes("- Dessert -", dessertDishes, false);
    }

    private static void printDishes(String s, List<Dish> dishes, boolean isSpecial) {
        System.out.println(s);
        for(Dish d : dishes){
            if(isSpecial){
                System.out.println(d.getName());
            }else{
                System.out.println(d.getName() + " € "+ d.getPrice());
            }
        }
        System.out.println("");
    }

    private static List<Dish> selectDishes(Restaurant restaurant) {
        int counter = 1;
        List<Dish> returnToOrderDishes = new ArrayList<>();
        for (Dish d : restaurant.getDishList()) {
            if (counter <= 2) {
                if (1 == (new Random().nextInt(5) +1)) {
                    returnToOrderDishes.add(d);
                    counter++;
                }
            } else {
                break;
            }
        }
        return returnToOrderDishes;
    }

    private static List<Special> selectSpecials(Restaurant restaurant) {
        List<Special> returnToOrderDishes = new ArrayList<>();
        for (Special s : restaurant.getSpecialList()) {
            if (1 == (new Random().nextInt(3) + 1)) {
                returnToOrderDishes.add(s);
            }
        }
        return returnToOrderDishes;
    }

    private static List<Drink> selectDrinks(Restaurant restaurant) {
        int counter = 1;
        List<Drink> returnToOrderDrinks = new ArrayList<>();
        for (Drink d : restaurant.getDrinkList()) {
            if (counter <= 3) {
                if (1 == (new Random().nextInt(5) + 1)) {
                    returnToOrderDrinks.add(d);
                    counter++;
                }
            } else {
                break;
            }
        }
        return returnToOrderDrinks;
    }
    //endregion
}
