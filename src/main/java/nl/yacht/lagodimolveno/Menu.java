package nl.yacht.lagodimolveno;

import java.util.List;

public class Menu {
    private boolean isAvailable;
    private List<Drink> drinks;
    private List<Dish> dishes;
    private List<Special> specials;

    //region getters and setters
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Special> getSpecials() {
        return specials;
    }

    public void setSpecials(List<Special> specials) {
        this.specials = specials;
    }
    //endregion

    public Menu(boolean isAvailable, List<Drink> drinks, List<Dish> dishes, List<Special> specials) {
        this.isAvailable = isAvailable;
        this.drinks = drinks;
        this.dishes = dishes;
        this.specials = specials;
    }

    public boolean isDishAvailable(Dish dish){
        boolean result = true;








        return result;
    }

    public boolean isDrinkAvailable(Drink drink){
        //logica maken
        return true;
    }

    public void editDishMenu(List<Dish> dishes){
        //logica maken
    }

    public void editSpecialMenu(List<Special> specials){
        //logica maken
    }

    public void editDrinkMenu(List<Drink> drinks){
        //logica maken
    }
}
