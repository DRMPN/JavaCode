package model;

import java.util.ArrayList;
import java.util.List;

public class Dish {

    private String name;
    private String description;
    private List<String> ingridients;
    private String recipe;

    public Dish(String name) {
        this.name = name;
        this.description = "";
        this.ingridients = new ArrayList<>();
        this.recipe = "";
    }

    public Dish (String name, String description, List<String> ingredients, String recipe) {
        this.name = name;
        this.description = description;
        this.ingridients = ingredients;
        this.recipe = recipe;
    }

    // Getters:
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public List<String> getIngridients() {
        return ingridients;
    }
    public String getRecipe() {
        return recipe;
    }

    // Setters:
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIngridients(List<String> ingridients) {
        this.ingridients = ingridients;
    }
    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public static Dish generateTurkeyClubSandwich() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("avocado");
        ingredients.add("sriracha");
        ingredients.add("cheddar cheese");
        ingredients.add("bread");
        ingredients.add("lettuce");
        ingredients.add("tomato");
        ingredients.add("turkey");
        ingredients.add("bacon");
        return new Dish("Turkey club sandwich",
                "\"Our trendy sandwich has avocado, sriracha sauce, cheese, veggies, turkey and bacon.\"",
                ingredients,
                "\t1. Pour sriracha\n\t2. Spread avocado\n\t3. Stack meat\n\t4. Place veggies");
    }


}
