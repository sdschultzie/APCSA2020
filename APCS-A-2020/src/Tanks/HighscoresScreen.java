package Tanks;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HighscoresScreen extends JPanel {	
	ScoreList highScores;
	
	// Constructor
	public HighscoresScreen()
	{
    	setBackground(Color.RED);
    	setLayout(new GridLayout(6,3));
    	setPreferredSize(new Dimension (972,576));    	
    	
    	displayScores();
	}
	
	public void displayScores() {
		removeAll();
    	highScores = new ScoreList();
    	
    	Font font1 = new Font ("Roboto", Font.BOLD, 30);
    	Font font2 = new Font ("Roboto", Font.PLAIN, 20);
    	
    	JLabel name = new JLabel("Name");
    	name.setFont(font1);
    	name.setHorizontalAlignment(JLabel.CENTER);

    	JLabel tanks = new JLabel("Tanks Destroyed");
    	tanks.setFont(font1);
    	tanks.setHorizontalAlignment(JLabel.CENTER);
    	
    	JLabel time = new JLabel("Time");    	
    	time.setFont(font1);
    	time.setHorizontalAlignment(JLabel.CENTER);

    	add(name);
    	add(tanks);
    	add(time);
    	
    	for (Score score : highScores.getScores()) {
    		JLabel nm = new JLabel(score.getName());
    		nm.setFont(font2);
        	nm.setHorizontalAlignment(JLabel.CENTER);
    		JLabel td = new JLabel(score.getNumTanks()+"");
    		td.setFont(font2);
    		td.setHorizontalAlignment(JLabel.CENTER);
    		JLabel tm = new JLabel(String.format("%d:%02d", score.getSeconds()/60, score.getSeconds()%60));
    		tm.setFont(font2);
    		tm.setHorizontalAlignment(JLabel.CENTER);

    		add(nm);
    		add(td);
    		add(tm);
    	}
    	revalidate();
	}
}
