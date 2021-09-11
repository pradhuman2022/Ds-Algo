class Solution {
    public int minAreaRect(int[][] points) {
      
        /// consider the diagonal points
        /*
            diagonalPoints(x1, y1)           *(x2, y1)
                                
             *(x1,y2)             diagonalPoints(x2,y2)
        */
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        
        for (int point[]: points) {
          if (!map.containsKey(point[0])){
                map.put(point[0], new TreeSet<>());
          }
            map.get(point[0]).add(point[1]);
        }
        
        for (int x1[]: points) {
            for (int x2[]: points) {
            
                if (x1[0] == x2[0] || x1[1] == x2[1])
                    continue;
                
                if (map.get(x2[0]).contains(x1[1]) && map.get(x1[0]).contains(x2[1])) {
                    ans = Math.min(ans, Math.abs(x2[0] - x1[0]) * Math.abs(x2[1] - x1[1]));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
        
    }
}
