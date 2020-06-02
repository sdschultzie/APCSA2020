package Tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;

public class Wall2 extends Block{
	public Wall2(double x, double y) {
		super(x,y,36,36,Color.black);
	}
	
	@Override
	public void draw(Graphics window)
	{
		Graphics2D g = (Graphics2D) window;
		g.setColor(getColor());
		g.draw(new Ellipse2D.Double(getX(), getY(), getWidth(), getHeight()));
	}
	
	public String toString() {
		return "Wall2: " + super.toString();
	}
}
