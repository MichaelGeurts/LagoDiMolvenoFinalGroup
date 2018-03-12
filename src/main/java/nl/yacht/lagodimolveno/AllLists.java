package nl.yacht.lagodimolveno;

import java.util.ArrayList;
import java.util.List;

public class AllLists {

    private List<Drink> drinkList;
    private List<Dish> dishList;
    private List<Ingredient> ingredientList;
    private List<Special> specialList;
    private  static List<Order> orderList;

    //region getters and setters
    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<Special> getSpecialList() {
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
    //endregion

    public void initAllLists() {
        drinkList = new ArrayList<>();
        dishList = new ArrayList<>();
        ingredientList = new ArrayList<>();
        specialList = new ArrayList<>();
        orderList = new ArrayList<>();
    }

}
