package Tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Turret extends Block
{
	//instance variables
	private int maxBullets;
	private int bulletSpeed;
	private double angle;
	
	//Constructors -------------------------------
	//constructor for user turret
	public Turret(double x, double y) 
	{
		super(0,0,26,6,new Color(0,0,100));
		setPivot(x,y);
		setMaxBullets(5);
		setBulletSpeed(4);
	}
	
	//constructor for enemy turrets
	public Turret(int x, int y, Color c, int max, int spd)
	{
		super(0,0,26,6,c);
		setPivot(x,y);
		setMaxBullets(max);
		setBulletSpeed(spd);
	}

	
	// getters and setters -----------------------
	public int getMaxBullets() {
		return maxBullets;
	}

	public int getBulletSpeed() {
		return bulletSpeed;
	}
	
	public double getAngle() {
		return angle;
	}

	public void setMaxBullets(int maxBullets) {
		this.maxBullets = maxBullets;
	}

	public void setBulletSpeed(int bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}
	
	public void setAngle(double a) {
		this.angle = a;
	}
	
	public void setPivot(double x, double y) {
		setX(x);
		setY(y-getHeight()/2);
	}
	//---------------------------------------------
	
	@Override
	public void draw(Graphics window) 
	{
		Graphics2D g2 = (Graphics2D) window;
		g2.rotate(angle, getX(), getY()+getHeight()/2);
		super.draw(g2);
	}
	
	public String toString() {
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getMaxBullets() + " " + getBulletSpeed();
	}
}
