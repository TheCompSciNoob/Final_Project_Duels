import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.*;
public class MainScreenManager extends JPanel implements ActionListener
{
    private static final String battleAction = "battleAction", fwdEditAction = "fwdEditAction", revEditAction = "revEditAction";
    private int index, listLocation;
    private Player[] characters;
    private ArrayList<GamePiece> entities;

    public MainScreenManager(ArrayList<GamePiece> pieces, int playerNum)
    {
        super(new BorderLayout(50, 100));
        entities = pieces;
        GamePiece player = null;
        if (playerNum == Constants.PLAYER_1)
        {
          player = entities.get(0);
          listLocation = 0;
        }
        if (playerNum == Constants.PLAYER_2)
        {
          player = entities.get(1);
          listLocation = 1;
        }
        characters = new Player[] {new Cannoneer(player.getX(), player.getY(), Constants.PLAYER_1), new Swordsman(player.getX(), player.getY(), playerNum)};
        createButtons();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
    }

    public void createButtons() //call after added to JFrame
    {
        //makes the start button, starts game(battle) when pressed
        JButton startButton = new JButton("Start");
        startButton.setActionCommand(battleAction);
        startButton.addActionListener(this);
        add(startButton, BorderLayout.PAGE_END);
        //makes the buttons that allows user to change character properties
        JButton fwdEdit = new JButton(fwdEditAction); //sets to next character in array (P1)
        fwdEdit.setActionCommand(fwdEditAction);
        fwdEdit.addActionListener(this);
        add(fwdEdit, BorderLayout.EAST);
        JButton revEdit = new JButton(revEditAction); //sets to previous character in array (P1)
        revEdit.setActionCommand(revEditAction);
        revEdit.addActionListener(this);
        add(revEdit, BorderLayout.WEST);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if (command.equals(battleAction))
        {
            setEnabled(false);
            BattleFrameManager bm = new BattleFrameManager(3, entities);
            GameWindow w = new GameWindow();
            w.setContentPane(bm);
            w.initialize();
            w.setVisible(true);
            JFrame parent = (JFrame) getTopLevelAncestor();
            parent.remove(this);
            parent.setVisible(false);
            parent.dispose();
        }
        if (command.equals(fwdEditAction))
        {
            index = (index + 1) % characters.length;
            entities.set(listLocation, (GamePiece) characters[index]);
        }
        if (command.equals(revEditAction))
        {
            index--;
            if (index < 0)
            index += characters.length;
            entities.set(listLocation, (GamePiece) characters[index]);
        }
    }
}