package nl.yacht.lagodimolveno;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateTestData {

    public static void generate(){
        AllLists a = new AllLists();
        a.initAllLists();
        generateDrinkList(a);
        generateIngredientList(a);
        generateDishList(a);
        sumSomeCosts(a);
    }

    public static void generateDrinkList(AllLists a){

        for (int i = 1; i < 21; i++){
            int testint = 1;
            boolean ishot = false;
            boolean isalcohol = false;
            if(new Random().nextInt(2) == testint){
                isalcohol = true;
            }
            if(new Random().nextInt(2) == testint){
                ishot = true;
            }
            Drink d = new Drink("Drank nummer" + i, "Hier komt beschrijving", ishot, isalcohol, new Random().nextInt(i)+1);
            a.getDrinkList().add(d);
        }

        for(Drink d : a.getDrinkList()){
            System.out.println(d);
        }
    }

    public static void generateDishList(AllLists a){

        for (int i = 1; i < 21; i++){
            Dish d = new Dish("Dish nummer" + i,"Andere beschrijving",a.getIngredientList(),
                    new Random().nextInt(i)+1, CourseType.values()[new Random().nextInt(CourseType.values().length)],
                    DishType.values()[new Random().nextInt(DishType.values().length)], true);
            a.getDishList().add(d);
        }

        for(Dish d : a.getDishList()){
            System.out.println(d);
        }
    }

    public static void generateIngredientList(AllLists a){
        for (int i = 1; i < 21; i++){
            int testint = 1;
            boolean isAllergen = false;
            boolean isInStock = false;
            if(new Random().nextInt(2) == testint){
                isAllergen = true;
            }
            if(new Random().nextInt(2) == testint){
                isInStock = true;
            }
            Ingredient in = new Ingredient("Ingredient nummer" + i, isAllergen,isInStock, null, new Random().nextInt(100), new Random().nextInt(i)+1);
            a.getIngredientList().add(in);
        }

        for(Ingredient i : a.getIngredientList()){
            System.out.println(i);
        }
    }

    public static void sumSomeCosts(AllLists a){
        sum(a.getIngredientList());
        sum(a.getDishList());
        sum(a.getDrinkList());
    }

    private static double sum(List<?> lijstje){
        double d = 0.0;
        String s = "";
        for(Object o : lijstje){
             s = o.getClass().getSimpleName();
            switch (s){
                case "Ingredient":
                    d = d + ((Ingredient) o).getCostPrice();
                    break;
                case "Drink":
                    d = d + ((Drink) o).getPrice();
                    break;
                case "Dish":
                    d = d + ((Dish) o).getPrice();
                    break;
            }
        }
        System.out.println("Sum of " + s + " :€" + d);
        return   d;
    }
}
