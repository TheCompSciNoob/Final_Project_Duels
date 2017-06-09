public class Thief extends Perk
{
    @Override
    public void installDefaults(GenericPlayer thePlayer)
    {
        super.installDefaults(thePlayer);
        player.setSpeed(2, 2);
        player.setAttack((int) (player.getAttack() * 1.5));
    }
    
    @Override
    public void updatePlayerStatus()
    {
        
    }
    
    @Override
    public String getPerkName()
    {
        return "Thief";
    }
    
    @Override
    public String getDescription()
    {
        return "Speed * 2; Attack * 1.5";
    }
}