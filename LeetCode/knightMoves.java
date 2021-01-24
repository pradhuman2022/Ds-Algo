class Solution {
    public int minKnightMoves(int x, int y) {
        
        x = Math.abs(x);
        y = Math.abs(y);
        
        int ans = Integer.MAX_VALUE;
        if (x == 1 && y == 1) 
            return 2; 
        
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, 0, 0));
        boolean visited[][] = new boolean[301][301];
        visited[0][0] = true;
        Pair directions[] = new Pair[] { 
            new Pair(2, 1, 0), 
            new Pair(-2, 1, 0), 
            new Pair(-1, 2, 0), 
            new Pair(1, 2, 0), 
            new Pair(-2, -1, 0),
            new Pair(-1, -2, 0), 
            new Pair(1, -2, 0), 
            new Pair(2, -1, 0)
            };
        System.out.println(false && false);
        while(!q.isEmpty()) {
          /** System.out.println(q.peek().x + 
                           " " + q.peek().y+ " " + q.peek().dist);**/
            Pair p = q.poll();
            
            if(p.x == x && p.y == y) 
                return p.dist;
            
            for (Pair direction: directions) {
                int currentX = p.x + direction.x;
                int currentY = p.y + direction.y;
                
                if (areCordinatesValid(currentX, currentY) && 
                    !visited[currentX][currentY]) {
                    visited[currentX][currentY] = true;
                    q.add(new Pair(currentX, currentY, p.dist + 1));
                }
            }
        }

        return -1;
    }
    
    private boolean areCordinatesValid(int x, int y) {
        if(x < 0 || y < 0 || x > 300 || y > 300)
            return false;
        return true;
    }
    
    class Pair {
        int x;
        int y;
        int dist;
        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
