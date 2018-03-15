package nl.yacht.lagodimolveno;

import java.util.List;

public class Special {
    private String name;
    private List<Dish> dishes;
    private Double price;

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

    public Special(String name, List<Dish> dishes, Double price) {
        this.name = name;
        this.dishes = dishes;
        this.price = price;
        Restaurant.addSpecialToList(this);
    }

    //region edit
    public void editSpecial(Special special, Double price, List<Dish> dishes, String name){
        for(Special s : Restaurant.getSpecialList()){
            if(s.equals(special)){
                s.setDishes(dishes);
                s.setName(name);
                s.setPrice(price);
            }
        }
    }

    public void editSpecial(Special special, Double price){
        for(Special s : Restaurant.getSpecialList()){
            if(s.equals(special)){
                s.setPrice(price);
            }
        }
    }

    public void editSpecial(Special special, List<Dish> dishes){
        for(Special s : Restaurant.getSpecialList()){
            if(s.equals(special)){
                s.setDishes(dishes);
            }
        }
    }

    public void editSpecial(Special special, String name){
        for(Special s : Restaurant.getSpecialList()){
            if(s.equals(special)){
                s.setName(name);
            }
        }
    }

    public void editSpecial(Special special, Dish toRemove, Dish toAdd){
        int counter = 0;
        for (Dish dish : special.getDishes()) {
            if (dish.getName().equals(toRemove.getName())) {
                special.getDishes().remove(counter);
                if (toAdd != null) {
                    special.getDishes().add(toAdd);
                }
                break;
            }
            counter++;
        }
    }

    public void addDishToSpecial(Special special, Dish d){
        special.getDishes().add(d);
    }
    //endregion

    public void deleteSpecial(Special special){
        int index = 0;
        for(Special s : Restaurant.getSpecialList()){
            if(s.equals(special)){
                Restaurant.getSpecialList().remove(index);
            }
            index++;
        }
    }

    @Override
    public String toString() {
        return "Special{" +
                "name='" + name + '\'' +
                ", dishes=" + dishes +
                ", price=" + price +
                '}';
    }
}
