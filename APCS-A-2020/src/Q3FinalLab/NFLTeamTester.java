package Q3FinalLab;

import java.util.ArrayList;

import core.data.DataSource;

public class NFLTeamTester {
	public static void main (String[] args) {
		DataSource ds = DataSource.connect("src/Q3FinalLab/FantasyFootballStats2019.csv"); 
	    ds.setCacheTimeout(15 * 60);  
	    ds.load();
	    ds.printUsageString();
	    
	    ArrayList<Stats> allStats = ds.fetchList(Stats.class, "G", "Pass Yds", "Pass TD", "Int", "Rush Yds", "Rush TD", "Rec", "Rec Yds", "Rec TD", "FL", "2PC");
	    ArrayList<Player> allPlayers = ds.fetchList(Player.class, "Player", "Tm", "FantPos");
	    NFLTeam chargers = new NFLTeam("LAC");
	    
	    for (int i=0; i<allPlayers.size(); i++) {
	    	Player plr = allPlayers.get(i);
	    	plr.setStats(allStats.get(i));
	    	
	    	if (plr.getTeamName().equals("LAC")) {
	    		chargers.addPlayer(plr);
	    	}
	    }
	    
	    System.out.println(chargers);
	    chargers.sort();
	    System.out.println("Team After Sorting\n" + chargers);
	}
}
