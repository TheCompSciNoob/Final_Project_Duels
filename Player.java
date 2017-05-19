import java.awt.event.*;
public interface Player
{
    void respondToKeyPressed(KeyEvent e);
    
    void respondToKeyReleased(KeyEvent e);
    
    void addHealth(int add);
    
    int getHealth();
    
    void addAttack(int add);
    
    int getAttack();
    
    void addRecovery(int add);
    
    int getRecovery();
    
    void setSpeed(int xSpeed, int ySpeed);
}