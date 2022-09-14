class Main
{
	public static void main(String[] args)
	{
		int[] arr = {10, 30, 5, 60};
		System.out.print(solve(arr,0,arr.length-1));
		
	}
	public static int solve(int[] arr, int i, int j)
	{	
		if(j <= i+1) return 0;

		int min = Integer.MAX_VALUE;
		
		for(int k = i+1; k < j; ++k)
		{
			int count = solve(arr,i,k);
			count += solve(arr,k,j);
			count += arr[i]*arr[k]*arr[j];
			min = Math.min(min,count);
		}
		return min;
	}
}
