import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
public class Cannoneer extends GenericPlayer
{
    private static final int pLength = 32, pWidth = 16;
    private boolean updated = true;

    public Cannoneer(int xStart, int yStart, int player)
    {
        super(xStart, yStart, player, 10000);
        attack = 500;
        recovery = 1;
        cd1 = (long) 7.5e8; //0.75 seconds
        cd2 = (long) 1e10; //10 seconds
        cd3 = (long) 1e10; //10 seconds
    }

    @Override
    public void useActive1(ArrayList<GamePiece> entities)
    {
        if (north())
        {
            Rectangle p = new Rectangle(xLoc + (Constants.TILE_WIDTH - pWidth) / 2, yLoc  - pLength, pWidth, pLength);
            entities.add(new Projectile(p, direction, attack));
        }
        if (south())
        {
            Rectangle p = new Rectangle(xLoc + (Constants.TILE_WIDTH - pWidth) / 2, yLoc + Constants.TILE_HEIGHT, pWidth, pLength);
            entities.add(new Projectile(p, direction, attack));
        }
        if (east())
        {
            Rectangle p = new Rectangle(xLoc + Constants.TILE_WIDTH, yLoc + (Constants.TILE_HEIGHT - pWidth) / 2, pLength, pWidth);
            entities.add(new Projectile(p, direction, attack));
        }
        if (west())
        {
            Rectangle p = new Rectangle(xLoc - pLength, yLoc + (Constants.TILE_HEIGHT - pWidth) / 2, pLength, pWidth);
            entities.add(new Projectile(p, direction, attack));
        }
    }

    @Override
    public void useActive2(ArrayList<GamePiece> entities)
    {
        health = Math.min(maxHealth, health + maxHealth / 2);
    }

    @Override
    public void useActive3(ArrayList<GamePiece> entities)
    {
        entities.add(new CrossLaser(bounds.get(0), attack / 50, this));
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.BLUE.brighter().brighter());
        super.draw(g);
    }

    @Override
    public String getDescription()
    {
        String genInfo = "Cannoneer\n\nA long range class. Good for long distance battles, with both offense and defense actives.\n";
        String act1 = "Active 1 : A projetile that shoots in the direction of where the player chooses to go.\n";
        String act2 = "Active 2 : reduce half of the player's max health.\n";
        String act3 = "Active 3 : A cross laser that causes severe damage to the other player.\n";
        return genInfo + act1 + act2 + act3;
    }
}