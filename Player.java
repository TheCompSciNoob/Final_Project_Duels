import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.util.ArrayList;
import javafx.geometry.BoundingBox;
public class Player extends GamePiece
{
    private int health, recovery, attack;
    private int xIncrement, yIncrement, direction, xSpeed, ySpeed, frameIndex; //right and left index represents direction of frames
    private boolean moving;
    private String[] frames;
    private Color playerColor;
    private int[] playerControls;
    private static final int[] xSetNorth = {GameIO.cWidth/2, 0, GameIO.cWidth}, xSetSouth = xSetNorth, xSetWest = {0, GameIO.cWidth, GameIO.cWidth}, xSetEast = {GameIO.cWidth, 0, 0};
    private static final int[] ySetNorth = {0, GameIO.cHeight, GameIO.cHeight}, ySetSouth = {GameIO.cHeight, 0, 0}, ySetWest = {GameIO.cHeight/2, 0, GameIO.cHeight}, ySetEast = ySetWest;
    private static String[] leftFrames = {"L1.png", "L2.png", "L3.png", "L4.png"}, rightFrames = {"R1.png", "R2.png", "R3.png", "R4.png"};

    public Player(int xStart, int yStart, int player, String imageName)
    {
        super(rightFrames[0]);
        frames = rightFrames;
        setCollision(true);
        player = Utility.truncate(player, Constants.PLAYER_1, Constants.PLAYER_2);
        if (player == 1)
        {
            playerControls = Constants.player1Controls;
            direction = Constants.SOUTH;
        }
        if (player == 2)
        {
            playerControls = Constants.player2Controls;
            direction = Constants.NORTH;
        }
        xLoc = xStart;
        yLoc = yStart;
        bounds.add(new BoundingBox(xStart, yStart, 64, 64));
    }

    public void respondToKeyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if (!moving)
        {
            if (keyCode == playerControls[0])
            {
                direction = Constants.NORTH;
                up();
                moving = true;
            }
            if (keyCode == playerControls[1])
            {
                direction = Constants.SOUTH;
                down();
                moving = true;
            }
            if (keyCode == playerControls[2])
            {
                direction = Constants.WEST;
                left();
                //frames
                moving = true;
                frames = leftFrames;
            }
            if (keyCode == playerControls[3])
            {
                direction = Constants.EAST;
                right();
                //frames
                moving = true;
                frames = rightFrames;
            }
        }
    }

    public void respondToKeyReleased(KeyEvent e)
    {
        reset();
    }

    public void updateGameState(ArrayList<GamePiece> entities)
    {
        if (!collideAfterMovement(xIncrement, yIncrement, entities))
        {
            xLoc += xIncrement;
            yLoc += yIncrement;
            updateBoundingBox(xIncrement, yIncrement);
        }
        if (direction != Constants.SOUTH && direction != Constants.NORTH && moving)
        {
            super.setImage(frames[frameIndex]);
        }
        frameIndex = (frameIndex + 1) % frames.length;
        if (frameIndex == 0)
        {
            moving = false;
        }
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.drawImage(image, xLoc, yLoc, null);
        /*
        int[] xLocs, yLocs;
        if (direction == NORTH)
        {
        xLocs = Utility.addToArray(xSetNorth, xLoc);
        yLocs = Utility.addToArray(ySetNorth, yLoc);
        }
        else if (direction == EAST)
        {
        xLocs = Utility.addToArray(xSetEast, xLoc);
        yLocs = Utility.addToArray(ySetEast, yLoc);
        }
        else if (direction == SOUTH)
        {
        xLocs = Utility.addToArray(xSetSouth, xLoc);
        yLocs = Utility.addToArray(ySetSouth, yLoc);
        }
        else
        {
        xLocs = Utility.addToArray(xSetWest, xLoc);
        yLocs = Utility.addToArray(ySetWest, yLoc);
        }
        g.fillPolygon(xLocs, yLocs, Math.min(xLocs.length, yLocs.length));
         */
    }

    public void up()
    {
        xIncrement = 0;
        yIncrement = -ySpeed;
    }

    public void down()
    {
        xIncrement = 0;
        yIncrement = ySpeed;
    }

    public void left()
    {
        xIncrement = -xSpeed;
        yIncrement = 0;
    }

    public void right()
    {
        xIncrement = xSpeed;
        yIncrement = 0;
    }

    public void reset()
    {
        xIncrement = 0;
        yIncrement = 0;
    }

    public void setSpeed(int xVelv, int yVelv)
    {
        xSpeed = xVelv;
        ySpeed = yVelv;
    }

    public int getDirection()
    {
        return direction;
    }

    public void addHealth(int add)
    {
        health += add;
    }

    public int getHealth()
    {
        return health;
    }
}