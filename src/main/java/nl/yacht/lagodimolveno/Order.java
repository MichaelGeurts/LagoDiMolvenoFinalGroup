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

    //Naar restaurant ??
    public void freeTable(Order order){

        for (Table correctTable: Restaurant.getTableList()) {
            if(correctTable.getTableNumber() == order.getTableNumber() && isPaid()){
                correctTable.setAvailable(true);
            }
        }

    }
    //Hierboven naar restaurant ??

    //Order object getter
    public Order correctOrder(int tableNumber, Guest g){
        for (Order correctOrder: Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())){
                return correctOrder;
                break;
            }
        }
    }
    //Hierboven objecct getter

/*
 * Bij de cancel methode werkt de verwerking van de stock nog niet. In de huidige code wordt 1 hoeveelheid stock van een dish
 *
 *
 *
 *
 *
 * HIER MEE VERDER
 */
    public void cancel(int tableNumber, Guest g){

        for (Order correctOrder: Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())){
                for (Drink drink:correctOrder.getDrinks()) {
                    drink.setDrinkStock(drink.getDrinkStock()+1);
                }
                for (Dish dish:correctOrder.getDishes()) {
                    int ingredient = dish.getIngredients().size();
                    for (Ingredient ingredient: dish.getIngredients()) {
                        ingredient.setNumberOfStock(ingredient.getNumberOfStock()+1);
                    }
                }
                Restaurant.getOrderList().remove(correctOrder);
            }
        }

    }

    public void cancel(Order myOrder){
        Restaurant.getOrderList().remove(myOrder);
    }



    /*
 * Input is tafelnummer, Guest object g en Drink drinkToAdd (het toe te voegen Drink object)
 * Vind het juiste Order object correctOrder uit de orderList van Restaurant, door middel van het tafelnummer en de naam van de gast
 * Voeg aan correctOrder een Drink object toe
 */
    public void addDrinkToOrder(int tableNumber, Guest g, Drink drinkToAdd){

        for (Order correctOrder: Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())){
                correctOrder.getDrinks().add(drinkToAdd);
            }
        }
        drinkToAdd.setDrinkStock(drinkToAdd.getDrinkStock()-1);
    }
/*
 * Input myOrder en Drink drinkToAdd (het toe te voegen Drink object)
 */
    public void addDrinkToOrder(Order myOrder, Drink drinkToAdd){
       myOrder.getDrinks().add(drinkToAdd);
       drinkToAdd.setDrinkStock(drinkToAdd.getDrinkStock()-1);
    }
/*
 * Input is tafelnummer, Guest object g, Drink drinkToRemove (het te verwijderen Drink object) en int amountToRemove voor hoeveelheid te verwijderen drankjes
 * Vind het juiste Order object correctOrder uit de orderList van Restaurant, door middel van het tafelnummer en de naam van de gast
 * Vind in correctOrder het index nummer van het Drink object dat je wil verwijderen en verwijder het object op deze index
 */
    public void removeDrinkFromOrder(int tableNumber, Guest g, Drink drinkToRemove, int amountToRemove){

        OUTER: for (Order correctOrder: Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())){
                int drinkCounter = 0;
                int index = 0;
                for (Drink drink : correctOrder.getDrinks()) {
                    if (drinkToRemove.equals(drink)){
                        correctOrder.getDrinks().remove(index);
                        drinkCounter++;
                        if(drinkCounter==amountToRemove){
                            drinkToRemove.setDrinkStock(drinkToRemove.getDrinkStock()+amountToRemove);
                            break OUTER;
                        }
                    }
                    index++;
                }
            }
        }
    }
/*
 * Input is Order myOrder en Drink drinkToRemove (het te verwijderen Drink object)
 */
    public void removeDrinkFromOrder(Order myOrder, Drink drinkToRemove, int amountToRemove){
       for(int i = 0; i <= amountToRemove; i++){
           int index = 0;
           for(Drink drink: myOrder.getDrinks()){
               if(drinkToRemove.equals(drink)){
                   myOrder.getDrinks().remove(index);
                   drinkToRemove.setDrinkStock(drinkToRemove.getDrinkStock()+amountToRemove);
                   break;
               }
               index++;
           }
       }
    }
/*
 * Input is tafelnummer, Guest object g, Drink drinkToAdd (het toe te voegen Drink object) en Drink drinkToRemove (het te verwijderen Drink object)
 * Vind het juiste Order object correctOrder uit de orderList van Restaurant, door middel van het tafelnummer en de naam van de gast
 * Vind in correctOrder het index nummer van het Drink object dat je wil verwijderen en vervang het object op deze index met drinkToAdd
 */
    public void changeDrinkInOrder(int tableNumber, Guest g, Drink drinkToAdd, Drink drinkToRemove){

        OUTER: for (Order correctOrder: Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())){
                int index = 0;
                for (Drink drinks : correctOrder.getDrinks()) {
                    if (drinkToRemove.equals(drinks)){
                        correctOrder.getDrinks().remove(index);
                        drinkToRemove.setDrinkStock(drinkToRemove.getDrinkStock()+1);
                        correctOrder.getDrinks().add(drinkToAdd);
                        drinkToAdd.setDrinkStock(drinkToAdd.getDrinkStock()-1);
                        break OUTER;
                    }
                    index++;
                }
            }
        }
    }
/*
 * Input is Order myOrder en Drink drinkToRemove (het te verwijderen Drink object) en Drink drinkToAdd (het toe te voegen Drink object)
 */
    public void changeDrinkInOrder(Order myOrder, Drink drinkToAdd, Drink drinkToRemove){
        int index = 0;
        for(Drink drink: myOrder.getDrinks()){
            if(drinkToRemove.equals(drink)){
                myOrder.getDrinks().remove(index);
                drinkToRemove.setDrinkStock(drinkToRemove.getDrinkStock()+1);
                myOrder.getDrinks().add(drinkToAdd);
                drinkToAdd.setDrinkStock(drinkToAdd.getDrinkStock()-1);
                break;
            }
            index++;
        }
    }


// GRENS VAN DONEHEID

    // BELOW MORE

    // WERK HIERBOVEN


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

}
