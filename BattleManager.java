import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
public class BattleManager extends JComponent implements ActionListener, KeyListener
{
    private Timer t;
    private ArrayList<GamePiece> entities;

    public BattleManager(int speed, ArrayList<GamePiece> pieces)
    {
        super();
        entities = pieces;
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
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        for (int i = entities.size() - 1; i >= 0; i--)
        {
            GamePiece g = entities.get(i);
            g.updateGameState(entities); //more GamePiece objects can be added in this step
            /*
            if (g instanceof Player && ((Player) g).getHealth() <= 0)
            {
            EndScreenManager esm = new EndScreenManager(entities);
            JFrame ef = new JFrame(); //end frame
            ef.add(esm);
            ef.setSize(getWidth(), getHeight());
            ef.setLocationRelativeTo(null);
            ef.setResizable(false);
            ef.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ef.setTitle("GameWindow");
            ef.setVisible(true);
            JFrame parent = (JFrame) getTopLevelAncestor();
            parent.dispose(); //disposes battle screen after use
            setEnabled(false);
            }
             */
        }
    }
}