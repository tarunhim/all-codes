
import java.util.*;
import java.io.*;
public class Practice {
    public static void main(String[] args) {
        String str = "catsanddog";
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("sand");
        list.add("and");
        list.add("dog");
        System.out.print(new Solution().wordBreak(str, list));
    }
    
}

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String i : wordDict) set.add(i);
        int n = s.length();
        List<String> list = new ArrayList<>();
        solve(s,set,0,"",list);
        return list;
    }
    void solve(String s, Set<String> set, int index, String ans,List<String> list) {
        if(index >= s.length()) {
            list.add(ans);
            return;
        }
        
        for(int i = index+1; i <= s.length(); ++i) {
            if(set.contains(s.substring(index, i))) {
                solve(s, set,i,ans+s.substring(index,i)+" ",list);
            }
        }
    }
    
}