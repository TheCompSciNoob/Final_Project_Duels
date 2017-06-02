import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Tester2
{
    public static void main(String[] args)
    {
        ArrayList<GamePiece> entities = Utility.defaultList();
        MainScreenManager msm1 = new MainScreenManager(entities, Constants.PLAYER_1);
        MainScreenManager msm2 = new MainScreenManager(entities, Constants.PLAYER_2);
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(Color.BLACK);
        tabbedPane.add("Player 1 Options", msm1);
        tabbedPane.add("Player 2 Options", msm2);
        GameWindow w = new GameWindow();
        w.setContentPane(tabbedPane);
        w.initialize();
        w.setVisible(true);
    }
}