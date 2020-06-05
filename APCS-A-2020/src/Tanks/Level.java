package Tanks;

import static java.lang.Character.toUpperCase;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

public class Level {
	// Instance variables
	private Tank playerTank;
	private ArrayList<EnemyTank> enemies;
	private ArrayList<Block> walls;
	private boolean gameOver;
	private int score;
	
	
	// Constructor
	public Level(int levelNum)
	{
		enemies = new ArrayList<EnemyTank>();
		walls = new ArrayList<Block>();
		gameOver = false;
		load(levelNum);
	}
	
	
	//Getter & Setters
	public Tank getPlayerTank() {
		return playerTank;
	}

	public ArrayList<EnemyTank> getEnemies() {
		return enemies;
	}

	public ArrayList<Block> getWalls() {
		return walls;
	}
	
	public boolean gameOver() {
		return gameOver;
	}
	
	public int getScore() {
		return score;
	}

	public void setPlayerTank(Tank playerTank) {
		this.playerTank = playerTank;
	}

	public void setEnemies(ArrayList<EnemyTank> enemies) {
		this.enemies = enemies;
	}

	public void setWalls(ArrayList<Block> walls) {
		this.walls = walls;
	}
	
	public void setGameOver(boolean b) {
		gameOver = b;
	}

	
	//generates level instance variables from levels.txt
	public void load(int levelNum)
	{
		try {
			Scanner input = new Scanner(new File("src/Tanks/levels.txt"));
			String line = "";
			boolean foundLevel = false;
			
			//find the level to load
			while (input.hasNextLine()) {
				line = input.nextLine();
				if (line.equals("Level" + levelNum)) {
					foundLevel = true;
					System.out.println(line);
					//add the walls
					for (int i=0; i<16; i++) {
						for (int j=0; j<27; j++) {
							int wallType = input.nextInt();
							if (wallType == 1) {
								walls.add(new Wall1(j*36 ,i*36));
							} 
							if (wallType == 2) {
								walls.add(new Wall2(j*36, i*36));
							}
						}
						input.nextLine();
					}
					
					//add the tanks
					line = input.nextLine();
					while (!line.equals("---")) {
						Scanner l = new Scanner(line);
						String type = l.next();
						
						if (type.equals("P")) 
							playerTank = new Tank(l.nextDouble(), l.nextDouble());
						else if (type.equals("B")) 
							enemies.add(new BrownTank(l.nextDouble(), l.nextDouble()));
						else if (type.equals("G"))
							enemies.add(new GreenTank(l.nextDouble(), l.nextDouble()));
						
						line = input.nextLine();
					}
					break;
				}
			}
			//System.out.println(foundLevel);
			if (foundLevel == false) {
				gameOver = true;
			}
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void draw(Graphics g)
	{
		playerTank.draw(g);
		
		for (Bullet b : playerTank.getBullets()) {
			b.moveAndDraw(g);
		}
		
		for (EnemyTank e : enemies) {
			e.move(this);
			e.aimTurret(playerTank.getBody());
			if (e.shouldIShoot() == true)
				e.shoot();
			e.draw(g);
			
			for (Bullet b : e.getBullets()) {
				b.moveAndDraw(g);
			}
		}
		
		for (Block b : walls) {
			b.draw(g);
		}
	}
	
	/*
	 * Detects for collisions with walls
	 * Destroys bullets if they collided more than their max collisions
	 * Makes bullets bounce off walls when they haven't gone over their maxCollisions
	 */
	public void checkBulletsHitWall(ArrayList<Bullet> bullets) {
		outer:
		for (int i=0; i<bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			for (Block w : walls) {
				if (w instanceof Wall1) {
					if (bullet.hitSomething(w) == 1 || bullet.hitSomething(w) == 2) {
						bullet.setCollisions(bullet.getCollisions()+1);
						if (bullet.isDestroyed()) {
							bullets.remove(i);
							i--;
						}
						else {
							bullet.setySpeed(-bullet.getySpeed());
						}
						continue outer;
					}
					if (bullet.hitSomething(w) == 3 || bullet.hitSomething(w) == 4) {
						bullet.setCollisions(bullet.getCollisions()+1);
						if (bullet.isDestroyed()) {
							bullets.remove(i);
							i--;
						}
						else {
							bullet.setxSpeed(-bullet.getxSpeed());
						}
						continue outer;
					}
				}
			}
		}
	}
	
	
	/*
	 * Detects bullets for collisions with other bullets
	 */
	public void checkBulletsHitBullets(ArrayList<Bullet> b1, ArrayList<Bullet>b2){
		outer:
		for (int i=0; i<b1.size(); i++) {
			for (int j=0; j<b2.size(); j++) {
				if (b1.get(i).hitSomething(b2.get(j)) != 0) {
					b1.remove(i);
					b2.remove(j);
					i--;
					j--;
					continue outer;
				}
			}
		}
	}
	
	public void checkBulletsHitTank(ArrayList<Bullet> bullets) {
		outer:
		for (int i=0; i<bullets.size(); i++) {
			Bullet b = bullets.get(i);
			
			// Check collisions with enemy tanks
			for (int j=0; j<enemies.size(); j++) {
				if (b.hitSomething(enemies.get(j).getBody()) != 0) {
					bullets.remove(i);
					enemies.remove(j);
					System.out.println("Hit Tank");
					score++;
					i--;
					j--;
					continue outer;
				}
			}
			
			// Check collisions with player tank
			if (b.hitSomething(playerTank.getBody()) != 0) {
				gameOver = true;
			}
		}
	}
	
	public void checkAllCollisions() {
		checkBulletsHitWall(playerTank.getBullets());
		checkBulletsHitTank(playerTank.getBullets());
		for (int i=0; i<enemies.size(); i++) {
			checkBulletsHitBullets(playerTank.getBullets(), enemies.get(i).getBullets());
			checkBulletsHitWall(enemies.get(i).getBullets());
			checkBulletsHitTank(enemies.get(i).getBullets());
			
		}
	
		//loop through walls to see if any tanks hit the walls
		for (Block w : walls) {
			TankBody body = playerTank.getBody();
			if (playerTank.hitSomething(w) == 1) {
				body.setY(w.getY()+w.getHeight()+body.getSpeed());
			}
			if (playerTank.hitSomething(w) == 2) {
				body.setY(w.getY()-body.getWidth()-body.getSpeed());
			}
			if (playerTank.hitSomething(w) == 3) {
				body.setX(w.getX()+w.getWidth()+body.getSpeed());
			}
			if (playerTank.hitSomething(w) == 4) {
				body.setX(w.getX()-body.getWidth()-body.getSpeed());
			}
			
			//check if enemy moving tanks hit walls
			for (EnemyTank e : enemies) {
				if (e.getBody().getSpeed() != 0){
					
					TankBody eBody = e.getBody();
					if (e.hitSomething(w) == 1) {
						eBody.setY(w.getY()+w.getHeight()+body.getSpeed());
					}
					if (e.hitSomething(w) == 2) {
						eBody.setY(w.getY()-body.getWidth()-body.getSpeed());
					}
					if (e.hitSomething(w) == 3) {
						eBody.setX(w.getX()+w.getWidth()+body.getSpeed());
					}
					if (e.hitSomething(w) == 4) {
						eBody.setX(w.getX()-body.getWidth()-body.getSpeed());
					}
				}
			}
		}
	}


	public boolean isComplete() {
		if (enemies.size() == 0) 
			return true;
		else
			return false;
	}
	
	
	public String toString() {
		String output = "";
		for (Block b : walls) {
			output += b + "\n";
		}
		for (EnemyTank e : enemies) {
			output += e + "\n";
		}
		
		return output + playerTank;
	}
}