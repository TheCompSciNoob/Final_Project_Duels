import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Color;
public abstract class GameEvent
{
    protected ArrayList<GamePiece> entities;

    public GameEvent()
    {
        entities = new ArrayList<GamePiece>();
    }

    public abstract void draw(Graphics g);

    public abstract void respondToKeyPressed(KeyEvent e);

    public abstract void respondToKeyReleased(KeyEvent e);

    public abstract void updateGameState(ActionEvent e);

    public void addPiece(GamePiece g)
    {
        if (g instanceof Player)
        {
            entities.add(0, g);
        }
        else
        {
            entities.add(g);
        }
    }
}