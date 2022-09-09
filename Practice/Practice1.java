import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

class Practice1{
	public static void main(String[] args){
		int[] arr = {1,2,3,3,-4,4};
		int k = 6;
		int ans = solve(arr,0,k);
		System.out.println(ans);
	}
	static int solve(int[] arr, int index, int k){
		int ret = 0;
		System.out.println(k);
		if(k == 0) ret++;
		if(index >= arr.length) return ret;
		
		int with = solve(arr,index+1,k-arr[index]);
		int without = solve(arr, index+1,k);
		
		return ret+with+without;
	}
}