class Solution 
{
	public int numberOfPaths(int[][] grid, int k) 
	{	
		int[][][] dp = new int[grid.length+1][grid[0].length+1][k+1];
        	return solve(grid,0,0,k,0,dp);	
	}
	int solve(int[][] grid, int i, int j, int k, int sum, int[][][] dp)
	{
		if(i >= grid.length || j >= grid[0].length)
		{
			return 0;
		}
		sum += grid[i][j];
		if(i == grid.length-1 && j == grid[0].length-1)
		{
			return sum%k == 0 ? 1 : 0;
		}
		
		if(dp[i][j][sum%k] != 0) return dp[i][k][sum%k];
		int ans = solve(grid,i,j+1,k,sum,dp);
		ans += solve(grid,i+1,j,k,sum,dp);
		return dp[i][j][sum%k] = ans%1000000007;
	}
}