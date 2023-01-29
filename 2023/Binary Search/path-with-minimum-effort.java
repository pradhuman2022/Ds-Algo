class Solution {

    boolean visited[][];
    int dirs[][] = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int minimumEffortPath(int[][] heights) {
        int start = 0;
        int end = (int)10e6;

        while (start < end) {
            int minDiff = (start + end) / 2;
            visited = new boolean[heights.length][heights[0].length];
            if (canReach(minDiff, heights, 0, 0)) {
                end = minDiff;
            } else {
                start = minDiff + 1;
            }
        }

        return start;
    }

    public boolean canReach (int minDiff, int heights[][], int r, int c) {

        if (r == heights.length - 1 && c == heights[0].length - 1)
            return true;
        
        visited[r][c] = true;
        for (int d[]: dirs) {
            int newR = r + d[0];
            int newC = c + d[1];
            if (isValid(newR, newC) && Math.abs(heights[newR][newC] - heights[r][c]) <= minDiff)     {           
            if (canReach (minDiff, heights, newR, newC)) 
                return true;
            } 
        }
        return false;
    }

    public boolean isValid (int newR, int newC) {

        if (newR < 0 || newC < 0 || newR >= visited.length || newC >= visited[0].length || visited[newR][newC])
            return false;
        return true;
    }

}
