import java.util.*;
interface Drawable{  
    // public void draw();  
    public void draw(int a, int b);
    // public void draw1();
}  
class LambdaExpressionExample {  
    public static void main(String[] args) {  
        int width=10;  
  
        //without lambda, Drawable implementation using anonymous class  
        // Drawable dra = () -> System.out.print(width);
        // dra.draw();
        Drawable dra2 = (a, b) -> System.out.print(a+b);
        // dra2 = () -> System.out.print("dkfjkd");
        dra2.draw(10,20);
        
    }  
} 