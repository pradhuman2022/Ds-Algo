class Solution {
    static boolean visited[][];
    static int grids[][];
    static int steps[][] = {{-1, 0}, {0 , -1}, {1, 0}, {0, 1}};
    public int orangesRotting(int[][] grid) {
        
        return getMinimumMinutesToRotOranges(grid);
    }
    
    public static int getMinimumMinutesToRotOranges(int grid[][]) {
        grids = grid;
        visited = new boolean[grids.length][grids[0].length];
        
        Queue<Pair> q = new LinkedList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.add(new Pair(i, j));
                }
            }
        }
        
        int minuteToRotOranges = 0;
        while(!q.isEmpty()) {

            int levelSize = q.size();
            for (int j = 0; j < levelSize; j++) {
                Pair currentState = q.poll();
                for (int i = 0; i < 4; i++) {
                   if(isValid(currentState.x + steps[i][0], currentState.y + steps[i][1]) && !visited[currentState.x + steps[i][0]]
                      [currentState.y + steps[i][1]])  {
                       visited[currentState.x + steps[i][0]][currentState.y + steps[i][1]] = true;
                       q.add(new Pair(currentState.x + steps[i][0], currentState.y + steps[i][1]));
                   }
                }
            }
            
            if(!q.isEmpty()) // at last level there will nbe nothing to rot
                minuteToRotOranges++;
        }
        
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if(!visited[i][j] && grids[i][j] == 1)
                    return -1;
            }
        }
        
        return minuteToRotOranges;
    }
    
    public static boolean isValid(int newX, int newY) {
        if(newX < 0 || newY < 0 || newX >= visited.length || newY >= visited[0].length || grids[newX][newY] == 0)
            return false;
        
        return true;
    }
    
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
