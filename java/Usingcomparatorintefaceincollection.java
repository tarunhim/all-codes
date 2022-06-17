

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Usingcomparatorintefaceincollection {

    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,3,4,5,5,5,6,7,7,8,88,8,8,8,8,9};
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : arr) {
            map.put(i,map.getOrDefault(i, 0)+1);
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                if(map.get(a) != map.get(b)) return map.get(b)-map.get(a);
                else 
                    return b-a;
                
            }
        });
        for(Integer i : list) {
            System.out.print(i+" ");
        }
    }
    
}
