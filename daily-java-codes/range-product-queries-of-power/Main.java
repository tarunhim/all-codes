class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        // int m = n;
        while(n > 0) {
            num1.add(n%2);
            n /= 2;
        }
        
        for(int i = 0; i < num1.size(); ++i) {
            if(num1.get(i) == 1) {
                num2.add((int)Math.pow(2,i));
            }
        }

        int[] ans = new int[queries.length];
        int k = 0;
        for(int[] i : queries) {
            long res = 1;
            for(int j = i[0]; j <= i[1]; j++) {
                res = (res*num2.get(j)%mod);
            }
            ans[k++] =(int)res%mod;
        }
        return ans;
    }
}
