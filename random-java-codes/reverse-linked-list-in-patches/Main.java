import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) {
    	Llist list = new Llist();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.print();
        list.reverse(5);
        list.print();
    }

}
class Llist{
    Node head;
    void reverse(int k) {
        Node node = head;
        Node temp = new Node(-1);
        Node ans = temp;
        while(node != null) {
            int t = k;
            Node temp2 = node;
            while(node != null && t-- > 0) {
                node = node.next;
            }
            temp.next = help(temp2,k);
            while(temp.next != null) temp = temp.next;

        }
        head = ans.next;


    }
    Node help(Node root, int k) {
        Node node = root;
        Node prev = null;
        Node next = null;
        while(node != null && k-- > 0) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    void add(int val) {
        if(head == null) {
            head = new Node(val);
            return;
        }
        Node node = head;
        while(node.next != null) {
            node = node.next;
        }
        node.next = new Node(val);
    }
    void print() {
        Node node = head;
        while(node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }

}

class Node{
    int val;
    Node next;
    Node(int val) {
        this.val = val;
    }
}