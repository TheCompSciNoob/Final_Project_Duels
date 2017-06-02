import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
public class Swordsman extends GenericPlayer
{
    public Swordsman(int xStart, int yStart, int player)
    {
        super(xStart, yStart, player, 10000);
        recovery = 1;
    }

    @Override
    public void useActive1(ArrayList<GamePiece> entities)
    {
        
    }

    @Override
    public void useActive2(ArrayList<GamePiece> entities)
    {

    }

    @Override
    public void useActive3(ArrayList<GamePiece> entities)
    {

    }
    
    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.YELLOW);
        super.draw(g);
    }
}