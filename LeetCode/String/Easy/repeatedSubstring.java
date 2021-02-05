class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        String newString = s + s;
        
        for (int i = 1; i < newString.length() - s.length(); i++) {
            int t = i;
            int j = 0;
            
            lab: while(j < s.length()) {
                if(s.charAt(j) == newString.charAt(t)){
                    j++;
                    t++;
                } else {
                    break lab;
                }
            }
            
            if(j == s.length())
                return true;
        }
        
        return false;
    }
}
