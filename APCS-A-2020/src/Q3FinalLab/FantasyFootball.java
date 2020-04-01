package Q3FinalLab;

import java.util.ArrayList;
import java.util.Collections;

import core.data.DataSource;

public class FantasyFootball {
	public static void main (String[] args) {
		DataSource ds = DataSource.connect("src/Q3FinalLab/FantasyFootballStats2019.csv"); 
	    ds.setCacheTimeout(15 * 60);  
	    ds.load();
	    
	    //allStats and allPlayers are parallel Lists
	    ArrayList<Stats> allStats = ds.fetchList(Stats.class, "G", "Pass Yds", "Pass TD", "Int", "Rush Yds", "Rush TD", "Rec", "Rec Yds", "Rec TD", "FL", "2PC");
	    ArrayList<Player> allPlayers = ds.fetchList(Player.class, "Player", "Tm", "FantPos");
	    ArrayList<NFLTeam> teamList = new ArrayList<NFLTeam>();
	    
	    //loop through all players
	    for (int i=0; i<allPlayers.size(); i++) {
	    	Player plr = allPlayers.get(i);
	    		
	    	//set the players stats to the corresponding stats object
	    	plr.setStats(allStats.get(i));
	    	
	    	//Check if the players team is already in the team list
	    	boolean teamInList = false;
	    	for (NFLTeam team : teamList) {
	    		// if team already in team list add player to the team
	    		if (plr.getTeamName().equals(team.getName())) {
	    			team.addPlayer(plr);
	    			teamInList = true;
	    			break;
	    		}
	    	}
	    	//if team not in team list create a new NFLTeam and add player to new team
	    	if (!teamInList){
				NFLTeam t = new NFLTeam(plr.getTeamName());
				teamList.add(t);
				t.addPlayer(plr);
	    	}
	    }
	    
	    //loop through all the teams
	    Collections.sort(teamList);
	    for (NFLTeam t : teamList) {
	    	System.out.println(t);
	    }
	}
}
