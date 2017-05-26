import java.awt.event.*;
public class Constants
{
    public static final int PLAYER_1 = 1, PLAYER_2 = 2, NORTH = 1001, EAST = 1002, SOUTH = 1003, WEST = 1004;
    public static final int[] player1Controls = {KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_C, KeyEvent.VK_V, KeyEvent.VK_B}, player2Controls = {KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD3};
    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
    public static final int PHASE_1 = 10001, PHASE_2 = 10002, PHASE_3 = 10003, PHASE_4 = 10004;
    public static final int WINDOW_WIDTH = 512, WINDOW_HEIGHT = 512;
}