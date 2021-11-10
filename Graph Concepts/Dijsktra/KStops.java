class Solution {
    public int findCheapestPrice(int n, int[][] flight, int src, int dst, int k) {
    
        int dist[][] = new int[n + 1][k + 2];
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int weight[][] = new int[n + 1][n + 1];
        
        for (int i = 0; i < flight.length; i++) {
            List<Integer> adjList = graph.getOrDefault(flight[i][0], new ArrayList<>());
            
            adjList.add(flight[i][1]);
            weight[flight[i][0]][flight[i][1]] = flight[i][2];
            graph.put(flight[i][0], adjList);
        }
        
        for (int d[]: dist)
            Arrays.fill(d, Integer.MAX_VALUE);
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
            (a, b) -> dist[a.node][a.stop] - dist[b.node][b.stop]);
        
        pq.add(new Pair(src, 0));
        for (int i = 0 ; i <= k + 1 ; i++)
            dist[src][i] = 0;
        
         int min = Integer.MAX_VALUE; 
        
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
        
            if (p.stop == k + 1)
                continue;
            
            for (int child: graph.getOrDefault(p.node, new ArrayList<>())) {
                if (dist[child][p.stop + 1] > dist[p.node][p.stop] + weight[p.node][child]) {
                    dist[child][p.stop + 1] = dist[p.node][p.stop] + weight[p.node][child];
                    pq.add(new Pair(child, p.stop + 1));
                    
                    if (child == dst)
                        min = Math.min(min, dist[child][p.stop + 1]);
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    class Pair {
        int node;
        int stop;
        
        Pair (int n, int s) {
            this.node = n;
            this.stop = s;
        }
    }
}
