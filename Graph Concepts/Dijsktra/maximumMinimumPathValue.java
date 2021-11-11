class Solution {
    public int maximumMinimumPath(int[][] grid) {
        final int[][] DIRS = {{0,1},{1,0},{0,-1},{-1,0}};
        
        int n = grid.length;
        int m = grid[0].length;
        int maxScore = grid[0][0];
        
        Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        pq.add(new int[]{grid[0][0], 0, 0});
        grid[0][0] = -1;
        
        while(!pq.isEmpty()) {
            
            int node[] = pq.poll();
            
            maxScore = Math.min(maxScore, node[0]);
            if (node[1] == n - 1 && node[2] == m - 1)
                break;
            
            for (int i = 0 ; i < 4; i++) {
                
                int newX = DIRS[i][0] + node[1];
                int newY = DIRS[i][1] + node[2];
                
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] >= 0) {
                    pq.offer(new int[]{grid[newX][newY], newX, newY});
                    grid[newX][newY] = -1;
                }
            }
        }
        return maxScore;
    } 
}
