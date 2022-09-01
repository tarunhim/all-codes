import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
public class Practice1 {
    public static void main(String[] args) {
        char[][] board = {{'C','A','P'},{'A','N','D'},{'T','I','E'}};
        String[] dictionary = {"CAT"};
        System.out.print(
            new Solution().
            wordBoggle(board, dictionary)
            );
    }
    
}
class Solution
{
    public String[] wordBoggle(char board[][], String[] dictionary)
    {   int n = board.length;
        int m = board[0].length;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                for(String str : dictionary) {
                    if(solve(board,str,i,j)) set.add(str);
                }
            } 
        }
        String[] ans = new String[set.size()];
        
        Iterator<String> it = set.iterator();
        int k = 0;
        while(it.hasNext()) {
            ans[k++] = it.next();
            System.out.print(ans.toString());
        }
       return ans;
    }
    boolean solve(char[][] board, String str, int i, int j) {
        if(str.length() == 0) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != str.charAt(0)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        int[] arr1 = {0,1,-1};
        int[] arr2 = {0,1,-1};
        for(int l : arr1) {
            for(int k : arr2) {
                if(l != 0 || k != 0) {
                    if(
                        solve(board,str.substring(1),i+l,j+k)
                        ) {
                        board[i][j] = temp;
                        return true;
                    }
                }
            }
        }
        board[i][j] = temp;
        return false;
    }
}