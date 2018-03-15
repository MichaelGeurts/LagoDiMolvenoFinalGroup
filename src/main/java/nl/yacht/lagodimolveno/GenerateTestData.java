package nl.yacht.lagodimolveno;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateTestData {

    public static void generate(Restaurant a) {
        a.initAllLists();
        generateDrinkList(a);
        generateIngredientList(a);
        generateDishList(a);
        generateTableList(a);
        generateSpecialList(a);
        generateReservationList(a);
        sumSomeCosts(a);

    }

    private static void generateReservationList(Restaurant a) {
    LocalDateTime.now();
        for(int i = 1; i < 10; i++){
            int testint = new Random().nextInt(4) + 1;
            int numberOfPerson = new Random().nextInt(8) + 1;
            Reservation res = new Reservation(LocalDate.now(), numberOfPerson, new Guest("Gereserveerde " + i, "061000000000", false, false));
        }
    }

    private static void generateSpecialList(Restaurant a) {
        List<Dish> starterDishes = new ArrayList<>();
        List<Dish> mainDishes = new ArrayList<>();
        List<Dish> dessertDishes = new ArrayList<>();

        for (Dish d : a.getDishList()) {
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
        for (int i = 1; i < 3; i++) {
            List<Dish> specialDishes = new ArrayList<>();
            specialDishes.add(starterDishes.get(new Random().nextInt(starterDishes.size())));
            specialDishes.add(mainDishes.get(new Random().nextInt(mainDishes.size())));
            specialDishes.add(dessertDishes.get(new Random().nextInt(dessertDishes.size())));
            Special s = new Special("Special nummer " + i, specialDishes, (double) (new Random().nextInt(80) + 1));
        }
    }

    private static void generateTableList(Restaurant a) {
        for (int i = 1; i < 30; i++) {
            int testint = new Random().nextInt(4) + 1;
            int numberOfSeats = 0;
            boolean isOccupied = true;

            if (new Random().nextInt(3) == 1) {
                isOccupied = false;
            }

            switch (testint) {
                case 1:
                    numberOfSeats = 2;
                    break;
                case 2:
                    numberOfSeats = 4;
                    break;
                case 3:
                    numberOfSeats = 6;
                    break;
                case 4:
                    numberOfSeats = 8;
                    break;
            }
            Table t = new Table(i, numberOfSeats, isOccupied);
        }
    }

    public static void generateDrinkList(Restaurant a) {

        for (int i = 1; i < 11; i++) {
            int testint = 1;
            boolean ishot = false;
            boolean isalcohol = false;
            if (new Random().nextInt(2) == testint) {
                isalcohol = true;
            }
            if (new Random().nextInt(2) == testint) {
                ishot = true;
            }
            Drink d = new Drink("Drank nummer" + i, "Hier komt beschrijving", ishot, isalcohol, new Random().nextInt(i) + 1, new Random().nextInt(i) + 1, true);
        }
    }

    public static void generateDishList(Restaurant a) {

        for (int i = 1; i < 11; i++) {
            List<Ingredient> lijst = new ArrayList<>();

            for (int it = 0; it < new Random().nextInt(7) + 1; it++) {
                lijst.add(a.getIngredientList().get(new Random().nextInt(19)));
            }


            Dish d = new Dish("Dish nummer" + i, "Andere beschrijving", lijst,
                    new Random().nextInt(50) + 1, CourseType.values()[new Random().nextInt(CourseType.values().length)],
                    DishType.values()[new Random().nextInt(DishType.values().length)], true);
        }
    }

    public static void generateIngredientList(Restaurant a) {
        for (int i = 1; i < 11; i++) {
            int testint = 1;
            boolean isAllergen = false;
            if (new Random().nextInt(4) == testint) {
                isAllergen = true;
            }
            Ingredient in = new Ingredient("Ingredient nummer" + i, isAllergen, null, new Random().nextInt(100), new Random().nextInt(i) + 1);
            a.getIngredientList().add(in);
        }
    }

    public static void sumSomeCosts(Restaurant a) {
        sum(a.getIngredientList());
        sum(a.getDishList());
        sum(a.getDrinkList());
        sum(a.getSpecialList());
    }

    private static double sum(List<?> lijstje) {
        double d = 0.0;
        String s = "";
        for (Object o : lijstje) {
            s = o.getClass().getSimpleName();
            switch (s) {
                case "Ingredient":
                    d = d + ((Ingredient) o).getCostPrice();
                    break;
                case "Drink":
                    d = d + ((Drink) o).getPrice();
                    break;
                case "Dish":
                    d = d + ((Dish) o).getPrice();
                    break;
                case "Special":
                    d = d + ((Special) o).getPrice();
                    break;
            }
        }
        return d;
    }
}
