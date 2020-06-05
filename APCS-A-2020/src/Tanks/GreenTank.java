package Tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;

public class GreenTank extends EnemyTank{

	double avgX;
	double avgY;
	double startX;
	double startY;
	int shotsFired;
	
	public GreenTank(double x, double y) {
		super(x, y, new Color(39, 161, 85), 1, 4, 3, 1);
		startX = x;
		startY = y;
		shotsFired = 0;
	}

	@Override
	public void aimTurret(TankBody player) {
		Turret t = getTurret();
		
		if (shotsFired == 0 || shotsFired == 4) {
			double angle = Math.atan2(player.getY() - (t.getY()+t.getHeight()/2), player.getX() + player.getWidth() - t.getX());
			t.setAngle(angle);
		}
		if (shotsFired == 1) {
			double angle = Math.atan2(player.getY() + player.getHeight() - (t.getY()+t.getHeight()/2), player.getX() + player.getWidth() - t.getX());
			t.setAngle(angle);
		}
		if (shotsFired == 2) {
			double angle = Math.atan2(player.getY() + player.getHeight() - (t.getY()+t.getHeight()/2), player.getX() - t.getX());
			t.setAngle(angle);
		}
		if (shotsFired == 3) {
			double angle = Math.atan2(player.getY() - (t.getY()+t.getHeight()/2), player.getX() - t.getX());
			t.setAngle(angle);
		}
	}

	/*
	 * Algorithm for avoiding bullets
	 * Moves to original position when no bullets nearby
	 */
	@Override
	public void move(Level level) {
		ArrayList<Bullet> allBullets = new ArrayList<Bullet>();
		for (Bullet b : level.getPlayerTank().getBullets()) {
			allBullets.add(b);
		}
		for (EnemyTank e : level.getEnemies()) {
			for (Bullet b : e.getBullets()) {
				allBullets.add(b);
			}
		}
		ArrayList<Block> walls = level.getWalls();
		double centerX = this.getBody().getCenterX();
		double centerY = this.getBody().getCenterY();
		double totalY = 0;
		double totalX = 0;
		double totalxSpeed = 0;
		double totalySpeed = 0;
		int closeBullets = 0;
		
		for (Bullet bullet : allBullets) {
			double xDiff = centerX - bullet.getX() + bullet.getWidth()/2;
			double yDiff = centerY - bullet.getY() + bullet.getHeight()/2;
			double distance = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
			
			if (distance <= 90) {
				closeBullets++;

				totalX += bullet.getX() + bullet.getxSpeed()*20;
				totalY += bullet.getY() + bullet.getySpeed()*20;
				
				totalxSpeed += Math.abs(bullet.getxSpeed());
				totalySpeed += Math.abs(bullet.getySpeed());
			}
		}
		
		if (closeBullets == 0) {
			double xDiff = getBody().getX() - startX;
			double yDiff = getBody().getY() - startY;
			if (Math.abs(yDiff) >= Math.abs(xDiff)) {
				if (yDiff > getBody().getSpeed())
					move(0);
				if (yDiff < -getBody().getSpeed())
					move(1);
			}
			else {
				if (xDiff > getBody().getSpeed())
					move(2);
				if (xDiff < -getBody().getSpeed())
					move(3);
			}
		}
		
		else {
			avgX = totalX/closeBullets;
			avgY = totalY/closeBullets;
	
			if (totalxSpeed > totalySpeed) {
				if (avgY > centerY)
					move(0);
				if (avgY < centerY)
					move(1);
			}
			
			if (totalySpeed > totalxSpeed) {
				if (avgX > centerX)
					move(2);
				if (avgX < centerX)
					move(3);
			}
		}
	}

	@Override
	public boolean shouldIShoot() {
		if (shotsFired < getTurret().getMaxBullets()) {
			if (Math.random() < 0.07)
				return true;
			else 
				return false;
		}
		else if (getBullets().size() == 0) {
			shotsFired = 0;
			return true;
		}
		else {
			return false;
		}
	}

	
	@Override 
	public void draw(Graphics window) {
		super.draw(window);
//		int radius = 125;
//
//		Graphics2D g = (Graphics2D) window;
//    	g.setColor(Color.black);
//        //g.draw(new Ellipse2D.Double(getBody().getCenterX()-radius, getBody().getCenterY()-radius, 2*radius, 2*radius));
//		//g.setColor(Color.red);
//		//g.fill(new Rectangle2D.Double(avgX, avgY, 5, 5));
	}
	
	
	@Override 
	public void shoot() {
		super.shoot();
		shotsFired++;
	}

}
