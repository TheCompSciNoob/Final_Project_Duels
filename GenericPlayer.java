import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.Graphics2D;
public abstract class GenericPlayer extends GamePiece implements Player
{
    protected int attack, recovery, health;
    private int xIncrement, yIncrement, direction, xSpeed = 1, ySpeed = 1, frameIndex;
    protected String[] frames;
    protected int[] playerControls;
    protected boolean keyActive1, keyActive2, keyActive3;

    public GenericPlayer(int xStart, int yStart, int player)
    {
        super();
        setCollision(true);
        player = Utility.truncate(player, Constants.PLAYER_1, Constants.PLAYER_2);
        if (player == Constants.PLAYER_1)
        {
            playerControls = Constants.player1Controls;
            direction = Constants.SOUTH;
        }
        if (player == Constants.PLAYER_2)
        {
            playerControls = Constants.player2Controls;
            direction = Constants.NORTH;
        }
        xLoc = xStart;
        yLoc = yStart;
        bounds.add(new Rectangle(xStart, yStart, Constants.TILE_WIDTH, Constants.TILE_HEIGHT)); //exact
    }

    @Override
    public void respondToKeyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if (keyCode == playerControls[0])
        {
            direction = Constants.NORTH;
            up();
        }
        if (keyCode == playerControls[1])
        {
            direction = Constants.SOUTH;
            down();
        }
        if (keyCode == playerControls[2])
        {
            direction = Constants.WEST;
            left();
        }
        if (keyCode == playerControls[3])
        {
            direction = Constants.EAST;
            right();
        }
        if (keyCode == playerControls[4])
        {
            keyActive1 = true;
        }
        if (keyCode == playerControls[5])
        {
            keyActive2 = true;
        }
        if (keyCode == playerControls[6])
        {
            keyActive3 = true;
        }
    }

    @Override
    public void respondToKeyReleased(KeyEvent e)
    {
        int k = e.getKeyCode();
        if (k == playerControls[0] || k == playerControls[1] || k == playerControls[2] || k == playerControls[3])
        {
            reset();
        }
    }

    @Override
    public void updateGameState(ArrayList<GamePiece> entities)
    {
        if (!collideAfterMovement(xIncrement, yIncrement, entities))
        {
            xLoc += xIncrement;
            yLoc += yIncrement;
            updateBoundingBox(xIncrement, yIncrement);
        }
        if (keyActive1)
        {
            useActive1(entities);
        }
        if (keyActive2)
        {
            useActive2(entities);
        }
        if (keyActive3)
        {
            useActive3(entities);
        }
    }
    
    @Override
    public void setSpeed(int xVelv, int yVelv)
    {
        xSpeed = xVelv;
        ySpeed = yVelv;
    }

    @Override
    public void draw(Graphics g)
    {
        //g.drawImage(image, xLoc, yLoc, null);
        g.setColor(Color.WHITE);
        for (Rectangle b : bounds)
        {
            ((Graphics2D) g).draw(b);
        }
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

    public abstract void useActive1(ArrayList<GamePiece> entities);

    public abstract void useActive2(ArrayList<GamePiece> entities);

    public abstract void useActive3(ArrayList<GamePiece> entities);
}