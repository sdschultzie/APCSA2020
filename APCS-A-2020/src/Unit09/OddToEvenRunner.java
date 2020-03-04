package Unit09;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.Arrays;

public class OddToEvenRunner
{
	public static void main( String args[] )
	{
		ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList(7,1,5,3,11,5,6,7,8,9,10,12345,11));
		ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList(11,9,8,7,6,5,4,3,2,1,-99,7));
		ArrayList<Integer> l3 = new ArrayList<Integer>(Arrays.asList(10,20,30,40,5,41,31,20,11,7));
		ArrayList<Integer> l4 = new ArrayList<Integer>(Arrays.asList(32767,70,4,5,6,7));
		ArrayList<Integer> l5 = new ArrayList<Integer>(Arrays.asList(2,7,11,21,5,7));
		ArrayList<Integer> l6 = new ArrayList<Integer>(Arrays.asList(7,255,11,255,100,3,2));
		ArrayList<Integer> l7 = new ArrayList<Integer>(Arrays.asList(9,11,11,11,7,1000,3));
		ArrayList<Integer> l8 = new ArrayList<Integer>(Arrays.asList(7,7,7,11,2,7,7,11,11,2));
		ArrayList<Integer> l9 = new ArrayList<Integer>(Arrays.asList(2,4,6,8,8));
		
		System.out.println(ListOddToEven.go(l1));
		System.out.println(ListOddToEven.go(l2));
		System.out.println(ListOddToEven.go(l3));
		System.out.println(ListOddToEven.go(l4));
		System.out.println(ListOddToEven.go(l5));
		System.out.println(ListOddToEven.go(l6));
		System.out.println(ListOddToEven.go(l7));
		System.out.println(ListOddToEven.go(l8));
		System.out.println(ListOddToEven.go(l9));

	}
}