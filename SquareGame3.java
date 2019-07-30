//note:change color when
//     space,get score,

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class SquareGame3 extends JPanel implements KeyListener
{  

//SMOOTH BUFF ADDED PART1
  public static final int FPS = 40;
  public static final int TIME_BETWEEN_FRAMES = 1000/FPS;
  

  
//
//  
  boolean up = false;
  boolean down = false;
  boolean left = false;
  boolean right = false;
  boolean up2 = false;
  boolean down2 = false;
  boolean left2 = false;
  boolean right2 = false;

  


  Square s = new Square(100,100,100);
  Square t = new Square(400,400,100);
  Random random= new Random();
  
  Square[] pickups;
  
  int sPoints = 0;
  int tPoints = 0;
  public static void main(String[] args)
  {
    JFrame frame = new JFrame();
    frame.setSize(800,600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SquareGame2 panel = new SquareGame2();
    frame.add(panel);
    frame.setVisible(true);
    
    
    panel.gameLoop(); } 
  

  
  public void gameLoop()
  {
    long nextFrame = System.currentTimeMillis();
    while(true)
    {
      while(System.currentTimeMillis() > nextFrame)
      {
        stepGame();
        nextFrame = nextFrame + TIME_BETWEEN_FRAMES;
      }
      repaint();
    }
  }

  
  
  
  
  

  
  public SquareGame3()
  {
    addKeyListener(this);
    setFocusable(true);
    
    // Place the pickups
    pickups = new Square[2];
    pickups[0] = new Square(300, 300, 50);
    pickups[1] = new Square(600, 500, 50);
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
  }
 

  
  
  
  
   /*
 //  
//   public void Tongguan(Graphics g)
//   {
//   if (tPoints + sPoints == 30)
//  { 
//  
//       g.drawString("Congratulations!!!", 20,120);}
//   }
//   
   
  */

  
  
  
  
  
  
  
  
  
  
  
  
  
  // public void keyPressed1(KeyEvent e)
//   {
//     int code = e.getKeyCode();
//     if(code == KeyEvent.VK_RIGHT)
//     {
//       t.moveRight();
//     }
//     else if(code == KeyEvent.VK_LEFT)
//     {
//       t.moveLeft();
//     }
//     else if(code == KeyEvent.VK_UP)
//     {
//       t.moveUp();
//     }
//     else if(code == KeyEvent.VK_DOWN)
//     {
//       t.moveDown();
//     }
//     else if(code == KeyEvent.VK_A)
//     {
//       s.moveLeft();
//     }
//     else if(code == KeyEvent.VK_D)
//     {
//       s.moveRight();
//     }
//     else if(code == KeyEvent.VK_W)
//     {
//       s.moveUp();
//     }
//     else if(code == KeyEvent.VK_S)
//     {
//       s.moveDown();
//     }
//     else if(code == KeyEvent.VK_SPACE)
//     {
//       s.color = Color.BLACK;
//     }
//     
//     if(s.colliding(t))
//     {
//       t.color = Color.BLACK;
//     }
    



//     for(int i=0; i<pickups.length; i++)
//     {
//       if(s.colliding(pickups[i])&& pickups[i].alive)
//       {
//         sPoints++;
//       pickups[i]= new Square(random.nextInt(1000),random.nextInt(1000),random.nextInt(75));
//      
//         
//         
//       }
//       else if(t.colliding(pickups[i])&& pickups[i].alive)       //pick up part
//       {
//        tPoints++;
//         pickups[i]= new Square(random.nextInt(1000),random.nextInt(1000),random.nextInt(45));
//         
//         
//       }
//     }
//     
//     repaint();
//   }
  
    public void stepGame()
  {
    if(left)
    {
      s.moveLeft();
    }
    if(right)
    {
      s.moveRight();
     
    }
    if(down)
    {
      s.moveDown();
         }
    if(up)
    {
      s.moveUp();
    }
      if(left2)
    {
      t.moveLeft();
    }
    if(right2)
    {
      t.moveRight();
     
    }
    if(down2)
    {
      t.moveDown();
         }
    if(up2)
    {
      t.moveUp();

      
//     if(A)
//     {
//       t.moveLeft();
//     }
//     if(D)
//     {
//       t.moveRight();
//     }
//     if(S)
//     {
//       t.moveDown();
//     }
//     if(W)
//     {
//       t.moveUp();

    }
  }
  
  public void keyPressed(KeyEvent e)
  {
    int code = e.getKeyCode();
    if(code == KeyEvent.VK_A)
    {
      left = true;
    }
    else if(code == KeyEvent.VK_D)
    {
      right = true;
    }
    else if(code == KeyEvent.VK_W)
    {
      up = true;
    }
    else if(code == KeyEvent.VK_S)
    {
      down = true;
    }
    
    else if(code == KeyEvent.VK_LEFT)
    {
      left2 = true;
    }
    else if(code == KeyEvent.VK_RIGHT)
    {
      right2 = true;
    }
    else if(code == KeyEvent.VK_UP)
    {
      up2 = true;
    }
    else if(code == KeyEvent.VK_DOWN)
    {
      down2 = true;
    }

       for(int i=0; i<pickups.length; i++)
    {
      if(s.colliding(pickups[i])&& pickups[i].alive)
      {
        sPoints++;
      pickups[i]= new Square(random.nextInt(1000),random.nextInt(1000),random.nextInt(75));
     
        
        
      }
      else if(t.colliding(pickups[i])&& pickups[i].alive)       //pick up part
      {
       tPoints++;
        pickups[i]= new Square(random.nextInt(1000),random.nextInt(1000),random.nextInt(45));
        
        
      }
    }
    
    repaint();
  } 
   
    // 
//     
//     public void keyPressed(KeyEvent e)
//   {
//     int code = e.getKeyCode();
//     if(code == KeyEvent.VK_A)
//     {
//       left = true;
//     }
//     else if(code == KeyEvent.VK_D)
//     {
//       right = true;
//     }
//     else if(code == KeyEvent.VK_W)
//     {
//       up = true;
//     }
//     else if(code == KeyEvent.VK_S)
//     {
//       down = true;
//     }
//   }
//   
  public void keyReleased(KeyEvent e)
  {
    int code = e.getKeyCode();
    if(code == KeyEvent.VK_A)
    {
      left = false;
    }
    else if(code == KeyEvent.VK_D)
    {
      right = false;
    }
    else if(code == KeyEvent.VK_W)
    {
      up = false;
    }
    else if(code == KeyEvent.VK_S)
    {
      down = false;
    }
    if(code == KeyEvent.VK_LEFT)
    {
      left2 = false;
    }
    else if(code == KeyEvent.VK_RIGHT)
    {
      right2 = false;
    }
    else if(code == KeyEvent.VK_UP)
    {
      up2 = false;
    }
    else if(code == KeyEvent.VK_DOWN)
    {
      down2 = false;
    }

  }
  public void keyTyped(KeyEvent e){
  
  
  }
  }

class Square
{
  int x;
  int y;
  int width;
  int height;
  Color color;
  
  
  boolean alive=true;
  
  int speed = 15;
  } // Incontrol's buff:Speed Up
  
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
}





