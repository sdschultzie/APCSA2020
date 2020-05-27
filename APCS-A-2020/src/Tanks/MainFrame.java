package Tanks;

import java.awt.Component;

import javax.swing.JFrame;

import Pong.Pong;
import Pong.TheGame;

public class MainFrame extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public MainFrame()
	{
		super("Tanks");

		GamePanel game = new GamePanel();

		((Component)game).setFocusable(true);
		getContentPane().add(game);

		setVisible(true);
		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		MainFrame run = new MainFrame();
	}
}
