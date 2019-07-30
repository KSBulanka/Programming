import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
public class Animation extends JPanel
{
  static int animationFrame = 0;// static shi,jing,tai,de,jiu,deng,yu,tong,yong,de,bu,hui,bian

  public static void main(String[] args)
  {
    JFrame frame = new JFrame();
    frame.setSize(800,600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// zai,ni,guan,bi,zhe,ge,jie,mian,hou,cheng,xu,ting,zhi,yun,xing
    Animation panel = new Animation();
    frame.add(panel);
    frame.setVisible(true);
    
    while(true) // infinite loop for now
    {
      // 4 frames of animation// you,4,ge,tu,xing
      for(animationFrame = 0; animationFrame < 4; animationFrame++)
      {
        frame.repaint(); // redraw the screen
        
        // This is one way to make the program wait in between frames
        // There is a better way so don't get too attached
        try
        {
          Thread.sleep(2); // wait 1000 milliseconds = 1 second
        }
        catch(Exception e){}//gu,ding,da,pei
      }
    }
  }
  
  // Fill this in with your own frames of animation!
  public void paintComponent(Graphics g)
  {
    if(animationFrame == 0)
    {
      g.fillRect(0,random.nextInt(550),200,100+random.nextInt(200));
    }
    else if(animationFrame == 1)
    {
      g.fillRect(200,random.nextInt(550),200,100+random.nextInt(200));
    }
    else if(animationFrame == 2)
    {
      g.fillRect(400,random.nextInt(550),200,100+random.nextInt(200));
    }
    else if(animationFrame == 3)
    {
      g.fillRect(600,random.nextInt(550),200,100+random.nextInt(200));
    }
     


  }
    }
    
