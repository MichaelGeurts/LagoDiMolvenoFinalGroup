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

    public void initAllLists() {
        drinkList = new ArrayList<>();
        dishList = new ArrayList<>();
        ingredientList = new ArrayList<>();
        reservationList = new ArrayList<>();
        specialList = new ArrayList<>();
        orderList = new ArrayList<>();
    }

    public static void addSpecialToList(Special s) {
        specialList.add(s);
    }
}
