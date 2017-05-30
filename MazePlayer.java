import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Rectangle;
public class MazePlayer extends GamePiece implements Player
{
    private int health, recovery, attack;
    private int playerNum, xIncrement, yIncrement, direction, xSpeed, ySpeed, frameIndex; //right and left index represents direction of frames
    private String[] frames;
    private Color playerColor;
    private int[] playerControls;
    private static String[] leftFrames = {"L1.png", "L2.png", "L3.png", "L4.png"}, rightFrames = {"R1.png", "R2.png", "R3.png", "R4.png"};

    public MazePlayer(int xStart, int yStart, int player, String imageName)
    {
        super(rightFrames[0]);
        frames = rightFrames;
        setCollision(true);
        playerNum = Utility.truncate(player, Constants.PLAYER_1, Constants.PLAYER_2);
        if (playerNum == 1)
        {
            playerControls = Constants.player1Controls;
            direction = Constants.SOUTH;
        }
        if (playerNum == 2)
        {
            playerControls = Constants.player2Controls;
            direction = Constants.NORTH;
        }
        xLoc = xStart;
        yLoc = yStart;
        bounds.add(new Rectangle(xStart, yStart, Constants.TILE_WIDTH - 2, Constants.TILE_HEIGHT - 2));
    }

    @Override
    public void respondToKeyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if (keyCode == playerControls[0])
        {
            direction = Constants.NORTH;
            up();
            frameIndex = 0;
        }
        if (keyCode == playerControls[1])
        {
            direction = Constants.SOUTH;
            down();
            frameIndex = 0;
        }
        if (keyCode == playerControls[2])
        {
            direction = Constants.WEST;
            left();
            //frames
            if (frames != leftFrames)
            {
                frameIndex = 0;
            }
            frames = leftFrames;
        }
        if (keyCode == playerControls[3])
        {
            direction = Constants.EAST;
            right();
            //frames
            if (frames != rightFrames)
            {
                frameIndex = 0;
            }
            frames = rightFrames;
        }
    }

    @Override
    public void respondToKeyReleased(KeyEvent e)
    {
        int k = e.getKeyCode();
        if (k == playerControls[0] || k == playerControls[1] || k == playerControls[2] || k == playerControls[3])
        {
            super.setImage(frames[0]);
            reset();
        }
    }

    public void updateGameState(ArrayList<GamePiece> entities)
    {
        if (!collideAfterMovement(xIncrement, yIncrement, entities))
        {
            xLoc += xIncrement;
            yLoc += yIncrement;
            updateBoundingBox(xIncrement, yIncrement);
            if (xIncrement != 0)
            {
                super.setImage(frames[frameIndex]);
                frameIndex = (frameIndex + 1) % frames.length;
            }
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

    @Override
    public void setSpeed(int xVelv, int yVelv)
    {
        xSpeed = xVelv;
        ySpeed = yVelv;
    }

    public int getDirection()
    {
        return direction;
    }

    @Override
    public void addHealth(int add)
    {
        health += add;
    }

    public int getHealth()
    {
        return health;
    }

    @Override
    public void addAttack(int add)
    {
        attack += add;
    }

    @Override
    public int getAttack()
    {
        return attack;
    }

    @Override
    public void addRecovery(int add)
    {
        recovery += add;
    }

    @Override
    public int getRecovery()
    {
        return recovery;
    }

    public int getPlayerNum()
    {
        return playerNum;
    }
    
    public String getName()
    {
        return "Player";
    }
    
    public int getMaxHealth()
    {
        return 100;
    }
}