class Solution {
    public boolean isPalindrome(String s) {
        
        int left = 0; 
        int right = s.length() - 1;
        if(s.isEmpty() || s.isBlank())
            return true;
        
        while(left <= right) {
            char leftChar = s.charAt(left);
            while(left < right && 
                  !isValid(s.charAt(left))) {
                left++;
            }
            
            while(left < right && !isValid(s.charAt(right))) {
                right--;
            }
            
            if(Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                right--;
                left++;
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isValid(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
}
