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
        phase = Constants.PHASE_1;
        Map map = new Map();
        map.start();
        entities = map.convertToGamePiece();
    }

    @Override
    public void draw(Graphics g)
    {
        if (phase == Constants.PHASE_1)
        {
            g.setColor(new Color(160, 244, 0));
            g.fillRect(0, 0, GameWindow.WIDTH, GameWindow.HEIGHT); //draws the background
            for (int i = entities.size() - 1; i >= 0; i--)
            {
                entities.get(i).draw(g);
            }
        }
        if (phase == Constants.PHASE_2)
        {
            g.setColor(Color.RED);
            g.fillRect(0, 0, GameWindow.WIDTH, GameWindow.HEIGHT); //draws the background
        }
        if (phase == Constants.PHASE_3)
        {
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, GameWindow.WIDTH, GameWindow.HEIGHT); //draws the background
        }
    }

    @Override
    public void respondToKeyPressed(KeyEvent e)
    {
        if (phase == Constants.PHASE_1)
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

    @Override
    public void respondToKeyReleased(KeyEvent e)
    {
        if (phase == Constants.PHASE_1)
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

    @Override
    public void updateGameState(ActionEvent e)
    {
        boolean portalExist = false;
        if (phase == Constants.PHASE_1)
        {
            for (int i = entities.size() - 1; i >= 0; i--)
            {
                GamePiece g = entities.get(i);
                g.updateGameState(entities);
                if (g instanceof Player && ((Player) g).getHealth() <= 0)
                {
                    phase = Constants.PHASE_2;
                }
                if (g instanceof Portal)
                {
                    portalExist = true;
                }
            }
            if (!portalExist)
            {
                phase = Constants.PHASE_3;
            }
        }
    }
}