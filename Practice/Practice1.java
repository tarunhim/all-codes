import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

class Test {
public static void swap(Integer i, Integer j) {
     Integer temp = new Integer(i);
     i = j;
     j = temp;
  }
  public static void main(String[] args) {
     Integer i = new Integer(10);
     Integer j = new Integer(20);
     swap(i, j);
     System.out.println("i = " + i + ", j = " + j);
  }
}