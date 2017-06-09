import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.*;
public class BattleManager extends JComponent implements ActionListener, KeyListener
{
    private Rectangle limit;
    private ArrayList<GamePiece> entities;
    private Timer t;

    public BattleManager(ArrayList<GamePiece> pieces)
    {
        super();
        entities = pieces;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        t = new Timer(3, this);
        t.start();
        addKeyListener(this);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //draws components on board
        setBackground(Color.BLACK);
        for (int i = entities.size() - 1; i >= 0; i--)
        {
            entities.get(i).draw(g);
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        for (GamePiece g : entities)
        {
            if (g instanceof Player)
            {
                ((Player) g).respondToKeyPressed(e);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        for (GamePiece g : entities)
        {
            if (g instanceof Player)
            {
                ((Player) g).respondToKeyReleased(e);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() //size that fits in all gamepieces in entities	
    {
        int maxX = 0, maxY = 0;
        for (GamePiece g : entities)
        {
            for (Rectangle b : g.getBounds())
            {
                maxX = (int) Math.max(b.getMaxX(), maxX);
                maxY = (int) Math.max(b.getMaxY(), maxY);
            }
        }
        return new Dimension(maxX, maxY);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i = entities.size() - 1; i >= 0; i--)
        {
            GamePiece g = entities.get(i);
            g.updateGameState(entities); //more GamePiece objects can be added in this step
        }
        JFrame parent = (JFrame) getTopLevelAncestor();
        parent.getContentPane().repaint();
    }

    public void stop()
    {
        t.stop();
    }
}