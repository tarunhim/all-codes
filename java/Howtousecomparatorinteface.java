

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Howtousecomparatorinteface {

    public static void main(String[] args) {
       int[] arr = {1,3,5,2,6,3,5,6,3,2,5,2,5,3,25,23,523,4};
       Map<Integer,Integer> map = new HashMap<>();
       for(int i : arr) {
           map.put(i, map.getOrDefault(i,0)+1);
       }
       Integer[] arr1 = new Integer[arr.length];
       int j = 0;
       for(int i : arr) {
        arr1[j++] = i;
       }
       Arrays.sort(arr1, new Comparator<Integer>() {
           public int compare(Integer a, Integer b) {
               if(map.get(a) != map.get(b)) return map.get(a) - map.get(b);
                else
                return a-b;
           }
       });
       j = 0;
       for(Integer i : arr1) {
           arr[j++] = i;
       }
       for(int i : arr) {
           System.out.print(i+" ");
       }

    }
}