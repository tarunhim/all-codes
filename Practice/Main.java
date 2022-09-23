import java.util.*;
import java.io.*;
public class Main 
{

	public static void main(String[] args) 
	{
		Integer[] arr = {4,2,5,2,3,6,1};
		Arrays.sort(arr,new Comparator<Integer>(){
			public int compare(Integer a, Integer b)
			{
				return a-b;
			}
		});
		System.out.println(Arrays.toString(arr)); 
	}
}

