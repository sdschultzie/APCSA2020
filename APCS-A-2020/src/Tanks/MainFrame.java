package Tanks;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainFrame extends JFrame
{
	private CardLayout cl;	
	JPanel cardPanel = new JPanel();
	GameScreen gamePanel;
	TitleScreen titlePanel;
	HighscoresScreen highscoresPanel;

	public MainFrame()
	{
		super("Tanks");
		//setSize(WIDTH, HEIGHT);
		
		//instantiate cardlayout object
		cl = new CardLayout();
		
		//set up main JPanel that will hold the other screens (JPanels)
		cardPanel.setLayout(cl);
		
		//add different screens to main JPanel with cardLayout
		gamePanel = new GameScreen(this);
		titlePanel = new TitleScreen();
		highscoresPanel = new HighscoresScreen();
		cardPanel.add(titlePanel, "title");
		cardPanel.add(gamePanel, "game");
		cardPanel.add(highscoresPanel, "highscores");
		
		
		//Create another JPanel to hold some buttons
		JPanel buttonPanel = new JPanel();
		
		//create buttons and add to buttonPanel
		JButton startButton = new JButton("Start Game");
		JButton highScoresButton = new JButton("View Highscores");
		JButton homeButton = new JButton("Home");
		buttonPanel.add(startButton);
		buttonPanel.add(highScoresButton);
		
		//add button listers
		startButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				cl.show(cardPanel, "game");
				gamePanel.startGame();
				buttonPanel.remove(startButton);
				buttonPanel.remove(highScoresButton);
				buttonPanel.add(homeButton);
				buttonPanel.revalidate();
				buttonPanel.repaint();
			}
		});
		
		highScoresButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				switchPanel("highscores");
				buttonPanel.remove(startButton);
				buttonPanel.remove(highScoresButton);
				buttonPanel.add(homeButton);
				buttonPanel.revalidate();
				buttonPanel.repaint();
			}
		});
		
		homeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				try{
					gamePanel.stopGame();
				}
				catch(Exception ex) {}
				
				cl.show(cardPanel, "title");
				startButton.setText("Start Game");
				buttonPanel.remove(homeButton);
				buttonPanel.add(startButton);
				buttonPanel.add(highScoresButton);
				buttonPanel.revalidate();
				buttonPanel.repaint();
			}
		});

		add(cardPanel);
		add(buttonPanel, BorderLayout.PAGE_END);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);

	}
	
	public void switchPanel(String panel) {
		cl.show(cardPanel, panel);
		highscoresPanel.displayScores();
	}

	public static void main( String args[] )
	{
		new MainFrame();
	}
}
