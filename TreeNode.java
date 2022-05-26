class Node{
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
    }
}
class TreeNode {
    static Node insert(Node root, int val) {
        if(root == null) {
         return new Node(val);
        }
        if(val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right,val);
        }
        return root;
    }
    static void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    static void delete(Node root, int key) {
        if(root == null) return;
        Node prev = null;
        Node curr = root;
        while(curr != null && curr.data != key) {
            prev = curr;
            if(key < curr.data) curr = curr.left;
            else curr = curr.right;
        }

        if(curr == null) return;

        if(curr.left == null && curr.right == null) {
            if(curr == root)
            root = null;
            else {
                if(prev.left == curr) {
                    prev.left = null;
                } else {
                    prev.right = null;
                }
            }
            return;
        } else if(curr.left != null && curr.right != null) {
            Node temp = curr.right;
            while(temp.left != null) {
                temp = temp.left;
            }
            int value = temp.data;
            delete(root, value);
            curr.data = value;
        } else {
            Node temp = curr.left == null ? curr.right : curr.left;
            if(curr != root) {
            if(prev.right == curr) {
                prev.right = temp;
            } else {
                prev.left = temp;
            }
        } else {
            root = temp;
        }
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,3,7,2,8,4,6};
        Node root = null;
        for(int i : arr) {
            root = insert(root, i);
        }
        inOrder(root);
        System.out.println();
        delete(root, 4);
        inOrder(root);
        
    }
}