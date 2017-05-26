import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Cursor;
public class GameIO extends JComponent implements ActionListener, KeyListener, MouseListener, MouseMotionListener
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
        addMouseListener(this);
        addMouseMotionListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e)
    {
        
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {

    }
}