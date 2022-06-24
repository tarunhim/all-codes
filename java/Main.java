import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
	public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			String str1 = br.readLine();
			String str2 = br.readLine();
			System.out.println(solve(str1,str2,0,0));
		}
	}
	static int solve(String str1, String str2, int index1, int index2) {
		if(index1 == str1.length() || index2 == str2.length()) return 0;
		if(str1.charAt(0) == str2.charAt(0)) return 1+solve(str1,str2,index1+1, index2+1);
		int num1 = solve(str1,str2,index1+1,index2);
		int num2 = solve(str1,str2,index1, index2+1);
		return Math.max(num1,num2);
	}
}