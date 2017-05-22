public class Cannoneer extends GenericPlayer
{
  public Cannoneer(int xStart, int yStart, int player)
  {
    super(xStart, yStart, player);
  }
  
  @Override
  public void respondToKeyPressed(KeyEvent e)
  {
    super.respondToKeyPressed(e);
    int keyCode = e.getKeyCode();
  }
}