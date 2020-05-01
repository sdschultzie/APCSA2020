package Pong;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private ArrayList<Wall> walls = new ArrayList<Wall>();
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private int p1Score = 0;
	private int p2Score = 0;
	private boolean[] keys;
	private BufferedImage back;


	public Pong()
	{
		//set up all variables related to the game
		walls.add(new Wall(0,10,0,600,Color.red));
		walls.add(new Wall(790,800,0,600,Color.red));
		walls.add(new Wall(10,790,0,10,Color.green));
		walls.add(new Wall(10,790,590,600,Color.green));
		leftPaddle = new Paddle(20,270,10,45,Color.red,3);
		rightPaddle = new Paddle(770,270,10,45,Color.red,3);
		ball = new InvisibleBall(400,300,10,10,Color.blue,-3,0);

		keys = new boolean[4];

    	setBackground(Color.WHITE);
		setVisible(true);
		setPreferredSize(new Dimension (800,600));
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and save it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		
		graphToBack.setColor(Color.black);
		graphToBack.drawString(p1Score + " | " + p2Score, 390, 25);
		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		for (Wall w : walls) {
			w.draw(graphToBack);
		}


		//see if ball hits left wall or right wall
		if (ball.didCollideLeft(walls.get(0))) {
			ball.draw(graphToBack, Color.white);
			ball.setPos(400,300);
			ball.setySpeed(0);
			p2Score += 1;
			graphToBack.setColor(Color.white);
			graphToBack.fillRect(390, 15, 50, 50);
		}
		
		if (ball.didCollideRight(walls.get(1))) {
			ball.draw(graphToBack, Color.white);
			ball.setPos(400,300);
			ball.setySpeed(0);
			p1Score +=1;
			graphToBack.setColor(Color.white);
			graphToBack.fillRect(390, 15, 50, 50);
		}

		
		//see if the ball hits the top or bottom wall 
		if (ball.didCollideTop(walls.get(2)) || ball.didCollideBottom(walls.get(3)))
		{
			ball.setySpeed(-ball.getySpeed());
		}


		//see if the ball hits the left paddle
		if (ball.didCollideLeft(leftPaddle)) {
				ball.setxSpeed(-ball.getxSpeed());
				ball.setySpeed(ball.getVerticalDistFromCenter(leftPaddle)/6);
		}
		
		//see if the ball hits the right paddle
		if (ball.didCollideRight(rightPaddle)) {
				ball.setxSpeed(-ball.getxSpeed());
				ball.setySpeed(ball.getVerticalDistFromCenter(rightPaddle)/6);
		}
		
		


		//see if the paddles need to be moved
		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		
		if(keys[2] == true)
		{
			//move right paddle up and draw it on the window
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		
		if(keys[3] == true)
		{
			//move right paddle down and draw it on the window
			rightPaddle.moveDownAndDraw(graphToBack);
		}


		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}