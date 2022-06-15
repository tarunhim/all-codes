package java;

import java.util.LinkedList;
import java.util.Queue;

class LList{
	Node head;

	class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	void add(int x) {
		if(head == null) {
			head = new Node(x);
			return;
		}
		Node node = head;
		while(node.next != null) {
			node = node.next;
		}
		node.next = new Node(x);

	}
	static void print(LList m) {
		Node node = m.head;
		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	static LList merge(LList m, LList n) {
		Node n1 = m.head;
		Node n2 = n.head;
		Node head = null;
		if(n1.data < n2.data) {
			head = n1;
			n1 = n1.next;
		} else {
			head = n2;
			n2 = n2.next;
		}
		Node node = head;
		while(n1 != null && n2 != null) {
			if(n1.data < n2.data) {
				node.next = n1;
				n1 = n1.next;
				node = node.next;
			} else {
				node.next = n2;
				n2 = n2.next;
				node = node.next;
			}
		}
		while(n1 != null) {
			node.next = n1;
			n1 = n1.next;
			node = node.next;
		}
		while(n2 != null) {
			node.next = n2;
			n2 = n2.next;
			node = node.next;
		}
		LList main3 = new LList();
		main3.head = head;
		return main3;


	}
	static LList mergingk(LList[] main) {
		LList head = main[0];
		for(int i = 1; i < main.length; ++i) {
			head = merge(head,main[i]);
		}
		return head;
	}
	
	public static void main(String[] args) {
		LList main = new LList();
		for(int i = 1; i <= 10; ++i) {
			main.add(i);
		}
		print(main);
	}
}