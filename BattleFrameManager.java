import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.*;
public class BattleFrameManager extends JPanel
{
    private ArrayList<GamePiece> entities;

    private BattleManager battle;
    private HealthBar bar1, bar2;
    private StatusBar stats;

    public BattleFrameManager(int speed, ArrayList<GamePiece> pieces)
    {
        super(new BorderLayout());
        setBackground(Color.BLACK);
        entities = pieces;
        bar1 = new HealthBar(pieces, Constants.PLAYER_1);
        bar2 = new HealthBar(pieces, Constants.PLAYER_2);
        battle = new BattleManager(pieces);
        stats = new StatusBar(pieces);
        add(bar1, BorderLayout.WEST);
        add(bar2, BorderLayout.EAST);
        add(battle, BorderLayout.CENTER);
        add(stats, BorderLayout.SOUTH);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (GamePiece piece : entities)
        {
            if (piece instanceof Player && ((Player) piece).getHealth() <= 0)
            {
                gameEnd();
                break;
            }
        }
    }

    private void gameEnd()
    {
        setEnabled(false);
        battle.stop(); //disables the timer
        EndScreenManager esm = new EndScreenManager(entities);
        GameWindow w = new GameWindow();
        w.setContentPane(esm);
        w.initialize();
        w.setVisible(true);
        JFrame parent = (JFrame) getTopLevelAncestor();
        parent.dispose(); //disposes battle screen after use
    }
}