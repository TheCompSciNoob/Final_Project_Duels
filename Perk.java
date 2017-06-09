public abstract class Perk
{
  protected long lastUpdateTime, updateInterval;
  protected GenericPlayer player;
  
  public Perk(GenericPlayer user)
  {
    player = user;
    setPlayerStats();
    lastUpdateTime = System.nanoTime();
  }
  
  public abstract void updatePlayerState()
  {
    if (System.nanoTime() - lastUpdateTime >= updateInterval)
    {
      setPlayerStats();
      lastUpdateTime = System.nanoTime();
    }
  }
  
  public abstract void setPlayerStats();
  
  public abstract String getPerkName();
  
  public abstract String getDescription();
}