package Q3FinalLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import core.data.*;

public class PlayerTester {
	public static void main (String[] args) {
		DataSource ds = DataSource.connect("src/Q3FinalLab/FantasyFootballSeason2019.csv"); 
	    ds.setCacheTimeout(15 * 60);  
	    ds.load();
	    ds.printUsageString();
	}
}
