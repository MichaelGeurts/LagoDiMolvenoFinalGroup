package nl.yacht.lagodimolveno;

import java.util.List;

public class Order {
    private List<Drink> drinks;
    private List<Dish> dishes;
    private List<Special> specials;
    private int tableNumber;

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

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    //endregion

    public Order(List<Drink> drinks, List<Dish> dishes, List<Special> specials, int tableNumber) {
        this.drinks = drinks;
        this.dishes = dishes;
        this.specials = specials;
        this.tableNumber = tableNumber;
    }

    // kan ook zijn dat dit een int wordt, ligt eraan of wij deze gaan returnen
    public void sum(List<Drink> drinks, List<Dish> dishes, List<Special> specials){
        //logica hier
    }

    public void cancel(){
        //logica hier
    }
}
