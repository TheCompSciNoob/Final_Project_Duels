import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Cannoneer extends GenericPlayer
{
    private static final int pLength = 32, pWidth = 16;
    private static final int normDamage = 10;

    public Cannoneer(int xStart, int yStart, int player)
    {
        super(xStart, yStart, player);
        cd1 = 750000000;
    }

    @Override
    public void useActive1(ArrayList<GamePiece> entities)
    {
        if (direction == Constants.NORTH)
        {
            Rectangle p = new Rectangle(xLoc + (Constants.TILE_WIDTH - pWidth) / 2, yLoc  - pLength, pWidth, pLength);
            entities.add(new Projectile(p, direction, normDamage));
        }
        if (direction == Constants.SOUTH)
        {
            Rectangle p = new Rectangle(xLoc + (Constants.TILE_WIDTH - pWidth) / 2, yLoc + Constants.TILE_HEIGHT, pWidth, pLength);
            entities.add(new Projectile(p, direction, normDamage));
        }
        if (direction == Constants.EAST)
        {
            Rectangle p = new Rectangle(xLoc + Constants.TILE_WIDTH, yLoc + (Constants.TILE_HEIGHT - pWidth) / 2, pLength, pWidth);
            entities.add(new Projectile(p, direction, normDamage));
        }
        if (direction == Constants.WEST)
        {
            Rectangle p = new Rectangle(xLoc - pLength, yLoc + (Constants.TILE_HEIGHT - pWidth) / 2, pLength, pWidth);
            entities.add(new Projectile(p, direction, normDamage));
        }
    }

    @Override
    public void useActive2(ArrayList<GamePiece> entities)
    {

    }

    @Override
    public void useActive3(ArrayList<GamePiece> entities)
    {

    }
}