import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
public class EditScreenManager extends JPanel
{
  private ArrayList<GamePiece> entities;
  private int playerNum;
  
  public EditScreenManager(int player, ArrayList<GamePiece> pieces)
  {
    entities = pieces;
    playerNum = player;
  }
  
  //TODO: changes contents of arraylist (in corresponding player) by clicking button
}