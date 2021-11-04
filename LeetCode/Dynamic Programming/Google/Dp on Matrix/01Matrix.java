class Solution {
    
    int dp[][];
    boolean visited[][];
    int mat[][];
    public int[][] updateMatrix(int[][] mat) {
        dp = new int[mat.length][mat[0].length];
        visited = new boolean[mat.length][mat[0].length];
        this.mat = mat;
        
        f(0, 0);
        
        visited = new boolean[mat.length][mat[0].length];
    
        f1(mat.length - 1, mat[0].length - 1);
    
        return dp;
    }
    
    //if 
    int f(int i, int j) {
        if (i >= mat.length || j >= mat[0].length)
            return 10001;

        if (visited[i][j])
            return dp[i][j];

        visited[i][j] = true;
        
        int option1 = f(i + 1, j);
        int option2 = f(i, j + 1);
        
        if (mat[i][j] == 0) {
            return dp[i][j] = 0;  
        }

        dp[i][j] = Math.min(option1, option2) + 1;

        return dp[i][j];
    }

    int f1(int i, int j) {
        
        if (i < 0 || j < 0)
            return 10001;

        if (visited[i][j])
            return dp[i][j];

        visited[i][j] = true;
        
        int option1 = f1(i - 1, j);
        int option2 = f1(i, j - 1);
        
        if (mat[i][j] == 0) {
            return dp[i][j] = 0;  
        }
        
        dp[i][j] = Math.min(dp[i][j], Math.min(option1, option2) + 1); 

        return dp[i][j];
    }
}
