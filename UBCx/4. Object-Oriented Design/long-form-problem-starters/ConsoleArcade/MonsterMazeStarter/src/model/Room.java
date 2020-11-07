package model;

import java.util.ArrayList;
import java.util.List;

public class Room extends MazeElement{

    private int id;
    private List<MazeElement> mazeElements;

    public Room(int id) {
        this.optionMessage = "Enter Room " + id + ".";
        this.id = id;
        this.mazeElements = new ArrayList<>();
    }


    //EFFECTS: prints all possible next choices
    public void printOutcome() {
        System.out.println("You are now in Room " + id + ".\n");
        System.out.println("You have the following options: ");

        int counter = 1;

        for (MazeElement me: mazeElements) {
            System.out.print("\tOption " + counter + ": ");
            me.printOptionMessage();
            counter++;
        }
    }

    //MODIFIES: this
    //EFFECTS: adds m to next possible monsters
    public void addMazeElement (MazeElement me) {
        mazeElements.add(me);
    }

    //getters for gameplay
    public MazeElement getMazeElement(int i) {
        return mazeElements.get(i);
    }

    public int getMazeElementRange() {
        return mazeElements.size();
    }

}
