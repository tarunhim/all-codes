import java.util.*;
import java.io.*;
public class Main3 {

    public static void main(String[] args) {
        
        int n = 5;
        List<List<Integer>> list = new ArrayList<>();
        solve(list,n,0,new ArrayList<Integer>());
        System.out.print(list);
        
    }
    static void solve(List<List<Integer>> list, int n,int sum, List<Integer> curr) {
        if(sum > n)  return;
        if(n == sum) {
            list.add(new ArrayList<Integer>(curr));
            return;
        }
        int start = curr.size()==0 ? 1 : curr.get(curr.size()-1);
        for(int i = start; i < n; ++i) {
            curr.add(i);
            solve(list,n,sum+i,curr);
            curr.remove(curr.size()-1);
        }

    }
    
}
