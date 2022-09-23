import java.util.*;
import java.io.*;
public class Main 
{

	public static void main(String[] args) 
	{
		int[] arr = {4,2,5,2,3,6,1};
		Arrays.sort(arr,(a,b) -> a-b);
		System.out.println(Arrays.toString(arr)); 
	}
}

