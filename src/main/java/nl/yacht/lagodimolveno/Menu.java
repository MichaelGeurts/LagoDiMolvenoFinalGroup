package nl.yacht.lagodimolveno;

import java.util.List;

public class Menu {
    private List<Drink> drinks;
    private List<Dish> dishes;
    private List<Special> specials;

    //region getters and setters
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

    public Menu(List<Drink> drinks, List<Dish> dishes, List<Special> specials) {
        this.drinks = drinks;
        this.dishes = dishes;
        this.specials = specials;
    }

    public boolean isDishAvailable(Dish dish){
        return  dish.isIngredientAvailable();
    }

    public boolean isDrinkAvailable(Drink drink){
        return false;
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
