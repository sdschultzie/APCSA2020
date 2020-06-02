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
	
	
	// Constructor
	public Level(int levelNum)
	{
		enemies = new ArrayList<EnemyTank>();
		walls = new ArrayList<Block>();
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

	public void setPlayerTank(Tank playerTank) {
		this.playerTank = playerTank;
	}

	public void setEnemies(ArrayList<EnemyTank> enemies) {
		this.enemies = enemies;
	}

	public void setWalls(ArrayList<Block> walls) {
		this.walls = walls;
	}

	
	//generates level instance variables from levels.txt
	public void load(int levelNum)
	{
		try {
			File f = new File("src/Tanks/levels.txt");
			Scanner input = new Scanner(f);
			String line = "";
			
			//find the level to load
			while (input.hasNextLine()) {
				line = input.nextLine();
				if (line.equals("Level" + levelNum)) {
					System.out.println(line);
					break;
				}
			}
			
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
				
				
				line = input.nextLine();
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
			e.draw(g);
			for (Bullet b : e.getBullets()) {
				b.moveAndDraw(g);
			}
		}
		for (Block b : walls) {
			b.draw(g);
		}
	}
	
	
	public void checkCollisions() {
		outer:
		for (int i=0; i<playerTank.getBullets().size(); i++) {
			Bullet bullet = playerTank.getBullets().get(i);
			for (int j=0; j<enemies.size(); j++) {
				if (bullet.hitSomething(enemies.get(j).getBody()) != 0) {
					System.out.println("Hit tank");
					playerTank.getBullets().remove(i);
					enemies.remove(j);
					i--;
					j--;
				}
			}
			for (Block b : walls) {
				if (bullet.hitSomething(b) == 1) {
					System.out.println("collided top");
					bullet.setySpeed(-bullet.getySpeed());
					continue outer;
				}
				if (bullet.hitSomething(b) == 2) {
					System.out.println("collided bottom");
					bullet.setySpeed(-bullet.getySpeed());
					continue outer;
				}
				if (bullet.hitSomething(b) == 3) {
					System.out.println("collided left");
					bullet.setxSpeed(-bullet.getxSpeed());
					continue outer;
				}
				if (bullet.hitSomething(b) == 4) {
					System.out.println("collided right");
					bullet.setxSpeed(-bullet.getxSpeed());
					continue outer;
				}
			}
		}
		
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
//		// paint method used to repaint -----------------------
//		public void paintComponent(Graphics g) 
//		{
//			super.paintComponent(g);
//			Graphics2D g2 = (Graphics2D) g;
//			for (Bullet b : tank.getBullets()) {
//				b.moveAndDraw(g2);
//			}
//			enemy.getTurret().setAngle(Math.PI);
//			enemy.draw(g2);
//			tank.draw(g2);
//			
//
//			
//			//Moves tank with WASD
//			if(keys[0] == true)
//			{
//				tank.move(0);
//			}
//			if(keys[1] == true)
//			{
//				tank.move(1);
//			}
//			if(keys[2] == true)
//			{
//				tank.move(2);
//			}
//			if(keys[3] == true)
//			{
//				tank.move(3);
//			}
//			
//		}
//		
//		
//		//Key listener methods -------------------------------
//		@Override
//		public void keyTyped(KeyEvent e) {}
//
//		@Override
//		public void keyPressed(KeyEvent e) 
//		{
//			switch(toUpperCase(e.getKeyChar()))
//			{
//				case 'W' : keys[0]=true; break;
//				case 'S' : keys[1]=true; break;
//				case 'A' : keys[2]=true; break;
//				case 'D' : keys[3]=true; break;
//			}
//		}
//
//		@Override
//		public void keyReleased(KeyEvent e) 
//		{
//			switch(toUpperCase(e.getKeyChar()))
//			{
//				case 'W' : keys[0]=false; break;
//				case 'S' : keys[1]=false; break;
//				case 'A' : keys[2]=false; break;
//				case 'D' : keys[3]=false; break;
//			}
//		}
//		
//		//Mouse listener methods -------------------------------
//		@Override
//		public void mouseDragged(MouseEvent e) {}
//
//		@Override
//		public void mouseMoved(MouseEvent e) {
//			Turret tu = tank.getTurret();
//			tu.setAngle(Math.atan2(e.getY() - (tu.getY()+tu.getHeight()/2), e.getX() - tu.getX()));
//		}
//		
//		@Override
//		public void mouseClicked(MouseEvent e) {}
//
//		@Override
//		public void mousePressed(MouseEvent e) {
//			tank.shoot();
//		}
//
//		@Override
//		public void mouseReleased(MouseEvent e) {}
//
//		@Override
//		public void mouseEntered(MouseEvent e) {}
//
//		@Override
//		public void mouseExited(MouseEvent e) {}
//		//------------------------------------------------------------
//		
//		public void startGame() {
//			setVisible(true);
//			new Thread(this).start();
//		}
//		
//		
//		// Main loop
//		@Override
//		public void run() {
//		   	try
//		   	{
//		   		requestFocusInWindow(); //needed to make key listeners work
//		   		while(true)
//		   		{
//		   			Thread.currentThread().sleep(13);
//		            repaint();
//		        }
//		   		
//	   		} 
//		   	catch(Exception e)
//		    {
//		    }
//		}
}
