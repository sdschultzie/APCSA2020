package Unit09;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.List;
import java.util.ArrayList;

public class ListSumFirst
{
	public static int go(List<Integer> ray)
	{
		int sum = 0;
		
		for(int i : ray) {
			if (i > ray.get(0))
				sum += i;
		}
		
		if (sum>0)
			return sum;
		else 
			return -1;
	}
}