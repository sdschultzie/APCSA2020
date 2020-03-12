package DataLab;
/*
 * Arrays of objects
 */

import core.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Welcome03_List {
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
      ArrayList<WeatherStation> allstns = ds.fetchList(WeatherStation.class, "station/station_name", 
             "station/station_id", "station/state",
             "station/latitude", "station/longitude");
      System.out.println("Total stations: " + allstns.size());
      
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a state abbreviation: ");
      String state = sc.next();
      ArrayList<WeatherStation> stateStns = new ArrayList<WeatherStation>();
      
      System.out.println("Stations in " + state);
      for (WeatherStation ws : allstns) {
         if (ws.isLocatedInState(state)) {
            System.out.println("  " + ws.getId() + ": " + ws.getName());
            stateStns.add(ws);
         }
      }
      System.out.println("Number of Stations in " + state + ": " + stateStns.size());
      
      WeatherStation southernmost = stateStns.get(0);
      for (WeatherStation ws : stateStns) {
    	  if (ws.getLat() < southernmost.getLat()) {
    		  southernmost = ws;
    	  }
      }
      System.out.println("The southernmost Station in " + state + " is " + southernmost.getName());
   }
}
  

/*
 Represents information about a NWS weather station
*/
class WeatherStation {
   private String name;
   private String id;
   private String state;
   private double lat;
   private double lng;
   
   WeatherStation(String name, String id, String state, double lat, double lng) {
      this.name = name;
      this.id = id;
      this.lat = lat;
      this.lng = lng;
      this.state = state;   
   }
   
   /* Produce the id of this station */
   public String getId() { 
      return id;
   }
   
   /* Produce the name of this station */
   public String getName() { 
      return name;
   }
   
   public double getLat() {
	   return lat;
   }
   
   /* Determine if this weather station is located in the given state */
   public boolean isLocatedInState(String st) {
      return this.state.equals(st);
   }
   
}
