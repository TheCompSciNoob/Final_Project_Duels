import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
public class Swordsman extends GenericPlayer
{
    private static final int pLength = 32, pWidth = 16;
    private long lastUpdateSpeed = System.nanoTime(), updateSpeedInterval = (long) 5e9;
    private int speedMultiplyer = 2;
    
    public Swordsman(int xStart, int yStart, int player)
    {
        super(xStart, yStart, player, 10000);
        recovery = 1;
        attack = 750;
        cd1 = (long) 7.5e8; //0.75 seconds
        cd2 = (long) 1e10; //10 seconds
        cd3 = (long) 1e10; //10 seconds
    }

    @Override
    public void useActive1(ArrayList<GamePiece> entities)
    {
        if (north())
        {
            Rectangle r = new Rectangle(xLoc + (Constants.TILE_WIDTH - pWidth) / 2, yLoc  - pLength, pWidth, pLength);
            Projectile p = new Projectile(r, direction, attack);
            p.setColor(Color.YELLOW);
            entities.add(p);
        }
        if (south())
        {
            Rectangle r = new Rectangle(xLoc + (Constants.TILE_WIDTH - pWidth) / 2, yLoc + Constants.TILE_HEIGHT, pWidth, pLength);
            Projectile p = new Projectile(r , direction, attack);
            p.setColor(Color.YELLOW);
            entities.add(p);
        }
        if (east())
        {
            Rectangle r = new Rectangle(xLoc + Constants.TILE_WIDTH, yLoc + (Constants.TILE_HEIGHT - pWidth) / 2, pLength, pWidth);
            Projectile p = new Projectile(r, direction, attack);
            p.setColor(Color.YELLOW);
            entities.add(p);
        }
        if (west())
        {
            Rectangle r = new Rectangle(xLoc - pLength, yLoc + (Constants.TILE_HEIGHT - pWidth) / 2, pLength, pWidth);
            Projectile p = new Projectile(r, direction, attack);
            p.setColor(Color.YELLOW);
            entities.add(p);
        }
    }

    @Override
    public void useActive2(ArrayList<GamePiece> entities)
    {
        setSpeed(speedMultiplyer, speedMultiplyer);
        lastUpdateSpeed = System.nanoTime();
    }

    @Override
    public void useActive3(ArrayList<GamePiece> entities)
    {
        entities.add(new Blade(bounds.get(0), attack / 100));
        useActive2(entities);
    }
    
    @Override
    public void updateGameState(ArrayList<GamePiece> entities)
    {
        super.updateGameState(entities);
        if (System.nanoTime() - lastUpdateSpeed > updateSpeedInterval)
        {
            setSpeed(1, 1);
        }
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.YELLOW);
        super.draw(g);
    }

    @Override
    public String getDescription()
    {
        String genInfo = "Swordsman\n\nA melee class, powerful in close combat, with 3 offensive actives.\n";
        String act1 = "Active 1 : A projectile that shoots in the direction of where the player chooses to go.\n";
        String act2 = "Active 2 : Increases player's speed for 5 seconds\n";
        String act3 = "Active 3 : Increases speed for 5 seconds; Creates 4 blades that allows the swordsman to charge at the opponent.\n";
        return genInfo + act1 + act2 + act3;
    }
}