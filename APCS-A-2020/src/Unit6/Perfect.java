package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Perfect
{
   private int number;

	//add constructors
   	public Perfect() {
   		number = 1;
   	}
   	
   	public Perfect(int i) {
   		setNumber(i);
   	}

	//add a set method
   	public void setNumber(int i) {
   		number = i;
   	}

	public boolean isPerfect()
	{
		int i = 1;
		int divisorSum = 0;
		
		while (i < number) {
			if (number % i == 0) {
				divisorSum += i;
			}
			i++;
		}
		
		if (divisorSum == number) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		if (isPerfect()) {
			return number + " is perfect.";
		} else {
			return number + " is not perfect.";
		}
	}
	
}