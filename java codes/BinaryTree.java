

class BinaryTree
{
	public static void main(String[] args) {
		Bst bst = new Bst();
		bst.add(5);
		bst.add(4);
		bst.add(8);
		bst.add(3);
		bst.add(6);
		bst.add(10);
		bst.add(19);
		bst.neighbor(8);
	}
}
class Node{
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
    }
}
class Bst{
    Node root;
    void add(int val) {
        root = add1(root,val);
    }
    Node add1(Node root, int val) {
        if(root == null) {
             
            return new Node(val);
        }
       if(val < root.val) {
		   root.left = add1(root.left,val);
	   } else {
		   root.right = add1(root.right,val);
	   }
	   return root;

    }
	void preOrder() {
		preOrder1(root);
	}
	void preOrder1(Node root) {
		if(root.left != null) preOrder1(root.left);
		System.out.print(root.val+" ");
		if(root.right != null) preOrder1(root.right);
	}
	void neighbor(int val) {
		if(root.val == val) {
			System.out.print(root.left.val+" ");
			System.out.print(root.right.val+" ");
			return;
		}
		neighbor1(root,val,root.val);

	}
	void neighbor1(Node root, int val, int pre) {
		if(root == null) return;
		if(root.val == val) {
			System.out.print(pre+" ");
			if(root.left != null) System.out.print(root.left.val+" ");
			if(root.right != null) System.out.print(root.right.val+" ");
			return;
		}
		neighbor1(root.left, val, root.val);
		neighbor1(root.right,val,root.val);

	}
}