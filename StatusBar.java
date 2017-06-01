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
public class StatusBar extends JComponent implements ActionListener
{
    private static final int margin = 10; //for locations of status bar
    private GenericPlayer player1, player2;
    private BufferedImage coolDown, active;

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
        //draws active status for player1
        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(margin, margin);
        if (player1.isActive1())
        {
          g2.drawImage(active, 0, 0);
          g2.translate(active.getWidth(), 0);
        }
        else
        {
          g2.drawImage(coolDown, 0, 0);
          g2.translate(coolDown.getWidth(), 0);
        }
        if (player1.isActive2())
        {
          g2.drawImage(active, 0, 0);
          g2.translate(active.getWidth(), 0);
        }
        else
        {
          g2.drawImage(coolDown, 0, 0);
          g2.translate(coolDown.getWidth(), 0);
        }
        if (player1.isActive3())
        {
          g2.drawImage(active, 0, 0);
          g2.translate(active.getWidth(), 0);
        }
        else
        {
          g2.drawImage(coolDown, 0, 0);
          g2.translate(coolDown.getWidth(), 0);
        }
        g2.dispose();
        //draws active status for player2
        Graphics2D g3 = (Graphics2D) g.create();
        g3.translate(getWidth - margin, margin);
        if (player2.isActive3())
        {
          g3.translate(-active.getWidth(), 0);
          g3.drawImage(active, 0, 0);
        }
        else
        {
          g3.translate(-coolDown.getWidth(), 0);
          g3.drawImage(coolDOwn, 0, 0);
        }
        if (player2.isActive2())
        {
          g3.translate(-active.getWidth(), 0);
          g3.drawImage(active, 0, 0);
        }
        else
        {
          g3.translate(-coolDown.getWidth(), 0);
          g3.drawImage(coolDOwn, 0, 0);
        }
        if (player2.isActive1())
        {
          g3.translate(-active.getWidth(), 0);
          g3.drawImage(active, 0, 0);
        }
        else
        {
          g3.translate(-coolDown.getWidth(), 0);
          g3.drawImage(coolDOwn, 0, 0);
        }
        g3.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }
    
    @Override
    public Dimension getPreferredSize()
    {
        int maxIconWidth = Math.max(active.getWidth(), coolDown.getWidth());
        int maxIconHeight = Math.max(active.getHeight(), coolDown.getHeight());
        int maxX = margin + maxIconWidth * 6 + ; //left to right
        int maxY = margin + maxIconHeight + margin; // top to bottom
        return new Dimension(maxX, maxY);
    }
    
    private BufferedImage getImage(Sting imageName)
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