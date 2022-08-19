import java.util.*;
class Main{
    public static void main(String[] args) {
        int[][] arr = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.print(new Solution().maxRoom(arr));
    }
}

class Solution{
	public int maxRoom(int[][] arr){
		int n = arr.length;
		int[] start = new int[n];
		int[] end = new int[n];
		for(int i = 0; i < n; ++i){
			start[i] = arr[i][0];
			end[i] = arr[i][1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int i = 1, j = 0, curr = 1, ans = 1;
		while(i < n && j < n){
			if(start[i] < end[j]){
			curr++;
			i++;
			} else {
			curr--;
			j++;
			}
		ans = Math.max(ans,curr);
		}
	return ans;
	
	}
}