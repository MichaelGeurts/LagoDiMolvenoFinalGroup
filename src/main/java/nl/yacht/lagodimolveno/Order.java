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
    //Juiste Order object getter aan de hand van tablenumber en Guest g. Verdere input Drink die toegevoegd moet worden.
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
    //Juiste Order object getter aan de hand van tablenumber en Guest g. Verdere input Drink die verwijderd moet worden en aantal te verwijderen.
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
    //Juiste Order object getter aan de hand van tablenumber en Guest g. Verdere input Drink toe te voegen, Drink te verwijderen, aantal te veranderen.
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

// GRENS VAN DONEHEID

    // BELOW MORE

    // WERK HIERBOVEN


    public void addDish(int tableNumber, Guest g, Dish dish) {

        for (Order correctOrder : Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest() == g) {
                correctOrder.getDishes().add(dish);
            }
        }

    }

    public void removeDish(int tableNumber, Guest g, Dish dish) {

        for (Order correctOrder : Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest() == g) {
                correctOrder.getDishes().remove(dish);
            }
        }

    }

    public void addSpecial(int tableNumber, Guest g, Special special) {

        for (Order correctOrder : Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest() == g) {
                correctOrder.getSpecials().add(special);
            }
        }

    }

    public void removeSpecial(int tableNumber, Guest g, Special special) {

        for (Order correctOrder : Restaurant.getOrderList()) {
            if (correctOrder.getTableNumber() == tableNumber && correctOrder.getGuest() == g) {
                correctOrder.getSpecials().remove(special);
            }
        }

    }

}
