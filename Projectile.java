import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
public class Projectile extends Obstacle
{
    private final int velocity = 2;
    private int xSpeed, ySpeed, damage;
    private Color currentColor = Color.BLUE;

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
            xSpeed = -velocity;
    }

    public void doPlayerEffect(Player p)
    {
        p.addHealth(-damage);
    }

    public void updateGameState(ArrayList<GamePiece> entities)
    {
        for (int i = entities.size() - 1; i >= 0; i--)
        {
            GamePiece g = entities.get(i);
            if (g == this)
            {
                continue;
            }
            else if (g.doesCollide() && collide(g))
            {
                if (g.doesCollide() && g instanceof Player)
                {
                    doPlayerEffect((Player) g);
                }
                entities.remove(this);
            }
        }
        xLoc += xSpeed;
        yLoc += ySpeed;
        updateBoundingBox(xSpeed, ySpeed);
    }

    public void draw(Graphics g)
    {
        g.setColor(currentColor);
        super.drawBounds(g);
    }
    
    public void setColor(Color newColor)
    {
        currentColor = newColor;
    }
}
