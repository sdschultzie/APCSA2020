package Tanks;

import java.awt.Color;

public abstract class EnemyTank extends Tank{

	public EnemyTank(double x, double y, Color c, double spd, int maxBul, int bulSpd) {
		super(x,y,c,spd,maxBul,bulSpd);
	}
	
	public abstract void aimTurret();
	
	public abstract void move();
	
	public abstract boolean shouldIShoot();
	
	public String toString() {
		return super.toString();
	}
}
