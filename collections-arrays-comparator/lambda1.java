import java.util.*;

public class lambda1 { 
    public static void main(String[] args) {
        // PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.b - b.b);
        PriorityQueue<Pair> q = new PriorityQueue<>();
        // PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
        //     public int compare(Pair a, Pair b) {
        //         return a.a-b.a;
        //     }
        // });
        q.offer(new Pair(6,8));
        q.offer(new Pair(9,3));
        q.offer(new Pair(3,8));
        q.offer(new Pair(7,9));

        while(!q.isEmpty()) {
            Pair temp = q.poll();
            System.out.println(temp.a+" "+temp.b);
        }
    
    }
    
}
