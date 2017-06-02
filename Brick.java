public class Brick
{
    int number;
    boolean visited;
    
    public Brick()
    {
        number=-1;
        visited=false;
    }
    public void setNumber(int num)
    {
        number=num;
        visited=true;
    }
    public void removeNumber()
    {
        number=-1;
    }
    public boolean getVisited() 
    {
        return visited;
    }
    public int getNumber()
    {
        return number;
    }
}