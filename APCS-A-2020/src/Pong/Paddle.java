package Pong;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle() {
	   super(10,10);
	   setSpeed(5);
   }

   //add the other Paddle constructors
   public Paddle(int x, int y) {
	   super(x,y);
	   setSpeed(5);
   }
   
   public Paddle(int x, int y, int spd) {
	   super (x,y);
	   setSpeed(spd);
   }
   
   public Paddle(int x, int y, int w, int h, int spd) {
	   super (x,y,w,h);
	   setSpeed(spd);
   }
   
   
   public Paddle(int x, int y, int w, int h, Color c, int spd) {
	   super (x,y,w,h,c);
	   setSpeed(spd);
   }



   // getters 
   public int getSpeed() {
	   return speed;
   }

   // setters
   public void setSpeed(int speed) {
	   this.speed = speed;
   }

   public void moveUpAndDraw(Graphics window)
   {
	   super.draw(window, Color.white);
	   setY(getY() - speed);
	   super.draw(window);
   }

   public void moveDownAndDraw(Graphics window)
   {
	   super.draw(window, Color.white);
	   setY(getY() + speed);
	   super.draw(window);
   }
   
   //add a toString() method
   public String toString() {
	   return super.toString() + ", " + speed;
   }
}