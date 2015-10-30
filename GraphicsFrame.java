import javax.swing.*;
import java.awt.*;

public class GraphicsFrame
{
  private final int LIST_MAX = 500;
  private int endOfList;
  private Drawable[] drawList;
  
  private JFrame f;
  private DrawPanel drawPan;
  private Color backgroundColor;
  
  public GraphicsFrame()
  {
     endOfList = -1; // list empty
     drawList = new Drawable[ LIST_MAX ];
    
     f = new JFrame("Graphics Frame");
     drawPan = new DrawPanel();
    
     f.add( drawPan );
     backgroundColor = Color.WHITE;

     f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
     f.setSize(800,800);
     f.setVisible( true );
  }
  
  public void add( Drawable d )
  {
     if (endOfList + 1 < LIST_MAX)
     {
       endOfList++;    
       drawList[endOfList] = d;
     }
     else
     {
       System.out.println("Draw list full");
     }
      
    drawPan.repaint();
  }
  
  public void redraw()
  {
     drawPan.repaint();
  }
  
  public void setBackgroundColor( Color c )
  { backgroundColor = c; }
  
  
  private class DrawPanel extends JPanel
  {
    public void paintComponent( Graphics g )
    {
      super.paintComponent( g );
      
      setBackground( backgroundColor );
      
      for( int i=0; i <= endOfList; i++ )
      {
        drawList[ i ].draw( g );
      }
    }
  }
  
}