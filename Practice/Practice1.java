// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Practice1{
    public static void main(String[] args) {
        ListNode root1 = new ListNode(4);
        root1.next = new ListNode(1);
        root1.next.next = new ListNode(8);
        root1.next.next.next = new ListNode(4);
        root1.next.next.next.next = new ListNode(5);
        ListNode root2 = new ListNode(5);
        root2.next = new ListNode(6);
        root2.next.next = new ListNode(1);
        root2.next.next.next = root1.next.next;
        System.out.print(new Solution().getIntersectionNode(root1, root2).val);
        // ListNode node = root2;
        // while(node != null) {
        //     System.out.print(node.val+" ");
        //     node = node.next;
        // }
    }

}
 class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<Integer> set = new HashSet<>();
        ListNode node = headA;
        while(node != null) {
            int temp = node.hashCode();
            set.add(temp);
            // System.out.print(node.hashCode()+" ");
            node = node.next;
            
        }
        node = headB;
        while(node != null) {
            int temp = node.hashCode();
            if(set.contains(temp)) {
                // System.out.print(node.hashCode() + "this is return value");
                // System.out.print(set);
                return node;
            } else {
                set.add(temp);
            }
        }
        return null;
    }
}
 class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }