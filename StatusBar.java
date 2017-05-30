import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.*;
public class StatusBar extends JComponent implements ActionListener
{
    private static final int margin = 10, barWidth = 200, barHeight = 50; //for locations for health bars
    private Player player1, player2;
    private Rectangle base1, base2, shape1, shape2;
    private Timer t;

    public StatusBar(ArrayList<GamePiece> entities)
    {
        t = new Timer(3, this);
        t.start();
        player1 = (Player) entities.get(0);
        player2 = (Player) entities.get(1);
        updateShape();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);
        g2.fill(shape1);
        g2.fill(shape2);
        g2.setColor(Color.WHITE);
        g2.draw(base1);
        g2.draw(base2);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        updateShape();
        repaint();
    }

    private void updateShape()
    {
        base1 = new Rectangle(margin, margin, barWidth, barHeight);
        base2 = new Rectangle(getWidth() - barWidth - margin, margin, barWidth, barHeight);
        shape1 = new Rectangle(margin, margin, barWidth * player1.getHealth() / player1.getMaxHealth(), barHeight);
        shape2 = new Rectangle(getWidth() - barWidth * player2.getHealth() / player2.getMaxHealth(), margin, barWidth - margin, barHeight);
    }
}