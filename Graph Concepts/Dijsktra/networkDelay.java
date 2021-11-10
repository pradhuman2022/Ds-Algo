class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
    
        Map <Integer, List<Integer>> graph = new HashMap<>();
        int weight[][] = new int[n + 1][n + 1];
        
        for (int i = 0; i < times.length; i++) {
            
            int u = times[i][0];
            int d = times[i][1];
            int w = times[i][2];
            
            weight[u][d] = w;
            
            List<Integer> adjList = graph.getOrDefault(u, new ArrayList<>());
            adjList.add(d);
            graph.put(u, adjList);
        }
        System.out.println(graph);
        
        Integer dis[] = new Integer[n + 1];
        int visited[] = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
            if (dis[a] == dis[b])
                return -1;
            else 
                return dis[a] - dis[b];
        });
        
        dis[k] = 0;
        pq.add(k);
        int max = 0;
      
        while(!pq.isEmpty()) {
            Integer node = pq.poll();
  
            if (visited[node] == 0) {
                visited[node] = 1;
                
                for (int child : graph.getOrDefault(node, new ArrayList<>())) {
                    if (visited[child] == 0 && dis[child] > dis[node] + weight[node][child]) {
                        dis[child] = dis[node] + weight[node][child];
                        pq.add(child);
                    }
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if(visited[i] == 0)
                return -1;
            else 
                max = Math.max(dis[i], max);
        }
    
    
        return max;
    }
}
