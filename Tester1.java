import javax.swing.JFrame;
import java.awt.Color;
public class Tester1
{
    public static void main(String[] args)
    {
        Maze maze = new Maze();
        MazePlayer p = new MazePlayer(0, GameWindow.HEIGHT - Constants.TILE_HEIGHT, Constants.PLAYER_1, "R1.png");
        p.setSpeed(16, 16);
        p.addHealth(100);
        maze.addPiece(p);
        maze.addPiece(new Wall(65, 65, ""));
        maze.addPiece(new Wall(250 + 64 + 65 + 10, 250, ""));
        GameIO io = new GameIO(100, maze);
        GameWindow window = new GameWindow();
        window.add(io);
        window.initialize();
        window.setVisible(true);
    }
}