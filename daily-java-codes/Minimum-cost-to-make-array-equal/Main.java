class Solution {
    public long minCost(int[] nums, int[] cost) {
        long left = 1L;
        long right = 10000000L;
        for(int num : nums){
            left = Math.min(num,left);
            right = Math.max(num,right);
        }
        long ans = solve(nums,cost,1);
        while(left < right) {
            long mid = (left+right)/2;
            long x = solve(nums,cost,mid);
            long y = solve(nums,cost,mid+1);
            if(x < y) right = mid;
            else left = mid+1;
            ans = Math.min(x,y);
        }
        return ans;
    }
    long solve(int[] nums, int[] cost, long x) {
        long ans = 0;
        for(int i = 0; i < nums.length; ++i){
            ans += Math.abs(nums[i]-x)*cost[i];
        }
        return ans;
    }
}
