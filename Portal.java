import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class Portal extends Obstacle
{
    public Portal(int xStart, int yStart, String imageName)
    {
        super(imageName);
        xLoc = xStart;
        yLoc = yStart;
        setCollision(false);
    }

    public void doPlayerEffect(Player p)
    {

    }

    public boolean collideAfterMovement(int row, int col, GamePiece [][] board)
    {
        return false;
    }

    public void updateGameState(ArrayList<GamePiece> entities)
    {
        GamePiece p = entities.get(0); //must be the player
        if (collide(p))
        {
            int i = 0;
            while (entities.get(i) != this)
                i++;
            entities.remove(i);
        }
    }

    public void draw(Graphics g)
    {
        g.drawImage(image, xLoc, yLoc, null);
    }
}