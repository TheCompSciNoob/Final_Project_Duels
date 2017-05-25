import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class Projectile extends Obstacle
{
    private final int velocity = 1;
    private int xSpeed, ySpeed, damage;

    public Projectile(Rectangle shape, int direction, int damage)
    {
        super();
        setCollision(false);
        this.damage = damage;
        xLoc = (int) shape.getX();
        yLoc = (int) shape.getY();
        bounds.add(shape);
        if (direction == Constants.NORTH)
            ySpeed = -velocity;
        if (direction == Constants.SOUTH)
            ySpeed = velocity;
        if (direction == Constants.EAST)
            xSpeed = velocity;
        if (direction == Constants.WEST)
            ySpeed = -velocity;
    }

    public void doPlayerEffect(Player p)
    {
        p.addHealth(-damage);
    }

    public void updateGameState(ArrayList<GamePiece> entities)
    {
        int index = -1;
        for (int i = entities.size() - 1; i >= 0; i--)
        {
            GamePiece g = entities.get(i);
            if (g == this)
            {
                index = i;
                continue;
            }
            if (collide(g))
            {
                if (g instanceof Player)
                {
                    doPlayerEffect((Player) g);
                }
                if (index != -1)
                {
                    entities.remove(i);
                }
            }
        }
        xLoc += xSpeed;
        yLoc += ySpeed;
        updateBoundingBox(xSpeed, ySpeed);	
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawRect(xLoc, yLoc, 50, 50);
    }
}