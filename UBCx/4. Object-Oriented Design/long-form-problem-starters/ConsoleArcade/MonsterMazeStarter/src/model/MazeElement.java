package model;

public abstract class MazeElement {

    protected String optionMessage;

    public abstract void printOutcome();

    //EFFECTS: prints a message representing this possible next choice
    public void printOptionMessage() {
        System.out.println(optionMessage);
    }

}
