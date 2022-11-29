class Solution {
    public ListNode removeNodes(ListNode head) {
        boolean shouldContinue = true;
        while (shouldContinue) {
            shouldContinue = false;
            ListNode dummyHead = new ListNode();
            ListNode pointer = dummyHead;
            ListNode node = head;
            while (node != null) {
                if (node.next != null && node.val < node.next.val) {
                    shouldContinue = true;
                } else {
                    pointer.next = node;
                    pointer = node;
                    // System.out.println(pointer.val);
                }
                node = node.next;
            }
            pointer.next = null;
            head = dummyHead.next;
            // System.out.println("-----------------");
        }
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
