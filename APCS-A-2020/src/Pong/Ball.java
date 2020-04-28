package Pong;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super();
		setxSpeed(1);
		setySpeed(1);
	}

	//add the other Ball constructors
	public Ball(int x, int y) {
		super(x,y);
		setxSpeed(3);
		setySpeed(1);
	}
	
	
	public Ball(int x, int y, int w, int h) {
		super (x,y,w,h);
		setxSpeed(4);
		setySpeed(2);
	}
	
	public Ball(int x, int y, int w, int h, Color c) {
		super (x,y,w,h,c);
		setxSpeed(4);
		setySpeed(2);
	}
	
	public Ball(int x, int y, int w, int h, Color c, int xSpd, int ySpd) {
		super (x,y,w,h,c);
		setxSpeed(xSpd);
		setySpeed(ySpd);
	}
	
   //add the set methods
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	//add the get methods
	public int getxSpeed() {
		return xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}
	
	
	public void moveAndDraw(Graphics window)
	{
		//draw a white ball at old ball location
		super.draw(window, Color.white);

		//move the ball
		setX(getX() + xSpeed);
		setY(getY() + ySpeed);

		//draw the ball at its new location
		super.draw(window);
	}
   
	public boolean equals(Object obj)
	{
		Ball other = (Ball) obj;
		if (super.equals(obj) && this.getxSpeed()==other.getxSpeed() && this.getySpeed() == other.getySpeed())
			return true;
		else
			return false;
	}   


	//add a toString() method
	public String toString() {
		return super.toString() + ", " + xSpeed + ", " + ySpeed;
	}
}