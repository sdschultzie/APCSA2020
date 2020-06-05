package Tanks;

import javax.swing.*;

import static java.lang.Character.toUpperCase;

import java.awt.*;
import java.awt.event.*;

public class TitleScreen extends JPanel
{
	// Constructor
	public TitleScreen()
	{
    	setBackground(Color.RED);
    	setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    	
    	JLabel title = new JLabel("Tanks!");
    	title.setAlignmentX(CENTER_ALIGNMENT);
    	title.setFont(new Font("Roboto", Font.BOLD, 100));
    	
    	JLabel creator = new JLabel("Creator: Chris Schultz");
    	creator.setAlignmentX(CENTER_ALIGNMENT);
    	creator.setFont(new Font("Roboto", Font.PLAIN, 20));

    	JLabel InstructionTitle = new JLabel("Instructions");
    	InstructionTitle.setAlignmentX(CENTER_ALIGNMENT);
    	InstructionTitle.setFont(new Font("Roboto", Font.BOLD, 50));

    	JLabel InstructionTxt = new JLabel("<html><p style='text-align: center'>Use WASD to move and click mouse to shoot. You can only shoot up to five bullets at a time. Bullets bounce off yellow walls and fly over circular holes. The most tanks destroyed in the fastest time wins.</p></html>");
    	InstructionTxt.setAlignmentX(CENTER_ALIGNMENT);
    	InstructionTxt.setFont(new Font("Roboto", Font.PLAIN, 20));


		add(title);
		add(creator);
		add(Box.createRigidArea(new Dimension(0,50)));
		add(InstructionTitle);
		add(InstructionTxt);
		setPreferredSize(new Dimension (972,576));
		
	}
	
	
//	// paint method used to repaint -----------------------
//	public void paintComponent(Graphics g) 
//	{
//		super.paintComponent(g);
//	}
	
	
	

	
}
