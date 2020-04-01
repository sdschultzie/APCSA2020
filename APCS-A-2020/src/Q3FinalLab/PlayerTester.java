package Q3FinalLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import core.data.*;

public class PlayerTester {
	public static void main (String[] args) {
		DataSource ds = DataSource.connect("src/Q3FinalLab/FantasyFootballStats2019.csv"); 
	    ds.setCacheTimeout(15 * 60);  
	    ds.load();
	    ds.printUsageString();
	    
	    Stats test1 = ds.fetch(Stats.class, "G", "Pass Yds", "Pass TD", "Int", "Rush Yds", "Rush TD", "Rec", "Rec Yds", "Rec TD", "FL", "2PC");
	    Player player1 = ds.fetch(Player.class, "Player", "Tm", "FantPos");
	    player1.setStats(test1);
	    
	    System.out.println(player1);
	    
	    
	}
}
