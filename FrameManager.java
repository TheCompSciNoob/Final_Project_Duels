import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class FrameManager
{
    //everything to keep track
    private ArrayList<GamePiece> entities;
    private JFrame mainFrame = new JFrame(), battleFrame = new JFrame();
    private JFrame[] frames = {mainFrame, battleFrame};
    private static final int gameSpeed = 3;

    public FrameManager()
    {
        entities = new ArrayList<GamePiece>();
        makeList();
    }

    public void displayGUI()
    {
        //adds the main screen and its buttons
        CustomButton startButton = new CustomButton(new Rectangle(50, 50, 50, 50));
        startButton.setLocation(50, 50);
        startButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    startButton.setEnabled(false);
                    mainFrame.getContentPane().removeAll();
                    mainFrame.add(new BattleManager(gameSpeed, entities));
                    mainFrame.revalidate();
                }
            });
        mainFrame.add(new MainScreenManager(entities));
        mainFrame.add(startButton);
        for (JFrame f : frames) {
            f.setLayout(null);
            f.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle("GameWindow");
        }
        mainFrame.setVisible(true);

    }

    private void makeList()
    {
        entities.add(new Cannoneer(0, 0, Constants.PLAYER_1));
    }
}