import java.util.*;
class Main{
    public static void main(String[] args) {
        String[] str = {"mobile","mouse","moneypot","monitor","mousepad"};
        String s = "mouse";
        System.out.print(new Solution().suggestedProducts(str, s));
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list = new ArrayList();
        // PriorityQueue<String> pq = new PriorityQueue<>();
        // for(String i : products){
        //     pq.offer(i);
        // }
        Arrays.sort(products);
        int n = searchWord.length();
        for(int i = 0; i < n; ++i) {
            String filter = searchWord.substring(0,i+1);
            List<String> temp = new ArrayList<>();
            int m = products.length;
            int count = 0;
            for(String k : products) {
                if(k.startsWith(filter) && count < 3) {
                  temp.add(k);
                    count++;
                } 
            }
            list.add(temp);
        }
        // Trie root = createTrie(products);
        
        // Arrays.sort(products);
        // for(int i = 1; i <= searchWord.length(); ++i) {
        //     list.add(solve(products,searchWord.substring(0,i)));
        // }
        // return list;
        // System.out.print(list);
        // solve(root,searchWord,list);
        // System.out.print(list);
        return list;
    }
    // void solve(Trie root, String searchWord,List<List<String>> list) {
    //     Trie p = root;
    //     for(char c : searchWord.toCharArray()) {
    //         int i = c-' ';
    //         if(p.next[i] != null) {
    //         p = p.next[i];
    //         List<String> temp = p.list;
    //         Collections.sort(temp);
    //         while(temp.size() > 3) {
    //             temp.remove(temp.size()-1);
    //         }
    //             System.out.print("is not working");
    //         list.add(temp);
    //         } else list.add(new ArrayList<String>());
    //     }
    // }
    // List<String> solve(String[] arr, String cop) {
    //     List<String> list = new ArrayList<>();
    //     int n = cop.length();
    //      for(int i = 0; i < arr.length; ++i) {
    //          if(arr[i].length() >= cop.length() && arr[i].substring(0,n).equals(cop)) {
    //              list.add(arr[i]);
    //              if(list.size() >= 3) {
    //                  break;
    //              }
    //          }
    //      }
    //     return list;
    // }
    Trie createTrie(String[] word) {
        Trie root = new Trie();
        for(String w : word) {
            Trie p = root;
            for(char c : w.toCharArray()) {
                int i = c-' ';
                if(p.next[i] == null) p.next[i] = new Trie();
                p = p.next[i];
                p.list.add(w);
            }
        }
        return root;
    }
}
class Trie{
    Trie[] next = new Trie[128];
    List<String> list = new ArrayList<>();
}