import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Tester2
{
    public static void main(String[] args)
    {
        ArrayList<GamePiece> entities = new ArrayList<GamePiece>();
        entities.add(new Cannoneer(0, 0, Constants.PLAYER_1));
        MainScreenManager msm = new MainScreenManager(entities);
        CustomButton startButton = new CustomButton(new Rectangle(50, 50, 50, 50));
        startButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    BattleManager bm = new BattleManager(3, entities);
                    JFrame bf = new JFrame(); //battle frame
                    bf.add(bm);
                    bf.setSize(512, 512);
                    bf.setLocationRelativeTo(null);
                    bf.setResizable(false);
                    bf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    bf.setTitle("GameWindow");
                    bf.setVisible(true);
                    JFrame parent = (JFrame) startButton.getTopLevelAncestor();
                    parent.dispose(); //disposes main screen after use
                }
            });
        msm.add(startButton);
        JFrame mf = new JFrame();
        mf.add(msm);
        mf.setSize(512, 512);
        mf.setLocationRelativeTo(null);
        mf.setResizable(false);
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setTitle("GameWindow");
        mf.setVisible(true);
    }
}