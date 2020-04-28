package Pong;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BallTestTwo extends Canvas implements Runnable
{
	private Ball [] balls = new Ball[5];

	public BallTestTwo()
	{
		setBackground(Color.WHITE);
		setVisible(true);

		//instantiate a new Ball
		//test all constructors
		Ball b0 = new Ball();
		balls[0] = b0;
		
		Ball b1 = new Ball(100,20);
		balls[1] = b1;
		
		Ball b2 = new Ball(50,50,30,30);
		balls[2] = b2;
		
		Ball b3 = new Ball(350,350,15,15,Color.red);
		balls[3] = b3;
		
		Ball b4 = new Ball(20,300,20,60,Color.green,4,5);
		balls[4] = b4;
		
		//test the Ball thoroughly
		for (Ball b : balls) {
			System.out.println(b);
		}

		new Thread(this).start();
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		for (Ball ball : balls) {
			ball.moveAndDraw(window);
	
			if(!(ball.getX()>=10 && ball.getX()<=550))
			{
				ball.setxSpeed(-ball.getxSpeed());
			}
	
			if(!(ball.getY()>=10 && ball.getY()<=450))
			{
				ball.setySpeed(-ball.getySpeed());
			}
		}
	}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(19);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}