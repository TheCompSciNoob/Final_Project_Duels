import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Rectangle;
public class MainScreenManager extends JPanel
{
    private ArrayList<GamePiece> entities;
    private ArrayList<CustomButton> buttons;

    public MainScreenManager(ArrayList<GamePiece> pieces)
    {
        entities = pieces;
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }

    private void createButtons()
    {
        //makes the start button, starts game(battle) when pressed
        CustomButton startButton = new CustomButton(new Rectangle(50, 50, 50, 50));
        startButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    BattleManager bm = new BattleManager(3, entities);
                    JFrame bf = new JFrame(); //battle frame
                    bf.add(bm);
                    bf.setSize(getWidth(), getHeight());
                    bf.setLocationRelativeTo(null);
                    bf.setResizable(false);
                    bf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    bf.setTitle("GameWindow");
                    bf.setVisible(true);
                    JFrame parent = (JFrame) getTopLevelAncestor();
                    parent.dispose(); //disposes main screen after use
                }
            });
    }
}