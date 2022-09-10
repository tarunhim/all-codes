import java.util.*;
import java.io.*;

class Main
{
	public static void main(String[] args)
	{	
		AdderII ad = new AdderII();
		int ans = ad.add(1,1);
		System.out.print(ans);
	}
}
// ient you interface here
interface Adder
{
    public int add();
    public int add(int a, int b);
    public int add(int a, int b, int c);
}

class AdderII implements Adder
{
    int num1;
    int num2;
    AdderII()
    {
        num1 = 0;
        num2 = 0;
    }
    AdderII(int a, int b)
    {
        num1 = a;
        num2 = b;
    }
    public int add(int a, int b, int c)
    {
        return num1*a+num2*b-c*c;
    }
    public int add()
    {
        return num1+num2;
    }
    public int add(int a, int b)
    {
        return (a*a)+(b*b);
    }
}