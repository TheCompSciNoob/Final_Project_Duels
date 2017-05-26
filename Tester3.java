import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Tester3
{
    public static void main(String[] args)
    {
        ArrayList<GamePiece> entities = new ArrayList<GamePiece>();
        entities.add(new Cannoneer(0, 0, Constants.PLAYER_1));
        entities.add(new Wall(100, 100, "Wall1.png"));
        BattleManager bm = new BattleManager(3, entities);
        JFrame bf = new JFrame();
        bf.add(bm);
        bf.setSize(512, 512);
        bf.setLocationRelativeTo(null);
        bf.setResizable(false);
        bf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bf.setTitle("GameWindow");
        bf.setVisible(true);
    }
}