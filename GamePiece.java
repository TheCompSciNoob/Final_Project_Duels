import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.Graphics2D;
public abstract class GamePiece
{
    private boolean collision;
    protected BufferedImage image;
    protected ArrayList<Rectangle> bounds;
    protected int xLoc, yLoc;

    public GamePiece(String imageName)
    {
        collision = true;	
        setImage(imageName);
        bounds = new ArrayList<Rectangle>();
    }

    public GamePiece()
    {
        collision = true;	
        setImage("");
        bounds = new ArrayList<Rectangle>();
    }

    public void setCollision(boolean collides)
    {
        collision = collides;
    }

    public boolean doesCollide()
    {
        return collision;
    }

    public boolean collideAfterMovement(int xIncrement, int yIncrement, ArrayList<GamePiece> entities)
    {
        if (xIncrement == 0 && yIncrement == 0)
        {
            return false;
        }
        for (Rectangle b : bounds)
        {
            Rectangle newBox = (Rectangle) b.clone();
            newBox.translate(xIncrement, yIncrement);
            for (GamePiece g : entities)
            {
                if (g.doesCollide() && g != this)
                {
                    for (Rectangle otherBox : g.getBounds())
                    {
                        if (newBox.intersects(otherBox))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<Rectangle> getBounds()
    {
        return bounds;
    }

    public void updateBoundingBox(int xIncrement, int yIncrement) //contains how the object collides
    {
        if (xIncrement == 0 && yIncrement == 0)
        {
            return;
        }
        for (Rectangle b : bounds)
        {
            b.translate(xIncrement, yIncrement);
        }
    }

    public void setImage(String imageName)
    {
        try {
            image = ImageIO.read(new File(imageName));
        } catch (IOException e) {
        }
    }

    public boolean collide(GamePiece other)
    {
        for (Rectangle myBound : bounds)
        {
            for (Rectangle otherBound : other.getBounds())
            {
                if (myBound.intersects(otherBound))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void drawBounds(Graphics g)
    {
        for (Rectangle b : bounds)
        {
            ((Graphics2D) g).fill(b);
        }
    }

    public abstract void updateGameState(ArrayList<GamePiece> entities);

    public abstract void draw(Graphics g);
}