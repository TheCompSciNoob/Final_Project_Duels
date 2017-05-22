public class DamageAreaEffect extends Obstacle
{
  private int damage;
  
  public DamageAreaEffect(Rectangle bound, int damage)
  {
    bounds.add(bound);
    this.damage = damage;
  }
  
  public void updateGameState(ActionEvent e)
  {
    
  }
  
  public void doPlayerEffect(Player p)
  {
    p.addHealth(-damage);
  }
}