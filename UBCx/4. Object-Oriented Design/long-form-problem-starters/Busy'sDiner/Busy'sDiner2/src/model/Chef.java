package model;

public class Chef {

    private static final String PREFIX = "CHEF - ";

    private Order order;
    private Dish dish;

    public Chef() {
        order = null;
        dish = null;
    }

    //MODIFIES: this, order
    //EFFECTS: makes food and logs order as prepared
    public void makeDish(Order order) {
        this.order = order;
        this.dish = order.getDish();
        prepareIngredients();
        followRecipe(dish);
        cookFood();
        plate();
    }

    //EFFECTS: prints out a doing dishes message
    public void doDishes() {
        System.out.println(PREFIX + "Cleaning, scrubbing...");
        System.out.println("Dishes done.");
    }

    //EFFECTS: prints out the ingredients being prepared
    private void prepareIngredients() {
        System.out.println(PREFIX + "Slicing tomatoes... Shredding lettuce...");
        System.out.println(PREFIX + "Mashing avocado! Yum!");
    }

    //EFFECTS: prints out the recipe being followed
    private void followRecipe(Dish dish) {
        System.out.println(PREFIX + "is following this recipe:");
        System.out.println(dish.getRecipe());
//        System.out.println(PREFIX + "Stacking meat... Placing veggies.... ");
//        System.out.println(PREFIX + "Pouring sriracha! Spreading avocado! Trendy!");
    }

    //EFFECTS: prints out a message about cooking food
    private void cookFood() {
        System.out.println(PREFIX + "Grilling sandwich...");
    }

    //MODIFIES: order
    //EFFECTS: logs order as prepared and prints out a plating message
    private void plate() {
        order.setIsPrepared();
        System.out.print(PREFIX + "Plated order: ");
        order.print();
        this.order = null;
    }
}
