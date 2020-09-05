class Solution {
    static int mod = (int)Math.pow(10, 9) + 7; 
    public int numWays(String s) {
        int ones = 0;
        for (int i = 0; i < s.length(); i++) 
            if(s.charAt(i) == '1')
                ones++;
        
        if(ones % 3 != 0)
            return 0;
        
        int n = s.length();
        if(ones == 0) {
            return (int)(((n - 1L) % mod) * ((n - 2) % mod) / 2 % mod) ;
        }
      
        
        int onesInOnePart = ones / 3;
        
        int endOfFirstPart = -1; 
        int endOfSecondPart = -1;
        int currentOneCount = 0;
        long zeroCountAfterFirstCut = 0;
        long zeroCountAfterSecondCut = 0;
        for (int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i) == '1')
                currentOneCount++;
         
            if(currentOneCount == onesInOnePart) {
                zeroCountAfterFirstCut++;
            } else if(currentOneCount == 2 * onesInOnePart) {
                zeroCountAfterSecondCut++;
            }
            
            
            /**if(currentOneCount == onesInOnePart) {
                if(endOfFirstPart == -1) {
                    endOfFirstPart = i;
                    currentOneCount = 0;
                    while(i < s.length() - 1 && s.charAt(i + 1) == '0') {
                        zeroCountAfterFirstCut++;
                        i++;
                    }
                } else if(endOfSecondPart == -1) {
                    endOfSecondPart = i;
                    currentOneCount = 0; 
                    while(i < s.length()  - 1 && s.charAt(i + 1) == '0') {
                        zeroCountAfterSecondCut++;
                        i++;
                    }
                    System.out.println(zeroCountAfterSecondCut);
                }
            }**/
            
        }
        long ans = (((zeroCountAfterFirstCut) % mod)* ((zeroCountAfterSecondCut) % mod)) % mod;
        return (int)ans;   
    }
}
