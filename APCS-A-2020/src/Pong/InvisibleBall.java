package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class InvisibleBall extends Ball{
	   //instance variables
	   private boolean invisible;
	   
	   //constructors
	   public InvisibleBall()
	   {
			super();
			invisible = false;
	   }

	   public InvisibleBall(int x, int y)
	   {
		   super(x,y);
		   invisible = false;
	   }

	   public InvisibleBall(int x, int y, int wid, int ht)
	   {
		   super(x,y,wid,ht);
		   invisible = false;
	   }

	   public InvisibleBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
	   {
		   super(x,y,wid,ht,xSpd,ySpd);
		   invisible = false;

	   }

	   public InvisibleBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
	   {
		   super (x,y,wid,ht,col,xSpd,ySpd);
		   invisible = false;
	   }

	   public boolean turnInvisible()
	   {
	   		double random = Math.random();
	   		if (random < 0.005) {
	   			invisible = true;
	   			return true;
	   		}
	   		else 
	   			return false;
	   }
	   
	   public boolean resetInvisibility() {
		   double random = Math.random();
		   if (random < 0.01) {
			   invisible = false;
			   return true;
		   }
		   else 
			   return false;
	   }
	   
	   public void drawInvisible(Graphics window) {
		   super.draw(window, Color.white);
		   setX(getX() + getxSpeed());
		   setY(getY() + getySpeed());
	   }
	   
	   public void drawNormal(Graphics window) {
		   super.draw(window, Color.white);
		   setX(getX() + getxSpeed());
		   setY(getY() + getySpeed());
		   super.draw(window, getColor());
	   }

	   public void moveAndDraw(Graphics window)
	   {
		   if (invisible == false) {
			   if (turnInvisible()) 
				   drawInvisible(window);
			   else 
				   drawNormal(window);
		   }
		   
		   else { //invisible is true
			   if (resetInvisibility()) 
				   drawNormal(window);
			   else 
				   drawInvisible(window);
		   }
	   }
}
