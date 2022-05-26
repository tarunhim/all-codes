

class bTree{
    int val;
    bTree left;
    bTree right;

    bTree(int val) {
        this.val = val;
    }
    bTree(){}

    void preOrder() {
        System.out.print(val+" ");
        if(left != null) left.preOrder();
        if(right != null) right.preOrder();
    }

}
class solve{
    public static void main(String[] args) {
        bTree root = new bTree();
        root.val = 1;
        // root.left = new bTree(2);
        // root.right = new bTree(3);
        // root.right.left = new bTree(4);
        // root.right.right = new bTree(5);
        // root.preOrder();
        // System.out.print(new Codec().serialize(root));
        String temp = new Codec().serialize(root);
        bTree node = new Codec().deserialize(temp);
        node.preOrder();
    }
}
 class Codec {
    String str;
    // Encodes a tree to a single string.
    public String serialize(bTree root) {
        str = "";
        if(root == null) return str;
        bTree node = root;
        preOrder(node);
        str += " ";
        node = root;
        inOrder(node);
        // System.out.print(str);
        return str;
        
    }
    void preOrder(bTree root) {
        if(root == null) return;
        str += root.val;
        preOrder(root.left);
        preOrder(root.right);
    }
    void inOrder(bTree root) {
        if(root == null) return;
        inOrder(root.left);
        str += root.val;
        inOrder(root.right);
    }

    // Decodes your encoded data to tree.
    public bTree deserialize(String data) {
        if(data == "") return null;
        String[] strarr = data.split(" ");
        int n = strarr[0].length();
        int[] pre = new int[n];
        int[] ino = new int[n];
        for(int i = 0; i < n; ++i) {
            pre[i] = Character.getNumericValue(strarr[0].charAt(i));
            ino[i] = Character.getNumericValue(strarr[1].charAt(i));
        }
        return tree(pre, ino, Integer.MIN_VALUE);
        
    }
    static int pr;
    static int in;
    bTree tree(int[] pre, int[] ino, int stop) {
        if(pr >= pre.length) return null;
        
        if(ino[in] == stop) {
            in++;
            return null;
        }
        bTree node = new bTree(pre[pr]);
        pr++;
        
        node.left = tree(pre, ino, node.val);
        node.right = tree(pre, ino, stop);
        return node;
        
    }
}
