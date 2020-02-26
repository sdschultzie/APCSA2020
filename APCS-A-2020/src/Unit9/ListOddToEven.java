package Unit9;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
	public static int go( List<Integer> ray )
	{
		int firstOdd = -1;
		int nextEven = -1;
		int i = 0;
		
		while (i < ray.size() && firstOdd < 0) {
			if (ray.get(i) % 2 != 0) 
				firstOdd = i;
			else
				i++;
		}
		
		while (i < ray.size() && nextEven < 0);
			if (ray.get(i) % 2 == 0)
				nextEven = i;
			else 
				i++;
		
		if (firstOdd >= 0 && nextEven >= 0)
			return nextEven - firstOdd;
		else
			return -1;
	}
}