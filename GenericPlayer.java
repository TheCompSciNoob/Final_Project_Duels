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
    protected int attack, recovery, health, maxHealth, direction;
    private int xIncrement, yIncrement, xSpeed = 1, ySpeed = 1, playerNum;
    protected long time1 = System.nanoTime(), time2 = System.nanoTime(), time3 = System.nanoTime();
    protected long cd1, cd2, cd3;
    protected String[] frames;
    protected String playerID;
    protected int[] playerControls;
    protected boolean keyActive1, keyActive2, keyActive3;

    public GenericPlayer(int xStart, int yStart, int player, int maxHealth)
    {
        super();
        setCollision(true);
        this.maxHealth = maxHealth;
        health = maxHealth;
        player = Utility.truncate(player, Constants.PLAYER_1, Constants.PLAYER_2);
        playerNum = player;
        if (player == Constants.PLAYER_1)
        {
            playerControls = Constants.player1Controls;
            direction = Constants.SOUTH;
            playerID = "P1";
        }
        if (player == Constants.PLAYER_2)
        {
            playerControls = Constants.player2Controls;
            direction = Constants.NORTH;
            playerID = "P2";
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
        if (keyActive1 && System.nanoTime() - time1 >= cd1)
        {
            useActive1(entities);
            keyActive1 = false;
            time1 = System.nanoTime();
        }
        if (keyActive2 && System.nanoTime() - time2 >= cd2)
        {
            useActive2(entities);
            keyActive2 = false;
            time2 = System.nanoTime();
        }
        if (keyActive3 && System.nanoTime() - time3 >= cd3)
        {
            useActive3(entities);
            keyActive3 = false;
            time3 = System.nanoTime();
        }
        health += recovery;
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
        int stringWidth = g.getFontMetrics().stringWidth(playerID);
        int stringHeight = g.getFontMetrics().getHeight();
        Rectangle box = bounds.get(0);
        g.drawString(playerID, (int) (box.getMinX() + (box.getWidth() - stringWidth) / 2), (int) (box.getMinY() + (box.getHeight() - stringHeight) / 2));
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

    public boolean north()
    {
        return direction == Constants.NORTH;
    }

    public boolean south()
    {
        return direction == Constants.SOUTH;
    }

    public boolean east()
    {
        return direction == Constants.EAST;
    }

    public boolean west()
    {
        return direction == Constants.WEST;
    }
    
    public int getMaxHealth()
    {
        return maxHealth;
    }
    
    public int getPlayerNum()
    {
        return playerNum;
    }

    public abstract void useActive1(ArrayList<GamePiece> entities);

    public abstract void useActive2(ArrayList<GamePiece> entities);

    public abstract void useActive3(ArrayList<GamePiece> entities);
}