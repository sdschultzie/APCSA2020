package Tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Tank {
	//instance variables
	private TankBody body;
	private Turret turret;
	private Color color;
	private ArrayList<Bullet> bullets;
	
	//Constructors ---------------------------------
	//constructor for user tank
	public Tank(double x, double y) {
		body = new TankBody(x,y);
		turret = new Turret(body.getCenterX(), body.getCenterY());
		bullets = new ArrayList<Bullet>();
	}
	
	public Tank(double x, double y, Color c, double spd, int maxBul, int bulSpd) {
		body = new TankBody(x,y,c,spd);
		turret = new Turret(body.getCenterX(), body.getCenterY(), c.darker().darker(), maxBul, bulSpd);
		bullets = new ArrayList<Bullet>();

	}

	
	// Getters & Setters ------------------------------
	public TankBody getBody() {
		return body;
	}

	public Turret getTurret() {
		return turret;
	}

	public Color getColor() {
		return color;
	}
	
	public ArrayList<Bullet> getBullets(){
		return bullets;
	}

	public void setBody(TankBody body) {
		this.body = body;
	}

	public void setTurret(Turret turret) {
		this.turret = turret;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	//-------------------------------------------------
	
	public void move(int d)
	{
		if (d==0)
			body.move(0);
		if (d==1)
			body.move(1);
		if (d==2)
			body.move(2);
		if (d==3)
			body.move(3);
		
		turret.setPivot(body.getCenterX(), body.getCenterY());
	}
	
	public void shoot()
	{
		if (bullets.size() < getTurret().getMaxBullets()) {
			double angle = getTurret().getAngle();
			double x = getTurret().getX() + (getTurret().getWidth()*Math.cos(angle));
			double y = getTurret().getY() + (getTurret().getWidth())*Math.sin(angle);
			double xSpd = getTurret().getBulletSpeed()*Math.cos(angle);
			double ySpd = getTurret().getBulletSpeed()*Math.sin(angle);
			bullets.add(new Bullet(x, y, xSpd, ySpd));
		}
	}
	
	public void draw(Graphics window)
	{
		body.draw(window);
		turret.draw(window);
	}
	
	public String toString() {
		return body.toString();
	}
}
