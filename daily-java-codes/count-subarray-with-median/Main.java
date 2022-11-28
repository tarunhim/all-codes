class Solution {
    public int countSubarrays(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int count = 0;
        boolean flag = false;
        int ans = 0;
        for(int i : nums) {
            if(i < k) {
                count--;
            } else if(i > k) {
                count++;
            } else {
                flag = true;
            }
            if(flag) {
                ans += map.getOrDefault(count,0) + 
map.getOrDefault(count-1,0);
            } else {
                map.put(count,map.getOrDefault(count,0)+1);
            }
        }
        return ans;
    }
}

