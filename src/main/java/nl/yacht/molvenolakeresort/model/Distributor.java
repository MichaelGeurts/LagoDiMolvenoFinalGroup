package nl.yacht.molvenolakeresort.model;

import java.util.List;

public class Distributor {

    private String name;
    private String telephoneNumber;
    private String email;
    private List<Ingredient> ingredients;

    //region getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Ingredient> getIngredientList() {
        return ingredients;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredients = ingredientList;
    }
    //endregion

    public Distributor(String name, String telephoneNumber, String email, List<Ingredient> ingredientList) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.ingredients = ingredientList;
    }

}
