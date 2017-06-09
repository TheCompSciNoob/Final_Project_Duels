public class Trojan extends Perk
{
  private int baseAttack;
  private double maxMultiplyer = 4.0;
  
  public Trojan(GenericPlayer user)
  {
    super(user);
    baseAttack = user.getAttack(); //records attack when player first started
    updateInterval = 0;
  }
  
  @Override
  public void setPlayerStats()
  {
    double newMultiplyer =  maxMultiplyer * player.getHealth() / player.getMaxHealth();
    player.addAttack(-player.getAttack()); //sets to zero
    player.addAttack((int) (baseAttack * newMultiplyer)); //sets to new multiplyer
  }
  
  @Override
  public String getPerkName()
  {
    return "Trojan";
  }
  
  @Override
  public String getDescription()
  {
    return "The lower the HP, the higher the attack, to the max x " + maxMultiplyer;
  }
}