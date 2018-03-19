package nl.yacht.molvenolakeresort.controller;

import nl.yacht.molvenolakeresort.Restaurant;
import nl.yacht.molvenolakeresort.model.Ingredient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class IngredientController {

    @GetMapping("/api/ingredientstock")
    public ArrayList<Ingredient> getIngredient(){
        return Restaurant.getList();
    }

}
