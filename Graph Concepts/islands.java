class Solution {
    static int steps[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static boolean visited[][]; 
    static char grids[][];
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length]; 
        grids = grid;
        int islands = 0; 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grids[i][j] != '0' && !visited[i][j]) {
                    islands++;
                    visitIsland(i, j);
                }
            }
        }
        
        return islands;
    } 
    
    
    public static void visitIsland(int i, int j) {
        
        if(i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || 
           visited[i][j] || grids[i][j] == '0') {
            return;
        }
               
        visited[i][j] = true;
        for (int step = 0; step < 4; step++) {
            visitIsland(i + steps[step][0], j + steps[step][1]);
        }
    }
}
