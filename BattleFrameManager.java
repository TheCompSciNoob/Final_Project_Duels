import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.*;
public class BattleFrameManager extends JPanel implements KeyListener, ActionListener
{
    private ArrayList<GamePiece> entities;
    private Timer t;
    private BattleManager battle;
    private HealthBar bar1, bar2;
    private StatusBar stats;

    public BattleFrameManager(int speed, ArrayList<GamePiece> pieces)
    {
        super(new BorderLayout());
        setBackground(Color.BLACK);
        t = new Timer(3, this);
        t.start();
        entities = pieces;
        bar1 = new HealthBar(pieces, Constants.PLAYER_1);
        bar2 = new HealthBar(pieces, Constants.PLAYER_2);
        battle = new BattleManager(pieces);
        stats = new StatusBar(pieces);
        add(bar1, BorderLayout.WEST);
        add(bar2, BorderLayout.EAST);
        add(battle, BorderLayout.CENTER);
        add(stats, BorderLayout.SOUTH);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        battle.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        battle.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        bar1.actionPerformed(e);
        bar2.actionPerformed(e);
        battle.actionPerformed(e);
        for (GamePiece g : entities)
        {
            if (g instanceof Player && ((Player) g).getHealth() <= 0)
            {
                gameEnd();
                return;
            }
        }
    }

    private void gameEnd()
    {
        setEnabled(false);
        t.stop(); //disables the timer
        EndScreenManager esm = new EndScreenManager(entities);
        GameWindow w = new GameWindow();
        w.setContentPane(esm);
        w.initialize();
        w.setVisible(true);
        JFrame parent = (JFrame) getTopLevelAncestor();
        parent.dispose(); //disposes battle screen after use
    }
}