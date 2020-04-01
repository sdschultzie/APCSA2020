package Q3FinalLab;

import java.util.ArrayList;

import core.data.DataSource;

public class StatsTester {
	public static void main(String[] args) {
		DataSource ds = DataSource.connect("src/Q3FinalLab/FantasyFootballStats2019.csv"); 
	    ds.setCacheTimeout(15 * 60);  
	    ds.load();
	    ds.printUsageString();
	    
	    Stats test = ds.fetch(Stats.class, "G", "Pass Yds", "Pass TD", "Int", "Rush Yds", "Rush TD", "Rec", "Rec Yds", "Rec TD", "FL", "2PC");
	    System.out.println(test);
	    
	}
}
