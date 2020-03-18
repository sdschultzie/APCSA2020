package DataLab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import core.data.*;

public class LaborParticipationCA {
	public static void main (String[] args) {
		DataSource ds = DataSource.connect("https://data.edd.ca.gov/api/views/phzw-uepq/rows.xml"); 
	    ds.setCacheTimeout(15 * 60);  
	    ds.load();
	    
	    ArrayList<LaborObservation> allObs = ds.fetchList(LaborObservation.class, 
	    		"row/row/year", "row/row/month",
	    		"row/row/age_16_19", "row/row/age_20_24",
	    		"row/row/age_25_34", "row/row/age_35_44",
	    		"row/row/age_45_54", "row/row/age_55_64",
	    		"row/row/age_65");
	    
	    System.out.println("Number of Observations: " + allObs.size() + "\n");
	    System.out.println("----Sample Observation----\n" + allObs.get(0));
	    
	    
	    ArrayList<LaborObservation> obs2010 = new ArrayList<LaborObservation>();
	    ArrayList<LaborObservation> obs2019 = new ArrayList<LaborObservation>();

	    for (LaborObservation obs : allObs) {
	    	if (obs.getYear() == 2010) {
	    		obs2010.add(obs);
	    	}
	    	if (obs.getYear() == 2019) {
	    		obs2019.add(obs);
	    	}
	    }
	    
	    double sum16_192010 = 0.0;
	    double sum35_442010 = 0.0;
	    double sum652010 = 0.0;
	    
	    double sum16_192019 = 0.0;
	    double sum35_442019 = 0.0;
	    double sum652019 = 0.0;


	    for (int i=0; i<12; i++) 
	    {
	    	sum16_192010 += obs2010.get(i).getRate16_19();
	    	sum35_442010 += obs2010.get(i).getRate35_44();
	    	sum652010 += obs2010.get(i).getRate65();
	    	
	    	sum16_192019 += obs2019.get(i).getRate16_19();
	    	sum35_442019 += obs2019.get(i).getRate35_44();
	    	sum652019 += obs2019.get(i).getRate65();
	    }
	    
	    double avg16_19rate2010 = sum16_192010/12;
	    double avg35_44rate2010 = sum35_442010/12;
	    double avg65rate2010 = sum652010/12;
	    
	    double avg16_19rate2019 = sum16_192019/12;
	    double avg35_44rate2019 = sum35_442019/12;
	    double avg65rate2019 = sum652019/12;

	    
	    System.out.println("Average Labor Particitpation Rate in 2010 for 16-19: " + avg16_19rate2010);
	    System.out.println("Average Labor Particitpation Rate in 2010 for 35-44: " + avg35_44rate2010);
	    System.out.println("Average Labor Particitpation Rate in 2010 for 65+: " + avg65rate2010);
	    System.out.println();
	    System.out.println("Average Labor Particitpation Rate in 2019 for 16-19: " + avg16_19rate2019);
	    System.out.println("Average Labor Particitpation Rate in 2019 for 35-44: " + avg35_44rate2019);
	    System.out.println("Average Labor Particitpation Rate in 2019 for 65+: " + avg65rate2019);
	}
}
