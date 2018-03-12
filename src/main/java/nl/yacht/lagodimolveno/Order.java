package nl.yacht.lagodimolveno;

import java.util.List;

public class Order {
    private List<Drink> drinks;
    private List<Dish> dishes;
    private List<Special> specials;
    private int tableNumber;
    private Guest guest;
    private boolean isPaid;

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

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    //endregion

    public Order(List<Drink> drinks, List<Dish> dishes, List<Special> specials, int tableNumber, Guest guest) {
        this.drinks = drinks;
        this.dishes = dishes;
        this.specials = specials;
        this.tableNumber = tableNumber;
        this.guest = guest;
    }

    // kan ook zijn dat dit een int wordt, ligt eraan of wij deze gaan returnen
    public void sum(List<Drink> drinks, List<Dish> dishes, List<Special> specials){

    }

    public void cancel(){
        //logica hier
    }
    
    public void freeTable(Order order){

        for (Table correctTable: Restaurant.getTableList()) {
            if(correctTable.getTableNumber() == order.getTableNumber()){
                correctTable.setAvailable(true);
            }
        }
        
    }
}
