package nl.yacht.molvenolakeresort;

import nl.yacht.molvenolakeresort.model.Ingredient;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Restaurant {

    private ArrayList<Ingredient> ingredientStock;

    public static ArrayList<Ingredient> getList(){
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Tomato", true, true, null, 100, 2.00));
        ingredients.add(new Ingredient("Potato", true, false, null, 100, 3.00));
        ingredients.add(new Ingredient("Banana", false, true, null, 100, 4.00));
        ingredients.add(new Ingredient("Apple", true, false, null, 100, 1.00));
        return ingredients;
    }

}
