import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        char[][] board = {{'C','A','P'},
                            {'A','N','D'},
                        {'T','I','E'}};
        String[] dictionary = {"CAT"};
        System.out.print(Arrays.toString(new Solution().wordBoggle(board, dictionary)));
    }
}

class Solution
{
    public String[] wordBoggle(char board[][], String[] dictionary)
    {   List<String> list = new ArrayList<>();
        Trie root = createTrie(dictionary);
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                solve(board,list,root,i,j);
            }
        }
        return list.toArray(new String[list.size()]);
            
    
    }
    void solve(char[][] board, List<String> list, Trie root, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == ' ' || root.next[board[i][j]-' '] == null) return;
        char c = board[i][j];
        root = root.next[c-' '];
        if(root.word != null) {
            list.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';
        int[] arr1 = {-1,0,1};
        int[] arr2 = {-1,0,1};
        for(int k : arr1) {
            for(int l : arr2) {
                if(k != 0 || l != 0) {
                    solve(board,list,root,i+k,j+l);
                }
            }
        }
        board[i][j] = c;
    }
    Trie createTrie(String[] word) {
        Trie root = new Trie();
        for(String w : word) {
            Trie p = root;
            for(char c : w.toCharArray()) {
                int i = c-' ';
                if(p.next[i] == null) p.next[i] = new Trie();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
}
class Trie {
    Trie[] next = new Trie[128];
    String word;
}