package Tanks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreList {
	private ArrayList<Score> scores;
	private File file;
	
	public ScoreList() {
		scores = new ArrayList<Score>();
		
		// load the scores from the data file (scores.txt)
		try {
			file = new File("src/Tanks/scores.txt");
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				Scanner line = new Scanner(input.nextLine());
				scores.add(new Score(line.next(), line.nextInt(), line.nextInt()));
			}
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean isHighscore(Score newScore) {
		return (newScore.compareTo(scores.get(scores.size()-1)) < 0);
	}
	
	
	public void update(Score newScore) throws IOException {
		if (newScore.compareTo(scores.get(scores.size()-1)) < 0) {
			scores.add(newScore);
			Collections.sort(scores);
			scores.remove(scores.size()-1);
			
			//create output to write to scores file
			String content = "";
			for (Score s : scores) {
				content += s.getName() + " " + s.getNumTanks() + " " + s.getSeconds() + "\n";
			}
			
			System.out.println(content);
			
			//try and write new output to file
			//use printwriter because it clears the file before writing
			try {
				new PrintWriter(file).close();
				FileWriter w = new FileWriter(file);
				w.write(content);
				w.close();
				System.out.println("wrote to file");
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
		}
	}
	
	
	public ArrayList<Score> getScores() {
		return scores;
	}
	
	
	public String toString() {
		String output = "";
		for (Score score : scores) {
			output += score + "\n";
		}
		return output;
	}
}
