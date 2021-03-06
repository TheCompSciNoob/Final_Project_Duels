import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.geom.AffineTransform;
public class StatusBar extends JComponent
{
    private static final int margin = 10; //for locations of status bar
    private GenericPlayer player1, player2;
    private BufferedImage coolDown, active;
    private int degrees;

    public StatusBar(ArrayList<GamePiece> entities)
    {
        player1 = (GenericPlayer) entities.get(0);
        player2 = (GenericPlayer) entities.get(1);
        setBackground(Color.BLACK);
        coolDown = getImage("coolDownIcon.png");
        active = getImage("activeIcon.png");
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        AffineTransform at = AffineTransform.getTranslateInstance(0, 0);
        at.rotate(Math.toRadians(degrees), coolDown.getWidth() / 2, coolDown.getHeight() / 2);
        degrees++;
        if (degrees == 360)
        {
            degrees = 0;
        }
        //draws active status for player1
        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(margin, margin);
        if (player1.isActive1())
        {
            g2.drawImage(active, 0, 0, null);
            g2.translate(active.getWidth(), 0);
        }
        else
        {
            g2.drawImage(coolDown, at, null);
            g2.translate(coolDown.getWidth(), 0);
        }
        if (player1.isActive2())
        {
            g2.drawImage(active, 0, 0, null);
            g2.translate(active.getWidth(), 0);
        }
        else
        {
            g2.drawImage(coolDown, at, null);
            g2.translate(coolDown.getWidth(), 0);
        }
        if (player1.isActive3())
        {
            g2.drawImage(active, 0, 0, null);
            g2.translate(active.getWidth(), 0);
        }
        else
        {
            g2.drawImage(coolDown, at, null);
            g2.translate(coolDown.getWidth(), 0);
        }
        g2.dispose();
        //draws active status for player2
        Graphics2D g3 = (Graphics2D) g.create();
        g3.translate(getWidth() - margin, margin);
        if (player2.isActive3())
        {
            g3.translate(-active.getWidth(), 0);
            g3.drawImage(active, 0, 0, null);
        }
        else
        {
            g3.translate(-coolDown.getWidth(), 0);
            g3.drawImage(coolDown, at, null);
        }
        if (player2.isActive2())
        {
            g3.translate(-active.getWidth(), 0);
            g3.drawImage(active, 0, 0, null);
        }
        else
        {
            g3.translate(-coolDown.getWidth(), 0);
            g3.drawImage(coolDown, at, null);
        }
        if (player2.isActive1())
        {
            g3.translate(-active.getWidth(), 0);
            g3.drawImage(active, 0, 0, null);
        }
        else
        {
            g3.translate(-coolDown.getWidth(), 0);
            g3.drawImage(coolDown, at, null);
        }
        g3.dispose();
    }

    @Override
    public Dimension getPreferredSize()
    {
        int maxIconWidth = Math.max(active.getWidth(), coolDown.getWidth());
        int maxIconHeight = Math.max(active.getHeight(), coolDown.getHeight());
        int maxX = margin + maxIconWidth * 6 + margin; //left to right
        int maxY = margin + maxIconHeight + margin; // top to bottom
        return new Dimension(maxX, maxY);
    }

    private BufferedImage getImage(String imageName)
    {
        BufferedImage image;
        try
        {
            return ImageIO.read(new File(imageName));
        }
        catch(IOException e)
        {
            System.out.println("No image of the name \"" + imageName + "\"");
            return null;
        }
    }
}