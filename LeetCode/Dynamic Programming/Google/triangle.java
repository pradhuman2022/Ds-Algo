class Solution {
    int dp[][];
    List<List<Integer>> triangle;
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        
        dp = new int[triangle.size() + 1][triangle.get(triangle.size() - 1).size()];
    
        for (int x[]: dp)
            Arrays.fill(x, -1);
        
        return getMinPath(0, 0);
    }
    
    int getMinPath(int i, int j) {
        
        if (i >= triangle.size() || j >= triangle.get(triangle.size() - 1).size())
            return 0;
        
        if (dp[i][j] != -1)
            return dp[i][j];
        
        int option1 = getMinPath(i + 1, j);
        int option2 = getMinPath(i + 1, j + 1);
        
        return dp[i][j] = Math.min(option1, option2) + triangle.get(i).get(j);
    }
}
