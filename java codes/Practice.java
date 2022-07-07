// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        int n = arr.length;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < n; ++i) {
            while(stack.peek() != -1 && arr[i] <= arr[stack.peek()]) {
                int temp = stack.pop();
                max = Math.max(max,arr[temp]*(i-stack.peek()-1));
                
            }
            stack.push(i);
        }
        System.out.print(max);
    }
//      public static int largestRectangleArea(int[] heights) {
//   Stack < Integer > stack = new Stack < > ();
//   stack.push(-1);
//   int length = heights.length;
//   int maxArea = 0;
//   for (int i = 0; i < length; i++) {
//      while ((stack.peek() != -1) &&
//       (heights[stack.peek()] >= heights[i])) {
//       int currentHeight = heights[stack.pop()];
//       int currentWidth = i - stack.peek() - 1;
//       maxArea = Math.max(maxArea, currentHeight * currentWidth);
//      }
//      stack.push(i);
//   }
//   while (stack.peek() != -1) {
//      int currentHeight = heights[stack.pop()];
//      int currentWidth = length - stack.peek() - 1;
//      maxArea = Math.max(maxArea, currentHeight * currentWidth);
//   }
//   return maxArea;
//  }
}