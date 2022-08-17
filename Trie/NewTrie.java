public class NewTrie {

    public static void main(String[] args) {
        
    }
    static void add(TR node, String word) {
        TR root = node;
        for(char c : word.toCharArray()) {
            int i = c-'a';
            if(root.next[i] == null) root.next[i] = new TR();
            root = root.next[i];
        }
        root.word = word;
    }

    
}

class TR{
    TR[] next = new TR[26];
    String word;
}
