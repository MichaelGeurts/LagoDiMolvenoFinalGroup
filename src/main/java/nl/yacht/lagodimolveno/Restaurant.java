package nl.yacht.lagodimolveno;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static List<Drink> drinkList;
    private static List<Dish> dishList;
    private static List<Ingredient> ingredientList;
    private static List<Reservation> reservationList;
    private static List<Special> specialList;
    private static List<Order> orderList;
    private static List<Table> tableList;

    //region getters and setters
    public static List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public static List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public static List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public static List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public static List<Special> getSpecialList() {
        return specialList;
    }

    public void setSpecialList(List<Special> specialList) {
        this.specialList = specialList;
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public static List<Table> getTableList() {
        return tableList;
    }

    public static void setTableList(List<Table> tableList) {
        Restaurant.tableList = tableList;
    }
    //endregion

    //region AddToList
    public static void addSpecialToList(Special s) {
        specialList.add(s);
    }

    public static void addDrinkToList(Drink d) {
        drinkList.add(d);
    }

    public static void addDishToList(Dish d) {
        dishList.add(d);
    }

    public static void addIngredientToList(Ingredient i) {
        ingredientList.add(i);
    }

    public static void addTableToList(Table t) {
        tableList.add(t);
    }

    public static void addOrderToList(Order o) {
        orderList.add(o);
    }

    public static void addReservationToList(Reservation r) {
        reservationList.add(r);
    }
    //endregion

    //region RemoveFromList
    public static void removeSpecialFromList(Special s) {
        int index = 0;
        for (Special special : specialList) {
            if (special.getName().equals(s.getName())) {
                specialList.remove(index);
            }
            index++;
        }
    }

    public static void removeDrinkFromList(Drink d) {
        int index = 0;
        for (Drink drink : drinkList) {
            if (drink.getName().equals(d.getName())) {
                drinkList.remove(index);
            }
            index++;
        }
    }

    public static void removeDishFromList(Dish d) {
        int index = 0;
        for (Dish dish : dishList) {
            if (dish.getName().equals(d.getName())) {
                dishList.remove(index);
            }
            index++;
        }
    }

    public static void removeIngredientFromList(Ingredient i) {
        int index = 0;
        for (Ingredient ingredient : ingredientList) {
            if (ingredient.getName().equals(i.getName())) {
                ingredientList.remove(index);
            }
            index++;
        }
    }

    public static void removeTableFromList(Table t) {
        int index = 0;
        for (Table table : tableList) {
            if (table.getTableNumber() == t.getTableNumber()) {
                tableList.remove(index);
            }
            index++;
        }
    }

    public static void removeOrderFromList(Order o) {
        int index = 0;
        for (Order order : orderList) {
            if (order.getGuest().getName().equals(o.getGuest().getName()) && order.getTableNumber() == o.getTableNumber()) {
                orderList.remove(index);
            }
            index++;
        }
    }

    public static void removeReservationFromList(Reservation r) {
        int index = 0;
        for (Reservation reservation : reservationList) {
            if (reservation.getGuest().getName().equals(r.getGuest().getName())) {
                reservationList.remove(index);
            }
            index++;
        }
    }
    //endregion

    public void initAllLists() {
        drinkList = new ArrayList<>();
        dishList = new ArrayList<>();
        ingredientList = new ArrayList<>();
        reservationList = new ArrayList<>();
        specialList = new ArrayList<>();
        orderList = new ArrayList<>();
        tableList =new ArrayList<>();
    }

    public static boolean isDrinkAvailable(Drink d) {
        for (Drink drink : drinkList) {
            if (drink.getName().equals(d.getName()) && drink.getDrinkStock() > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIngredientAvailable(Ingredient i) {
        for (Ingredient ingredient : ingredientList) {
            if (ingredient.getName().equals(i.getName()) && ingredient.getNumberOfStock() > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDishAvailable(Dish d) {
        for (Ingredient i : d.getIngredients()) {
            if (!isIngredientAvailable(i)) {
                return false;
            }
        }
        return true;
    }
}
