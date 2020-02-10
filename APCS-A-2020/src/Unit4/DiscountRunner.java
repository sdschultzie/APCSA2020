package Unit4;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name - 
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class DiscountRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		
		for (int i=0; i<5; i++) {
			
			out.print("Enter the original bill amount :: ");
			double amt = keyboard.nextDouble();
			String finalAmt = String.format("%.2f", Discount.getDiscountedBill(amt));
			System.out.println("Bill after discount :: " + finalAmt);
		
		}
	}
}