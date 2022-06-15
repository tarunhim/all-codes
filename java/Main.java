


import java.util.*;
import java.io.*;
class Main {
   public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int Y = Integer.parseInt(br.readLine());
		String[] str = br.readLine().trim().split(" ");
		 int[] arr = new int[N];
		 Map<Integer,String> map = new HashMap<>();
		 String[] str1 = br.readLine().trim().split(" ");
		 for(int i = 0; i < N; ++i) {
		     arr[i] = Integer.parseInt(str1[i]);
		     map.put(arr[i],str[i]);
		 }
		 Arrays.sort(arr);
		 System.out.print("The winner is "+map.get(arr[arr.length-1]));
		 for(int i = 0; i <= 2; ++i) {
		     System.out.print(i+"st Place = "+map.get(arr[arr.length-1-i])+" got "+arr[arr.length-1-i]+"-points,");
		 }
		 
	}
}