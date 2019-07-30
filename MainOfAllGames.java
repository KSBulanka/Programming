import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class MainOfAllGames extends JPanel
{
public static void main(String[] args)
  {
    JFrame frame = new JFrame();
    frame.setSize(800,600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
//     SquareGame1 panel = new SquareGame1();
//     frame.add(panel);
//     frame.setVisible(true);
 //    panel.gameloop();
    
    Animation panel2 = new Animation();
    frame.add(panel2);
    frame.setVisible(true);
  //  panel.gameloop();
  }
}