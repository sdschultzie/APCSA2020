package Tanks;

import javax.swing.*;

import static java.lang.Character.toUpperCase;

import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable, MouseMotionListener, KeyListener, MouseListener
{
	// Instance variables
	private Tank tank;
	private Bullet b;
	
	private boolean[] keys;
	
	
	// Constructor
	public GamePanel()
	{
		keys = new boolean[4];
		
		tank = new Tank(50,300);
		
    	setBackground(Color.WHITE);
		setVisible(true);
		setPreferredSize(new Dimension (800,600));
		
		new Thread(this).start();
		//add event listeners
        addMouseMotionListener(this);
        addMouseListener(this);
        addKeyListener(this);
	}
	
	
	// paint method used to repaint -----------------------
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (b != null) {
			b.move();
			b.draw(g2);
		}
		tank.draw(g2);

		
		//Moves tank with WASD
		if(keys[0] == true)
		{
			tank.move(0);
		}
		if(keys[1] == true)
		{
			tank.move(1);
		}
		if(keys[2] == true)
		{
			tank.move(2);
		}
		if(keys[3] == true)
		{
			tank.move(3);
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
		Turret tu = tank.getTurret();
		tu.setAngle(Math.atan2(e.getY() - (tu.getY()+tu.getHeight()/2), e.getX() - tu.getX()));
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		double angle = tank.getTurret().getAngle();
		double x = tank.getTurret().getX() + (tank.getTurret().getWidth()*Math.cos(angle));
		double y = tank.getTurret().getY() + (tank.getTurret().getWidth())*Math.sin(angle);
		double xSpd = tank.getTurret().getBulletSpeed()*Math.cos(angle);
		double ySpd = tank.getTurret().getBulletSpeed()*Math.sin(angle);
		b = new Bullet(x, y, xSpd, ySpd);
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	//------------------------------------------------------------
	
	
	// Main loop
	@Override
	public void run() {
	   	try
	   	{
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
