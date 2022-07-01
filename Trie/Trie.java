import java.util.Map;
import java.util.Stack;

class Trie{
    Node root;

    Trie() {
        root = new Node();
    }
    void insert(String str) {
        int n = str.length();
        Node currNode = root;
        for(int i = 0; i < n; ++i) {
            if(!currNode.map.containsKey(str.charAt(i))) {
                currNode.map.put(str.charAt(i),new Node());
            }
            currNode = currNode.map.get(str.charAt(i));
        }
        currNode.end = true;
    }
    void print() {
        Node currNode = root;
        printhelper(currNode,"");
    }
    void printhelper(Node root, String ans) {
        if(root.end) {
            System.out.print(ans+" ");
        }
        for(char i : root.map.keySet()) {
            printhelper(root.map.get(i), ans+i);
        }
    }
    boolean search(String str) {
        int n = str.length();
        Node node = root;
        for(int i = 0; i < n; ++i) {
            if(!node.map.containsKey(str.charAt(i))) {
                return false;
            }
            node = node.map.get(str.charAt(i));
        }
        return node.end;
    }
    boolean delete(String str) {
        int n = str.length();
        Stack<Node> stack = new Stack<>();
        Node node = root;
        for(int i = 0; i < n; ++i) {
            if(!node.map.containsKey(str.charAt(i))) {
                return false;
            }
            stack.push(node);
            node = node.map.get(str.charAt(i));
        }
        if(!node.end) return false;
        node.end = false;
        int i = n-1;
        
        while(node.end == false && node.map.size() == 0) {
            char ch = str.charAt(i);
            stack.peek().map.remove(ch);
            node = stack.pop();
        }
        return true;

    }
}