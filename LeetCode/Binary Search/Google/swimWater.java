class Solution {
    
    int steps[][] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    boolean visited[][];
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        visited = new boolean[n][n];
        
        int start = 0;
        int end =  n * n;
        
        while(start < end) {
            int mid = (start + end) / 2;
            visited = new boolean[n][n];
            if(isPossible(mid, grid, 0, 0))
                end = mid;
            else
                start = mid + 1;
        }
        
        return start;
    }
    
    public boolean isPossible(int atTime, int grid[][], int x, int y) {

         if (grid[x][y] > atTime)
            return false;
        
        if (x == grid.length - 1 && y == grid[0].length - 1)
            return true;
        
        visited[x][y] = true;
        
        for (int i = 0 ; i < 4; i++) {
            if(isValid(x + steps[i][0], y + steps[i][1], grid, atTime) &&
                                    !visited[x + steps[i][0]][y + steps[i][1]]) {
                
                if(isPossible(atTime, grid, x + steps[i][0], y + steps[i][1]))
                    return true;
            }
        }
    
        return false;
    }
    
    public boolean isValid(int x, int y, int grid[][], int time) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return false;
                
        return true;
    }
}


