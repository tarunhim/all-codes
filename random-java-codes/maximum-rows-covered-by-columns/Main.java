class Main{
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{1,0,1},{0,1,1},{0,0,1}};
        int cols = 2;
        System.out.print(new Solution().maximumRows(mat,cols));
    
    }
}


class Solution{
	public int maximumRows(int[][] mat, int cols){
		return solve(mat,new boolean[mat[0].length],0,cols);
	}
	int solve(int[][] mat,boolean[] arr, int i, int cols){
		if(i >= mat[0].length || cols <= 0) return 0;
		arr[i] = true;
		int count = 0;
		if(cols == 1){
			for(int[] row : mat){
				boolean flag = true;
				for(int j = 0; j < row.length; ++j){
					if(arr[j]) continue;
					if(row[j] == 1){
						flag = false;
						break;
					}
				}
				if(flag){count++;}
			}
		}
		int with = solve(mat,arr,i+1,cols-1);
		arr[i] = false;
		int without = solve(mat,arr,i+1,cols);
		return Math.max(count,Math.max(with,without));
	}
}
