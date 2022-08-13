import java.util.*;
class Main7 {
    static int max;
    public static void main(String[] args) {
        /*
         * Given 2 lists a and b. Each element is a pair of integers where the first integer 
         * represents the unique id and the second integer represents a value. 
         * Your task is to find an element from a and an element form b such that the sum of their 
         * values is less or equal to target and as close to target as possible.
         * Return a list of ids of selected elements. If no pair is possible, return an empty list.
         */
        int[][] a = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
        int[][] b = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        // int[][] a = {{1,4},{2,4},{3,6}};
        // int[][] b = {{1,2}};
        int k = 10;
        Arrays.sort(a,(v,c) -> c[1]-v[1]);
        Arrays.sort(b,(c,v) -> v[1]-c[1]);
        // for(int[] i : a) {
        //     System.out.print(i[0]+" "+i[1]+"  ");
        // }
        // System.out.println();
        // for(int[] i : b) {
        //     System.out.print(i[0]+" "+i[1]+"  ");
        // }
        List<List<Integer>> list = new ArrayList<>();
        max = 0;
        solve(list,a,b,k,0,0);
        System.out.print(list);
    }
    static void solve(List<List<Integer>> list, int[][] arr1, int[][] arr2,int k,int index1, int index2) {
        if(index1 >= arr1.length || index2 >= arr2.length) return;
        if(arr1[index1][1]+arr2[index2][1] < max) return;
        
        if(arr1[index1][1]+arr2[index2][1] <= k) {
            if(arr1[index1][1]+arr2[index2][1] > max) {
                list.clear();
                max = arr1[index1][1]+arr2[index2][1];
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(arr1[index1][0]);
                temp.add(arr2[index2][0]);
                list.add(temp);
            } else {
                
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(arr1[index1][0]);
                temp.add(arr2[index2][0]);
                list.add(temp);
            }
        }
        solve(list,arr1,arr2,k,index1+1,index2);
            solve(list,arr1,arr2,k,index1,index2+1);
    }
}