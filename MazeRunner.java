import javax.swing.JFrame;
import java.awt.Color;
public class MazeRunner
{
    public static void main(String[] args)
    {
        Maze maze = new Maze();
        GameIO io = new GameIO(100, maze);
        GameWindow window = new GameWindow();
        window.add(io);
        window.initialize();
        window.setSize(15 * 64, 11 * 64);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}