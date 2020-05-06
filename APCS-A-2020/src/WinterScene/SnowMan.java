package WinterScene;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SnowMan extends AbstractShape
{
   public SnowMan(int x, int y, int w, int h )
   {
		super(x, y, w, h, Color.WHITE, 0, 0);
   }

   @Override
   public void draw(Graphics window)
   {
	  window.setColor(getColor());
      window.fillOval(getX(), getY() + getHeight()/2, getWidth(), getHeight()/2);
      window.fillOval(getX() + getWidth()/6, getY() + getHeight()/5, getWidth()*4/6, getHeight()/3);
      window.fillOval(getX() + getWidth()/4, getY(), getWidth()*2/4, getHeight()/4);
   }

   @Override
   public void moveAndDraw(Graphics window)
   {
      draw(window);   
   }
}