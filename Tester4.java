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
        BattleFrameManager bm = new BattleFrameManager(3, entities);
        panel.add(bm, BorderLayout.CENTER);
        JFrame bf = new JFrame();
        bf.setContentPane(panel);
        bf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bf.setTitle("GameWindow");
        bf.setLocationRelativeTo(null);
        bf.pack();
        bf.setVisible(true);
    }
}