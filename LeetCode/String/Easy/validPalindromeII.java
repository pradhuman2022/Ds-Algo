class Solution {
    public boolean validPalindrome(String s) {
    
        if(s.length() == 1 || s.isEmpty()) 
            return true;
        
        if(isPalindrome(s))
            return true;
        
        StringBuilder sk = new StringBuilder();
        for (int i = 0 ; i < s.length() / 2; i++) {
            int j = s.length() - 1 - i;
            if(s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s.substring(i + 1, j + 1)) || isPalindrome(s.substring(i, j));
            }
        }
        
        return true;        
    }
    
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        System.out.println(s);
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        s = null;
        System.gc();
        return true;
    }
    
    
}
