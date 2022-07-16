import java.util.*;

public class lambda3 {
    public static void main(String[] args) {
        
        
        List<Pair> list = new ArrayList<>();
        list.add(new Pair("a","b"));
        list.add(new Pair("b","g"));
        list.add(new Pair("z","n"));
        list.add(new Pair("r","e"));
        Collections.sort(list,(p1,p2)->{  
            return p1.b.compareTo(p2.b);  
            });
            list.forEach(n -> System.out.println(n.a+" "+n.b));
    }
    
}

class Pair {
    String a;
    String b;
    Pair(String a, String b) {
        this.a = a;
        this.b = b;
    }
} 