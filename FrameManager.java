import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.geom.Ellipse2D;
public class FrameManager
{
    //everything to keep track
    private ArrayList<GamePiece> entities;
    private GameWindow mainFrame, battleFrame;
    private static final int gameSpeed = 3;

    public FrameManager(int width, int height)
    {
        entities = new ArrayList<GamePiece>();
        mainFrame = new GameWindow();
        battleFrame = new GameWindow();
        makeList();
        battleFrame.add(new BattleManager(3, entities));
    }

    public void displayGUI()
    {
        //adds the main screen and its buttons   
        MainScreenManager msm = new MainScreenManager(entities);
        msm.setOpaque(true);
        /*
        CustomButton startButton = new CustomButton(new Rectangle(50, 50, 50, 50));
        startButton.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
        {
        mainFrame.setVisible(false);
        mainFrame.dispose();
        battleFrame.initialize();
        battleFrame.setVisible(true);
        }
        });
        CustomButton testButton = new CustomButton(new Ellipse2D.Double(300, 300, 50, 50));
        mainFrame.add(startButton);
        mainFrame.add(testButton);
         */
        mainFrame.setContentPane(msm);
        mainFrame.initialize();
        mainFrame.setVisible(true);
    }

    private void makeList()
    {
        entities.add(new Cannoneer(0, 0, Constants.PLAYER_1));
    }
}