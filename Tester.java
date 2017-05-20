import javax.swing.JFrame;
import java.awt.Color;
public class Tester
{
    public static void main(String[] args)
    {
        Maze maze = new Maze();
        MazePlayer p = new MazePlayer(GameWindow.WIDTH - Constants.TILE_WIDTH, 0, Constants.PLAYER_1, "R1.png");
        p.setSpeed(16, 16);
        maze.addPiece(p);
        maze.addPiece(new Wall(65, 65, ""));
        maze.addPiece(new Wall(250 + 64 + 65 + 10, 250, ""));
        GameIO io = new GameIO(100, maze);
        GameWindow window = new GameWindow();
        window.add(io);
        window.initialize();
    }
}