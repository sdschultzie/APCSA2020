package Tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Wall1 extends Block{
	public Wall1(double x, double y) {
		super(x,y,36,36,Color.yellow);
	}
	
	
    public void draw(Graphics window)
    {
    	Graphics2D g = (Graphics2D) window;
    	g.setColor(getColor());
        g.fill(new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight()));
    	g.setColor(Color.black);
        g.draw(new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight()));
        

    }
    
	public String toString() {
		return "Wall1: " + super.toString();
	}
}
