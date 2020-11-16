import model.board.Canvas;

import javax.swing.*;
import java.awt.*;

import static model.board.Canvas.CANVAS_HEIGHT;
import static model.board.Canvas.CANVAS_WIDTH;

public class Game extends JFrame {

    public Game() {
        initGame();
    }

    private void initGame() {
        add(new Canvas());
        setTitle("Apple eater");
        setSize(CANVAS_WIDTH, CANVAS_HEIGHT);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Game g = new Game();
            g.setVisible(true);
        });
    }

}
