package model;

public class Treasure extends MazeElement{

    private int prize;

    public Treasure(int prize) {
        this.optionMessage = "Claim your treasure!";
        this.prize = prize;
    }

    //EFFECTS: prints the result of choosing this choice
    public void printOutcome() {
        System.out.println("Your prize is " + prize + " spendibees.");
    }

}
