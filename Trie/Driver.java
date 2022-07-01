public class Driver {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("tarun");
        trie.insert("varun");
        trie.insert("tarash");
        trie.print();
        trie.delete("varun");
        System.out.println();
        trie.print();
        // System.out.print(trie.search("tarun"));
        // System.out.print(trie.search("taru"));
    }
    
}
