package Unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore
{
	private ArrayList<Toy> toyList;

	public ToyStore()
	{
		toyList = new ArrayList<Toy>();
	}

	public void loadToys( String toys )
	{
		String [] toysArr = toys.split(" ");
		for (String toyStr : toysArr) {
			Toy toy = getThatToy(toyStr);
			if (toy != null) {
				toy.setCount(toy.getCount()+1);
			}
			else {
				toyList.add(new Toy(toyStr));
			}
		}
		
	}
  
  	public Toy getThatToy( String nm )
  	{
  		for (Toy toy : toyList) {
  			if (toy.getName().equals(nm))
  				return toy;
  		}
  		return null;
  	}
  
  	public String getMostFrequentToy()
  	{
  		int mostToyCount = 0;
  		String mostToyName = "";
  		for (int i=0; i<toyList.size(); i++) {
  			if (toyList.get(i).getCount() > mostToyCount) {
  				mostToyCount = toyList.get(i).getCount();
  				mostToyName = toyList.get(i).getName();
  			}
  		}
  		return mostToyName;
  	}  
  
  	public void sortToysByCount()
  	{
  		ArrayList<Toy> sorted = new ArrayList<Toy>();
  		while (toyList.size() > 0) {
  			Toy biggestCountToy = getThatToy(getMostFrequentToy());
  			toyList.remove(biggestCountToy);
  			sorted.add(biggestCountToy);
  		}
  		
  		toyList = sorted;
  	}  
  	  
	public String toString()
	{
		String output = "";
		sortToysByCount();
		
		for (Toy toy : toyList) {
			output += toy + ", ";
		}
		
		output += "\n\n Most Frequent Toy: " + getMostFrequentToy();
		return output;
	}
}