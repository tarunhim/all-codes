import java.util.*;
class Main{
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = new Solution().merge(arr);
        for(int[] i : ans) System.out.print(i[0]+" "+i[1]+" ");
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int[] temp = intervals[0];
        ArrayList<int[]> list = new ArrayList<>();
        list.add(temp);
        for(int[] i : intervals) {
            if(temp[1] >= i[0]) {
                temp[1] = Math.max(temp[1],i[1]);
            } else {
                temp = i;
                list.add(temp);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}