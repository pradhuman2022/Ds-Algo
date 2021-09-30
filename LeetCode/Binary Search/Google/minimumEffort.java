class Solution {
    int steps[][] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    boolean visited[][];
    public int minimumEffortPath(int[][] heights) {
        
        int start = 0;
        int end = (int)1e6;
        int res = end;
        
        while(start < end) {
            
            int mid = (start + end) / 2;
        
            visited = new boolean[heights.length][heights[0].length];
            
            if (isPossible(mid, heights, 0, 0))
                end = mid;
            else
                start = mid + 1;
        }
        
        return start;
    }
    
    
    public boolean isPossible(int target, int h[][], int row, int column) {
        
        if (row == h.length - 1 && column == h[0].length - 1) {
                return true;
        }
        
        visited[row][column] = true;
        
        for (int i = 0 ; i < 4; i++) {
            int newRow = row + steps[i][0];
            int newColumn = column + steps[i][1];
            
            if (isValid(newRow, newColumn, h) && !visited[newRow][newColumn] 
                            && Math.abs(h[newRow][newColumn] - h[row][column]) <= target) {
                if (isPossible(target, h, newRow, newColumn)) {
                    return true;
                }
            }
            
        }
        
        return false;  
    }
    
    public boolean isValid(int r, int c, int h[][]) {
        
        if (r < 0 || r >= h.length || c < 0 || c >= h[0].length)
            return false;
        
        return true;
    }
}

