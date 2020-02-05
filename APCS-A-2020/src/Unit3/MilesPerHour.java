package Unit3;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class MilesPerHour
{
	private int distance, hours, minutes;
	private double mph;

	public MilesPerHour()
	{
		setNums(0,0,0);
		mph=0.0;
	}

	public MilesPerHour(int dist, int hrs, int mins)
	{
		setNums(dist, hrs, mins);
		mph=0.0;
	}

	public void setNums(int dist, int hrs, int mins)
	{
		distance = dist;
		hours = hrs;
		minutes = mins;
	}

	public void calcMPH()
	{
		double totalTime = hours + (double) minutes/60;
		mph = distance/totalTime;
	}

	public void print()
	{
		String mphString = String.format("%.0f", mph);
		System.out.println("\n");
		System.out.println(distance + " miles in " + hours + " hours and " + minutes + " minutes = " + mphString + " MPH.");
		System.out.println("\n");
	}
	
	//create a print or toString or both
	
	public String toString()
	{		
		return "";
	}
}