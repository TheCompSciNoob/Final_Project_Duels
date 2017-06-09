import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class Blade extends Obstacle
{
    private static final int length = 100;
    private long creationTime = System.nanoTime(), existTime = (long) 3e9;
    private int damage;
    private Rectangle base;

    public Blade(Rectangle base, int damage)
    {
        super();
        setCollision(false);
        this.base = base;
        this.damage = damage;
        updateBounds();
    }

    public void updateGameState(ArrayList<GamePiece> entities)
    {
        updateBounds();
        for (GamePiece g : entities)
        {
            if (collide(g) && g instanceof Player)
            {
                doPlayerEffect((Player) g);
            }
        }
        if (System.nanoTime() - creationTime > existTime)
        {
            entities.remove(this);
        }
    }

    @Override
    public void doPlayerEffect(Player p)
    {
        p.addHealth(-damage);
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.YELLOW);
        super.drawBounds(g);
    }

    private void updateBounds()
    {
        int width = calculateWidth();
        Rectangle p1 = new Rectangle((int) base.getX() + (Constants.TILE_WIDTH - width) / 2, (int) base.getY()  - length, width, length);
        Rectangle p2 = new Rectangle((int) base.getX() + (Constants.TILE_WIDTH - width) / 2, (int) base.getY() + Constants.TILE_HEIGHT, width, length);
        Rectangle p3 = new Rectangle((int) base.getX() + Constants.TILE_WIDTH, (int) base.getY() + (Constants.TILE_HEIGHT - width) / 2, length, width);
        Rectangle p4 = new Rectangle((int) base.getX() - length, (int) base.getY() + (Constants.TILE_HEIGHT - width) / 2, length, width);
        bounds.clear();
        bounds.add(p1);
        bounds.add(p2);
        bounds.add(p3);
        bounds.add(p4);
    }
    
    private int calculateWidth()
    {
        int side = (int) Math.min(base.getWidth(), base.getHeight());
        return (int) Math.min((double) side, (System.nanoTime() - creationTime) / 1000000);
    }
}