package Tanks;

import javax.swing.*;

import static java.lang.Character.toUpperCase;

import java.awt.*;
import java.awt.event.*;

public class GameScreen extends JPanel implements Runnable, MouseMotionListener, KeyListener, MouseListener
{
	// Instance variables
	private Level currentLevel;
	private Tank tank;
	private EnemyTank enemy;
	
	private boolean[] keys;
	
	
	// Constructor
	public GameScreen()
	{
		currentLevel = new Level(1);
		keys = new boolean[4];
		
		tank = new Tank(150,300);
		enemy = new BrownTank(900,300);
		
    	setBackground(Color.WHITE);
    	setPreferredSize(new Dimension (972,576));
	
		//add event listeners
        addMouseMotionListener(this);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        
	}
	
	
	// paint method used to repaint -----------------------
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
//		for (Bullet b : tank.getBullets()) {
//			b.moveAndDraw(g2);
//		}
		//enemy.getTurret().setAngle(Math.PI);
		//enemy.draw(g2);
		//tank.draw(g2);
		currentLevel.draw(g2);
		currentLevel.checkCollisions();
		

		
		//Moves tank with WASD
		if(keys[0] == true)
		{
			currentLevel.getPlayerTank().move(0);
		}
		if(keys[1] == true)
		{
			currentLevel.getPlayerTank().move(1);
		}
		if(keys[2] == true)
		{
			currentLevel.getPlayerTank().move(2);
		}
		if(keys[3] == true)
		{
			currentLevel.getPlayerTank().move(3);
		}
		
	}
	
	
	//Key listener methods -------------------------------
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'S' : keys[1]=true; break;
			case 'A' : keys[2]=true; break;
			case 'D' : keys[3]=true; break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'S' : keys[1]=false; break;
			case 'A' : keys[2]=false; break;
			case 'D' : keys[3]=false; break;
		}
	}
	
	//Mouse listener methods -------------------------------
	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		Turret tu = currentLevel.getPlayerTank().getTurret();
		tu.setAngle(Math.atan2(e.getY() - (tu.getY()+tu.getHeight()/2), e.getX() - tu.getX()));
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		currentLevel.getPlayerTank().shoot();
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	//------------------------------------------------------------
	
	public void startGame() {
		setVisible(true);
		new Thread(this).start();
	}
	
	
	// Main loop
	@Override
	public void run() {
	   	try
	   	{
	   		requestFocusInWindow(); //needed to make key listeners work
	   		while(true)
	   		{
	   			Thread.currentThread().sleep(13);
	            repaint();
	        }
	   		
   		} 
	   	catch(Exception e)
	    {
	    }
	}

	
}
