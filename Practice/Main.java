class Main
{
	public static void main(String[] args)
	{
		Node root = new Node(10);
		root.left = new Node(-2);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);
		print(root);
		//System.out.print(maxSum(root));
	}
	static int maxSum(Node root)
	{
		if(root == null) return -1000000;
		int sum1 = maxSum(root.left);
		int sum2 = maxSum(root.right);
		
		int a = max(root.left);
		int b = max(root.right);
		int sum3 = Math.max(root.val+a+b,Math.max(root.val+a,Math.max(root.val+b,root.val)));
		return Math.max(sum1,Math.max(sum2,sum3));
	}
	static int max(Node root)
	{
		if(root == null) return -1000000;
		return Math.max(root.val,root.val+Math.max(max(root.left),max(root.right)));
	}
	static void print(Node root)
	{
		if(root == null) return;
		print(root.left);
		System.out.println(root.val);
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