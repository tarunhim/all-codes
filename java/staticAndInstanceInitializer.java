package java;

class staticAndInstanceInitializer {

    int num1 = 2;
    int num2 = 3;
    staticAndInstanceInitializer() {
        System.out.println("this is the constructer");
    }
    static {
        System.out.println("this is static intializer");
        staticAndInstanceInitializer main = new staticAndInstanceInitializer();
        System.out.println(main.num1);
        System.out.println(main.num2);
        
    }
    {
        num1 = 4;
        num2 = 5;
        System.out.println("this is instance initializer");
    }
    public static void main(String[] args) {
        System.out.println("this is main");
    }
}
class Comp extends staticAndInstanceInitializer {

    Comp() {
        super();
    }

    static {
        // Comp comp = new Comp();
        // System.out.print(comp.num1);
    }
    public static void main(String[] args) {
        Comp comp1 = new Comp();

    }
}