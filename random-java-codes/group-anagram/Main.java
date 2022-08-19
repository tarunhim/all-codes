import java.util.*;
class Main{
    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.print(new Solution().groupAnagrams(str));
    }
}

class Solution {
	public List<List<String>> groupAnagrams(String[] str){
		List<List<String>> list = new ArrayList<>();
		Map<String,List<String>> map = new HashMap<>();
		for(String s : str) {
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			String key = new String(arr);
			if(map.containsKey(key)){
				map.get(key).add(s);
			} else {
                List<String> temp = new ArrayList<>();
                temp.add(s);
				map.put(key,temp);			
			}
		}
		for(String i : map.keySet()){
			list.add(map.get(i));
		}
		
		return list;
	}
}