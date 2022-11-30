import java.util.*;
import java.io.*;

class ListNode{
	int val;
	ListNode next;
	ListNode(){

	}
	ListNode(int val) {
		this.val = val;
	}
	

}


class Solution {
    public ListNode removeNodes(ListNode head) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        return solve(head,pq);
    }
    ListNode solve(ListNode head, PriorityQueue<Integer> pq) {
        if(head == null) {
            return null;
        }

        ListNode next = solve(head.next,pq);
        if(pq.size() > 0 && pq.peek() > head.val) {
            return next;
        }
        pq.offer(head.val);
        head.next = next;
        return head;
    }
}
class Main
{
	public static void main(String[] args)
	{



		for(int i = 0; i < 10; ++i)
		System.out.println(i);
	}
}
