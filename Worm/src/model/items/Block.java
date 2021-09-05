package model.items;

import java.awt.geom.Rectangle2D;
import java.util.List;

import static model.board.Canvas.CANVAS_HEIGHT;
import static model.board.Canvas.CANVAS_WIDTH;

public class Block {

    private Rectangle2D square;
    private final double SIDE = 5.0;

    public Block(double x, double y) {
        this.square = new Rectangle2D.Double(x, y, SIDE, SIDE);
    }

    // Getters
    public double getX() {
        return square.getX();
    }
    public double getY() {
        return square.getY();
    }
    public Rectangle2D getSquare() {
        return square;
    }
    public double getSide() {
        return SIDE;
    }

    // Setters
    public void setBlockPosition(double x, double y) {
        square.setRect(x,y,SIDE,SIDE);
    }

    // Moves head by every tick
    public void moveHead(Direction dir) {
        double x = square.getX();
        double y = square.getY();

        switch (dir) {
            case LEFT: setBlockPosition(x - SIDE,y); break;
            case RIGHT: setBlockPosition(x + SIDE,y); break;
            case UP: setBlockPosition(x,y - SIDE); break;
            case DOWN: setBlockPosition(x,y + SIDE); break;
        }
    }

    // Moves every block in worm's body
    public void moveBody(List<Block> wormBody) {
        double oldX = this.getX();
        double oldY = this.getY();

        double newX;
        double newY;
        for (Block b : wormBody) {
            newX = b.getX();
            newY = b.getY();

            b.setBlockPosition(oldX, oldY);

            oldX = newX;
            oldY = newY;
        }
    }
    // Transfers head to opposite side when at it the end of game's border
    public void changeSide(Direction headDir) {
        double currentX = this.getX();
        double currentY = this.getY();

        switch (headDir) {
            case LEFT: setBlockPosition(CANVAS_WIDTH - SIDE,currentY);
                nearVerticalBorder(currentX); break;
            case RIGHT: setBlockPosition(SIDE, currentY);
                nearVerticalBorder(currentX); break;
            case UP: setBlockPosition(currentX,CANVAS_HEIGHT - SIDE);
                nearHorizontalBorder(currentY); break;
            case DOWN: setBlockPosition(currentX, SIDE);
                nearHorizontalBorder(currentY); break;
        }
    }

    public void nearVerticalBorder(double x) {
        //System.out.println("VERTICAL");
        //System.out.println(x);
        if (x == CANVAS_WIDTH - 2 * SIDE) {
            System.out.println("LEFT");
            setBlockPosition(250,125);
        }
        if (x == 2 * SIDE) {
            System.out.println("RIGHT");
            setBlockPosition(250,125);
        }
    }

    public void nearHorizontalBorder(double y) {
        //System.out.println("HORIZONTAL");
        //System.out.println(y);
        if (y == CANVAS_HEIGHT - 2 * SIDE) {
            System.out.println("UP");
            setBlockPosition(250,125);
        }
        if (y == 2 * SIDE) {
            System.out.println("DOWN");
            setBlockPosition(250,125);
        }
    }

}
