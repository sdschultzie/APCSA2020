package Tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

// Adapted from Pong block class
public class Block implements Locatable
{
	private double xPos;
	private double yPos;
	private int width;
	private int height;
	private Color color;

	// Constructors ---------------------------------------
	public Block() {
		setPos(100,100);
		setWidth(10);
		setHeight(10);
		setColor(Color.black);
	}
	
	//used for wall blocks
	public Block(double x, double y) {
		setPos(x,y);
		setWidth(36);
		setHeight(36);
		setColor(Color.lightGray);
	}

	//used for user tank
	public Block (double x, double y, int w, int h) {
		setPos(x,y);
		setWidth(w);
		setHeight(h);
		setColor(Color.blue);
	}
	
	public Block (double x, double y, int w, int h, Color c) {
		setPos(x,y);
		setWidth(w);
		setHeight(h);
		setColor(c);
	}
	
	
	// Set Methods -----------------------------------------
	@Override
	public void setPos(double x, double y) {
		setX(x);
		setY(y);
	}

	@Override
	public void setX(double x) {
		this.xPos = x;
	}

	@Override
	public void setY(double y) {
		this.yPos = y;	
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setColor(Color col)
	{
		this.color = col;
   	}
	

	
	// Get Methods ----------------------------------------
	@Override
	public double getX() {
		return xPos;
	}

	@Override
	public double getY() {
		return yPos;
	}   
   

   public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public Color getColor() {
		return color;
	}
	//-----------------------------------------------------------------
	
	
    public void draw(Graphics window)
    {
    	Graphics2D g = (Graphics2D) window;
    	g.setColor(color);
        g.fill(new Rectangle2D.Double(getX()+0.5, getY(), getWidth(), getHeight()));
    }

//    public void draw(Graphics window, Color c)
//    {
//    	window.setColor(c);
//	    window.fillRect(getX(), getY(), getWidth(), getHeight());
//    }
   
	public boolean equals(Object obj)
	{
		Block other = (Block) obj;
		if (this.height == other.getHeight()) {
			if (this.width == other.getWidth()) {
				if (this.color == other.getColor()) {
					return true;
				}
			}
		}
		return false;
	}

	public String toString() {
		return xPos + ", " + yPos + ", " + width + ", " + height + ", " + color;
	}
}
