package Tanks;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainFrame extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private CardLayout cl;
	private JPanel panel;
	

	public MainFrame()
	{
		super("Tanks");
		//setSize(WIDTH, HEIGHT);
		
		//instantiate cardlayout object
		cl = new CardLayout();
		
		//set up main JPanel that will hold the other screens (JPanels)
		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(cl);
		//cardPanel.setPreferredSize(new Dimension(800,600));
		
		//add different screens to main JPanel with cardLayout
		GameScreen gamePanel = new GameScreen();
		TitleScreen titlePanel = new TitleScreen();
		cardPanel.add(titlePanel, "title");
		cardPanel.add(gamePanel, "game");
		
		
		//Create another JPanel to hold some buttons
		JPanel buttonPanel = new JPanel();
		
		//create buttons and add to buttonPanel
		JButton gameButton = new JButton("Start Game");
		JButton highScoresButton = new JButton("View Highscores");
		buttonPanel.add(gameButton);
		buttonPanel.add(highScoresButton);
		
		//add button listers
		gameButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				cl.show(cardPanel, "game");
				gamePanel.startGame();
			}
		});

		add(cardPanel);
		add(buttonPanel, BorderLayout.PAGE_END);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);

	}

	public static void main( String args[] )
	{
		new MainFrame();
	}
}
