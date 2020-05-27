package Tanks;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	//instance variables
	private TankBody body;
	private Turret turret;
	private Color color;
	
	//Constructors ---------------------------------
	//constructor for user tank
	public Tank(int x, int y) {
		body = new TankBody(x,y);
		turret = new Turret(body.getCenterX(), body.getCenterY());
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
	
	public void draw(Graphics window)
	{
		body.draw(window);
		turret.draw(window);
	}
	
	
}
