package Pong;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables

   public SpeedUpBall()
   {
	   super();
   }

   public SpeedUpBall(int x, int y)
   {
	   super(x,y);
   }


   public SpeedUpBall(int x, int y, int wid, int ht)
   {
	   super(x,y,wid,ht);
   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super (x,y,wid,ht,xSpd,ySpd);
   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht,col,xSpd,ySpd);
   }

   public void setxSpeed( int xSpd )
   {
	   if (xSpd > 0)
		   xSpd++;
	   else if (xSpd < 0)
		   xSpd--;
	   
	   super.setxSpeed(xSpd);
   }

   public void setySpeed( int ySpd )
   {
	   if (ySpd > 0)
		   ySpd++;
	   else if (ySpd < 0)
		   ySpd--;
	   
	   super.setySpeed(ySpd);

   }
}

