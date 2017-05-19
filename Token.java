import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class Token extends Obstacle
{
    public Token(int xStart, int yStart, String imageName)
    {
        super(imageName);
        xLoc = xStart;
        yLoc = yStart;
        setCollision(false);
    }
    
    public void doPlayerEffect(Player p)
    {
        p.addHealth(p.getHealth());
    }
    
    public boolean collideAfterMovement(int row, int col, GamePiece [][] board)
    {
        return false;
    }
    
    public void updateGameState(ArrayList<GamePiece> entities)
    {
        
    }
    
    public void draw(Graphics g)
    {
        g.drawImage(image, xLoc, yLoc, null);
    }
}