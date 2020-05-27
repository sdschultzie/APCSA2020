package Tanks;

import java.awt.Color;
import java.awt.Graphics;

// Adapted from Pong block class
public class Block implements Locatable
{
	private int xPos;
	private int yPos;
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
	public Block(int x, int y) {
		setPos(x,y);
		setWidth(36);
		setHeight(36);
		setColor(Color.lightGray);
	}

	//used for user tank
	public Block (int x, int y, int w, int h) {
		setPos(x,y);
		setWidth(w);
		setHeight(h);
		setColor(Color.blue);
	}
	
	public Block (int x, int y, int w, int h, Color c) {
		setPos(x,y);
		setWidth(w);
		setHeight(h);
		setColor(c);
	}
	
	
	// Set Methods -----------------------------------------
	@Override
	public void setPos(int x, int y) {
		setX(x);
		setY(y);
	}

	@Override
	public void setX(int x) {
		this.xPos = x;
	}

	@Override
	public void setY(int y) {
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
	public int getX() {
		return xPos;
	}

	@Override
	public int getY() {
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
    	window.setColor(color);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
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
