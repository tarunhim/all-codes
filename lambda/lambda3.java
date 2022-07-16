public class lambda3 {
    public static void main(String[] args) {
        
        Pair arr[] = new Pair[5];
        arr[0] = new Pair(1,4);
        arr[1] = new Pair(5,3);
        arr[2] = new Pair(6,3);
        arr[3] = new Pair(2,9);
        arr[4] = new Pair(7,4);
        for(Pair i : arr) {
            System.out.println(i.a +" "+ i.b);
        }
    }
    
}

class Pair {
    int a;
    int b;
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
} 