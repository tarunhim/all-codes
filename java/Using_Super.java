

class Using_Super {
    int a;
    int b;

    // Main() {

    // }
    
    Using_Super(int a, int b) {
        this.a = a;
        this.b = b;
    }
    void call() {
        System.out.println("calling Main class method");
    }
}
class Using_Super1 extends Using_Super {
    int c;
    
    Using_Super1(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }
    void call() {
        super.call();
        System.out.println("calling Main1 class method");
        super.call();
    }
}

class Main2 {

    public static void main(String[] args) {
        Using_Super1 mm = new Using_Super1(1,2,3);
        // mm.call();
        Using_Super nn;
        nn = mm;
        nn.call();
    

    }
}