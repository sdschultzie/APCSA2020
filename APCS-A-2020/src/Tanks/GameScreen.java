package Tanks;

import javax.swing.*;

import static java.lang.Character.toUpperCase;

import java.awt.*;
import java.awt.event.*;
import java.time.Duration;
import java.time.Instant;

public class GameScreen extends JPanel implements Runnable, MouseMotionListener, KeyListener, MouseListener
{
	// Instance variables
	private MainFrame frame;
	private Level level;
	private int levelCounter;
	private int previousScore;
	private int levelScore;
	private Instant startTime;
	private Instant currentTime;
	private boolean terminated;
	private boolean[] keys;
	
	// Constructor
	public GameScreen(MainFrame f)
	{
		frame = f;
		keys = new boolean[4];
		
    	setBackground(Color.WHITE);
    	setLayout(new GridBagLayout());
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
		if (level.gameOver() == false) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			//Moves playerTank with WASD
			if(keys[0] == true)
			{
				level.getPlayerTank().move(0);
			}
			if(keys[1] == true)
			{
				level.getPlayerTank().move(1);
			}
			if(keys[2] == true)
			{
				level.getPlayerTank().move(2);
			}
			if(keys[3] == true)
			{
				level.getPlayerTank().move(3);
			}
			
			level.checkAllCollisions();
			levelScore = level.getScore();
			level.draw(g2);
			currentTime = Instant.now();
			g2.drawString("Time: " + Duration.between(startTime, currentTime), 40, 50);
			if (level.isComplete()) {
				previousScore = previousScore + levelScore;
				levelCounter++;
				level = new Level(levelCounter);
				levelScore = level.getScore();
			}
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
		try {
			Turret tu = level.getPlayerTank().getTurret();
			tu.setAngle(Math.atan2(e.getY() - (tu.getY()+tu.getHeight()/2), e.getX() - tu.getX()));
		}
		catch (Exception ex) {}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		level.getPlayerTank().shoot();
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
		levelCounter = 1;
		previousScore = 0;
		levelScore = 0;
		startTime = Instant.now();
		level = new Level(levelCounter);
		terminated = false;
		new Thread(this).start();
	}
	
	
	public void stopGame() {
		level.setGameOver(true);
		terminated = true;
	}
	
	public void gameIsOver() {
		frame.switchPanel("highscores");
	}
	
	
	// Main loop
	@Override
	public void run() {
	   	try
	   	{
	   		requestFocusInWindow(); //needed to make key listeners work
	   		while(level.gameOver() == false)
	   		{
	   			Thread.currentThread().sleep(13);
	            repaint();
	            
	        }
	   		
	   		//game is over and not ended by clicking the home button
	   		if (! terminated) {
	   			Thread.currentThread().sleep(1500);
	   			ScoreList scores = new ScoreList();
	   			Score thisScore = new Score(previousScore + levelScore, Duration.between(startTime, currentTime).toSeconds());
	   			if (scores.isHighscore(thisScore)) {
	   				String name = "N/A";
	   				name = JOptionPane.showInputDialog("You Destroyed " + thisScore.getNumTanks() + " tanks in " + thisScore.getSeconds() + " seconds. That is worthy of the leaderboard! Enter your name");
	   				thisScore.setName(name);
	   				scores.update(thisScore);
	   			}
		   		gameIsOver();
	   		}

   		} 
	   	catch(Exception e)
	    {
	    }
	}

	
}
