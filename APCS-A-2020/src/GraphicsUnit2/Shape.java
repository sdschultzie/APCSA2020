package GraphicsUnit2;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color; 
import java.awt.Graphics;

public class Shape
{
   //instance variables
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;
	private int xSpeed;
	private int ySpeed;

   /*
    *The constructor is used to initialize all instance variables.
    *The constructor makes the object.
    */
   public Shape(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
		xPos = x;
		yPos = y;
		width = wid;
		height = ht;
		color = col;
		xSpeed = xSpd;
		ySpeed = ySpd;
   }

      /*
    *The draw method draws the shape on the screen.
    */
   public void draw(Graphics window)
   {
      window.setColor(color);
      window.fillRoundRect(xPos, yPos, width, height, 10, 10);

   }

   /*
    *This draw method will be used to erase the shape.
    */
   public void draw(Graphics window, Color col)
   {
      window.setColor(col);
      window.fillRoundRect(xPos, yPos, width, height, 10, 10);
   }

   public void moveAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setX(this.xPos + this.xSpeed);
	   setY(this.yPos + this.ySpeed);
	   draw(window);
	   
   }

   //add in set and get methods for xPos, yPos, xSpeed, and ySpeed
   public int getX()
   {
   	return xPos;
   }

   public void setX( int x )
   {
   	this.xPos = x;
   }

   public int getY() {
	return yPos;
	}
	
	public void setY(int yPos) {
		this.yPos = yPos;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getXSpd() {
		return xSpeed;
	}
	
	public void setXSpd(int xSpeed) {
		this.xSpeed = xSpeed;
	}
	
	public int getYSpd() {
		return ySpeed;
	}
	
	public void setYSpd(int ySpeed) {
		this.ySpeed = ySpeed;
	}

public String toString()
   {
   	return xPos+" "+yPos+" "+width+" "+height+" "+color+" "+xSpeed+" "+ySpeed;
   }
}