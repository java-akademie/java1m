package ch.java_akademie.applet1;

import java.awt.*;
import java.awt.event.*;

public class MyFrame
{
  Frame frame;

  public MyFrame(String feld)
  {

    frame = new Frame("Frame");

    frame.add(new MyPanel());

    frame.setSize     (500,300);
    frame.setLocation (200,100);
    frame.pack        ();
    frame.setVisible  (true);

    frame.addWindowListener
      (new WindowAdapter()
           {
             public void windowClosing (WindowEvent e)
             {
               System.out.println("Window geschlossen" + e);
               System.exit(0);
             }
           }
      );
  }


  public static void main (String[] args)
  {
    System.out.println("start main");
    new MyFrame("mein Frame");
  }
}
