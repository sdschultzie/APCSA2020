package DataLab;
import java.util.ArrayList;
import java.util.Collections;

import core.data.*;

public class LaborParticipationCA {
	public static void main (String[] args) {
		DataSource ds = DataSource.connect("https://data.edd.ca.gov/api/views/phzw-uepq/rows.xml"); 
	    ds.setCacheTimeout(15 * 60);  
	    ds.load();
	    ds.printUsageString();
	    
	    ArrayList<LaborObservation> allObs = ds.fetchList(LaborObservation.class, 
	    		"row/row/year", "row/row/month",
	    		"row/row/age_16_19", "row/row/age_20_24",
	    		"row/row/age_25_34", "row/row/age_35_44",
	    		"row/row/age_45_54", "row/row/age_55_64",
	    		"row/row/age_65");
	    
	    Collections.sort(allObs);
	    System.out.println(allObs.get(0));
	}
}
