package ui;

import model.Monster;
import model.Room;
import model.Treasure;

public class MonsterMaze {

    public static void main(String[] args) throws InterruptedException {
        Room r1 = new Room(1);
        Room r2 = new Room(2);
        Room r3 = new Room(3);
        Room r4 = new Room(4);
        Room r5 = new Room(5);
        Room r6 = new Room(6);

        Monster m1 = new Monster();
        Monster m2 = new Monster();
        Monster m3 = new Monster();

        Treasure t1 = new Treasure(100);

        m3.setTreasure(t1);

        r1.addMazeElement(r2);
        r1.addMazeElement(r4);
        r1.addMazeElement(m1);

        r2.addMazeElement(r3);
        r2.addMazeElement(r6);

        r3.addMazeElement(m3);

        r4.addMazeElement(r5);

        r5.addMazeElement(m2);

        r6.addMazeElement(t1);

        //Game g = new Game(r1);
        RefactoredGame g = new RefactoredGame(r1);
    }



}
