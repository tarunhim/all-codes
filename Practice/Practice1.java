import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Practice1 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int e = Integer.parseInt(str[1]);
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < e; ++i) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            adj[a].add(b);
            adj[b].add(a);
        }
        Set<Integer> set = new HashSet<>();
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; ++i) {
            if(!vis[i]) {
                solve(i,-1,adj,vis,set);
            }
        }
        System.out.print(set.size());

    }
    static boolean solve(int src, int prev, ArrayList<Integer>[] adj, boolean[] vis,Set<Integer> set) {
        vis[src] = true;
        boolean flag = false;
        for(int i : adj[src]) {
            if(i != prev) {
                if(!vis[i]) {
                    flag = flag || solve(i,src,adj,vis,set);
                } else {
                    flag = true;
                }
            }
        }
        if(flag) set.add(src);
        return flag;
    }
}