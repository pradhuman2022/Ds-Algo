class Solution {
    public int numSquares(int n) {
        HashSet<Integer> squares = new HashSet<>();
        
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int ans = 0;
        visited.add(n);
    
        while(!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Integer value = q.poll();
                if(value == 0)
                    return ans;
                
                for (Integer x: squares) {
                    int diff = value - x;
                    if (!visited.contains(diff)) {
                        q.add(diff);
                        visited.add(diff);
                    }
                }
            }
             if(!q.isEmpty())
                ans++;
        }
        
        return ans;
    }
}
