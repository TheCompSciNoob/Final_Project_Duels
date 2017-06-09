public abstract class Perk
{
    protected GenericPlayer player;

    public Perk()
    {
    }

    public abstract void updatePlayerStatus();

    public abstract String getPerkName();

    public abstract String getDescription();
    
    public void installDefaults(GenericPlayer thePlayer) //do mutating methods here
    {
        player = thePlayer;
    }
}