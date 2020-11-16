package model.board;

import model.items.Apple;
import model.items.Block;
import model.items.Worm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// TODO: COMPLETE GRAND JUICY REFACTOR
public class Canvas extends JPanel implements ActionListener {

    private Timer timer;
    private Worm worm;
    private Apple apple;

    public static final int CANVAS_WIDTH = 500;
    public static final int CANVAS_HEIGHT = 250;
    private final Color BACKGROUND_COLOR = Color.BLACK;

    public static final double X_START = 250.0;
    public static final double Y_START = 125.0;
    private final int DELAY = 50;

    public Canvas() {
        initCanvas();
    }

    private void initCanvas() {
        worm = new Worm(X_START,Y_START);
        apple = new Apple();
        worm.setApple(apple);

        setBackground(BACKGROUND_COLOR);
        addKeyListener(new WormKeyAdapter());
        setFocusable(true);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawWorm(g);
        drawApple(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawWorm(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);

        g2d.draw(worm.getWormHead().getSquare());
        for (Block wb : worm.getWormBody()) {
            g2d.draw(wb.getSquare());
        }
    }

    private void drawApple(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);

        g2d.draw(apple.getCircle());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (worm.isDead()) {
            timer.stop();
        }
        step();
    }

    private void step() {
        worm.move();
        repaint();
    }

    private class WormKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {
                worm.keyPressed(keyEvent);
        }

    }
}
