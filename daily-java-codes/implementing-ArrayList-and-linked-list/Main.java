import java.util.*;

class Main
{
	public static void main(String[] args)
	{
		// AL list = new AL();
		// list.add(1);
		// list.add(2);
		// list.add(3);
		// list.add(4);
		// list.add(5);
		// list.add(6);
		// list.add(7);
		// list.remove(2);

		// for(int i = 0; i < list.size; ++i) {
		// 	System.out.println(list.get(i));
		// }

		LL l = new LL();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.remove(5);
		l.print();
		// System.out.println(l.get(4));

		
    }
}
class Node{
	Node next;
	int val;
	Node(int val) 
	{
		this.val = val;
	}
}
class LL{
	Node head;
	
	int size = 0;
	void add(int val) {
		if(head == null) {
			head = new Node(val);
			size++;
			return;
		}
		Node node = head;
		head = new Node(val);
		head.next = node;
		size++;
	}
	void remove(int val)
	{
		int n = val;
		if(head == null || n > size) return;

		if(n == 1) {
			head = head.next;
			return;
		}
		Node node = head;
		while(n-- > 2) {
			node = node.next;
		}
		node.next = node.next.next;
	}


	int get(int n)
	{
		if(head == null || n > size) return -1;
		Node node = head;
		while(n-- > 1) {
			node = node.next;
		}
		return node.val;
	}
	void print()
	{
		Node node = head;
		while(node != null) 
		{
		System.out.print(node.val+" ");
		node = node.next;
		}
		System.out.println();
	}
}

class AL{
	int[] arr;
	int size;
	int cap = 5;
	AL() {
		arr = new int[cap];
		size = 0;
	}
	void add(int val) {
		arr[size] = val;
		size ++;
		if(size >= cap-1) {
			dbl();
		}
	}
	int get(int i) {
		return arr[i];
	}
	void remove(int j) {
		for(int i = j; i < cap-1; ++i)  {
			arr[i] = arr[i+1];
		}
		size--;
	}
	void dbl() {
		cap *= 2;
		int[] temp = new int[cap];
		int i = 0;
		for(int j : arr) {
			temp[i++] = j;
		}
		this.arr = temp;
	}
}