import java.util.*;
public class Main4 {

    public static void main(String[] args) {
        int[][] arr = {{5,10},{2,5},{4,7},{3,9}};
        int n = 10;
        // Arrays.sort(arr,new Comparator<int[]>() {
        //     public int compare(int[] a,int[] b) {
        //         return b[1] - a[1];
        //     }
            
        // });
        Arrays.sort(arr,(a,b) -> b[1]-a[1]);
        int sum = 0;
        for(int[] i : arr) {
            if(n > 0) {
                if(i[0] <= n) {
                    sum += i[0]*i[1];
                    n = n-i[0];
                } else {
                    sum += i[1]*n;
                    n = 0;
                }
            }
        }
        System.out.print(sum);

    }
    
}
