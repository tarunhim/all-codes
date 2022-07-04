import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
	public static void main (String[] args) {
       LinkedList<Integer> list = new LinkedList<>();
	   list.offer(3);
	   list.offer(5);
	   list.offer(7);
		for(int i : list) System.out.print(i+" ");
	   
	}
}