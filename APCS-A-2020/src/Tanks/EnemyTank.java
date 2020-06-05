package Tanks;

import java.awt.Color;
import java.util.ArrayList;

public abstract class EnemyTank extends Tank{

	public EnemyTank(double x, double y, Color c, double spd, int maxBul, int bulSpd, int maxCol) {
		super(x,y,c,spd,maxBul,bulSpd,maxCol);
	}
	
	public abstract void aimTurret(TankBody player);
	
	public abstract void move(Level level);
	
	public abstract boolean shouldIShoot();
	
	public String toString() {
		return super.toString();
	}
}
