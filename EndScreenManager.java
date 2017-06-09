import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.*;
public class EndScreenManager extends JPanel implements ActionListener
{
    private ArrayList<GamePiece> entities;
    private static final String playAgainAction = "playAgainAction", exitAction = "exitAction";

    public EndScreenManager(ArrayList<GamePiece> pieces)
    {
        entities = pieces;
        createButtons();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //to be completed with backgrounds
    }

    private void createButtons()
    {
        JButton playAgain = new JButton("Play Again");
        playAgain.setActionCommand(playAgainAction);
        playAgain.addActionListener(this);
        JButton exit = new JButton("Quit Game");
        exit.setActionCommand(exitAction);
        exit.addActionListener(this);
        //figures out which player wins
        Player winner = null;
        for (GamePiece g : entities)
        {
            if (g instanceof Player && ((Player) g).getHealth() > 0)
            {
                winner = (Player) g;
                break;
            }
        }
        if (winner != null)
        {
            JLabel winnerLine = new JLabel("Player " + winner.getPlayerNum() + " wins!", JLabel.CENTER);
            add(winnerLine, BorderLayout.CENTER);
        }
        add(playAgain, BorderLayout.WEST);
        add(exit, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if (command.equals(playAgainAction))
        {
            setEnabled(false);
            JFrame parent = (JFrame) getTopLevelAncestor();
            parent.remove(this);
            parent.setVisible(false);
            parent.dispose();
            DuelRunner.main(new String[]{""});
        }
        if (command.equals(exitAction))
        {
            setEnabled(false);
            JFrame parent = (JFrame) getTopLevelAncestor();
            parent.remove(this);
            parent.setVisible(false);
            parent.dispose();
        }
    }
}