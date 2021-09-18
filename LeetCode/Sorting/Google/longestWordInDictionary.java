class Solution {
    HashMap<Character, TreeSet<Integer>> map = new HashMap<>();
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary);
        
        for (int i = 0 ; i < s.length(); i++) {
            TreeSet<Integer> tSet = map.getOrDefault(s.charAt(i), new TreeSet<>());
            tSet.add(i);
            map.put(s.charAt(i), tSet);
        }
    
        int maxLength = 0;
        String ans = "";
        
        for (int i = 0 ; i < dictionary.size(); i++) {
            if (isSubSequence(dictionary.get(i)) 
                        && dictionary.get(i).length() > maxLength) {
                maxLength = dictionary.get(i).length();
                ans = dictionary.get(i);
            }
        }
        
        return ans;
    }
    
    public boolean isSubSequence(String word) {
        int currentIndex = -1;
	    for (char letter: word.toCharArray()) {
            if (!map.containsKey(letter))
		        return false;
            
            SortedSet<Integer> tailSet = map.get(letter).tailSet(currentIndex + 1);
            
            if (tailSet.isEmpty()) 
                return false;
 	        currentIndex = tailSet.first();
        }
        return true;
    }
}
