import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Pit extends Obstacle
{
    public Pit(int xStart, int yStart, String imageName)
    {
        super(imageName);
        xLoc = xStart;
        yLoc = yStart;
        setCollision(false);
        bounds.add(new Rectangle(xStart, yStart, Constants.TILE_WIDTH-2, Constants.TILE_HEIGHT-2));
    }

    public void doPlayerEffect(Player p)
    {
        p.addHealth(-(p.getHealth()));
    }

    public boolean collideAfterMovement(int row, int col, GamePiece [][] board)
    {
        return false;
    }

    public void updateGameState(ArrayList<GamePiece> entities)
    {
        for (GamePiece g : entities)
        {
            if (g instanceof Player && g.collide(this))
            {
                doPlayerEffect((Player) g);
            }
        }
    }

    public void draw(Graphics g)
    {
        g.drawImage(image, xLoc, yLoc, null);
    }

    public String getName()
    {
        return "Pit";
    }
}