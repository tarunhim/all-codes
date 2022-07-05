import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
	static int min = 1000000000;
    public static void main (String[] args) throws IOException {
		String beginWord = "hit", endWord = "cog";
		String[] wordList = {"hot","dot","dog","lot","log","cog"};
		List<String> list = new ArrayList<>();
		for(String i : wordList) list.add(i);
		System.out.print(new Solution().findLadders(beginWord, endWord, list));
	}
}
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        set.addAll(wordList);
        List<String> curr = new ArrayList<>();
        curr.add(beginWord);
        Queue<List<String>> q = new LinkedList<>();
        q.offer(curr);
        while(!q.isEmpty()) {
            int size = q.size();
            List<String> dlist = new ArrayList<>();
            for(int k = 0; k < size; ++k) {
            List<String> templ = q.poll();
            String temp = templ.get(templ.size()-1);
            if(temp.equals(endWord)) {
                list.add(templ);
                continue;
            }
           
            
            for(int i = 0; i < temp.length(); ++i) {
				StringBuilder sb = new StringBuilder(temp);
                for(char j = 'a'; j <= 'z'; ++j) {
                    sb.setCharAt(i,j);
                    if(temp.equals(sb.toString())) continue;
                    if(set.contains(sb.toString())) {
                        templ.add(sb.toString());
                        q.add(new ArrayList<String>(templ));
                        templ.remove(templ.size()-1);
                        dlist.add(sb.toString());
                    }
                }
            }
            }
            for(String i : dlist) set.remove(i);
        }
        return list;
        
    }
}