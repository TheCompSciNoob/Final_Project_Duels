import java.util.ArrayList;
public class Maper
{
    Tile[][] map;
    Brick[][] bluPrnt=new Brick [7][5];
    int up=-1;
    int down=-1;
    int left=-1;
    int right=-1;
    boolean upb=true;// can visit this area
    boolean downb=true;
    boolean leftb=true;
    boolean rightb=true;
    int dcounter;
    int counter =0;
    public Maper()
    {
        map=new Tile[15][11];
        
        for (int row=0;row<map.length;row++)
        {
            for (int col=0;col<map[row].length;col++)
            {

                map[row][col]=new Tile((int)(1+(Math.random()*2.)),0,0);

            }
        }
        map[5][0].setType(0);
    }
    
    public void genMap()
    {
        int currow=0;
        int curcol=5;
        int count;
        for (int row=0;row<bluPrnt.length;row++)
        {
            for (int col=0;col<bluPrnt[row].length;col++)
            {

                bluPrnt[row][col]=new Brick();

            }
        }
        
        while (isThereMore()==true)
        {
            
                detectDrctnOpts(currow/2,curcol/2);
                if(dcounter>-1)
                {
                    int direction=(int)(Math.random())*(dcounter+1);
                    if (up==direction)
                    {
                        map[currow-1][curcol].setType(0);
                    }
                    if (down==direction)
                    {
                        map[currow+1][curcol].setType(0);
                    }
                    if (left==direction)
                    {
                        map[currow][curcol-1].setType(0);
                    }
                    if (right==direction)
                    {
                        map[currow][curcol+1].setType(0);
                    }
                }
                if(dcounter==-1)
                {
                    bluPrnt[currow][curcol].setNumber(-1);
                    counter-=1;
                }
        }
        
    }
    public boolean isThereMore()
    {
        for (int row=0;row<bluPrnt.length;row++)
        {
            for (int col=0;col<bluPrnt[row].length;col++)
            {
                if(bluPrnt[row][col].getVisited()==false||bluPrnt[row+1][col].getVisited()==false||bluPrnt[row][col+1].getVisited()==false||bluPrnt[row-1][col].getVisited()==false||bluPrnt[row][col-1].getVisited()==false)
                {
                    return true;
                }
            }
    
        }
        return false;
        //this detects whether there is more unfilled blockes in the whole arra
    }
    public Brick findBrick(int i)
    {
        for (int row=0;row<bluPrnt.length;row++)
        {
            for (int col=0;col<bluPrnt[row].length;col++)
            {
                if(bluPrnt[row][col].getNumber()==i)
                {
                    return bluPrnt[row][col];
                }
            }
    
        }
        return bluPrnt[0][-1];
    }
    public void detectDrctnOpts(int row, int col)
    {
        up=-1;
        down=-1;
        left=-1;
        right=-1;
        upb=true;
        downb=true;
        leftb=true;
        rightb=true;
        dcounter=-1;
        if (row==0)
        {
            upb=false;
        }
        if (row==7)
        {
            downb=false;
        }
        if (col==14)
        {
            rightb=false;
        }
        if (col==0)
        {
            leftb=false;
        }
        if(rightb==true && bluPrnt[row][col+1].getVisited()==false)
        {
            dcounter+=1;
            right=dcounter;
        }
        if(leftb==true && bluPrnt[row][col-1].getVisited()==false)
        {
            dcounter+=1;
            left=dcounter;
        }
        if(upb==true && bluPrnt[row-1][col].getVisited()==false)
        {
            dcounter+=1;
            up=dcounter;
        }
        if(downb==true && bluPrnt[row+1][col].getVisited()==false)
        {
            dcounter+=1;
            down=dcounter;
        }
    }
    public void printMap()
    {
        for (int col=0;col<map[0].length;col++)
        {
            for (int row=0;row<map.length;row++)
            {
                System.out.print("("+map[row][col].getType()+","+map[row][col].getItem()+")");

            }
            System.out.println();
        }
    }   
    /*public static ArrayList<GamePiece> convertToGamePiece()
    
    {
        Arraylist<GamePiece> x= new Arraylist<GamePiece>();
        for (int col=0;col<map[0].length;col++)
        {
            for (int row=0;row<map.length;row++)
            {
                if (map.getType()=1)
                {
                    x.add(new Wall(col*65,row*65,"Wall1"));
                }
                else if(map.getType()=2)
                {
                    x.add(new Wall(col*65,row*65,"Pit") );
                }
                else if(map.getType()=3)
                {
                    x.add(new Pit(col*65,row*65,"Wall2") );
                }
                else if(map.getType()=5)
                {
                    x.add(new Portal(col*65,row*65,"Wall2") );
                }
            }
            
        }
        for (int col=0;col<map[0].length;col++)
        {
            for (int row=0;row<map.length;row++)
            {
                //Add tobokens
                if (map.getItem==1)
                {
                    x.add(new Token(col*65,row*65,"Token"));
                }
            }
        }
    }*/
}