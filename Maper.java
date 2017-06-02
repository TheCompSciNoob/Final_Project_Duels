/*THINGS TO FIX
1) THERE ARE PROBLEMS WITH THE VARIABLE curcolMap AND currowMap
 */
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
        for (int row=0;row<map.length;row++)
        {
            for (int col=0;col<map[row].length;col++)
            {

                if((int)(Math.random()*15)==1)
                {
                    map[row][col].setType(3);
                }

            }
        }
        for (int row=1;row<map.length;row+=2)
        {
            for (int col=1;col<map[row].length;col+=2)
            {

                map[row][col].setType(0);

            }
        }
        map[5][0].setType(0);
        map[5][1].setType(0);
        if((int)(Math.random()*2)==1)
        {
            map[1][1].setType(5);

        }
        else
        {
            map[13][9].setType(5);
        }
    }

    public void genMap()
    {
        int currowMap=0;
        int curcolMap=5;
        int count;
        for (int row=0;row<bluPrnt.length;row++)
        {
            for (int col=0;col<bluPrnt[row].length;col++)
            {

                bluPrnt[row][col]=new Brick();

            }
        }
        bluPrnt[currowMap/2][curcolMap/2].setNumber(counter);
        while (isThereMore()==true)
        {
            currowMap=findBrickRow(counter)*2+1;//this is of the array map
            curcolMap=findBrickCol(counter)*2+1;
            detectDrctnOpts(currowMap,curcolMap);
            if(dcounter>-1)
            {
                int direction=(int)(Math.random())*(dcounter+1);
                counter+=1;
                if (up==direction)
                {
                    map[currowMap-1][curcolMap].setType(0);
                    bluPrnt[currowMap/2-1][curcolMap/2].setNumber(counter);
                }
                if (down==direction)
                {
                    map[currowMap+1][curcolMap].setType(0);
                    bluPrnt[currowMap/2+1][curcolMap/2].setNumber(counter);

                }
                if (left==direction)
                {
                    map[currowMap][curcolMap-1].setType(0);
                    bluPrnt[currowMap/2][curcolMap/2-1].setNumber(counter);
                }
                if (right==direction)
                {
                    map[currowMap][curcolMap+1].setType(0);
                    bluPrnt[currowMap/2][curcolMap/2+1].setNumber(counter);
                }
            }
            if(dcounter==-1)
            {
                bluPrnt[currowMap/2][curcolMap/2].setNumber(-1);
                counter-=1;
                //Make the Backtracker
            }

        }
        setKoin(8);
    }

    public boolean isThereMore()
    {
        for (int row=0;row<bluPrnt.length;row++)
        {
            for (int col=0;col<bluPrnt[row].length;col++)
            {
                if(bluPrnt[row][col].getVisited()==false)
                {
                    return true;
                }
            }

        }
        return false;
        //this detects whether there is more unfilled blockes in the whole array
    }

    public int findBrickRow(int i)
    {
        for (int row=0;row<bluPrnt.length;row++)
        {
            for (int col=0;col<bluPrnt[row].length;col++)
            {
                if(bluPrnt[row][col].getNumber()==i)
                {
                    return row;
                }
            }

        }
        return -1;
    }

    public int findBrickCol(int i)
    {
        for (int row=0;row<bluPrnt.length;row++)
        {
            for (int col=0;col<bluPrnt[row].length;col++)
            {
                if(bluPrnt[row][col].getNumber()==i)
                {
                    return col;
                }
            }

        }
        return -1;
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
        if (row<=1)
        {
            upb=false;
        }
        if (row>=13)
        {
            downb=false;
        }
        if (col>=8)
        {
            rightb=false;
        }
        if (col<=1)
        {
            leftb=false;
        }
        if(rightb==true && bluPrnt[row/2][col/2+1].getVisited()==false)
        {
            dcounter+=1;
            right=dcounter;
        }
        if(leftb==true && bluPrnt[row/2][col/2-1].getVisited()==false)
        {
            dcounter+=1;
            left=dcounter;
        }
        if(upb==true && bluPrnt[row/2-1][col/2].getVisited()==false)
        {
            dcounter+=1;
            up=dcounter;
        }
        if(downb==true && bluPrnt[row/2+1][col/2].getVisited()==false)
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

    public void setKoin(int num)
    {
        while(num>0)
            for (int row=0;row<map.length;row++)
            {
                for (int col=0;col<map[row].length;col++)
                {
                    if(map[row][col].getType()==0 && (int)(Math.random()*6)==1)
                    {
                        map[row][col].setItem(1);
                        num--;
                    }
                }
            }
    }

    public ArrayList<GamePiece> convertToGamePiece()
    {
        ArrayList<GamePiece> x = new ArrayList<GamePiece>();
        for (int col = 0;col < map[0].length; col++)
        {
            for (int row = 0;row < map.length; row++)
            {
                Tile tile = map[row][col];
                if (tile.getType() == 1)
                {
                    x.add(new Wall(row*64,col*64,"Wall1.png"));
                }
                else if(tile.getType()==2)
                {
                    x.add(new Wall(row*64,col*64,"Wall2.png") );
                }
                else if(tile.getType()==3)
                {
                    x.add(new Pit(row*64,col*64,"Pit.png") );
                }
                else if(tile.getType()==5)
                {
                    x.add(new Portal(row*64,col*64,"Portal.png") );
                }
            }
        }
        for (int col=0;col<map[0].length;col++)
        {
            for (int row=0;row<map.length;row++)
            {
                //Add tobokens
                if (map[row][col].getItem() == 1)
                {
                    x.add(new Token(row*64,col*64,"Token.png"));
                }
            }
        }
        return x;
    }
}
