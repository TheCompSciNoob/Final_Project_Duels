import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Cursor;
public class CustomButton extends JButton implements MouseListener, MouseMotionListener
{
    private Shape buttonShape;

    public CustomButton(Shape s)
    {
        super();
        buttonShape = s;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        ((Graphics2D) g).draw(buttonShape);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        Area a = new Area(buttonShape);
        if (a.contains(e.getX(), e.getY()))
        {
            System.out.println("clicked");
            doClick();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        Area a = new Area(buttonShape);
        if (a.contains(e.getX(), e.getY()))
        {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else
        {
            setCursor(Cursor.getDefaultCursor());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {

    }
}