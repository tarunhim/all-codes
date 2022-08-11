import java.util.*;
class Lambda{
    public static void main(String[] args) {
        // int[][] arr = {{2,8},{3,2},{6,0},{4,9}};
        // Arrays.sort(arr,(a,b) -> a[1]-b[1]);
        // for(int[] i: arr) {
        //     System.out.println(i[0]+" "+i[1]);
        // }


        ArrayList<Pair> list = new ArrayList<>();
        list.add(new Pair(2,8));
        list.add(new Pair(3,2));
        list.add(new Pair(6,0));
        list.add(new Pair(4,9));

        // lmbda way of doing it
        // Collections.sort(list, (a,b) -> a.a-b.a);

        Collections.sort(list, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return b.b - a.b;
            }
        });


        for(Pair i : list) {
            System.out.println(i.a+" "+i.b);
        }


    }
}
class Pair implements Comparable<Pair> {
    int a;
    int b;
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int compareTo(Pair that) {
        return this.a - that.a;
    }
}