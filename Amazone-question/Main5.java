class Main5 {
    public static void main(String[] args) {
        /*
            * There are a total of n piles of products.
            The number of products in each pile is represented by the array nums.
            Select any subarray from the array nums and pick up products from that subarray such that the number of the products you pick from the ith pile is strictly less the than the number of the products you pick from the (i+1)th pile for all the indices i of the subarray.

            Example
            nums [7,4,5,2,6,5]
            Choose subarray from indices (1,3) and pick products [3,4,5] respectively from each index, which is 12 products. Note that we are not forced to pick only 3 products from the index 1 as the maximum number of the products we can pick from index 2 is 4 and we need to make sure it is greater than the number of the products picked from index 1.

            indices (3,6) [1,2,4,5] = 12
            indices (3,5) = [1,26] = 9
            indices (1,1) = 7
         */

        int[] arr = {7,4,5,2,6,5};
        int n = arr.length;
        int ans = arr[n-1];
        int max = ans;
        int last = ans;

        for(int i = n-2; i >= 0; --i) {
            if(arr[i] > arr[i+1]) {
                if(arr[i] > ans+arr[i+1]-1) {
                    ans = arr[i];
                    last = arr[i];
                } else {
                    ans += last-1;
                    last = last-1;
                }
            } else {
                if(last == 1) {
                    ans = arr[i];
                    last = arr[i];
                } else {
                    ans += Math.min(last-1,arr[i]);
                    last = Math.min(last-1,arr[i]);
                }
            }
            max = Math.max(max,ans);
        }
        System.out.print(max);
    }
}