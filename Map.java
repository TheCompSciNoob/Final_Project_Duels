import java.util.ArrayList;
public class Map
{
    Tile[][] map;
    private  int mapType=(int)Math.random()*2;
    private int rowSpawn;
    private int colSpawn;
    public Map()
    {
        map=new Tile[14][9];//4&6 are the min sizes of a array 
        rowSpawn=0;
        colSpawn=map[0].length-1;
        for (int row=0;row<map.length;row++)
        {
            for (int col=0;col<map[row].length;col++)
            {
                map[row][col]=new Tile((int)(1+(Math.random()*2.)),0,0);
            }
        }
    }

    public void start()
    {
        int x= (map[0].length-1)*(map.length-1);
        while (x>5)
        {
            genMap();
            x/=12;
        }
        filBlok();
        setEnd();
        setKoin(map.length*map[0].length/8);
    }

    public void genMap()
    {

        for (int row=0;row<map.length;row++)
        {
            for (int col=map[0].length-1;col>=map[row].length;col--)
            {
                int i= (int)(Math.random()*2.0);
                if (i==3)
                {map[row][col].setType(i);}

            }
        }
        for (int row=0;row<map.length;row++)
        {
            for (int col=map[0].length-1;col>=map[row].length;col--)
            {
                int i= (int)(Math.random()*2.0);
                if (i==3)
                {map[row][col].setType(i);}

            }
        }
        map[rowSpawn][colSpawn].setType(0);

        for (int loop = 0; loop < 4; loop++) //edit by chi
        {
            for (int row=0;row<map.length;row++)
            {
                for (int col=map[0].length-1;col>=map[row].length-1;col--)
                {
                    int i= (int)(Math.random()*2.0);
                    if (i==0 && nearBlank(row,col)==true)
                    {
                        map[row][col].setType(i);

                    }

                }
            }
        }

        for (int col=map[0].length-1;col>=map[0].length-1;col--)
        {
            for (int row=0;row<map.length;row++)
            {
                int i= (int)(Math.random()*2.0);
                if (i==0 && nearBlank(row,col)==true)
                {
                    map[row][col].setType(i);

                }

            }
        }
        for (int row=0;row<map.length;row++)
        {
            for (int col=0;col<map[row].length-1;col++)
            {
                int i= (int)(Math.random()*2.0);
                if (i==0 && nearBlank(row,col)==true)
                {
                    map[row][col].setType(i);

                }

            }
        }
        for (int col=0;col<map[0].length;col++)
        {
            for (int row=0;row<map.length;row++)
            {
                int i= (int)(Math.random()*2.0);
                if (i==0 && nearBlank(row,col)==true)
                {
                    map[row][col].setType(i);

                }

            }
        }
        for (int row=0;row<map.length;row++)
        {
            for (int col=0;col<map[row].length;col++)
            {
                int i= (int)(Math.random()*2.0);
                if (i==0 && nearBlank(row,col)==true)
                {
                    map[row][col].setType(i);

                }

            }
        }
    }

    public void setEnd()
    {
        int mxROW=0;
        int mxCOL=0;
        int mxL=0;
        for (int row=0;row<map.length;row++)
        {
            for (int col=0;col<map[row].length;col++)
            {
                int l=Math.abs(row-rowSpawn)+Math.abs(col-colSpawn);
                if (map[row][col].getType()==0&&l>mxL)
                {
                    mxL=l;
                    mxROW=row;
                    mxCOL=col;
                }
            }
        }
        map[mxROW][mxCOL].setType(5);
    }

    public void setKoin(int num)
    {
        while(num>0)
            for (int row=0;row<map.length;row++)
            {
                for (int col=0;col<map[row].length;col++)
                {
                    if(map[row][col].getType() == 0 && (int)(Math.random()*8) == 1)
                    {
                        map[row][col].setItem(1);
                        num-=20;
                    }
                }
            }
    }

    public boolean nearBlank(int row, int col)
    {
        if ( row !=0 && map[row-1][col].getType()==0 ||
        col !=0 && map[row][col-1].getType()==0 ||
        col != map[0].length-1 && map[row][col+1].getType()==0 ||
        row != map.length-1 && map[row+1][col].getType()==0)
        {
            return true;
        }
        return false;
    }

    public void filBlok()
    {
        for (int row=0;row<map.length;row++)
        {
            for (int col=0;col<map[row].length;col++)
            {

                if ( row !=0 && col !=0 &&col != map[0].length-1 &&row!= map.length-1
                && map[row-1][col].getType()==0 &&
                map[row+1][col-1].getType()==0 &&
                map[row-1][col+1].getType()==0 &&
                map[row+1][col+1].getType()==0 &&
                row !=0 && map[row-1][col-1].getType()==0 &&
                col !=0 && map[row][col-1].getType()==0 &&
                col != map[0].length-1 && map[row][col+1].getType()==0 &&
                row != map.length-1 && map[row+1][col].getType()==0)
                {
                    map[row][col].setType(3);
                }

            }
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