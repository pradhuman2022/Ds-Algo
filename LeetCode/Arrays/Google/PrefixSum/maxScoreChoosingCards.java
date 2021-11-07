class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        int prefixSum[] = new int [n + 1];
        int suffixSum[] = new int [n + 1];
        
        for (int i = 1; i <= n; i++)
            prefixSum[i] = prefixSum[i - 1] + cardPoints[i - 1];
        
        for (int i = 1; i <= n; i++)
            suffixSum[i] = suffixSum[i - 1] + cardPoints[n - i];
        
        int ans = 0;
        for (int i = 0; i <= k; i++)
            ans = Math.max(ans, prefixSum[i] + suffixSum[k - i]);
        
        return ans;
    }
}

/**
k = 4
1 3
3 1
2 2

a1 a2 a3 a4 a5 a6 k
a1 

a2 a3 a4 a5 a6

a6 

a2 a3 a4 a5

a2

a3 a4 a5

a5 

a3 a4

**/
