package java;

import java.util.*;

class ListNode {
    ListNode head;
    int val;
    ListNode next;

    ListNode () {}
    ListNode(int val) {
        this.val = val;
        next = null;
    }
    ListNode(int val,ListNode node) {
        this.val = val;
        next = node;
    }
    void add(int val) {
        if(head == null) {
            head = new ListNode(val);
            return;
        }
        ListNode node = head;
        while(node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(val);
    }
    void print() {
        if(head == null) {
            System.out.println("list is empty");
            return;
        }
        ListNode node = head;
        while(node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
    void reverseK(int k) {
        ListNode node = this.head;
        Queue<ListNode> q = new LinkedList<>();

        int count = 0;
        ListNode prev = null;
        ListNode next = null;

        while(node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            count++;
            if(count == k || node == null) {
                q.add(prev);
                prev = null;
                count = 0;
            }
        }
        this.head = q.peek();
        ListNode curr = new ListNode(0);
        while(!q.isEmpty()) {
            curr.next = q.remove();
            while(curr.next != null) {
                curr = curr.next;
            }
        }
    }
    public static void main(String[] args) {
        ListNode node = new ListNode();
        for(int i = 1; i <= 10; ++i) {
            node.add(i);
        }
        node.reverseK(3);
        node.add(1);
        node.print();
    }
}