package Q3FinalLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import core.data.*;

public class Points {
	private double[] points;
	
	public Points() {
		points = new double[3];
	}
	
	public Points(String pointsList) {
		setPoints(pointsList);
	}
	
	public void setPoints(String pointsList) {
		points = new double[3];
		Scanner input = new Scanner(pointsList);
		
		for (int i=0; i<points.length; i++) {
			points[i] = input.nextDouble();
		}
	}
	
	public void setPoint(int season, double value) {
		points[season-2017] = value;
	}
	
	public double getTotalPoints() {
		double totalPoints = 0;
		for (double p : points) {
			totalPoints += p;
		}
		return totalPoints;
	}
	
	public String toString() {
		String output = "";
		for (int i=0; i<points.length; i++) {
			output += i+2017 + ": " + points[i] + "\n"; 
		}
		output += "Total Points: " + getTotalPoints();
		return output;
	}
}
