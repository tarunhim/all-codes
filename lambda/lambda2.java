import java.util.*;
import java.util.stream.Stream;
public class lambda2 {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        // list.forEach((n) -> System.out.print(n+" "));
        Stream<Integer> filer = list.stream().filter((n) -> n%2 == 0);
        filer.forEach(n -> System.out.print(n+" "));
    }
    
}
