class Solution {
    
    static int [][] grids;
    public int minCost(int[][] grid) {
        int steps[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0));
        int m = grid.length;
        int n = grid[0].length;
        int dist[][] = new int[m][n];
        
        grids = grid;
        for (int mi[] : dist)
            Arrays.fill(mi, Integer.MAX_VALUE);
        
        dist[0][0] = 0;
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            label: for (int i = 1; i <= 4; i++) {
                int newX = p.x + steps[i - 1][0];
                int newY = p.y + steps[i - 1][1];
                if(!isValid(newX, newY)) {
                    continue label;
                }
                
                if(i != grid[p.x][p.y]) {
                    if (dist[newX][newY] > 1 + dist[p.x][p.y]) {
                        dist[newX][newY] = 1 + dist[p.x][p.y];
                         System.out.println(grid[newX][newY]+"not mactech"+i);
                        q.addLast(new Pair(newX, newY));
                    }
                } else {
                    if (dist[newX][newY] > dist[p.x][p.y]) {
                        dist[newX][newY] = dist[p.x][p.y];
                        System.out.println(grid[newX][newY]+"mactech"+i);
                        q.addFirst(new Pair(newX, newY));
                    }
                }
            }
        }
       
        return dist[m - 1][n - 1] ;
    }
    
    public static boolean isValid(int x , int y) {
        if(x < 0 || y < 0 || grids.length <= x || grids[0].length <= y)
            return false;
        return true;
    }
    
    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x; 
            this.y = y;
        }
    } 
}

