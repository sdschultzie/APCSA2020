package Tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

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
		super(0,0,26,6,Color.blue.darker().darker());
		setPivot(x,y);
		setMaxBullets(5);
		setBulletSpeed(4);
	}
	
	//constructor for enemy turrets
	public Turret(double x, double y, Color c, int max, int spd)
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
		g2.setColor(getColor());
		
		//Modified from https://stackoverflow.com/questions/7517688/rotate-a-java-graphics2d-rectangle
		Rectangle2D r = new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
		Path2D.Double path = new Path2D.Double();
		path.append(r, false);

		AffineTransform t = new AffineTransform();
		t.rotate(angle, getX(), getY() + getHeight()/2);
		path.transform(t);
		g2.fill(path);
	}
	
	public String toString() {
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getMaxBullets() + " " + getBulletSpeed();
	}
}
