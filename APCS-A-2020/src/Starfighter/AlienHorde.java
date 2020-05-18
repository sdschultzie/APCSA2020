package Starfighter;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;
	private int height;
	private int maxSize;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>();
		maxSize = size;
		for (int i=0; i<size; i++) {
			int x = 50 + (i%10)*70;
			int y = 50 + (i/10)*50;
			aliens.add(new Alien(x,y,1));
		}
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for (Alien a : aliens){
			a.draw(window);
		}
	}

	public void moveEmAll()
	{
		for (Alien a : aliens){
			if (a.getX() < 10 || a.getX() + a.getWidth() > 770) {
				a.setY(a.getY() + (maxSize/10)*50);
				a.setSpeed(-a.getSpeed());
				a.move("r");
			}
			else 
				a.move("r");
		}
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
		for (int a=0; a<aliens.size(); a++) {
			for (int b=0; b<shots.size(); b++) {
				if (shots.get(b).hitAlien(aliens.get(a))) {
					aliens.remove(a);
					shots.remove(b);
					a--;
					b--;
				}
			}
		}
	}

	public String toString()
	{
		return "";
	}
}
