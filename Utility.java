import java.util.ArrayList;
public class Utility
{
    public static int truncate(int num, int min, int max)
    {
        return Math.max(Math.min(num, max), min);
    }

    public static int[] addToArray(int[] arr, int num)
    {
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = arr[i] + num;
        }
        return result;
    }

    public static boolean outOfScreen(int xLoc, int yLoc)
    {
        return xLoc < 0 || yLoc < 0 || xLoc > Constants.WINDOW_WIDTH || yLoc > Constants.WINDOW_HEIGHT;
    }

    public static ArrayList<GamePiece> defaultList()
    {
        ArrayList<GamePiece> entities = new ArrayList<GamePiece>();
        entities.add(new Cannoneer(0, 0, Constants.PLAYER_1));
        entities.add(new Cannoneer(Constants.WINDOW_WIDTH - Constants.TILE_WIDTH, Constants.WINDOW_HEIGHT - Constants.TILE_HEIGHT, Constants.PLAYER_2));
        entities.add(new Wall(100, 100, ""));
        return entities;
    }
}