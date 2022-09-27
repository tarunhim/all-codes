class Solution 
{
    
	public int lengthOfLIS(int[] nums, int k) 
	{
        	int[] arr = new int[5];
		for(int i = 5; i > 0; i-)
		arr[5-i] = i;
		
		for(int i = 0; i < 5; i++)
		System.out.print(arr[i]);
	}
}
