import java.util.*;
class Main{
    public static void main(String[] args) {
        int[][] row = {{1,2},{3,2}};
        int[][] col = {{3,2},{2,1}};
        System.out.print(Arrays.toString(new Solution().buildMatrix(3, row, col)));
    }
}

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer>[] row = new ArrayList[k+1];
        for(int i = 0; i < row.length; ++i) {
            row[i] = new ArrayList<Integer>();
        }
        for(int[] i : rowConditions) {
            row[i[0]].add(i[1]);
        }
        int[] rows= sort(row);
        List<Integer>[] col = new ArrayList[k+1];
        for(int i = 0; i < row.length; ++i) {
            col[i] = new ArrayList<Integer>();
        }
        for(int[] i : colConditions) {
            col[i[0]].add(i[1]);
        }
        int[] cols = sort(col);
        System.out.println(Arrays.toString(rows));
        System.out.print(Arrays.toString(cols));
        if(isCycle(row,rows) || isCycle(col,cols)) return new int[][]{};
        
        int[][] ans = new int[k][k];
        for(int i = 0; i < rows.length; ++i) {
            for(int j = 0; j < cols.length; ++j) {
                if(rows[i] == cols[j]) {
                    ans[i][j] = rows[i];
                }
            }
        }
        return ans;
        
    }
    boolean isCycle(List<Integer>[] adj, int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; ++i) {
            map.put(arr[i],i);
        }
        for(int i = 1; i < adj.length; ++i) {
            for(int j : adj[i]) {
                if(map.get(i) > map.get(j))  {
                    System.out.print(i+" "+j+" "+map.get(i)+" "+map.get(j)+" ");
                    return true;
                }
            }
        }
        return false;
    }
    
    int[] sort(List<Integer>[] adj) {
        boolean[] vis = new boolean[adj.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 1; i < adj.length; ++i) {
            if(!vis[i]) {
                sortH(i,vis,adj,st);
            }
        }
        int[] ans = new int[st.size()];
        int n = 0;
        while(!st.isEmpty()) {
            ans[n++] = st.pop();
        }
        return ans;
                
    }
    void sortH(int src,boolean[] vis, List<Integer>[] adj,Stack<Integer> st) {
        vis[src] = true;
        for(int i : adj[src]) {
            if(!vis[i]) {
                sortH(i,vis,adj,st);
            }
        }
        st.push(src);
        
    }
}