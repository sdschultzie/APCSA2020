package Tanks;

import java.awt.Color;
import java.util.ArrayList;

public class BrownTank extends EnemyTank{

	public BrownTank(double x, double y) {
		super(x, y, new Color(222, 158, 55), 0, 3, 3, 1);
	}

	@Override
	public void aimTurret(TankBody player) {
		Turret t = getTurret();
		double angle = Math.atan2(player.getCenterY() - (t.getY()+t.getHeight()/2), player.getCenterX() - t.getX());
		t.setAngle(angle);
	}

	
	@Override
	public void move(Level level) {}

	
	@Override
	public boolean shouldIShoot() {
		if (Math.random()<0.01) 
			return true;
		else 
			return false;
	}

}
