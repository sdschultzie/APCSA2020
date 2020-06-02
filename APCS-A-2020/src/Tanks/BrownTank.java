package Tanks;

import java.awt.Color;

public class BrownTank extends EnemyTank{

	public BrownTank(double x, double y) {
		super(x, y, new Color(222, 158, 55), 0, 3, 4);
	}

	@Override
	public void aimTurret() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean shouldIShoot() {
		// TODO Auto-generated method stub
		return false;
	}

}
