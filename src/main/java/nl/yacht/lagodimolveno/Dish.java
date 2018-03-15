package nl.yacht.lagodimolveno;

import java.util.List;

public class Dish {
    private String name;
    private String description;
    private List<Ingredient> ingredients;
    private double price;
    private CourseType courseType;
    private DishType dishType;
    private boolean isIngredientAvailable;

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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    public boolean isIngredientAvailable() {
        return isIngredientAvailable;
    }

    public void setIngredientAvailable(boolean ingredientAvailable) {
        isIngredientAvailable = ingredientAvailable;
    }

    //endregion

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                ", price=" + price +
                ", courseType=" + courseType +
                ", dishType=" + dishType +
                ", isIngredientAvailable=" + isIngredientAvailable +
                '}';
    }

    public Dish(String name, String description, List<Ingredient> ingredients, double price, CourseType courseType, DishType dishType, boolean isIngredientAvailable) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.price = price;
        this.courseType = courseType;
        this.dishType = dishType;
        this.isIngredientAvailable = isIngredientAvailable;

        Restaurant.addDishToList(this);
    }

    public boolean hasAllergen(Dish dish) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.isAllergen()) {
                return true;
            }
        }
        return false;
    }
}

