import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Cannoneer extends GenericPlayer
{
    public Cannoneer(int xStart, int yStart, int player)
    {
        super(xStart, yStart, player);
    }
    
    @Override
    public void useActive1(ArrayList<GamePiece> entities)
    {
        entities.add(new Projectile(new Rectangle(xLoc + 64, yLoc + 64, Constants.TILE_WIDTH, Constants.TILE_HEIGHT), Constants.NORTH, 10));
        keyActive1 = false;
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