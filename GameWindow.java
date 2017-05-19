import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
public class GameWindow extends JFrame
{
    public static final int NUM_ROWS = 10, NUM_COLS = 10;
    private int BORDER_HEIGHT = 30, BORDER_WIDTH = 7;
    public static final int HEIGHT = NUM_ROWS * Constants.TILE_HEIGHT, WIDTH = NUM_COLS * Constants.TILE_WIDTH;
    

    public void initialize()
    {
        setSize(NUM_COLS * Constants.TILE_WIDTH + BORDER_WIDTH, NUM_ROWS * Constants.TILE_HEIGHT + BORDER_HEIGHT);
        setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("GameWindow");
        setVisible(true);
    }
}