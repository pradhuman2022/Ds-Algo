class Solution {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        int lowerCases = 0;
    
        for (int i = 0; i < word.length(); i++) {
            if(Character.isLowerCase(word.charAt(i))) {
                lowerCases++;
            }
            
            if(Character.isUpperCase(word.charAt(i))) {
                capitals++;
            }
        }
        
        if(capitals == word.length() || lowerCases == word.length() || (Character.isUpperCase(word.charAt(0)) && lowerCases == word.length() - 1))
            return true;
            
        return false;
    }
}
