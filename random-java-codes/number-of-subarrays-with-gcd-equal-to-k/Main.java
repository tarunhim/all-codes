class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int total = 0;
        for(int i = 0; i < nums.length; ++i) {
            int curr = 0;
            for(int j = i; j < nums.length; ++j) {
                curr = gcd(curr,nums[j]);
                total += ((curr == k) ? 1 : 0);

            }
        }
        
        return total;
    }
    int gcd(int a, int b) {
       if(b == 0) return a;
       return gcd(b,a%b);
    }
}
