class Main
{
	public static void main(String[] args)
	{
		int[] arr = {4,2,1,4,3,4,5,8,15};
		int k = 3;
		System.out.println(new Solution().lengthOfLIS(arr,k));
	}
}

class Solution {
    
    public int lengthOfLIS(int[] nums, int k) {
       
        int max = 1;
        for(int num: nums) {
            max = Math.max(num, max);
        }
        // SegmentTree of array [0, 1, 2, 3, ..., max], length is max
        MaxSegmentTree seg = new MaxSegmentTree(max+1);
        int res = 1;
        for(int i=0;i<nums.length;i++) {
            int preMax = seg.query(Math.max(1, nums[i]-k), nums[i]-1);
            res = Math.max(res, preMax+1);
            seg.update(nums[i], preMax+1);
        }
        return res;
    }
}
class MaxSegmentTree {
        int[] seg;
        int n;
        public MaxSegmentTree(int n) {
            this.n = n;
            this.seg = new int[2*this.n];
        }
        // region [l, r]
        public int query(int l, int r) {
            l += this.n;
            r += this.n;
            int max = 0;
            while(l <= r) {
                if((l&1) == 1) {
                    max = Math.max(max, this.seg[l]);
                    l++;
                }
                if((r&1) == 0) {
                    max = Math.max(max, this.seg[r]);
                    r--;
                }
                l>>=1;
                r>>=1;
            }
            return max;
        }
        public void update(int i, int val) {
            i += this.n;
            this.seg[i] = val;
            while(i>1) {
                i >>= 1;
                this.seg[i] = Math.max(this.seg[i*2], this.seg[i*2+1]);
            }
        }
    }