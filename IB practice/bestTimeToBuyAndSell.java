public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] A) {
        int n = A.length;
        if(n == 0 || n == 1)
            return 0;
        int maxProfit = Integer.MIN_VALUE;
        int minFromLeft[] = new int[n];
        minFromLeft[0] = A[0];
        for(int i = 1; i < A.length; i++) {
            minFromLeft[i] = Math.min(minFromLeft[i - 1], A[i]);  
        }
        int maxFromRight[] = new int[n];
        maxFromRight[n - 1] = A[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            maxFromRight[i] = Math.max(maxFromRight[i + 1], A[i]); 
        }
        for(int i = 1 ; i < n; i++) {
            maxProfit = Math.max(maxProfit,maxFromRight[i] - minFromLeft[i - 1]);
        }
        return maxProfit < 0 ? 0: maxProfit;
    }
}
