package nl.yacht.lagodimolveno;

import java.util.List;

public class Special {
    private String name;
    private List<Dish> dishes;
    private double price;

    //region getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //endregion

    public Special(String name, List<Dish> dishes, double price) {
        this.name = name;
        this.dishes = dishes;
        this.price = price;
    }

    public void generateSpecial(List<Dish> dishes){
        //logica hier
    }

    public void editSpecial(Special special){
        //logica hier
    }

    public void deleterSpecial(Special special){
        //logica hier
    }
}
