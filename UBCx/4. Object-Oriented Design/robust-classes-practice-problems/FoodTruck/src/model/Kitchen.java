package model;

import model.exceptions.NoCookException;
import model.exceptions.NoIngredientException;
import model.exceptions.NotEnoughMoneyException;

public class Kitchen {

    private final static int INGREDIENT_PER_TACO = 3;
    private final static int DOLLAR_PER_INGREDIENT = 2;
    private int ingredient;
    private int tacoCount;
    private int balance;
    private boolean cookReady;

    public Kitchen(int initialIngredient, int initialTaco, int balance, boolean cookStatus) {
        ingredient = initialIngredient;
        tacoCount = initialTaco;
        cookReady = cookStatus;
        this.balance = balance;
    }

    // getters
    public int getIngredientCount() { return ingredient; }
    public int getTacoCount() { return tacoCount; }
    public boolean getCookState() { return cookReady; }
    public int getBalance() { return balance; }

    // setter
    public void setCookStatus(boolean b) {
        cookReady = b;
    }

    // REQUIRES: the cook needs to be ready to cook
    // MODIFIES: this
    // EFFECTS:  number is added to tacoCount, and ingredient is decremented accordingly
    public void makeTaco(int number) throws NoCookException, NotEnoughMoneyException {
        if (!cookReady) {throw new NoCookException();}
        if (ingredient < number * INGREDIENT_PER_TACO) {throw new NotEnoughMoneyException();}
        ingredient -= (INGREDIENT_PER_TACO * number);
        tacoCount += number;
    }

    // REQUIRES: balance should be >=0
    // MODIFIES: this
    // EFFECTS: (amount) is added to the ingredient field, and the balance field
    //          is decremented accordingly
    public void buyIngredients(int amount) throws NotEnoughMoneyException {
        if (balance < amount * DOLLAR_PER_INGREDIENT) {throw new NotEnoughMoneyException(); }
        balance -= (DOLLAR_PER_INGREDIENT * amount);
        ingredient += amount;
    }

  



}
