public class Tank extends Perk
{
    @Override
    public void installDefaults(GenericPlayer thePlayer)
    {
        super.installDefaults(thePlayer);
        player.setMaxHealth(player.getMaxHealth() * 2);
        player.setHealth(player.getMaxHealth());
    }
    
    @Override
    public void updatePlayerStatus()
    {
        
    }
    
    @Override
    public String getPerkName()
    {
        return "Tank";
    }
    
    @Override
    public String getDescription()
    {
        return "Health * 2";
    }
}