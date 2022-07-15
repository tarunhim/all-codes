import java.util.*;
public class Practice2 {
    public static void main(String[] args) {
        int arr1[] = { 5, 9, 9, 10 };
        int arr2[] = { 10, 13, 15 }; // mergeArr={5,9,10,13,15}
        int n = arr1.length;
        int m = arr2.length;

        sortTwoArray(arr1, arr2, n, m);
    }

    static void sortTwoArray(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (!arr.contains(arr1[i])) {
                    arr.add(arr1[i]);
                    
                }
                i++;
            } else {
                if (!arr.contains(arr2[j])) {
                    arr.add(arr2[j]);
                    
                }
                j++;
            }
        }
        while (i < n) {
            if (!arr.contains(arr1[i])) {
                arr.add(arr1[i]);
            
            }
            i++;
        }
        while (j < m) {
            if (!arr.contains(arr2[j])) {
                arr.add(arr2[j]);
            
            }
            j++;
        }
        for (int k = 0; k < arr.size(); k++) {
            System.out.print(arr.get(k)+" ");
        }
    }
}