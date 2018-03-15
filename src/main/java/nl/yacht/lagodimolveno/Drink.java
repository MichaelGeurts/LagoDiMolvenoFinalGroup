package nl.yacht.lagodimolveno;

import java.util.List;

public class Drink {
    private String name;
    private String description;
    private int drinkStock;
    private boolean isHot;
    private boolean containsAlcohol;
    private double price;
    private boolean isDrinkAvailable;


    //region getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isContainsAlcohol() {
        return containsAlcohol;
    }

    public void setContainsAlcohol(boolean containsAlcohol) {
        this.containsAlcohol = containsAlcohol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDrinkStock() {
        return drinkStock;
    }

    public void setDrinkStock(int drinkStock) {
        this.drinkStock = drinkStock;
    }

    public boolean isDrinkAvailable() {
        return isDrinkAvailable;
    }

    //endregion

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isHot=" + isHot +
                ", containsAlcohol=" + containsAlcohol +
                ", price=" + price +
                ", drinkStock=" + drinkStock +
                ", isDrinkAvailable=" + isDrinkAvailable +
                '}';
    }

    public Drink(String name, String description, boolean isHot, boolean containsAlcohol, double price, int stock, boolean isDrinkAvailable) {
        this.name = name;
        this.description = description;
        this.isHot = isHot;
        this.containsAlcohol = containsAlcohol;
        this.price = price;
        this.drinkStock = stock;
        this.isDrinkAvailable = isDrinkAvailable;

        Restaurant.addDrinkToList(this);
    }


}
