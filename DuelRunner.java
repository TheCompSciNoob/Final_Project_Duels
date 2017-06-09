import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Rectangle;
public class DuelRunner
{
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    createAndShowGUI();
                }
            });
    }

    private static void createAndShowGUI()
    {
        ArrayList<GamePiece> entities = Utility.defaultList();
        Perk[] perkList = {new Standard(), new Tank(), new Thief(), new Trojan(), new SelfDamage()};
        MainScreenManager msm1 = new MainScreenManager(entities, perkList, Constants.PLAYER_1); //manages player 1
        MainScreenManager msm2 = new MainScreenManager(entities, perkList, Constants.PLAYER_2); //manages player 2
        JTabbedPane perkDescriptions = new JTabbedPane(JTabbedPane.LEFT); //manages all descriptions of the perks
        for (Perk p : perkList)
        {
            int style = Font.BOLD;
            Font font = new Font("Helvetica", style, 20);
            JTextArea description = new JTextArea(p.getPerkName() + "\n" + p.getDescription());
            description.setFont(font);
            description.setMargin(new Insets(5, 5, 5, 5));
            description.setEditable(false);
            description.setLineWrap(true);
            description.setWrapStyleWord(true);
            perkDescriptions.add(p.getPerkName(), description);
        }
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.add("Player 1 Options", msm1);
        tabbedPane.add("Player 2 Options", msm2);
        tabbedPane.add("Perk Information", perkDescriptions);
        GameWindow w = new GameWindow();
        w.setContentPane(tabbedPane);
        w.initialize();
        w.setVisible(true);
    }
}