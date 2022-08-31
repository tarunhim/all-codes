import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) {
        int[][] arr = {{0,1},{1,0}};
        int n = 2;
        System.out.print(new Solution().canFinish(n,arr));
    }
}





class Solution{
	public boolean canFinish(int n, int[][] arr){
		if(arr.length == 0) return true;
		ArrayList<Integer>[] adj = new ArrayList[n];
		for(int i = 0; i < n; ++i){
			adj[i] = new ArrayList<Integer>();
		}
		for(int[] i : arr){
			adj[i[1]].add(i[0]);
		}
		boolean[] vis = new boolean[n];
		boolean[] v = new boolean[n];
		for(int i = 0; i < n; ++i){
			if(!solve(i,adj,vis,v)){
					return false;
			}
		}
		return true;
	}
	boolean solve(int src, ArrayList<Integer>[] adj, boolean[] vis, boolean[] v){
		if(v[src]) return false;
        if(vis[src]) return true;
		
		
        vis[src] = true;
		v[src] = true;
		for(int i : adj[src]){
			if(!solve(i,adj,vis,v)){
				return false;
			}
		}
		v[src] = false;
		return true;
	}
}