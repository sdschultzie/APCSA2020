package Tanks;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Block{
	private double xSpeed;
	private double ySpeed;
	
	// Constructors -------------------------------------
	public Bullet(double x, double y, double xSpd, double ySpd) {
		super (x,y,5,5,Color.black);
		setxSpeed(xSpd);
		setySpeed(ySpd);
	}
	
	public Bullet(double x, double y, Color c, double xSpd, double ySpd) {
		super(x,y,5,5,c);
		setxSpeed(xSpd);
		setySpeed(ySpd);
	}

	
	// Getters & Setters -------------------------------
	public double getxSpeed() {
		return xSpeed;
	}

	public double getySpeed() {
		return ySpeed;
	}

	public void setxSpeed(double xSpd) {
		this.xSpeed = xSpd;
	}

	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}
	//------------------------------------------------
	
	public void move() 
	{
		setX(getX() + xSpeed);
		setY(getY() + ySpeed);
	}
	
	public void moveAndDraw(Graphics window)
	{
		move();
		super.draw(window);
	}
	
	public String toString()
	{
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getxSpeed() + " " + getySpeed();
	}
}
