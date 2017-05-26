import javax.swing.*;
import java.awt.event.*;
import java.awt.Rectangle;
import java.util.ArrayList;
public class FrameManager extends JFrame
{
    //everything to keep track
    private ArrayList<GamePiece> entities;
    private static final int gameSpeed = 3;

    public FrameManager()
    {
        super();
        entities = new ArrayList<GamePiece>();
        makeList();
    }

    public void displayGUI()
    {
        //adds the main screen and its buttons
        add(new MainScreenManager(entities));
        CustomButton startButton = new CustomButton(new Rectangle(50, 50, 50, 50));
        startButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    add(new BattleManager(gameSpeed, entities));
                    revalidate();
                    startButton.setEnabled(false);
                }
            });
        add(startButton);
        //shows the frame
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("GameWindow");
        setVisible(true);
    }

    private void makeList()
    {
        entities.add(new Cannoneer(0, 0, Constants.PLAYER_1));
    }
}