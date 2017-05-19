import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
public class GameIO extends JComponent implements ActionListener, KeyListener
{
    private Timer t;
    private GameEvent event;

    public GameIO(int speed, GameEvent e)
    {
        super();
        event = e;
        t = new Timer(speed, this);
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //draws components on board
        event.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        event.respondToKeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        event.respondToKeyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        event.updateGameState(e);
    }
}
