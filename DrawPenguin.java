import java.awt.*;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.util.Random;

public class DrawPenguin
{
   public static void main(String[] args)
   {
      int n, rX, rY, rType, randomize, printing, move;
      String message1 = "Would you like to draw random penguins at random locations? (Choose NO if you want to draw them manually)";
      String title1 = "Random option";
      String message2 = "Do you need information about penguins?";
      String title2 = "Printing option";
      String message3 = "Would you like to redraw some penguin?";
      String title3 = "Redrawing option";
      String info = "";
      String choice;
      
      boolean contin = true;
            
      JPanel myPanel = new JPanel(new GridLayout(0,1));
      
      JTextField nameField = new JTextField(10 );
      JTextField xField = new JTextField(10);
      JTextField yField = new JTextField(10);
      JTextField typeField = new JTextField(10);
      
      myPanel.add(new JLabel("Choose a name: "));
      myPanel.add(nameField);
      myPanel.add(new JLabel("Enter x coordinate: "));
      myPanel.add(xField);
      myPanel.add(new JLabel("Enter y coordinate: "));
      myPanel.add(yField);
      myPanel.add(new JLabel("Choose a penguin's type (1 - Regular, 2 - Zombie, 3 - Patriot, 4 - Funky, 5 - Invisible): "));
      myPanel.add(typeField);
      
      n = Integer.parseInt(JOptionPane.showInputDialog(null, "How many penguins would you like to draw? "));   
      Penguin[] myArray = new Penguin[n];

      randomize = JOptionPane.showConfirmDialog(null, message1, title1, JOptionPane.YES_NO_OPTION);
      if (randomize == JOptionPane.YES_OPTION)
      {
         for (int i = 0; i < n; i++)
         {
            Random rand = new Random();
            rX = rand.nextInt(700);
            rY = rand.nextInt(600);
            rType = rand.nextInt(5);
            myArray[i] = new Penguin("Random Penguin", rX, rY, rType);
         }
      }
         else
         {
            for (int i = 0; i < n; i++)
            {
               JOptionPane.showMessageDialog(null, myPanel);
               myArray[i] = new Penguin(nameField.getText(), Integer.parseInt(xField.getText()), Integer.parseInt(yField.getText()), Integer.parseInt(typeField.getText()));
            }
         }
 
      GraphicsFrame gf = new GraphicsFrame();
      for (int i = 0; i < n; i++)
      {
         gf.add(myArray[i]);  
      }
      
      printing = JOptionPane.showConfirmDialog(null, message2, title2, JOptionPane.YES_NO_OPTION);
      if (printing == JOptionPane.YES_OPTION)
      {
         for (int i = 0; i < n; i++)
         {
            info += "Position in array: " + i  + "\n" + myArray[i].getInfo() + "\n";
         }
            
            JTextArea textArea = new JTextArea(10, 30);
            textArea.setText("There are " + n + "penguins exist." + "\n\n" + info);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(null, scrollPane);
          
            while (contin)
            {
               move = JOptionPane.showConfirmDialog(null, message3, title3, JOptionPane.YES_NO_OPTION);
               if (move == JOptionPane.YES_OPTION)
               {
                  int j = Integer.parseInt(JOptionPane.showInputDialog(null, "Which penguin would you like to move? (Enter an integer number from 0 to " + (n - 1) + ")")); 
                  while (j < 0 || j >= n)
                  {
                     j = Integer.parseInt(JOptionPane.showInputDialog(null, "Which penguin would you like to move? (Enter an integer number from 0 to " + (n - 1) + ")")); 
                  }
                  int nX = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter new x-coordinate: "));
                  int nY = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter new y-coordinate: "));
                  myArray[j].move(nX, nY);
                  gf.add(myArray[j]); 
               }
               choice = JOptionPane.showInputDialog(null, "Continue? y - YES, anything else - NO");
               if (!(choice.equals("y")))
               {
                  contin = false;
               }
            }
      }
   }
}