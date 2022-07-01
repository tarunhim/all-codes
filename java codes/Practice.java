import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
	static int min = 1000000000;
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int v = Integer.parseInt(str[0]);
		int e = Integer.parseInt(str[1]);
		ArrayList<Integer>[] adj = new ArrayList[v+1];
		for(int i = 0; i <= v; ++i) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < e; ++i) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			adj[a].add(b);
			adj[b].add(a);
		}
		boolean[] vis = new boolean[v+1];
		int[] dis = new int[v+1];
		for(int i = 1; i <= v; ++i) {
			if(!vis[i]) dfs(adj,vis,dis,i,-1,0);
		}
		System.out.print(min);
    }
	static void dfs(ArrayList<Integer>[] adj,boolean[] vis, int[] dis, int src, int prev, int h) {
		vis[src] = true;
		dis[src] = h;
		for(int i : adj[src]) {
			if(i == prev) continue;
			if(vis[i]) {
				min = Math.min(min,Math.abs(dis[src]-dis[i])+1);
			} else {
				dfs(adj,vis,dis,i,src,h+1);
			}
		}
	}
}