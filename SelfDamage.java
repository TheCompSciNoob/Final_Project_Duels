public class SelfDamage extends Perk
{
    private long lastUpdateTime, updateInterval = (long) 5e9;
    private int selfDamage;
    private double attackMultiplyer = 2.5;

    @Override
    public void updatePlayerStatus()
    {
        if (System.nanoTime() - lastUpdateTime >= updateInterval)
        {
            player.addHealth(-selfDamage);
            lastUpdateTime = System.nanoTime();
        }
    }

    @Override
    public String getPerkName()
    {
        return "Thirst for Blood";
    }

    @Override
    public String getDescription()
    {
        return "Attack x " + attackMultiplyer + "; depletes 10% of total HP every 5 seconds";
    }

    @Override
    public void installDefaults(GenericPlayer thePlayer)
    {
        super.installDefaults(thePlayer);
        lastUpdateTime = System.nanoTime();
        player.setAttack((int)(player.getAttack() * attackMultiplyer));
        selfDamage = player.getMaxHealth() / 10;
    }
}