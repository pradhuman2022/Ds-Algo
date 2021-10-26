class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int count[][] = new int[s.length() + 1][2];
    
        int oneCount = 0;
        
        int minOps = 0;

        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0') {
                minOps = 1 + minOps; // flip this
                minOps = Math.min(minOps, oneCount);
            } else {
                oneCount++;
            }
        }
        
        return minOps;
    }
}
