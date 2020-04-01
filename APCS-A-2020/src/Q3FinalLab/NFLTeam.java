package Q3FinalLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NFLTeam implements Comparable<NFLTeam>{
	private String name;
	private ArrayList<Player> players;
	
	public NFLTeam(String nmIn) {
		setName(nmIn);
		players = new ArrayList<Player>();
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}

	public void setName(String nmIn) {
		this.name = nmIn;
	}
	
	public void setPlayers(ArrayList<Player> plyrsIn) {
		this.players = plyrsIn;
	}
	
	public void addPlayer(Player plr) {
		players.add(plr);
	}
	
	public void sort() {
		Collections.sort(players);
	}
	
	public double getTeamFP() {
		double totalFP = 0.0;
		for (Player plr : this.players) {
			totalFP += plr.getMyFantasyPoints();
		}
		return totalFP;
	}
	
	public double getAvgFP() {
		return getTeamFP()/players.size();
	}
	
	public int compareTo(NFLTeam other) {
		if (getTeamFP() > other.getTeamFP())
			return -1;
		else if (getTeamFP() < other.getTeamFP())
			return 1;
		else
			return 0;
	}
	
	
	public String toString() {
		String output = name + "\n";
		for (Player plr : players) {
			output += plr.getName() + ": " + String.format("%.2f", plr.getMyFantasyPoints()) + "\n";
		}
		output += "Total Fantasy Points: " + String.format("%.2f", getTeamFP()) + "\n";
		output += "Average Fantasy Points: " + String.format("%.2f", getAvgFP()) + "\n\n";
		return output;
	}
	
	
	
}
