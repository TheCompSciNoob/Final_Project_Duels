import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Tester4
{
    public static void main(String[] args)
    {
        JPanel panel = new JPanel(new BorderLayout());
        ArrayList<GamePiece> entities = Utility.defaultList();
        entities.add(new Cannoneer(0, 0, Constants.PLAYER_1));
        entities.add(new Wall(100, 100, "Wall1.png"));
        BattleManager bm = new BattleManager(3, entities);
        panel.add(bm, BorderLayout.CENTER);
        panel.add(new StatusBar(entities), BorderLayout.SOUTH);
        JFrame bf = new JFrame();
        bf.setContentPane(panel);
        bf.setSize(512, 512);
        bf.setLocationRelativeTo(null);
        bf.setResizable(false);
        bf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bf.setTitle("GameWindow");
        bf.setVisible(true);
    }
}