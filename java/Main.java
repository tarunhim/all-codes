import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
	public static void main (String[] args) {
        // ["bags","baggage","banner","box","cloths"]
        // "bags"
		String[] arr = {"bags","baggage","banner","box","cloths"};
		String str = "bags";
		System.out.print(new Solution().suggestedProducts(arr, str));
	}
	
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list = new ArrayList();
        Arrays.sort(products);
        for(int i = 1; i <= searchWord.length(); ++i) {
            list.add(solve(products,searchWord.substring(0,i)));
        }
        return list;
    }
    List<String> solve(String[] arr, String cop) {
        List<String> list = new ArrayList<>();
        int n = cop.length();
         for(int i = 0; i < arr.length; ++i) {
             if(arr[i].length() >= cop.length() && arr[i].substring(0,n).equals(cop)) {
                 list.add(arr[i]);
                 if(list.size() >= 3) {
                     break;
                 }
             }
         }
        return list;
    }
}