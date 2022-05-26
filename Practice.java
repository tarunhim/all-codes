import java.util.*;
import java.io.*;

class BFS{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str1 = br.readLine();
        System.out.print(solve(str,str1));
    }
    static int solve(String from, String to) {
        Pair start = pair(from);
        Pair end = pair(to);
        int[][] dir = {{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
        boolean[][] visited = new boolean[8][8];
        Queue<Pair> q = new LinkedList<>();
        int level = 1;
        q.add(start);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Pair temp = q.remove();
                for(int[] i : dir) {
                    int row = temp.x + i[0];
                    int col = temp.y + i[1];
                    if(row < 0 || row > 7 || col < 0 || col > 7 || visited[row][col] == true) {
                        continue;
                    } else {
                        if(row == end.x && col == end.y) return level;
                        q.add(new Pair(row, col));
                    }
                }
            }
            level++;
        }
            return 0;
    }
    static Pair pair(String str) {
        return new Pair(str.charAt(0)-'1', 7-(str.charAt(1)-'A'));
    }
}
class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}