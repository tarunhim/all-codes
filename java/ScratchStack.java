package java;

class ScratchStack {
    int[] arr;
    int capacity;
    int size;

    ScratchStack() {
        capacity = 5;
        arr = new int[capacity];
        size = 0;
    }

    ScratchStack(int n) {
        arr = new int[n];
        capacity = n;
        size = 0;
    }

    void push(int data) {
        if(arr.length < capacity) {
            System.out.println("there is no space available");
            return;
        }
        if(size > capacity/2) {
            capacity = capacity*2;
        }
        arr[size] = data;
        size++;
    }
    int pop() {
        if(size == 0) {
            System.out.println("stack is empty");
            return -1;
        }
        int temp = arr[size-1];
        size--;
        return temp;
    }
    int peek() {
        if(size == 0) {
            System.out.println("stack is empty");
        }
        return arr[size-1];
    }
    void print() {
        if(size == 0) {
            System.out.println("stack is empty");
        }
        for(int i = 0; i < size; ++i) {
            System.out.print(arr[size-i-1] + " ");
        }
    }
    public static void main(String[] args) {
            ScratchStack main = new ScratchStack();
            System.out.println(main.capacity);
            main.push(8);
            main.push(9);
            System.out.println(main.capacity);
            main.push(7);
            System.out.println(main.capacity);


    }
}
