public class SelfDamage extends Perk
{
  private int damage;
  private double attackMultiplyer = 2.5;
  private boolean attackUpdated = false;
  
  public SelfDamage(GenericPlayer user)
  {
    super(user);
    damage = user.getMaxHealth() / 10;
    updateInterval = (long) 5e9;
  }
  
  @Override
  public void setPlayerStats()
  {
    if (!attackUpdated)
    {
      int currentAttack = player.getAttack();
      player.addAttack(-currentAttack + (int) (currentAttack * attackMultiplyer));
      attackUpdated = true;
    }
    player.addHealth(-damage);
  }
  
  @Override
  public String getPerkName()
  {
    return "Thirst for Blood - EX";
  }
  
  @Override
  public String getDescription()
  {
    return "Attack x 2.5; depletes 10% of total HP every 5 seconds";
  }
}