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

    public void addDrinktoOrder(int tableNumber, Guest g, Drink drink){

        for (Order correctOrder: Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equals(g.getName())){
                correctOrder.getDrinks().add(drink);
            }
        }

    }

    public void removeDrinkFromOrder(int tableNumber, Guest g, Drink drink, int amountOfDrinks){

        for (Order correctOrder: Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest() == g){

                int index = 0;
                int drinksCounter = 0;
                LOOP: for (Drink drinks : correctOrder.getDrinks()) {
                    if (drink.equals(drinks));{
                        correctOrder.getDrinks().remove(index);
                        drinksCounter++;
                        if(drinksCounter==amountOfDrinks){
                            break LOOP;
                        }
                    }
                }
            }
        }
    }

    public void changeDrinkFromOrder(int tableNumber, Guest g, Drink drinkToAdd, Drink drinkToRemove, int amountOfDrinks){

        for (Order correctOrder: Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest() == g){

                int index = 0;
                int drinksCounter = 0;
                LOOP: for (Drink drinks : correctOrder.getDrinks()) {
                    if (drinkToRemove.equals(drinks));{
                        correctOrder.getDrinks().set(index, drinkToAdd);
                        drinksCounter++;
                        if(drinksCounter==amountOfDrinks){
                            break LOOP;
                        }
                    }
                }
            }
        }
    }


    /*
     *  Hieronder is oude code
     *  Wordt nog aangepast op basis van de eerste 3 methodes
     */





    public void addDish(int tableNumber, Guest g, Dish dish){

        for (Order correctOrder: Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest() == g){
                correctOrder.getDishes().add(dish);
            }
        }

    }

    public void removeDish(int tableNumber, Guest g, Dish dish){

        for (Order correctOrder: Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest() == g){
                correctOrder.getDishes().remove(dish);
            }
        }

    }

    public void addSpecial(int tableNumber, Guest g, Special special){

        for (Order correctOrder: Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest() == g){
                correctOrder.getSpecials().add(special);
            }
        }

    }

    public void removeSpecial(int tableNumber, Guest g, Special special){

        for (Order correctOrder: Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest() == g){
                correctOrder.getSpecials().remove(special);
            }
        }

    }

    public void cancel(int tableNumber, Guest g){

        for (Order correctOrder: Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest() == g){
                Restaurant.getOrderList().remove(correctOrder);
            }
        }

    }

    //Naar restaurant
    public void freeTable(Order order){

        for (Table correctTable: Restaurant.getTableList()) {
            if(correctTable.getTableNumber() == order.getTableNumber() && isPaid()){
                correctTable.setAvailable(true);
            }
        }
        
    }
}
