package WinterScene;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class WinterScenePanel extends JPanel implements Runnable
{
	private List<AbstractShape> shapes;
	private AbstractShape sMan;
	private AbstractShape tree;

	public WinterScenePanel()
	{
		setVisible(true);
		//refer shapes to a new ArrayList of AbstractShape
		shapes = new ArrayList<AbstractShape>();

		//populate the list with 50 unique snowflakes
		for (int i=0; i<50; i++) {
			int x = (int) (751 * Math.random());
			int y = (int) (600 * Math.random());
			int w = (int) (41 * Math.random()) + 10;
			int h = w;
			int ySpd = (int) (5*Math.random()) + 1;
			shapes.add(new FancySnowFlake(x,y,w,h,Color.white,0,ySpd));
		}

		//add a snowman to list of shapes
		shapes.add(new SnowMan(600,345,100,200));
		
		//add a tree to list of shapes
		shapes.add(new Tree(100,245,200,300));

		new Thread(this).start();
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		window.setColor(Color.BLUE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.WHITE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("MAKE A WINTER SCENE!",40,40);

		//make the snowflakes appear and move down the screen
		for (AbstractShape sh : shapes) {
			sh.moveAndDraw(window);
			
			//check to see if any of the snowflakes need to be reset to the top of the screen
			if (sh.getY() > 600) {
				sh.setY(0 - sh.getHeight());
			}
		}
		
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(35);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}