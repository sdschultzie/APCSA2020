package Starfighter;

import java.util.ArrayList;

public class AlienHorde2 extends AlienHorde{

	public AlienHorde2(int size) {
		super(size);
		for (Alien a : getAliens()) {
			a.setImage("/Starfighter/Images/alien2.png");
			a.setPos((int) (Math.random()*735+15), (int) (Math.random()*375)+15);
		}
	}
	
	
	public void checkWallHit() {
		for (Alien a : getAliens()) {
			if (a.getX() < 10 || a.getX() + a.getWidth() > 780) {
				a.setSpeed(-a.getSpeed());
			}
			
			if (a.getY() < 10 || a.getY() + a.getHeight() > 580) {
				a.setSpeed(-a.getSpeed());
			}
		}
	}
	
	@Override
	public void moveEmAll() {
		String directions = "lurd";
		for (int i=0; i<getAliens().size(); i++) {
			getAliens().get(i).move(directions.charAt(i%4)+"");
			getAliens().get(i).move(directions.charAt(((i%4)+1)%4)+"");
		}
	}

}
