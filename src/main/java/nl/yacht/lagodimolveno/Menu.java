package nl.yacht.lagodimolveno;

import java.util.List;

public class Menu {
    private List<Drink> drinks;
    private List<Dish> dishes;
    private List<Special> specials;

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

    //endregion

    public Menu(List<Drink> drinks, List<Dish> dishes, List<Special> specials) {
        this.drinks = drinks;
        this.dishes = dishes;
        this.specials = specials;

    }

    //Order by dishtype MEAT,FISH,SOUP,VEGETARIAN,EXTRA
    public void SortByDishType() {
        for (Dish dish : dishes) {
            DishType dishType = dish.getDishType();

            switch (dishType) {
                case MEAT:
                    ;// do something
                    break;

                case FISH:
                    ;// do something
                    break;

                case SOUP:
                    ;// do something
                    break;

                case VEGETARIAN:
                    ;// do something
                    break;

                case EXTRA:
                    ;// do something
                    break;
                default:
                    System.out.println("Default dishtype");
                    break;
            }
        }
    }

    public void SortByCourseType() {
        for (Dish dish : dishes) {
            CourseType courseType = dish.getCourseType();

            switch (courseType) {
                case MAIN:
                    ;// do something
                    break;

                case STARTER:
                    ;// do something
                    break;

                case DESSERT:
                    ;// do something
                    break;

                default:
                    System.out.println("Default dishtype");
                    break;
            }
        }
    }

    /**
     * Vanuit menu door lijst dishes heen
     * dish moet functie bevatten = dish allergen (boolean)
     * kan die alleen weten door aan eigen lijst te vragen of allergen is
     */
    //Order by course type      MAIN,STARTER,DESSERT;


    public boolean isDishAvailable(Dish dish) {
        return dish.isIngredientAvailable();
    }

    public boolean isDrinkAvailable(Drink drink) {
        return drink.isDrinkAvailable();
    }

    public void editDishMenu(List<Dish> dishes) {
        //logica maken
    }

    public void editSpecialMenu(List<Special> specials) {
        //logica maken
    }

    public void editDrinkMenu(List<Drink> drinks) {
        //logica maken
    }
}

