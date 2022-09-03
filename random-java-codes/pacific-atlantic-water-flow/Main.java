impo
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            dfs(pac,i,0,-1,heights);
            dfs(atl,i,heights[0].length-1,-1,heights);
        }
        for(int i = 0; i < m; i++) {
            dfs(pac,0,i,-1,heights);
            dfs(atl,heights.length-1,i,-1,heights);
        }
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(pac[i][j] && atl[i][j]) {
                    System.out.println(i+" "+j);
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }
        return list;
    }
    
    void dfs(boolean[][] oc, int i, int j, int last, int[][] arr) {
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) return;
        if(arr[i][j] < last || oc[i][j]) return;
        oc[i][j] = true;
        dfs(oc,i-1,j,arr[i][j],arr);
        dfs(oc,i,j+1,arr[i][j],arr);
        dfs(oc,i+1,j,arr[i][j],arr);
        dfs(oc,i,j-1,arr[i][j],arr);
    }
}
