import java.util.*;

class Main
{
	public static void main(String[] args)
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.left.right = new Node(19);
		root.left.left.right.left = new Node(40);
		root.left.left.right.right = new Node(50);
		root.left.left.left = new Node(8);
		root.left.left.left.left = new Node(30);
		root.right = new Node(9);
		root.right.left = new Node(5);
		root.right.right = new Node(7);
		root.right.right.left = new Node(20);
		root.right.right.right = new Node(11);
		// print(root);
		Map<Integer,Node> map = new HashMap<>();
		map.put(root.val, null);
		Node node = root;
		create(map,node);
		int target = 40;
		int k = 2;
		node = root;
		Node temp = find(node,target);
		node = root;
		
		int ans = totalSum(temp,map,k,-1);
		System.out.print(ans);
	}
	static int totalSum(Node root, Map<Integer,Node> map, int k,int prev) {
		if(k < 0) return 0;
		if(root == null) return 0;

		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		if(root.left != null && root.left.val != prev)
		sum1 = totalSum(root.left,map,k-1,root.val);
		if(root.right != null && root.right.val != prev)
		sum2 = totalSum(root.right,map,k-1,root.val);
		if(map.get(root.val) != null && map.get(root.val).val != prev)
		sum3 = totalSum(map.get(root.val),map,k-1,root.val);
		return root.val+sum1+sum2+sum3;
	}

	static void create(Map<Integer,Node> map, Node root) {
		if(root == null) return;
		if(root.left != null) {
			map.put(root.left.val,root);
			create(map, root.left);
		}
		if(root.right != null) {
			map.put(root.right.val,root);
			create(map,root.right);
		}
	}
	static Node find(Node root, int val) {
		if(root == null) return null;
		if(root.val == val) return root;

		Node left = find(root.left,val);
		if(left != null) return left;
		Node right = find(root.right,val);
		if(right != null) return right;
		return null;

	}



	static void print(Node root) {
		if(root == null) return;
		print(root.left);
		System.out.print(root.val+" ");
		print(root.right);
	}
}

class Node 
{
	int val;
	Node left;
	Node right;
	
	Node(int val)
	{
		this.val = val;
	}
}