import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Wall extends Obstacle
{
    public Wall(int xStart, int yStart, String imageName)
    {
        super(imageName);
        setCollision(true);
        xLoc = xStart;
        yLoc = yStart;
        bounds.add(new Rectangle(xStart, yStart, Constants.TILE_WIDTH - 2, Constants.TILE_HEIGHT - 2));
    }

    public void doPlayerEffect(Player p)
    {

    }

    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(xLoc, yLoc, Constants.TILE_WIDTH, Constants.TILE_HEIGHT);
        //g.drawImage(image, xLoc, yLoc, null);
    }

    public void updateGameState(ArrayList<GamePiece> entities)
    {

    }
}