import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
public class Practice1 {
    public static void main(String[] args) {
        char[][] board = {{'C','A','P'},{'A','N','D'},{'T','I','E'}};
        String[] dictionary = {"CAT"};
        System.out.print(new Solution().wordBoggle(board, dictionary));
    }
    
}
class Solution
{
    public String[] wordBoggle(char board[][], String[] dictionary)
    {   int n = board.length;
        int m = board[0].length;
        Map<Character,ArrayList<int[]>> map = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                char a = board[i][j];
                if(map.containsKey(a)) 
            map.put(a,);
            System.out.println(map.get(a));
            }
        }
        return new String[] {"ksh"};
    }
}