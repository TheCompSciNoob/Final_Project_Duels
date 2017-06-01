import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Tester5
{
  public static void main(String[] args)
  {
    ArrayList<GamePiece> enities = Utility.defaultList();
    MainScreenManager msm1 = new MainScreenManager(entities, Constants.PLAYER_1);
    MainScreenManager msm2 = new MainScreenManager(entities, Constants.PLAYER_2);
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.add("Edit P1", msm1);
    tabbedPane.add("Edit P2", msm2);
    GameWindow w = new GameWindow();
    w.setContentPane(tabbedPane);
    w.initialize();
    w.setVisible(true);
  }
}