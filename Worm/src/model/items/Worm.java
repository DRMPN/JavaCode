package model.items;

import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import static model.board.Canvas.*;
import static model.items.Direction.*;

public class Worm {

    private boolean Dead;

    private Apple apple;
    private Block wormHead;
    private List<Block> wormBody;

    private Direction headDirection = UP;


    public Worm(double coordX, double coordY) {
        Dead = false;

        wormHead = new Block(coordX,coordY);
        wormBody = new ArrayList<>();
    }

    // Getters
    public Block getWormHead() {
        return wormHead;
    }
    public List<Block> getWormBody() {
        return wormBody;
    }
    public boolean isDead() {
        return Dead;
    }

    // Setters
    public void setApple(Apple apple) {
        this.apple = apple;
    }
    public void setHeadDirection(Direction headDirection) {
        this.headDirection = headDirection;
    }

    // Decides whether or not worm can move, travels whole worm by every tick
    public void move() {
        // fixme: bug with double printed message
        if (touchedTail()) {
            Dead = true;
            System.out.println("YOU DIED!");
        }
        if (nearApple()) {
            apple.dropApple();
            addBlockBody();
        }
        // fixme: bug with corners
        if (!canMove()) {
            wormHead.changeSide(headDirection);
        }
        wormHead.moveBody(wormBody);
        wormHead.moveHead(headDirection);
    }

    // Border collision check
    private boolean canMove() {
        double sideSize = wormHead.getSide();
        double xPosition = wormHead.getX();
        double yPosition = wormHead.getY();

        boolean widthCheck = (xPosition >= 2* sideSize) && (xPosition < CANVAS_WIDTH - sideSize);
        boolean heightCheck = (yPosition >= 2 * sideSize) && (yPosition < CANVAS_HEIGHT - sideSize);

        return widthCheck && heightCheck;
    }

    // Apple consuming check
    private boolean nearApple() {
        return apple.getCircle().intersects(wormHead.getSquare());
    }

    // Head - Body collision check
    private boolean touchedTail() {
        boolean touched = false;
        Rectangle2D head = wormHead.getSquare();

        for (Block b : wormBody) {
            Rectangle2D bodyBlock = b.getSquare();
            if (head.intersects(bodyBlock)) {
                touched = true;
            }
        }

        return touched;
    }

    // Adds another block to worm's body
    private void addBlockBody() {
            Block b = new Block(0, 0);

            if (wormBody.isEmpty()) {
                b.setBlockPosition(wormHead.getX(), wormHead.getY());
            } else {
                Block last_b = wormBody.get(wormBody.size() - 1);
                b.setBlockPosition(last_b.getX(), last_b.getY());
            }
            wormBody.add(b);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // TODO: cant move opposite way
        switch (key) {
            case (KeyEvent.VK_LEFT): headDirection = LEFT; break;
            case (KeyEvent.VK_RIGHT): headDirection = RIGHT; break;
            case (KeyEvent.VK_UP): headDirection = UP; break;
            case (KeyEvent.VK_DOWN): headDirection = DOWN; break;
            // TODO: create pause event
            case (KeyEvent.VK_SPACE): addBlockBody(); break;
        }
    }

}
