import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javafx.geometry.BoundingBox;
public class Wall extends Obstacle
{
    public Wall(int xStart, int yStart, String imageName)
    {
        super(imageName);
        setCollision(true);
        xLoc = xStart;
        yLoc = yStart;
        bounds.add(new BoundingBox(xStart, yStart, GameIO.cWidth - 2, GameIO.cHeight - 2));
    }

    public void doPlayerEffect(Player p)
    {

    }

    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(xLoc, yLoc, GameIO.cWidth, GameIO.cHeight);
    }

    public void updateGameState(ArrayList<GamePiece> entities)
    {

    }
}