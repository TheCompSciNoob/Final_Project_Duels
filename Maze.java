import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Color;
public class Maze extends GameEvent
{
    private int phase;

    public Maze()
    {
        super();
        phase = 1;
        Map map = new Map();
        map.start();
        entities = map.convertToGamePiece();
    }

    public void draw(Graphics g)
    {
        g.setColor(new Color(160, 244, 0));
        g.fillRect(0, 0, GameWindow.WIDTH, GameWindow.HEIGHT); //draws the background
        for (int i = entities.size() - 1; i >= 0; i--)
        {
            entities.get(i).draw(g);
        }
    }

    public void respondToKeyPressed(KeyEvent e)
    {
        if (phase == 1)
        {
            for (GamePiece g : entities)
            {
                if (g instanceof Player)
                {
                    ((Player) g).respondToKeyPressed(e);
                }
            }
        }
    }

    public void respondToKeyReleased(KeyEvent e)
    {
        if (phase == 1)
        {
            for (GamePiece g: entities)
            {
                if (g instanceof Player)
                {
                    ((Player) g).respondToKeyReleased(e);
                }
            }
        }
    }

    public void updateGameState(ActionEvent e)
    {
        if (phase == 1)
        {
            for (int i = entities.size() - 1; i >= 0; i--)
            {
                entities.get(i).updateGameState(entities);
            }
        }
    }
}