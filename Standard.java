public class Standard extends Perk
{
    @Override
    public void installDefaults(GenericPlayer thePlayer)
    {
        super.installDefaults(thePlayer);
        player.addRecovery(player.getRecovery());
        player.addAttack(player.getAttack());
    }
    
    @Override
    public void updatePlayerStatus()
    {
        
    }
    
    @Override
    public String getPerkName()
    {
        return "Standard";
    }
    
    @Override
    public String getDescription()
    {
        return "Default perk for all players; Attack and Recovery x 2";
    }
}