public class Trojan extends Perk
{
    private int baseAttack;
    private double maxMultiplyer = 5.0, minMultiplyer = 0.5;

    public void updatePlayerStatus()
    {
        double healthRatio = (double) player.getHealth() / player.getMaxHealth();
        double multiplyer = maxMultiplyer * (1.0 - healthRatio);
        player.setAttack((int) (baseAttack * Math.max(minMultiplyer, multiplyer)));
    }

    @Override
    public String getPerkName()
    {
        return "Trojan - EX";
    }

    @Override
    public String getDescription()
    {
        return "The lower the HP, the higher the attack, to the max x " + (float) maxMultiplyer;
    }

    @Override
    public void installDefaults(GenericPlayer thePlayer)
    {
        super.installDefaults(thePlayer);
        baseAttack = player.getAttack();
    }
}