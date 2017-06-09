import java.awt.event.*;
public interface Player
{
    void respondToKeyPressed(KeyEvent e);

    void respondToKeyReleased(KeyEvent e);

    //Health
    void addHealth(int add);

    void setHealth(int set);

    int getHealth();

    //Attack
    void addAttack(int add);

    void setAttack(int set);

    int getAttack();

    //Recovery
    void addRecovery(int add);

    void setRecovery(int set);

    int getRecovery();

    void setSpeed(int xSpeed, int ySpeed);

    int getMaxHealth();

    int getPlayerNum();

    String getDescription();
}