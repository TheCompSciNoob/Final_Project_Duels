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
}