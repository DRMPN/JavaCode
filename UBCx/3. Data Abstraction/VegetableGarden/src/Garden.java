import model.Carrot;
import model.Lettuce;
import model.Tomato;
import model.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class Garden {

    private List<Vegetable> garden;

    public static void main(String[] args) {
        List<Vegetable> garden = new ArrayList();
        garden.add(new Carrot());
        garden.add(new Tomato());
        garden.add(new Lettuce());

        System.out.println("Taking care for every vegetable in garden:");
       for (Vegetable v : garden) {
           System.out.println(v.getName());
           v.water();
           v.feed();
           System.out.println();
       }

        System.out.println("It's time to collect our product!");
       for (Vegetable v : garden) {
           v.harvest();
       }
    }

}
