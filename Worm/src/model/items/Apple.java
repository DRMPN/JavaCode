package model.items;

import java.awt.geom.Ellipse2D;
import java.util.Random;

import static java.lang.Math.round;
import static model.board.Canvas.CANVAS_HEIGHT;
import static model.board.Canvas.CANVAS_WIDTH;

public class Apple {

    private Ellipse2D.Double circle;
    private boolean isEaten;
    private final double RADIUS = 5;

    public Apple() {
        double xCoord = generateCoordinate(RADIUS,CANVAS_WIDTH - RADIUS);
        double yCoord = generateCoordinate(RADIUS,CANVAS_HEIGHT - RADIUS);
        circle = new Ellipse2D.Double(xCoord,yCoord, RADIUS, RADIUS);

        // FIXME: what could you do with that?
        isEaten = false;
    }

    // Getters
    public double getX() {
        return circle.getX();
    }
    public double getY() {
        return circle.getY();
    }
    public Ellipse2D.Double getCircle() {
        return circle;
    }
    public double getRadius() {
        return RADIUS;
    }
    public boolean isEaten() {
        return isEaten;
    }

    // Creates new apple location when it was eaten
    public void dropApple() {
        double xCoord = generateCoordinate(RADIUS,CANVAS_WIDTH - RADIUS);
        double yCoord = generateCoordinate(RADIUS,CANVAS_HEIGHT - RADIUS);

        circle.setFrame(xCoord,yCoord, RADIUS, RADIUS);
    }

    private double generateCoordinate(double min, double max){
        // todo: add wormBody collision
        double coordinate = new Random().nextDouble();
        return round(min + (coordinate * (max - min)));
    }

}
