package nl.yacht.lagodimolveno;

import java.util.List;

public class Ingredient {
    private String name;
    private boolean isAllergen;
    private Distributor distributor;
    private int numberOfStock;
    private double costPrice;

    //region getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAllergen() {
        return isAllergen;
    }

    public void setAllergen(boolean allergen) {
        isAllergen = allergen;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public int getNumberOfStock() {
        return numberOfStock;
    }

    public void setNumberOfStock(int numberOfStock) {
        this.numberOfStock = numberOfStock;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    //endregion

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", isAllergen=" + isAllergen +
                ", distributor=" + distributor +
                ", numberOfStock=" + numberOfStock +
                ", costPrice=" + costPrice +
                '}';
    }

    public Ingredient(String name, boolean isAllergen, Distributor distributor, int numberOfStock, double costPrice) {
        this.name = name;
        this.isAllergen = isAllergen;
        this.distributor = distributor;
        this.numberOfStock = numberOfStock;
        this.costPrice = costPrice;

        Restaurant.addIngredientToList(this);
    }
}
