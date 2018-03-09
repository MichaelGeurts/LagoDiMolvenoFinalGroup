package nl.yacht.lagodimolveno;

import java.util.List;

public class Financial {
    private double dishMargin;
    private double drinkMargin;

    //region getters and setters
    public double getDishMargin() {
        return dishMargin;
    }

    public void setDishMargin(double dishMargin) {
        this.dishMargin = dishMargin;
    }

    public double getDrinkMargin() {
        return drinkMargin;
    }

    public void setDrinkMargin(double drinkMargin) {
        this.drinkMargin = drinkMargin;
    }
    //endregion

    //Static want we willen geen financial object elke keer moeten aanmaken ( dus er is ook geen constructor )
    public static double calculateTotalPrice(Order order){
        //logica hier
        double totalPrice = 0.0;
        return totalPrice;
    }

    //Static want we willen geen financial object elke keer moeten aanmaken ( dus er is ook geen constructor )
    public static double calculateGrossProfit(Order order){
        //logica hier
        double totalPrice = 0.0;
        return totalPrice;
    }

    //Static want we willen geen financial object elke keer moeten aanmaken ( dus er is ook geen constructor )
    public static double calculateCostOfGoodsSold(List<Order> orders){
        //logica hier
        double totalPrice = 0.0;
        return totalPrice;
    }
}
