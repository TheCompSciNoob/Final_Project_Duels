import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
public class EndScreenManager extends JPanel
{
  private ArrayList<GamePiece> entities;
  
  public EndScreenManager(ArrayList<GamePiece> pieces)
  {
    entities = pieces;
  }
  
  //TODO: figure out which player wins
  
  //TODO: play again button, redirects to a new main screen
}