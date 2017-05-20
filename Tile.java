public class Tile
{
    //0-ground
    //1-wall
    //2-wall2
    //3-pit
    //4-button
    //5-portal
    int type;
    //0-none
    //1-coin
    int item;
    //0-none
    //1-player
    //2-weaker enemy
    //3-armored enemy
    int occupant;

    public Tile(int t, int i, int o)
    {
        type=t;
        item=i;
        occupant=0;
    }

    public int getType()
    {
        return type;
    }
    public void setType(int q)
    {
        type=q;
    }
    
    public void setItem(int i)
    {
        item=i;
    }
    public int getItem()
    {
        return item;
    }

    public int getOccupant()
    {
        return occupant;
    }
}