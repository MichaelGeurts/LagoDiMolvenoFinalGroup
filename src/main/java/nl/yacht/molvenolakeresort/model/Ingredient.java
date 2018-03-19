package nl.yacht.molvenolakeresort.model;

public class Ingredient {

    private String name;
    private boolean isAllergen;
    private boolean isStock;
    private Distributor distributor;
    private int numberOfStock;
    private double costPrice;

    public Ingredient(){}

    public Ingredient(String name, boolean isAllergen, boolean isStock, Distributor distributor, int numberOfStock, double costPrice) {
        this.name = name;
        this.isAllergen = isAllergen;
        this.isStock = isStock;
        this.distributor = distributor;
        this.numberOfStock = numberOfStock;
        this.costPrice = costPrice;
    }

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

    public boolean isStock() {
        return isStock;
    }

    public void setStock(boolean stock) {
        isStock = stock;
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
}
