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
        Restaurant.addOrderToList(this);
    }

    //Juiste Order object getter aan de hand van tablenumber en Guest g
    public void findOrderToCancel(int tableNumber, Guest g) {
        for (Order correctOrder : Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())) {
                cancelOrder(correctOrder);
            }
        }
    }
    //Cancel Order methode. Nog geen funcionaliteit voor aanpassen stock ingredienten voor dishes en specials
    public void cancelOrder(Order myOrder) {
        for (Drink drink : myOrder.getDrinks()) {
            drink.setDrinkStock(drink.getDrinkStock() + 1);
        }
        int index = 0;
        for (Order orderToCancel:Restaurant.getOrderList()) {
            if(orderToCancel.equals(myOrder)){
                Restaurant.getOrderList().remove(index);
                index++;
            }
        }
    }

    /*
     * Hieronder staan de Drankjes
     */

    //Juiste Order object getter aan de hand van tablenumber en Guest g. Verdere input: Drink die toegevoegd moet worden.
    public void findOrderToAddDrinkTo(int tableNumber, Guest g, Drink drinkToAdd) {
        for (Order correctOrder : Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())) {
                addDrinkToOrder(correctOrder, drinkToAdd);
            }
        }
    }
    //Add Drink to Order
    public void addDrinkToOrder(Order myOrder, Drink drinkToAdd) {
        myOrder.getDrinks().add(drinkToAdd);
        drinkToAdd.setDrinkStock(drinkToAdd.getDrinkStock() - 1);
    }
    //Juiste Order object getter aan de hand van tablenumber en Guest g. Verdere input: Drink die verwijderd moet worden en aantal te verwijderen.
    public void findOrderToRemoveDrinkFrom(int tableNumber, Guest g, Drink drinkToAdd, int amountToRemove) {
        for (Order correctOrder : Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())) {
                removeDrinkFromOrder(correctOrder, drinkToAdd, amountToRemove);
            }
        }
    }
    //Remove a certain amount of Drink from order
    public void removeDrinkFromOrder(Order myOrder, Drink drinkToRemove, int amountToRemove) {
        for (int i = 0; i < amountToRemove; i++) {
            int index = 0;
            for (Drink drink : myOrder.getDrinks()) {
                if (drinkToRemove.equals(drink)) {
                    myOrder.getDrinks().remove(index);
                    break;
                }
                index++;
            }
        }
        drinkToRemove.setDrinkStock(drinkToRemove.getDrinkStock() + amountToRemove);
    }
    //Juiste Order object getter aan de hand van tablenumber en Guest g. Verdere input: Drink toe te voegen, Drink te verwijderen, aantal te veranderen.
    public void findOrderToChangeDrinkIn(int tableNumber, Guest g, Drink drinkToAdd, Drink drinkToRemove, int amountToChange) {
        for (Order correctOrder : Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())) {
                changeDrinkInOrder(correctOrder, drinkToAdd, drinkToRemove, amountToChange);
            }
        }
    }
    //Change a certain amount of Drink in Order
    public void changeDrinkInOrder(Order myOrder, Drink drinkToAdd, Drink drinkToRemove, int amountToChange) {
        for (int i = 0; i < amountToChange; i++) {
            int index = 0;
            for (Drink drink : myOrder.getDrinks()) {
                if (drinkToRemove.equals(drink)) {
                    myOrder.getDrinks().remove(index);
                    drinkToRemove.setDrinkStock(drinkToRemove.getDrinkStock() + 1);
                    myOrder.getDrinks().add(drinkToAdd);
                    drinkToAdd.setDrinkStock(drinkToAdd.getDrinkStock() - 1);
                    break;
                }
                index++;
            }
        }
    }

    /*
     * Hieronder staan de Dishes
     */


    //Juiste Order object getter aan de hand van tablenumber en Guest g. Verdere input: Dish die toegevoegd moet worden.
    public void findOrderToAddDishTo(int tableNumber, Guest g, Dish dishToAdd) {
        for (Order correctOrder : Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())) {
                addDrinkToOrder(correctOrder, dishToAdd);
            }
        }
    }
    //Add Dish to Order
    public void addDrinkToOrder(Order myOrder, Dish dishToAdd) {
        myOrder.getDishes().add(dishToAdd);
        //Code om ingredienten voorraad aan te passen
    }
    //Juiste Order object getter aan de hand van tablenumber en Guest g. Verdere input: Dish die verwijderd moet worden.
    public void findOrderToRemoveDishFrom(int tableNumber, Guest g, Dish dishToAdd) {
        for (Order correctOrder : Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())) {
                removeDrinkFromOrder(correctOrder, dishToAdd);
            }
        }
    }
    //Remove a Dish from order
    public void removeDrinkFromOrder(Order myOrder, Dish dishToRemove) {
            int index = 0;
            for (Dish dish : myOrder.getDishes()) {
                if (dishToRemove.equals(dish)) {
                    myOrder.getDrinks().remove(index);
                    break;
                }
                index++;
            }
        //Code om ingredienten voorraad aan te passen
    }
    //Juiste Order object getter aan de hand van tablenumber en Guest g. Verdere input: Dish toe te voegen, Dish te verwijderen.
    public void findOrderToChangeDishIn(int tableNumber, Guest g, Dish dishToAdd, Dish dishToRemove) {
        for (Order correctOrder : Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())) {
                changeDishInOrder(correctOrder, dishToAdd, dishToRemove);
            }
        }
    }
    //Change a Dish in Order
    public void changeDishInOrder(Order myOrder, Dish dishToAdd, Dish dishToRemove) {
            int index = 0;
            for (Dish dish : myOrder.getDishes()) {
                if (dishToRemove.equals(dish)) {
                    myOrder.getDishes().remove(index);
                    //Code om ingredienten voorraad aan te passen
                    myOrder.getDishes().add(dishToAdd);
                    //Code om ingredienten voorraad aan te passen
                    break;
                }
                index++;
            }
    }

    /*
     * Hieronder staan de Specials
     */

    //Juiste Order object getter aan de hand van tablenumber en Guest g. Verdere input: Special die toegevoegd moet worden.
    public void findSpecialToAddSpecialTo(int tableNumber, Guest g, Special specialToAdd) {
        for (Order correctOrder : Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())) {
                addSpecialToOrder(correctOrder, specialToAdd);
            }
        }
    }
    //Add Special to Order
    public void addSpecialToOrder(Order myOrder, Special specialToAdd) {
        myOrder.getSpecials().add(specialToAdd);
        //Code om ingredienten voorraad aan te passen
    }
    //Juiste Order object getter aan de hand van tablenumber en Guest g. Verdere input: Special die verwijderd moet worden.
    public void findOrderToRemoveSpecialFrom(int tableNumber, Guest g, Special specialToAdd) {
        for (Order correctOrder : Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())) {
                removeSpecialFromOrder(correctOrder, specialToAdd);
            }
        }
    }
    //Remove a Special from order
    public void removeSpecialFromOrder(Order myOrder, Special specialToRemove) {
        int index = 0;
        for (Special special : myOrder.getSpecials()) {
            if (specialToRemove.equals(special)) {
                myOrder.getSpecials().remove(index);
                break;
            }
            index++;
        }
        //Code om ingredienten voorraad aan te passen
    }
    //Juiste Order object getter aan de hand van tablenumber en Guest g. Verdere input: Special toe te voegen, Special te verwijderen.
    public void findOrderToChangeSpecialIn(int tableNumber, Guest g, Special specialToAdd, Special specialToRemove) {
        for (Order correctOrder : Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest().getName().equalsIgnoreCase(g.getName())) {
                changeSpecialInOrder(correctOrder, specialToAdd, specialToRemove);
            }
        }
    }
    //Change a Special in Order
    public void changeSpecialInOrder(Order myOrder, Special specialToAdd, Special specialToRemove) {
        int index = 0;
        for (Special special : myOrder.getSpecials()) {
            if (specialToRemove.equals(special)) {
                myOrder.getSpecials().remove(index);
                //Code om ingredienten voorraad aan te passen
                myOrder.getSpecials().add(specialToAdd);
                //Code om ingredienten voorraad aan te passen
                break;
            }
            index++;
        }
    }

}
