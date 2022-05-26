import java.util.*;

class Graphs{
    ArrayList<Integer>[] adj;

    Graphs(int nodes) {
        adj = new ArrayList[nodes];
        for(int i = 0; i < nodes; ++i) {
            adj[i] = new ArrayList<Integer>();
        }
    }
    void addEdges(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }
    void dfs(int source) {
        boolean[] dp = new boolean[adj.length];
        dfsHelper(source,dp);
    }
    void dfsHelper(int source,boolean[] dp) {
        dp[source] = true;
        System.out.print(source+" ");

        for(int i: adj[source]) {
            if(!dp[i]) {
                dfsHelper(i, dp);
            }
        }
    }
    void bfs(int source) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] dp = new boolean[adj.length];
        q.add(source);
        dp[source] = true;
        while(!q.isEmpty()) {
            int temp = q.remove();
            
            System.out.print(temp+" ");
            for(int i : adj[temp]) {
                if(!dp[i]) {
                    q.add(i);
                    dp[i] = true;
                }
            }
        }
    }
}
class Test {
    public static void main(String[] args) {
        Graphs gr = new Graphs(5);
        gr.addEdges(0, 1);
        gr.addEdges(1, 2);
        gr.addEdges(2, 3);
        gr.addEdges(3, 1);
        gr.addEdges(3, 4);
        // gr.dfs(4);
        gr.bfs(0);
    }
}