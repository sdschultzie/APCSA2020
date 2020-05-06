package WinterScene;

import java.awt.Color;
import java.awt.Graphics;

public class Tree extends AbstractShape 
{

	public Tree(int x, int y, int wid, int ht) {
		super(x, y, wid, ht);
	}

	@Override
	public void draw(Graphics window) {
		int x = getX();
		int y = getY();
		int w = getWidth();
		int h = getHeight();
		
		window.setColor(new Color(110,45,0));
		window.fillRect(x+w*4/10, y+h*9/10, w*2/10, h*1/10);
		window.setColor(Color.green);
		window.fillPolygon(new int[] {x, x+w/2, x+w}, new int[] {y+h*9/10, y+h*4/10, y+h*9/10}, 3);
		window.fillPolygon(new int[] {x+w*1/10, x+w/2, x+w*9/10}, new int[] {y+h*6/10, y+h*2/10, y+h*6/10}, 3);
		window.fillPolygon(new int[] {x+w*2/10, x+w/2, x+w*8/10}, new int[] {y+h*3/10, y, y+h*3/10}, 3);

	}

	@Override
	public void moveAndDraw(Graphics window) {
		draw(window);
	}

}
