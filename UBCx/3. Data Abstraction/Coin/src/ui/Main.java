package ui;

import model.Coin;

public class Main {

    public static void main(String[] args) {
      Coin c = new model.Coin();
        System.out.println("Now it's: "+c.checkStatus());
        System.out.println();
        System.out.println("Flip, Flap, Flop...");
        System.out.println();
      c.flip();
        System.out.println("Pow it's: "+c.checkStatus());
    }

}
