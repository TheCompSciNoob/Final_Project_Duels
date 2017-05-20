import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javafx.geometry.BoundingBox;
import java.util.ArrayList;
public abstract class GamePiece
{
    private boolean collision;
    protected BufferedImage image;
    protected ArrayList<BoundingBox> bounds;
    protected int xLoc, yLoc;

    public GamePiece(String imageName)
    {
        collision = true;	
        setImage(imageName);
        bounds = new ArrayList<BoundingBox>();
    }
    
    public GamePiece()
    {
        collision = true;	
        setImage("");
        bounds = new ArrayList<BoundingBox>();
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
        for (BoundingBox b : bounds)
        {
            BoundingBox newBox = new BoundingBox(b.getMinX() + xIncrement, b.getMinY() + yIncrement, b.getWidth(), b.getHeight());
            for (GamePiece g : entities)
            {
                if (g.doesCollide() && g != this)
                {
                    for (BoundingBox otherBox : g.getBounds())
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

    public ArrayList<BoundingBox> getBounds()
    {
        return new ArrayList<BoundingBox>(bounds);
    }

    public void updateBoundingBox(int xIncrement, int yIncrement) //contains how the object collides
    {
        if (xIncrement == 0 && yIncrement == 0)
        {
            return;
        }
        for (int i = 0; i < bounds.size(); i++)
        {
            BoundingBox b = bounds.get(i);
            bounds.set(i, new BoundingBox(b.getMinX() + xIncrement, b.getMinY() + yIncrement, b.getWidth(), b.getHeight()));
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
        ArrayList<BoundingBox> otherBounds = other.getBounds();
        for (BoundingBox myBound : bounds)
        {
            for (BoundingBox otherBound : otherBounds)
            {
                if (otherBound.intersects(myBound))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract void updateGameState(ArrayList<GamePiece> entities);

    public abstract void draw(Graphics g);

}