import java.awt.*;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Random;

public class Penguin implements Drawable
{
   //fields
   private String name;
   private int type;
   private int x, y;
   private BufferedImage image; 
   Color myColor = new Color (0, 102, 102);
    
   //constructors
   public Penguin(String n, int px, int py, int t) 
   {
      type = t;
      name = n;
      x = px;
      y = py;
   }
   
   public String getInfo()
   {
      return "Name: " + name + "\nType: " + type + "\nCoordinates: x - " + x + ", y - " + y + "\n";
   }
   
   public void draw(Graphics g)
   {
       if (type != 5) //if not invisible
       {
         Random rand;
         float red;
         float green;
         float blue;
         
         if (type == 4) //if funky
            {
            rand = new Random();
            red = rand.nextFloat();
            green = rand.nextFloat();
            blue = rand.nextFloat();
            Color randColor = new Color(red, green, blue);
            g.setColor(randColor);
            }
            else
               {
                  g.setColor(Color.ORANGE);
               }
         
         Polygon myPolygon3 = new Polygon(); //left foot
         myPolygon3.addPoint(x + 2, y + 140);
         myPolygon3.addPoint(x - 5, y + 145);
         myPolygon3.addPoint(x - 8, y + 152);
         myPolygon3.addPoint(x - 10, y + 155);
         myPolygon3.addPoint(x, y + 150);
         myPolygon3.addPoint(x - 7, y + 163);
         myPolygon3.addPoint(x + 5, y + 153);
         myPolygon3.addPoint(x, y + 165);
         myPolygon3.addPoint(x + 10, y + 155);
         myPolygon3.addPoint(x + 12, y + 150);
         myPolygon3.addPoint(x + 15, y + 145);
         g.fillPolygon(myPolygon3);
         
         if (type == 4) //if funky
            {
            rand = new Random();
            red = rand.nextFloat();
            green = rand.nextFloat();
            blue = rand.nextFloat();
            Color randColor = new Color(red, green, blue);
            g.setColor(randColor);
            }
            else
               {
                  g.setColor(Color.ORANGE);
               }
               
         Polygon myPolygon6 = new Polygon(); //right foot
         myPolygon6.addPoint(x + 55, y + 140);
         myPolygon6.addPoint(x + 60, y + 143);
         myPolygon6.addPoint(x + 65, y + 146);
         myPolygon6.addPoint(x + 72, y + 153);
         myPolygon6.addPoint(x +62, y + 151);
         myPolygon6.addPoint(x + 68, y + 162);
         myPolygon6.addPoint(x + 58, y + 155);
         myPolygon6.addPoint(x + 60, y + 165);
         myPolygon6.addPoint(x + 52, y + 155);
         myPolygon6.addPoint(x + 45, y + 145);
         myPolygon6.addPoint(x + 50, y + 140);
         g.fillPolygon(myPolygon6);
            
         if (type != 4) //if not funky
         {
            g.setColor(Color.BLACK);
         }
         g.fillOval(x - 15, y + 43, 87, 110); //filled body
         
         if (type != 4) //if not funky
         {
            g.setColor(Color.WHITE);
         }
         g.fillOval(x - 9, y +50, 75, 95 ); //body
   
          if (type == 3) //if patriot
         { 
            g.setColor(myColor); 
         }
            else if (type == 4) //if funky
            {
               rand = new Random();
               red = rand.nextFloat();
               green = rand.nextFloat();
               blue = rand.nextFloat();
               Color randColor = new Color(red, green, blue);
               g.setColor(randColor);
            }
               else
                  { 
                     g.setColor(Color.BLACK); 
                  }
                  
         g.fillOval(x - 5, y - 5, 70, 70 ); //head colored
         
         if (type != 4) //if not funky
         {
            g.setColor(Color.WHITE);
         }
         g.fillOval(x, y, 60, 60 ); //head
         
         if (type == 3) //if patriot
         { 
            g.setColor(myColor); 
         }
            else if (type == 4) //if funky
            {
               rand = new Random();
               red = rand.nextFloat();
               green = rand.nextFloat();
               blue = rand.nextFloat();
               Color randColor = new Color(red, green, blue);
               g.setColor(randColor);
            }
               else
                  { 
                     g.setColor(Color.BLACK); 
                  }      
         Polygon myPolygon4 = new Polygon(); //head mask
         myPolygon4.addPoint(x, y + 20);
         myPolygon4.addPoint(x + 5, y +15);
         myPolygon4.addPoint(x + 10, y + 12);
         myPolygon4.addPoint(x + 15, y + 11);
         myPolygon4.addPoint(x + 20, y + 12);
         myPolygon4.addPoint(x + 23, y + 15);
         myPolygon4.addPoint(x + 27, y + 20);
         myPolygon4.addPoint(x + 30, y + 25);
         myPolygon4.addPoint(x + 33, y + 20);
         myPolygon4.addPoint(x + 36, y +15);
         myPolygon4.addPoint(x + 39, y + 12);
         myPolygon4.addPoint(x + 44, y + 11);
         myPolygon4.addPoint(x + 49, y + 12);
         myPolygon4.addPoint(x + 54, y + 15);
         myPolygon4.addPoint(x + 59, y + 20);
         myPolygon4.addPoint(x + 51, y + 5);
         myPolygon4.addPoint(x + 30, y - 2);
         myPolygon4.addPoint(x + 12, y + 2);
         g.fillPolygon(myPolygon4);
           
         if (type == 2) //if zombie
            {
               g.setColor(Color.RED);
            }
            else
            {
               g.setColor(Color.BLACK);
            }
               
         g.fillOval(x + 3, y + 23, 15,15); //left eye
         g.fillOval(x + 42, y + 23, 15,15); //right eye
         
          if (type == 2) //if zombie
            {
            g.setColor(Color.BLACK);
            }
            else
            {
            g.setColor(Color.WHITE);
            }  
               
         g.fillOval(x + 10, y + 26, 7, 7); //left eyeball
         g.fillOval(x + 48, y + 26, 7, 7); //right eyeball
         
         Polygon myPolygon5 = new Polygon(); //beak
         myPolygon5.addPoint(x + 24, y + 38);
         myPolygon5.addPoint(x + 30, y + 36);
         myPolygon5.addPoint(x + 35, y + 38);
         myPolygon5.addPoint(x + 33, y + 43);
         myPolygon5.addPoint(x + 29, y + 48);
         myPolygon5.addPoint(x + 26, y + 43);
         
         if (type == 2) //if zombie
            {
            g.setColor(Color.RED);
            }
            else
            {
            g.setColor(Color.ORANGE);
            }
         g.fillPolygon(myPolygon5);
     
              
         g.setColor(Color.BLACK);
         Polygon myPolygon1 = new Polygon(); //left wing
         myPolygon1.addPoint(x + 10, y + 50);
         myPolygon1.addPoint(x + 5, y + 55);
         myPolygon1.addPoint(x, y + 60);
         myPolygon1.addPoint(x - 5, y + 65);
         myPolygon1.addPoint(x - 10, y + 70);
         myPolygon1.addPoint(x - 15, y + 75);
         myPolygon1.addPoint(x - 20, y + 82);
         myPolygon1.addPoint(x - 25, y + 90);
         myPolygon1.addPoint(x - 30, y + 97);
         myPolygon1.addPoint(x - 35, y + 105);
         myPolygon1.addPoint(x - 37, y + 115);
         myPolygon1.addPoint(x - 35, y + 117);
         myPolygon1.addPoint(x - 30, y + 115);
         myPolygon1.addPoint(x - 25, y + 112);
         myPolygon1.addPoint(x - 20, y + 107);
          g.fillPolygon(myPolygon1);
         
         Polygon myPolygon2 = new Polygon(); //right wing
         myPolygon2.addPoint(x + 50, y + 50);
         myPolygon2.addPoint(x + 55, y + 55);
         myPolygon2.addPoint(x + 60, y + 58);
         myPolygon2.addPoint(x + 65, y + 63);
         myPolygon2.addPoint(x + 70, y + 68);
         myPolygon2.addPoint(x + 75, y + 72);
         myPolygon2.addPoint(x + 80, y + 77);
         myPolygon2.addPoint(x +85, y + 83);
         myPolygon2.addPoint(x +90, y + 92);
         myPolygon2.addPoint(x + 93, y + 100);
         myPolygon2.addPoint(x +94, y + 106);
         myPolygon2.addPoint(x + 93, y + 110);
         myPolygon2.addPoint(x + 90, y + 112);
         myPolygon2.addPoint(x + 85, y + 110);
         myPolygon2.addPoint(x + 80, y + 105);
         g.fillPolygon(myPolygon2);
       
         if (type == 3) //if patriot
         {
            try {                
                  image = ImageIO.read(new File(".\\CptnAmerica.jpg"));
                 }
            catch (IOException ex) 
                {
                  System.out.println(ex);
                }
            g.drawImage(image, x - 40, y + 63, null);
         }
                         
       }
    }
    
    public void move(int newX, int newY)
         {
            x = newX;
            y = newY;
         }

}