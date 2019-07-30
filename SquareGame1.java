import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class SquareGame1 extends JPanel implements KeyListener,MouseListener
{
  Square s = new Square(100,100,100);
  Square t = new Square(400,400,100);
  

  Random random= new Random();
  
  Square[] pickups;
  
  int sPoints = 0;
  int tPoints = 0;
  int time = 0;
  int a = 10;
 
  int xClick = 100;
  int yClick = 100;
  
  int buttonX = 300;
  int buttonY = 200;
  int buttonW = 200;
  int buttonH = 50;

  public static void main(String[] args)
  {
    JFrame frame = new JFrame();
    frame.setSize(800,600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SquareGame1 panel = new SquareGame1();
    
    frame.add(panel);
    frame.setVisible(true);
    panel.gameloop();
  }
  
  public SquareGame1()
  {
    addKeyListener(this);
    setFocusable(true);
   
    //Place the pickups
    pickups = new Square[2];
    pickups[0] = new Square(300, 300, 50);
    pickups[1] = new Square(600, 500, 50);
    
    
    addMouseListener(this);
    setFocusable(true);

  }

  
 /* public void paintComponent(Graphics g)
  {
    
    // Draw the button
    g.fillRect(buttonX, buttonY, buttonW, buttonH);
  }
  */
  public void mousePressed(MouseEvent e)
  { 
  }
  public void mouseReleased(MouseEvent e)
  { 
  }
  public void mouseClicked(MouseEvent e)
  {
    xClick = e.getX();
    yClick = e.getY();
    
    // Example of checking for a button press
    if(xClick > buttonX  &&
       xClick < (buttonX + buttonW) &&
       yClick > buttonY &
       yClick < buttonY + buttonH )//&& a == 1)
    {
   // System.out.println("sdf");
      repaint();
      gameloop();
    }
  
    //repaint();
  }
  public void mouseExited(MouseEvent e)
  {
  }
  public void mouseEntered(MouseEvent e)
  { 
  }

  
  public void paintComponent(Graphics g)
  {
    
    super.paintComponent(g);
    
    // Draw the players
    s.drawTo(g);
    t.drawTo(g);
    
    // Draw all of the pickups
    for(int i=0; i<pickups.length; i++)
    {
      pickups[i].drawTo(g);
    }
    
    g.drawString("Player 1 Score: " + sPoints, 20, 50);
    g.drawString("Player 2 Score: " + tPoints, 20, 80);
    
    g.drawString("" + a ,200,50);
  
  

  if (sPoints + tPoints >= 1 && a >0)
{ g.drawString("Congratulations!",700,200);
// g.drawRect(buttonX, buttonY, buttonW, buttonH);
 // g.drawString("Continue",875,225);
}
  //g.drawRect(buttonX, buttonY, buttonW, buttonH);
  else if(a == 0)
  {
  g.drawRect(buttonX, buttonY, buttonW, buttonH);
  g.drawString("Start again...",875,225);
 //g.drawString("Congratulations!",700,200);

  }

  }
  
  
  
  

  
  
  
  
  
  
  
  
  public void keyPressed(KeyEvent e)
  {
    int code = e.getKeyCode();
    if(code == KeyEvent.VK_RIGHT)
    {
      t.moveRight();
    }
    else if(code == KeyEvent.VK_LEFT)
    {
      t.moveLeft();
    }
    else if(code == KeyEvent.VK_UP)
    {
      t.moveUp();
    }
    else if(code == KeyEvent.VK_DOWN)
    {
      t.moveDown();
    }
   /* else if(code == KeyEvent.VK_A)
    {
      s.moveLeft();
    }
    else if(code == KeyEvent.VK_D)
    {
      s.moveRight();
    }
    else if(code == KeyEvent.VK_W)
    {
      s.moveUp();
    }
    else if(code == KeyEvent.VK_S)
    {
      s.moveDown();
    }
    else if(code == KeyEvent.VK_SPACE)
    {
      s.color = c1;
      if (code == KeyEvent.VK_SPACE)
      {s.color = c2;}
      
      
    }
    /*
    if(s.colliding(t))
    {
      t.color = Color.BLACK;
    }
    */
    
    for(int i=0; i<pickups.length; i++)
    {
      if(s.colliding(pickups[i])&& pickups[i].alive)
      {
        sPoints++;
      pickups[i]= new Square(random.nextInt(800),random.nextInt(600),30 + random.nextInt(15));
     
        
        
      }
      else if(t.colliding(pickups[i])&& pickups[i].alive)       //pick up part
      {
       tPoints++;
        pickups[i]= new Square(random.nextInt(800),random.nextInt(600),30 + random.nextInt(15));
        
        
      }
    }
    
    repaint();
  }
  
  public void keyReleased(KeyEvent e)
  {
  int code = e.getKeyCode();

   if(code == KeyEvent.VK_A)
    {
      s.moveLeft2();
    }
    else if(code == KeyEvent.VK_D)
    {
      s.moveRight2();
    }
    else if(code == KeyEvent.VK_W)
    {
      s.moveUp2();
    }
    else if(code == KeyEvent.VK_S)
    {
      s.moveDown2();
    }

  }
  
  public void keyTyped(KeyEvent e)
  {
  }
  
  
  
  //////////////////////////////////////////////////////////////////////////////////
  public void gameloop()
  {
  repaint();
  //System.out.println("jhgajgjasd");
  for(a = 5; a >= 0 ; a = a - 1)
  {System.out.println(a);
   repaint();

      if (sPoints + tPoints >= 1 || a == 0)
      {
      break;}
       // repaint(); // redraw the screen
        
        // This is one way to make the program wait in between frames
        // There is a better way so don't get too attached
       /* try
        {
          Thread.sleep(2); // wait 1000 milliseconds = 1 second
        }
        catch(Exception e){}
        */
      else{ //repaint(); 
        try
        {
          Thread.sleep(1000); // wait 1000 milliseconds = 1 second
        }
        catch(Exception e){} }

  }
}


/////////////////////////////////////////////////////////////////////////////


class Square
{
  int x;
  int y;
  int width;
  int height;
  Color color;
  
  
  boolean alive=true;
  
  int speed = 10;
  int speed2 = 30 ;// number of pixels to move each time
  
  // Constructor
  public Square(int x, int y, int size)
  {
    this.x = x;
    this.y = y;
    width = size; // We can use size as both width and height
    height = size;
    color = Color.BLACK;
  }
  // This method describes how to draw the square
  // on the screen
  // The name of this method is nothing special
  public void drawTo(Graphics g)
  {
  if(alive)
  {
    g.setColor(color);
    g.fillRect(x,y,width,height);
    }
  }
  
  public void moveRight()
  {
    x = x + speed;
  }
  
  public void moveLeft()
  {
    x = x - speed;
  }
  
  public void moveUp()
  {
    y = y - speed;
  }
  
  public void moveDown()
  {
    y = y + speed;
  }
  
  
  
  public void moveRight2()
  {
    x = x + speed2;
  }
  
  public void moveLeft2()
  {
    x = x - speed2;
  }
  
  public void moveUp2()
  {
    y = y - speed2;
  }
  
  public void moveDown2()
  {
    y = y + speed2;
  }

  
  // Return true iff the two squares are colliding
  public boolean colliding(Square other)
  {
    return (other.x < x + width &&
            x       < other.x + other.width &&
            other.y < y + height &&
            y       < other.y + other.height);
  }
  
  
  
  
  public void grow(int amount)
  {
  
  width +=amount;
  height +=amount;
  
  
  }
  

}}