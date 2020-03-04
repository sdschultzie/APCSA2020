package Unit08;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayOddToEven
{
	public static int go(int[] ray)
	{
		int firstOdd = -1;
		int nextEven = -1;
		int i = 0;
		
		while (i < ray.length && firstOdd < 0) {
			if (ray[i] % 2 != 0) 
				firstOdd = i;
			else
				i++;
		}
		
		while (i < ray.length && nextEven < 0) {
			if (ray[i] % 2 == 0)
				nextEven = i;
			else 
				i++;
		}
		
		if (firstOdd >= 0 && nextEven >=0)
			return nextEven - firstOdd;
		else 	
			return -1;
	}
}