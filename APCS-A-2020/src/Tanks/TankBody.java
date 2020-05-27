package Tanks;

import java.awt.Color;
import java.awt.Graphics;

public class TankBody extends Block
{
	//Instance Variables
	private int speed;
	
	
	//Constructors --------------------------------------------
	//constructor for user tank
	public TankBody(int x, int y) 
	{
		super(x,y,34,34);
		setSpeed(2);
	}
	
	//constructor for enemy tanks
	public TankBody(int x, int y, Color c, int s)
	{
		super(x,y,34,34,c);
		setSpeed(s);
	}

	
	//Getters & Setters --------------------------------------
	public int getSpeed() {
		return speed;
	}
	
	public int getCenterX() {
		return getX()+getWidth()/2;
	}
	
	public int getCenterY() {
		return getY()+getHeight()/2;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	//--------------------------------------------------------
	
	
	public void move(int d) 
	{
		if (d==0)
			setY(getY() - getSpeed());
		if (d==1)
			setY(getY() + getSpeed());
		if (d==2)
			setX(getX() - getSpeed());
		if (d==3)
			setX(getX() + getSpeed());
	}
	
	
	public String toString() {
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getSpeed();
	}
	
}
