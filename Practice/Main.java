class Solution 
{
    
	public int lengthOfLIS(int[] nums, int k) 
	{
        	int n = nums.length;
		int mValue = 0;
		for(int i : nums) mValue = Math.max(mValue,i);
		ST st = new ST(mValue+1);
		int ans = 0;
		for(int i = 0; i < n; ++i)
		{
			int temp = st.qr(Math.max(1,nums[i]-k),nums[i]-1);
			st.update(nums[i],temp+1);
			ans = Math.max(ans,1+temp);
		}
		return ans;
	}
}

class ST
{
	int n;
	int[] arr;
	ST(int n)
	{
		this.n = n;
		arr = new int[n*2];
	}
	int qr(int l, int r)
	{
		l += n;
		r += n;
		int max = 0;
		while(l <= r)
		{
			if((l&1) == 1)
			{
				max = Math.max(max,arr[l]);
				l++;
			}
			if((r&1) == 1)
			{
				max = Math.max(max,arr[r]);
				r--;
			}
			l >>= 1;
			r >>= 1;
		}
		return max;
	}
	void update(int index, int val)
	{
		index += n;
		arr[index] = val;
		while(index > 1)
		{
			index >>= 1;
			arr[index] = Math.max(arr[index*2],arr[index*2+1]);
		}
	}
}