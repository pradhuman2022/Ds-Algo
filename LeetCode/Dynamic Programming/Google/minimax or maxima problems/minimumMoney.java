class Solution {
    int[][] dp;
    boolean[][] visited;
    
public int getMoneyAmount(int n) {
    dp = new int[n+1][n+1];
    visited = new boolean[n+1][n+1];

    return getMoneyAmount(1, n);
}

private int getMoneyAmount(int lower, int upper) {
    if (lower >= upper) {
        return 0;
    }
    
    if (visited[lower][upper]) {
        return dp[lower][upper];
    }
    
    visited[lower][upper] = true;
    int maximum = Integer.MAX_VALUE;
    
    for (int i = lower; i <= upper; i++) {
        int leftPart = getMoneyAmount(lower, i-1);
        int rightPart = getMoneyAmount(i+1, upper);
        
        maximum = Math.min(maximum, Math.max(getMoneyAmount(lower, i-1), getMoneyAmount(i+1, upper)) + i);
    }
    
    dp[lower][upper] = maximum;
    
    return maximum;
}
}
