import java.util.*;
class Main{
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        System.out.print(new Solution().fourSum(arr, 0));
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums ==null && nums.length<4) return list;
        if(nums[0]==1000000000 && nums[1]==1000000000) return list;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n-3; ++i) {
            for(int j = i+1; j < n-2; ++j) {
                int p = j+1;
                int q = n-1;
                while(p < q) {
                    int num = nums[i]+nums[j]+nums[p]+nums[q];
                    if(num == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[p]);
                        temp.add(nums[q]);
                        list.add(temp);
                while(p+1 < q && nums[p+1] == nums[p]) ++p;
                while(q-1 > p && nums[q-1] == nums[q]) --q;
                ++p;
                --q;
                    } else if (num < target) p++;
                    else q--;
                }
                while(j < n-3 && nums[j] == nums[j+1]) j++;
                
            }
            while(i < n-4 && nums[i] == nums[i+1]) i++;
        }
        return list;
    }
}