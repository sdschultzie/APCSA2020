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
	
	/*
	 * returns 0 if didn't hit anything
	 * returns 1 if bullet collided top
	 * returns 2 if bullet collided bottom
	 * returns 3 if bullet collided left
	 * returns 4 if bullet collided right 
	 */
	public int hitSomething(Object o)
	{
		Block that = (Block) o;
		
		//checks top and bottom collisions
		if (this.getX() <= that.getX() + that.getWidth() && this.getX() + this.getWidth() >= that.getX()) {
			if (this.getY() <= that.getY() + that.getHeight() + Math.abs(this.getySpeed()) && this.getY() >= that.getY() + that.getHeight() - Math.abs(this.getySpeed())) {
				//System.out.println("collided top");
				return 1;
			}
			if (this.getY() + this.getHeight() >= that.getY() - Math.abs(this.getySpeed()) && this.getY() + this.getHeight() <= that.getY() + Math.abs(this.getySpeed())) {
				//System.out.println("collided bottom");
				return 2;
			}	
		}
		
		//checks left and right collisions
		if (this.getY() + this.getHeight() >= that.getY() && this.getY() <= that.getY() + that.getHeight()) {
			if (getxSpeed() < 0) {
				if (this.getX() <= that.getX() + that.getWidth() + Math.abs(this.getxSpeed()) && this.getX() >= that.getX() + that.getWidth() - Math.abs(this.getxSpeed())) {
					//System.out.println("collided left"); 
					return 3;
				}
			}
			
			if (getxSpeed() > 0) {
				if (this.getX() + this.getWidth() >= that.getX() - Math.abs(this.getxSpeed()) && this.getX() + this.getWidth() <= that.getX() + Math.abs(this.getxSpeed())) {
					//System.out.println("collided right");
					return 4;
				}
			}
		}
		
		
		return 0;
	}
	
	
	public String toString()
	{
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getxSpeed() + " " + getySpeed();
	}
}
