import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.*;
public class HealthBar extends JComponent
{
    private static final int margin = 10, barWidth = 50, barHeight = 490; //for locations of health bars
    private Player player;
    private Rectangle base, shape;
    private Color maxColor = Color.GREEN, minColor = Color.RED;

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
        updateShape();
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(findColor());
        g2.fill(shape);
        g2.setColor(Color.WHITE);
        g2.draw(base);
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
    
    private Color findColor()
    {
        double healthRatio = (double) player.getHealth() / player.getMaxHealth();
        //finds difference in all colors
        int dRed = maxColor.getRed() - minColor.getRed();
        int dGreen = maxColor.getGreen() - minColor.getGreen();
        int dBlue = maxColor.getBlue() - minColor.getBlue();
        //finds new color composition
        int newRed = minColor.getRed() + (int) (dRed * healthRatio);
        int newGreen = minColor.getGreen() + (int) (dGreen * healthRatio);
        int newBlue = minColor.getBlue() + (int) (dBlue * healthRatio);
        return new Color(Utility.truncate(newRed, 0, 255), Utility.truncate(newGreen, 0, 255), Utility.truncate(newBlue, 0, 255));
    }
}