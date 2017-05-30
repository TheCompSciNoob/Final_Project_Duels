import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.FlowLayout;
public class GameWindow extends JFrame
{
    public static final int NUM_ROWS = 9, NUM_COLS = 14;
    private int BORDER_HEIGHT = 30, BORDER_WIDTH = 7;
    private int width, height;
    public static final int HEIGHT = NUM_ROWS * Constants.TILE_HEIGHT, WIDTH = NUM_COLS * Constants.TILE_WIDTH;
    
    public GameWindow()
    {
      super();
    }

    public void initialize()
    {
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("GameWindow");
        pack();
    }
}