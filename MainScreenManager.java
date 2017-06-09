import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.*;
public class MainScreenManager extends JPanel implements ActionListener
{
    private static final String battleAction = "battleAction", fwdEditAction = "fwdEditAction", revEditAction = "revEditAction", selectAction = "selectAction";
    private int index = 0, perkLocation, listLocation, selectedIndex;
    private Player[] characters;
    private Perk[] perkList;
    private ArrayList<GamePiece> entities;
    private JTextArea description;

    public MainScreenManager(ArrayList<GamePiece> pieces, Perk[] thePerkList, int playerNum)
    {
        super(new BorderLayout(5, 5));
        entities = pieces;
        GamePiece player = null;
        if (playerNum == Constants.PLAYER_1)
        {
            listLocation = 0;
            player = entities.get(listLocation);
        }
        else if (playerNum == Constants.PLAYER_2)
        {
            listLocation = 1;
            player = entities.get(listLocation);
        }
        characters = new Player[] {new Cannoneer(player.getX(), player.getY(), playerNum), new Swordsman(player.getX(), player.getY(), playerNum)};
        perkList = thePerkList;
        ((GenericPlayer) player).setPerk(perkList[selectedIndex]);
        createComponents();
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
    }

    public void createComponents() //call after added to JFrame
    {
        //makes the start button, starts game(battle) when pressed
        JButton startButton = new JButton("Start");
        startButton.setActionCommand(battleAction);
        startButton.addActionListener(this);
        add(startButton, BorderLayout.PAGE_END);
        //makes the buttons that allows user to change character properties
        JButton fwdEdit = new JButton("NEXT >"); //sets to next character in array (P1)
        fwdEdit.setActionCommand(fwdEditAction);
        fwdEdit.addActionListener(this);
        add(fwdEdit, BorderLayout.EAST);
        JButton revEdit = new JButton("< PREV"); //sets to previous character in array (P1)
        revEdit.setActionCommand(revEditAction);
        revEdit.addActionListener(this);
        add(revEdit, BorderLayout.WEST);
        //creates the text are which displays the character info
        int style = Font.BOLD;
        Font font = new Font("Helvetica", style, 18);
        description = new JTextArea();
        description.setFont(font);
        description.setMargin(new Insets(5, 5, 5, 5));
        description.setEditable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.append(((Player) entities.get(listLocation)).getDescription());
        JScrollPane textPane = new JScrollPane(description);
        add(textPane, BorderLayout.CENTER);
        //creates the JComboBox for selection of perk
        JComboBox perkBox = new JComboBox(getPerkNames());
        perkBox.setSelectedIndex(selectedIndex);
        perkBox.setActionCommand(selectAction);
        perkBox.addActionListener(this);
        add(perkBox, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        GenericPlayer editPlayer = (GenericPlayer) entities.get(listLocation);
        if (command.equals(battleAction))
        {
            //initialize players
            for (GamePiece g : entities)
            {
                if (g instanceof GenericPlayer)
                {
                    ((GenericPlayer) g).initialize();
                }
            }
            //disables current frame and makes new frame
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
            description.setText(characters[index].getDescription());
            repaint();
        }
        if (command.equals(revEditAction))
        {
            index--;
            if (index < 0)
                index += characters.length;
            entities.set(listLocation, (GamePiece) characters[index]);
            description.setText(characters[index].getDescription());
            repaint();
        }
        if (command.equals(selectAction))
        {
            JComboBox selectBox = (JComboBox) e.getSource();
            selectedIndex = selectBox.getSelectedIndex();
        }
        ((GenericPlayer) entities.get(listLocation)).setPerk(perkList[selectedIndex]);
    }

    private String[] getPerkNames()
    {
        String[] perkNames = new String[perkList.length];
        for (int i = 0; i < perkList.length; i++)
        {
            perkNames[i] = perkList[i].getPerkName();
        }
        return perkNames;
    }
}