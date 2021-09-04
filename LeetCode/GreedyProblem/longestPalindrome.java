class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        boolean isValue = false;
        boolean present = false;
        
       for (int ch = 0; ch < s.length(); ch++) {
      	 freq.put(s.charAt(ch), freq.getOrDefault(s.charAt(ch), 0) + 1);
      }
      

     int ans = 0;
     for (Map.Entry<Character, Integer> entry: freq.entrySet()) {
     	int frequency = entry.getValue();
           if (frequency % 2 == 0) {
                ans += frequency;
            } else if (frequency % 2 != 0 && frequency > 1) {
                ans += frequency - 1;
                present = true;
            } else if (isValue == false) {
               ans += 1;
               isValue = true;
           }
     }
        return isValue ? ans : present ? ans + 1 : ans;
    }
}
