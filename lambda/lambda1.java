interface Drawable{  
    // public void draw();  
    public void draw(int a, int b);
}  
class LambdaExpressionExample {  
    public static void main(String[] args) {  
        int width=10;  
  
        //without lambda, Drawable implementation using anonymous class  
        // Drawable dra = () -> System.out.print(width);
        // dra.draw();
        Drawable dra2 = (a, b) -> System.out.print(a+b);
        dra2.draw(10,20);
        
    }  
} 