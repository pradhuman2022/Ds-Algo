class Solution {
     public boolean wordBreak(String s, List<String> wordDict) {
    
        Set<String> set = new HashSet<>(wordDict);
    
         return isBreakPossible(0, s.length(), s, set);
    }

    public boolean isBreakPossible(int start, String s, Set<String> dict) {
	
        if (start == end)
		    return true;
	    
	    for (int i = start + 1; i <= end; i++) {
		    boolean option1 = dict.contains(s.substring(start, i));
            
	        if (option1 && isBreakPossible(i, s, dict))
		        return true;
        }

        return false;
    }

}

