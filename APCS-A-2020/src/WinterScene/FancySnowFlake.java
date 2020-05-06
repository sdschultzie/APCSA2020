package WinterScene;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

//extend the AbstractShape class to make a FancySnowFlake class
public class FancySnowFlake extends AbstractShape
{

	public FancySnowFlake(int x, int y, int w, int h, Color col, int xSpd, int ySpd) {
		super(x, y, w, h, col, xSpd, ySpd);
	}

	@Override
	public void draw(Graphics window) {
		int x = getX();
		int y = getY();
		int w = getWidth();
		int h = getHeight();
		int [] xPoints = {x, x+w*4/10, x+w/2, x+w*6/10, x+w, x+w*6/10, x+w/2, x+w*4/10, x};
		int [] yPoints = {y+h/2, y+h*4/10, y, y+h*4/10, y+h/2, y+h*6/10, y+h, y+h*6/10, y+h/2};
		
		window.setColor(getColor());
		window.drawPolyline(xPoints, yPoints, xPoints.length);
	}
	
	public void draw(Graphics window, Color c) {
		int x = getX();
		int y = getY();
		int w = getWidth();
		int h = getHeight();
		int [] xPoints = {x, x+w*4/10, x+w/2, x+w*6/10, x+w, x+w*6/10, x+w/2, x+w*4/10, x};
		int [] yPoints = {y+h/2, y+h*4/10, y, y+h*4/10, y+h/2, y+h*6/10, y+h, y+h*6/10, y+h/2};
		
		window.setColor(c);
		window.drawPolyline(xPoints, yPoints, xPoints.length);
	}

	@Override
	public void moveAndDraw(Graphics window) {
		draw(window, Color.blue);
		
		setX(getX() + getXSpeed());
		setY(getY() + getYSpeed());
		
		window.setColor(getColor());
		draw(window);
	}
	
}


