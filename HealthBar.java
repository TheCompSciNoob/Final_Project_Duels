import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.*;
public class HealthBar extends JComponent implements ActionListener
{
  private static final int margin = 10, barWidth = 50, barHeight = 490; //for locations of health bars
    private Player player;
    private Rectangle base, shape;

    public HealthBar(ArrayList<GamePiece> entities, int playerNum)
    {
      if (playerNum == Constants.PLAYER_1)
      {
        player = (Player) entities.get(0);
      }
      if (playerNum == Constants.PLAYER_2)
      {
        player = (Player) entities.get(1);
      }
        setBackground(Color.BLACK);
        updateShape();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);
        g2.fill(shape);
        g2.setColor(Color.WHITE);
        g2.draw(base);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        updateShape();
    }
    
    @Override
    public Dimension getPreferredSize()
    {
        int maxX = (int) base.getMaxX() + margin;
        int maxY = (int) base.getMaxY() + margin;
        return new Dimension(maxX, maxY);
    }

    private void updateShape()
    {
        base = new Rectangle(margin, margin, barWidth, barHeight);
        shape = new Rectangle(margin, margin + barHeight - barHeight * player.getHealth() / player.getMaxHealth(), barWidth, barHeight * player.getHealth() / player.getMaxHealth());
    }
}