class Solution {
    
    private static final int[][] steps = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int dp[][], matrix[][];
    int n, m;
    public int longestIncreasingPath(int[][] matrix) {
        this.n = matrix.length;
        this.m = matrix[0].length;
        this.matrix = matrix;
        
        this.dp = new int[n][m];
        
        int ans = 1;
        
        for (int i = 0; i < n; i++)
            for (int j = 0 ; j < m; j++)
                ans = Math.max(ans, f(i, j));
        
        return ans;
    }
    
    int f(int i, int j) {
        
        if (dp[i][j] != 0)
            return dp[i][j];
        
        int max = 0;
        
        for (int l = 0; l < 4; l++) {
            
            int x = i + steps[l][0];
            int y = j + steps[l][1];
            
            if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, f(x, y));
            }
            
        }
            
        return dp[i][j] = max + 1;
    }
}
